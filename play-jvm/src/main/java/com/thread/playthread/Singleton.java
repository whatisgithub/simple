package com.thread.playthread;

public class Singleton {
    private static volatile Singleton intance;

    private Singleton(){}

    public static Singleton getIntance(){

        if(intance == null) {
            synchronized (Singleton.class) {
                if(intance == null) {
                    intance = new Singleton();
                }
            }
        }

        return intance;
    }
}
