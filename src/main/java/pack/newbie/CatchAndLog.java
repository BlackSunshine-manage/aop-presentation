package pack.newbie;

import org.slf4j.event.Level;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CatchAndLog {
    Class<Exception> exceptionClass() default Exception.class;

    Level logLevel() default Level.INFO;

    String baseMessage();

    boolean writeExceptionInLog() default true;

    Values val1() default Values._0;

    Values val2() default Values._0;
}
