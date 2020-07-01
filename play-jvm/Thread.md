
多线程编程是一件很复杂的事情  或者说这种编程模型很复杂




###线程join() 方法有什么用处？  
两个线程t1和t2 如果t1里边调用t2.join()表示等待t2线程运行完毕在继续运行t1

###线程都有哪些状态？
1. new 状态
2. runnable 分为ready和running
3. teminated 运行完成了以后变成结束状态
4. TimedWaiting 调用sleep(time) wait(time) join(time) 进入这个状态
5. Waiting wait() join() park() 进入这个状态
6. Blocked 进入同步代码块后的状态  

synchronized   
是可重入锁，当抛出异常时，jvm会自动释放锁  
实现方式
1. 早期是重量级 - OS实现  
2. 后来进行了锁升级的改进  
   在markword 记录这个线程的id（偏向锁）  
   如果有线程争用：征用线程升级为自旋锁，自旋10次以后会升级为重量级锁-》os实现  
   
如果线程执行时间比较短，线程不多，可以使用自旋锁  
如果执行时间长，线程数多，用系统锁  
尽量锁不要使用String Integer Long类型进行加锁  

volatile 作用  
保证线程可见性  
禁止指令重排序  

reentrantLock and synchronize 区别？？  
cas vs sync  
trylog 功能
lockinterrupt
公平非公平转换

 


