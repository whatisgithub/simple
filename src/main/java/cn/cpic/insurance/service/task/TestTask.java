package cn.cpic.insurance.service.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Scheduled 定时任务的核心
 *
 * cron： cron表达式，根据表达式循环执行，与fixedRate属性不同的是它是将时间进行了切割。（@Scheduled(cron = "0/5 * * * * *")任务将在5、10、15、20...这种情况下进行工作）
 * fixedRate： 每隔多久执行一次；（@Scheduled(fixedRate = 1000) 假设第一次工作时间为2018-05-29 16:58:28，工作时长为3秒，那么下次任务的时候就是2018-05-29 16:58:31，配置成异步后，只要到了执行时间就会开辟新的线程工作），如果（@Scheduled(fixedRate = 3000) 假设第一次工作时间为2018-05-29 16:58:28，工作时长为1秒，那么下次任务的时间依然是2018-05-29 16:58:31）
 * fixedDelay： 当前任务执行完毕后等待多久继续下次任务（@Scheduled(fixedDelay = 3000) 假设第一次任务工作时间为2018-05-29 16:54:33，工作时长为5秒，那么下次任务的时间就是2018-05-29 16:54:41）
 * initialDelay： 第一次执行延迟时间，只是做延迟的设定，与fixedDelay关系密切，配合使用，相辅相成。
 * @Async 代表该任务可以进行异步工作，由原本的串行改为并行
 */
@Component
public class TestTask {

    @Async
    @Scheduled(cron = "0/1 * * * * *")
    public void scheduled1() throws InterruptedException {
        System.out.println("hello" + Thread.currentThread().getName());
//        log.info("scheduled1 每1秒执行一次：{}", LocalDateTime.now());
    }

    @Async
    @Scheduled(cron = "0/1 * * * * *")
    public void scheduled8() throws InterruptedException {
        System.out.println("hell222222o" + Thread.currentThread().getName());
//        log.info("scheduled1 每1秒执行一次：{}", LocalDateTime.now());
    }

    @Scheduled(fixedRate = 1000)
    public void scheduled2() throws InterruptedException {
//        log.info("scheduled2 每1秒执行一次：{}", LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 3000)
    public void scheduled3() throws InterruptedException {
//        log.info("scheduled3 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now());
    }
}
