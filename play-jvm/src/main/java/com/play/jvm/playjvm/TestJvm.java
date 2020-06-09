package com.play.jvm.playjvm;

public class TestJvm {
    private static volatile TestJvm t;

    public TestJvm getInstance(){
        if(t == null) {
            synchronized(TestJvm.class) {
                if(t == null) {
                    t = new TestJvm();
                }
                return t;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        new TestJvm().getClass().getClassLoader();
    }
}
