package com.play.jvm.playjvm;

public class YoungGc {
    public static void main(String[] args) {

        /**
         * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760 -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
         * -Xloggc:gc.log
         *
         */

        byte[] a = new byte[1024*1024];
        a = new byte[1024*1024];
        a = new byte[1024*1024];
        a = null;

        byte[] a2 = new byte[2*1024*1024];

    }
}
