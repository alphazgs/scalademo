package com.zgs.java;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BigFileDealMain {
    static ExecutorService pool = Executors.newFixedThreadPool(2);
    static CountDownLatch count = new CountDownLatch(2);

    public static void main(String[] args) {
        FileChannel fc = null;
        try {
            fc = new RandomAccessFile("F:\\1.txt", "r").getChannel();
            long t = System.currentTimeMillis();
            for (int i = 0; i < 2; i++) {
                pool.execute(new ReadThread(fc));
            }
            count.await();
            pool.shutdown();
            System.out.println(System.currentTimeMillis() - t);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("end");
        }
    }

    public static synchronized ByteBuffer read(FileChannel fc) {
        ByteBuffer bb = ByteBuffer.allocate(4096);
        try {
            if (fc.position() >= fc.size())
                return null;
            fc.read(bb);
            bb.flip();
            long filePosition = fc.position();
            int lastN = 0;
            int nowLimit = bb.limit();
            for (int p = nowLimit - 1; p > 0; p--) {
                bb.position(p);
                if ('\n' == bb.get()) {
                    lastN = p + 1;
                    break;
                }
            }
            bb.position(0);
            bb.limit(lastN);
            if (lastN > 0)
                fc.position(filePosition - (nowLimit - lastN));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bb;
    }

    public static class ReadThread implements Runnable {
        FileChannel fc;

        public ReadThread(FileChannel fc) {
            this.fc = fc;
        }

        @Override
        public void run() {
            ByteBuffer bb = null;
            while ((bb = read(fc)) != null) {
                int lastP = 0;
                while (bb.hasRemaining()) {
                    if ('\n' == bb.get()) {
                        int nowP = bb.position();
                        bb.position((int) lastP);
                        int len = nowP - lastP;
                        byte[] b1 = new byte[len > 2 ? len - 2 : len];
                        bb.get(b1);
                        lastP = nowP;
                        if (len > 2) {//最后一两个字节是\r\n ，不同的系统可能换行符不同，
                            bb.get();
                            bb.get();
                        }
                        String str = new String(b1, Charset.forName("gbk"));
                        System.out.println(str);
                    }
                }
            }
            count.countDown();
        }
    }
}