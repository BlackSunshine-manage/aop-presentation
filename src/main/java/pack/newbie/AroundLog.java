package pack.newbie;

import org.slf4j.event.Level;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AroundLog {
    Class loggingClass();

    Level levelsBefore() default Level.INFO;
    String baseMessageBefore();
    Values _1Before() default Values._0 ;
    Values _2Before() default Values._0 ;
    Values _3Before() default Values._0 ;

    Level levelsAfter() default Level.INFO;
    String baseMessageAfter();
    Values _3After() default Values._0 ;
    Values _1After() default Values._0 ;
    Values _2After() default Values._0 ;
}
