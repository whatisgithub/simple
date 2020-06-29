

###启动类加载器
lib/rt.jar  
###扩展类加载器
jre/lib/ext/*.jar  
###应用类加载器
我们自己应用的类加载器  
加载classpath指定内容  
###customer classloader
我们自定义的类加载器  


加载过程  
加载   
    双亲委派  
链接  
    验证 验证下class文件是不是符合规范  
    准备 静态成员变量默认赋值  
    解析 符号引用解析为直接引用  
初始化  
    给变量赋初始值  
    
注意是 先默认值->初始值  


###缓存行 cache line
多核CPU load主存储相同内容，并在各自L1，L2缓存中计算，这样存在多份数据，容易造成数据不一致  
怎么办呢可以采用不同的协议解决数据一致性问题  
MESI cache一致性协议  
总线锁  

当然双刃剑  
有些无法被缓存的数据  
跨越多个缓存行数据  
依然必须使用总线锁  

cache line 多数为64字节  
cpu读取缓存的时候，以cache line为基本单位  
当两个数据在同一个缓存行的时候，cpu计算数据产生相互影响，这被称为伪共享  
使用缓存行对齐，能介解决cache line问题  
long p1,p2,p3,p4,p5,p6,p7;  
long cursor;  
long p8,p9,p10,p11,p12,p13,p14  


指令重排序 volitle
cpu为了提高效率  
执行代码的时候可能会打乱代码执行效率  
主要原因是cpu速度和内存速度相差太大，为了提高效率，如果两个指令不相干  
cpu可能会直接执行另外一条指令  

cpu有一个特别高速的缓存，如果每次都满足这个4字节缓存执行起来效率特别高  
合并写技术 只有4个字节

###java运行时数据区
pc计数器  代码执行的位置  
虚拟机栈  jvm stack  
本地方法栈  
直接内存  
> 可以直接访问内存空间内存
>
方法区  
> 逻辑概念 perm space 或者是meta space是具体实现
>
堆  
运行时常量池

JVM STACK   每个方法都有一个栈帧
local veriable table  局部变量表  
operand stack  操作数栈  
dynamic linking 方法的链接    
return address   


###垃圾回收算法
GC roots  
线程栈变量  
静态变量  
常量池  
> jvm stack
> native method stack 
> runtime constant pool
> static reference in method area
> Clazz  

GC清除算法
标记清除   
拷贝  
标记压缩  


java -XX:PrintFlagsFinal


JVM 调优的核心概念  
吞吐量：用户代码执行时间 / （用户代码执行时间 + 垃圾回收时间）  
响应时间：STW越短，响应时间越好  
调优的追求就是吞吐量优先还是响应时间优先？在一个条件一定的情况下，尽量调优另外一个参数  
科学计算：吞吐量优先（PS+PO）  
一般网站：响应时间优先  
JVM调优到底是解决什么问题？  
根据需求进行JVM规划和调优  
优化JVM运行环境  
解决JVM运行过程中的各种问题（如OOM）  
