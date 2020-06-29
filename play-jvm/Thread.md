
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


