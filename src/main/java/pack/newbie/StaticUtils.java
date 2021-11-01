package pack.newbie;

import org.slf4j.Logger;
import org.slf4j.event.Level;

public abstract class StaticUtils {
    private StaticUtils() { }

    private static final String DOTE_CLASS = ".class";

    public static final Level switchLogLevel(Logger log, Level level, String baseMessage, String... args) {
        var count = args.length;
        switch (level) {
            case ERROR -> {
                switch (count) {
                    case 0 -> log.error(baseMessage);
                    case 1 -> log.error(baseMessage, args[0]);
                    case 2 -> log.error(baseMessage, args[0], args[1]);
                    case 3 -> log.error(baseMessage, args[0], args[1], args[2]);
                    case 4 -> log.error(baseMessage, args[0], args[1], args[2], args[3]);
                    case 5 -> log.error(baseMessage, args[0], args[1], args[2], args[3], args[4]);
                    case 6 -> log.error(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5]);
                    case 7 -> log.error(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
                    case 8 -> log.error(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
                    case 9 -> log.error(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
                }
            }
            case INFO -> {
                switch (count) {
                    case 0 -> log.info(baseMessage);
                    case 1 -> log.info(baseMessage, args[0]);
                    case 2 -> log.info(baseMessage, args[0], args[1]);
                    case 3 -> log.info(baseMessage, args[0], args[1], args[2]);
                    case 4 -> log.info(baseMessage, args[0], args[1], args[2], args[3]);
                    case 5 -> log.info(baseMessage, args[0], args[1], args[2], args[3], args[4]);
                    case 6 -> log.info(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5]);
                    case 7 -> log.info(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
                    case 8 -> log.info(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
                    case 9 -> log.info(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
                }
            }
            case WARN -> {
                switch (count) {
                    case 0 -> log.warn(baseMessage);
                    case 1 -> log.warn(baseMessage, args[0]);
                    case 2 -> log.warn(baseMessage, args[0], args[1]);
                    case 3 -> log.warn(baseMessage, args[0], args[1], args[2]);
                    case 4 -> log.warn(baseMessage, args[0], args[1], args[2], args[3]);
                    case 5 -> log.warn(baseMessage, args[0], args[1], args[2], args[3], args[4]);
                    case 6 -> log.warn(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5]);
                    case 7 -> log.warn(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
                    case 8 -> log.warn(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
                    case 9 -> log.warn(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
                }
            }
            case DEBUG -> {
                switch (count) {
                    case 0 -> log.debug(baseMessage);
                    case 1 -> log.debug(baseMessage, args[0]);
                    case 2 -> log.debug(baseMessage, args[0], args[1]);
                    case 3 -> log.debug(baseMessage, args[0], args[1], args[2]);
                    case 4 -> log.debug(baseMessage, args[0], args[1], args[2], args[3]);
                    case 5 -> log.debug(baseMessage, args[0], args[1], args[2], args[3], args[4]);
                    case 6 -> log.debug(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5]);
                    case 7 -> log.debug(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
                    case 8 -> log.debug(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
                    case 9 -> log.debug(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
                }
            }
            case TRACE -> {
                switch (count) {
                    case 0 -> log.trace(baseMessage);
                    case 1 -> log.trace(baseMessage, args[0]);
                    case 2 -> log.trace(baseMessage, args[0], args[1]);
                    case 3 -> log.trace(baseMessage, args[0], args[1], args[2]);
                    case 4 -> log.trace(baseMessage, args[0], args[1], args[2], args[3]);
                    case 5 -> log.trace(baseMessage, args[0], args[1], args[2], args[3], args[4]);
                    case 6 -> log.trace(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5]);
                    case 7 -> log.trace(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
                    case 8 -> log.trace(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
                    case 9 -> log.trace(baseMessage, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + log);
        }
        return null;
    }

    public static final Class<?> getClassFromFileName(String fileName) throws ClassNotFoundException {
        return Class.forName(parseFileNameToJavaClass(fileName));//Class.forName(fileName));
    }

    private static String parseFileNameToJavaClass(String rawName){
        var name = rawName.split("[\\.]");
        switch (name.length){
            case 2: {
                ClassLoader.getSystemClassLoader().getDefinedPackage(name[0]);
                System.out.println("Все норм.");
                return name[0];
            }
            default: {
                System.out.println("Не очень норм");
                return "";
            }
        }
    }




}
