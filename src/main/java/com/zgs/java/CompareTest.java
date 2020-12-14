package com.zgs.java;


public class CompareTest implements Comparable<CompareTest> {
    private int amount;
    public CompareTest(int amount) {
        this.amount = amount;
    }

    private int getAmount() {
        return amount;
    }

    private void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(CompareTest another) {
        if(another == null){
            throw new RuntimeException("dndskfe");
        } else {
            return getAmount()-another.getAmount();
        }
    }
}
