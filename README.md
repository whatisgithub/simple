业务模块
暂时没有将util，dao，service，biz，web，facade，integration
分成单独模块，后面有需要在进行分层，现在先通过不同包来实现分层

接口维护
使用swagger作为和前端交互工具，具体配置在swaggerconfig里边
http://localhost:8082/swagger-ui.html

异常处理
业务异常都是通过GlobalExceptionHandler进行处理
后续业务需要定义异常使用@ExceptionHandler注解声明即可

定时任务
service层task包里边，用来做定时任务跑批，可能会涉及到一些补偿操作
开启定时任务支持，别忘记在入口类增加@EnableAsync @EnableScheduling
注解

数据验证
使用@Valid进行验证，内部具体可用注解有哪些，可以参考ValidateVo里边注释说明

数据库


redis

限流
http://blog.battcn.com/2018/08/08/springboot/v2-cache-redislimter/





