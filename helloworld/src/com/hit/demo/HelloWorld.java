package helloworld.src.com.hit.demo;

abstract class Person {
    String name;

    public abstract void smoke();
}

class Worker extends Person {
    public void smoke() {
        System.out.println(name + "helloworld");
    }

    public static int nums(int n) {
        for (int i = 10; i < n; i = i + 1) {
            System.out.println(i);
        }
        return n;
    }
}

class Student extends Person {
    public void smoke() {
        System.out.println(name + "goodbyeworld");
    }
}

public class HelloWorld {
    public static void main(String args[]) {
        Worker w = new Worker();
        Student s = new Student();
        s.name = "张三";
        w.name = "李四";
        w.smoke();
        s.smoke();
        System.out.println(w.nums(50));
    }
}
