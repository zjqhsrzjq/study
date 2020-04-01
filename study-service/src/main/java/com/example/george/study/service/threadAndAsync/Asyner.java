//package com.example.george.study.service.threadAndAsync;
//
//import com.alibaba.goc.project.mw.context.GOCContext;
//import com.alibaba.goc.project.mw.util.ContextUtils;
//import com.alibaba.ttl.threadpool.TtlExecutors;
//import com.google.common.base.Optional;
//import com.google.common.util.concurrent.MoreExecutors;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * Aysner
// *
// * @author jianbai
// */
//public final class Asyner {
//
//    private static final Logger logger = LoggerFactory.getLogger(Asyner.class);
//
//    private static final int MAX_SIZE = 2000;
//
//    /**
//     * 异步器
//     */
//    private static ExecutorService AYSNER;
//
//    /**
//     * 异步器-自动通告
//     */
//    private static ExecutorService AYSNER_AUTO_NOTICE;
//
//    static {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(MAX_SIZE), new AysnFactory("AYSNER"));
//        AYSNER = MoreExecutors.listeningDecorator(TtlExecutors.getTtlExecutorService(executor));
//
//        ThreadPoolExecutor executorAutoNotice = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(MAX_SIZE), new AysnFactory("AYSNER_AUTO_NOTICE"));
//        AYSNER_AUTO_NOTICE = MoreExecutors.listeningDecorator(ScheduledExecutorService super);
//    }
//
//    /**
//     * Execute
//     */
//    public static void execute(final Runnable command) {
//        AYSNER.execute(wrapCommand(command));
//    }
//
//    /**
//     * Execute-AutoNotice
//     */
//    public static void executeNotice(final Runnable command) {
//        AYSNER_AUTO_NOTICE.execute(wrapCommand(command));
//    }
//
//    private static Runnable wrapCommand(final Runnable command) {
//        return new Runnable() {
//            @Override
//            public void run() {
//                ContextUtils.initTrace();
//                Optional<GOCContext> contextOld = GOCContext.copy();
//
//                command.run();
//
//                if (contextOld.isPresent()) {
//                    GOCContext.initBy(contextOld.get());
//                }
//            }
//        };
//    }
//
//    /**
//     * 线程池工厂
//     */
//    private static class AysnFactory implements ThreadFactory {
//
//        private final String mark;
//
//        private final AtomicInteger id = new AtomicInteger(0);
//
//        public AysnFactory(String mark) {
//            this.mark = mark;
//        }
//
//        @Override
//        public Thread newThread(Runnable runnable) {
//            Thread thread = new Thread(runnable);
//            thread.setDaemon(false);
//            thread.setPriority(Thread.MAX_PRIORITY);
//            thread.setName(mark + "/" + id.incrementAndGet());
//
//            /*
//             * 注册异常监听
//             */
//            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//                   @Override
//                   public void uncaughtException(Thread t, Throwable e) {
//                       logger.error(String.format("[Asyner] thread(%s) termination by uncaught exception: %s", t.getName(), e.getMessage()), e);
//                   }
//               }
//            );
//
//            return thread;
//        }
//    }
//}
