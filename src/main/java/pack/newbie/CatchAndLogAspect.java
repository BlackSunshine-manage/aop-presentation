package pack.newbie;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;

@Aspect
public class CatchAndLogAspect {
    @Pointcut("@annotation(catchAndLog) && execution(* * (..))")
    public void throwing(CatchAndLog catchAndLog) {
    }

    @AfterThrowing(value = "throwing(catchAndLog)", throwing = "exception")
    public void execute(CatchAndLog catchAndLog, Throwable exception) throws Throwable {
        var log = LoggerFactory.getLogger(Hello.class);
        log.error(catchAndLog.baseMessage(), exception.getMessage());
        exception.printStackTrace();
    }
//    /**
//     * TODO: Раскомментировать здесь для получения стэктрейса ошибок при подключении аспектов.
//     */
//    @Around(value = "throwing(catchAndLog)")
//    public void executeSuppressException(ProceedingJoinPoint pjp, CatchAndLog catchAndLog) throws Throwable{
//        Object val =null;
//        try{ /* TODO: Перенос на новую строчку вставлял сюда, дабы удостовериться что в стектрейсе именно сюда ссылается 3 строчка, а не в класс Hello */
//            val = pjp.proceed();
//        }catch (Throwable throwable){ }
//    }


//    @Aspect
//    public static class CompositionAroundLogAndCatchAndLogAspect {
//        @Pointcut("@annotation(aroundLog) &&" +
//                " @annotation(catchAndLog) &&" +
//                " execution(* * (..))")
//        public void declareCombination(AroundLog aroundLog, CatchAndLog catchAndLog) {
//        }
//

    /* raw method */
//        @Around("declareCombination(aroundLog, catchAndLog)")
//        public Object combinationAroundLogCatchAndLog(AroundLog aroundLog, CatchAndLog catchAndLog, ProceedingJoinPoint point) {
//            Object returned = null;
//            var args = point.getArgs();
//            var log = LoggerFactory.getLogger(aroundLog.loggingClass());
//            var _1B = aroundLog._1Before();
//            try {
//                StaticUtils.switchLogLevel(log, aroundLog.levelsBefore(), aroundLog.baseMessageBefore());// TODO: Дополнить логику.
//                returned = point.proceed();
//            } catch (Throwable exception1) {
//                StaticUtils.SWITCH_LOG_LEVEL(log, catchAndLog.logLevel(), catchAndLog.baseMessage());
//            }
//            return returned;
//        }
//    }
}
