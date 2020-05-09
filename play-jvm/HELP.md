

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
    验证 准备 解析
初始化