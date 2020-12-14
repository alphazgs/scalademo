//无参方法
def ff = {
  println("调用了无参方法")
  "fffff"
}

def ffff = "hhhhh"

def f(func: => String) = func

f("djnje")
f(ff)
f(ffff)







