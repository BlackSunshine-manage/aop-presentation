package pack.newbie;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static pack.newbie.Values._1;


/**
 * Класс, содержащий примеры работы с самыми простыми ситуациями
 */
public class Hello {
    private static final Logger log = LoggerFactory.getLogger(Hello.class);
//    /**
//     * TODO: ПРИМЕР ИЗ ПРЕЗЕНТАЦИИ. ЛОГИРОВАНИЕ БЕЗ АСПЕКТОВ.
//     * Раскомментировать для проверки и закомментировать пример с исключением
//     */
//    public String receive(String processId, BusinessTask businessTask) throws InterruptedException {
//        log.info("Задача принята в обработку. Идентификатор процесса [{}]", processId);
//
//        /* Обработка бизнес-задачи. Результат - String */
//        var resultProcessing = businessTask.process();
//
//        log.info("Задача полность завершена. Идентификатор процесса [{}]", processId);
//        return resultProcessing;
//    }
//    /**
//     * TODO: ПРИМЕР ИЗ ПРЕЗЕНТАЦИИ. ЛОГИРОВАНИЕ С АСПЕКТАМИ.
//     * Раскомментировать для проверки и закомментировать пример с исключением
//     */
//    @AroundLog(loggingClass = Hello.class, baseMessageBefore = "Задача принята в обработку. Идентификатор процесса [{}]", _1Before = _1,
//            baseMessageAfter = "Задача полность завершена. Идентификатор процесса [{}]", _1After = _1)
//    public String receiveWithAspect(String processId, BusinessTask businessTask) throws InterruptedException {
//        /* Обработка бизнес-задачи */
//        return businessTask.process();
//    }

/**
 * TODO: ПРИМЕР ИЗ ПРЕЗЕНТАЦИИ. ПЕРЕХВАТ ИСКЛЮЧЕНИЙ БЕЗ АСПЕКТОВ
 * Раскомментировать для проверки и закомментировать пример с логированием
 */
    public void receive(String processId, BusinessTask businessTask) {
        try {
            /* Выбрасывает new Exception("Message exception in class ["+getClass()+"]") */
            businessTask.throwException();
        } catch (Exception e) {
            log.error("Произошла ошибка. Описание: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * TODO: ПРИМЕР ИЗ ПРЕЗЕНТАЦИИ. ПЕРЕХВАТ ИСКЛЮЧЕНИЙ С АСПЕКТАМИ.
     * Раскомментировать для проверки и закомментировать пример с логированием
     */
    @CatchAndLog(baseMessage = "Произошла ошибка. Описание: {}")
    public void receiveWithAspect(String processId, BusinessTask businessTask) throws Exception {
        businessTask.throwException();
    }
}
