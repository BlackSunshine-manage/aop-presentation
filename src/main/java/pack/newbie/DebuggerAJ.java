package pack.newbie;

/**
 * Интерфейс создан для отладки аспектов.
 * Причина создания:
 * Попасть в те точки, куда дебаггер IntelliJ IDEA попасть не может
 *
 * Использование:
 * Вставляя те или иные методы в классы-аспекты перехватывать те или иные объекты.
 * В методы вставлять брейкпоинты и ловить
 * */
public interface DebuggerAJ {

    /**
     * Для случаев, когда на вход подается 1 объект
     * */
    default Object debugPoint(Object obj){
        return obj;
    }


    /**
     * Для случаев, когда подается на вход более одного объекта(Raw type)
     * */
    default Object debugPoint(Object ... obj){
        return obj;
    }

    /**
     * Для случаев, когда на вход подается 1 объект
     * И нужно что-то напечатать специфичное в STDOUT
     * */
    default Object debugPoint(String look, Object obj){
        System.out.println(look);
        return obj;
    }


    /**
     * Для случаев, когда подается на вход более одного объекта(Raw type)
     * И нужно что-то напечатать специфичное в STDOUT
     * */
    default Object debugPoint(String look, Object ... obj){
        System.out.println(look);
        return obj;
    }
}
