package com.thread.playthread;

public class SyncHronizedPlay {
    private int count = 0;
    private Object lockObject = new Object();

    public void add(){
        synchronized (lockObject) {
            count ++;
            System.out.println(Thread.currentThread().getName() + ": " + count);
        }
    }

    public static void main(String[] args) {

        final SyncHronizedPlay syncHronizedPlay = new SyncHronizedPlay();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    syncHronizedPlay.add();
                }
            }).start();
        }



    }
}
