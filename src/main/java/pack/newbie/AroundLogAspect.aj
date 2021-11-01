package pack.newbie;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;

/**
 * ПРИМЕР ИЗ ПРЕЗЕНТАЦИИ
 *
 * Присутствуют аспекты по:
 * 1. Обработка логирования вокруг какого-либо метода
 * 2. Логирования И перехвата исключения аннотаций: AroundLog
 *
 *
 * */
@Aspect
public class AroundLogAspect implements DebuggerAJ{

    /**
     * Точка среза на аннотацию AroundLog по кейсам:
     * <table>
     *  <tr>
     *      <th>№ Условия</th>
     *      <th>Условие</th>
     *      <th>Взаимодействие с условиями</th>
     *      <th>Порядок</th>
     *  </tr>
     *  <tr>
     *      <td>№1</td>
     *      <td>Нахождение над структурой или функцией аннотации {@link AroundLog}</td>
     *      <td>№1 И (&) №2</td>
     *      <td>1</td>
     *  </tr>
     *  <tr>
     *      <td>№2</td>
     *      <td>Выполнение метода (по условию абсолютно любого)</td>
     *      <td>№1 И (&) №2</td>
     *      <td>1</td>
     *  </tr>
     * </table>
     * */
    @Pointcut("@annotation(aroundLog) && execution(* * (..))")
    public void callAt(AroundLog aroundLog) { }

    /**
     * ПРИМЕР ИЗ ПРЕЗЕНТАЦИИ
     * */
    @Around("callAt(aroundLog)")
    public Object execute(ProceedingJoinPoint pjp, AroundLog aroundLog) throws Throwable {
        /* возвращает класс, в котором был вызван аспект */
        var currentExecuteClass = pjp.getSourceLocation().getWithinType();
        debugPoint(pjp);
        var log = LoggerFactory.getLogger(currentExecuteClass);

        if(aroundLog._1Before() != Values._0){
            log.info(aroundLog.baseMessageBefore(), pjp.getArgs()[0]);
        }
        var obj = pjp.proceed();
        if (aroundLog._1Before() != Values._0){
            log.info(aroundLog.baseMessageAfter(), pjp.getArgs()[0]);
        }
        return obj;
    }
}
