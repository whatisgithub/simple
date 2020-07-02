package com.com.com.jucplay;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    static ReentrantLock lock = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock(false);

    public static void main(String[] args) {
        try {
           lock.lock();
            boolean lockSuccess = lock.tryLock(5, TimeUnit.SECONDS);
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
