package com.bysj.event.znz.utils;

import java.util.concurrent.*;

/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/03/26 11:28
 * @Description:
 * @Version: 1.0
 */
public class ThreadPoolDemo {
    private static final int THREADS_SIZE = 1;
    private static final int CAPACITY = 1;
    public static void main(String[] args) {
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(5,20,0,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));
//        corePoolSize
//        核心线程数量
//        线程池大小，决定着新提交的任务是新开线程去执行还是放到任务队列中，也是线程池的最最核心的参数。一般线程池开始时是没有线程的，只有当任务来了并且线程数量小于corePoolSize才会创建线程。
//        maximumPoolSize
//        最大线程数，线程池能创建的最大线程数量。
//        keepAliveTime
//        在线程数量超过corePoolSize后，多余空闲线程的最大存活时间。
//        unit
//        时间单位
//        workQueue
//        存放来不及处理的任务的队列，是一个BlockingQueue。
//        threadFactory
//        生产线程的工厂类，可以定义线程名，优先级等。
//        handler
//        拒绝策略，当任务来不及处理的时候，如何处理, 前面有讲解。
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,20,0, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(9),new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                //根据参数r接收的任务,创建一个线程
                Thread t = new Thread( r );
                t.setDaemon(true);  //设置为守护线程, 当主线程运行结束,线程池中的线程会自动退出
                System.out.println("创建了线程: " + t);
                return t ;
            }
        });
        /**   设置拒绝时:
         * AbortPolicy  上报异常
         * CallerRunsPolicy 会将被拒绝任务添加去运行
         * DiscardOldestPolicy 会把等待任务丢弃并替换成要被拒绝任务
         * DiscardPolicy 线程池会执行阻塞等待任务执行，其他的任务全部移除
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i <20; i++) {
            Runnable myrun = new MyRunnable("task-"+i);
            executor.execute(myrun);
        }
        executor.shutdown();
    }

    static class MyRunnable implements Runnable {
        private String name;
        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.name+"is running");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
