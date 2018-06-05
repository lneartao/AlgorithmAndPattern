package com.general.lneartao.lib.basic.reflect.constructor;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class RestoreAliases {
    private static Map<String, String> defaultAliases = new HashMap<>();

    static {
        defaultAliases.put("Duke", "Hi Duke!");
        defaultAliases.put("Fang", "Hi Fang");
    }

    public static void main(String[] args) {
        try {
            Constructor ctor = EmailAliases.class.getDeclaredConstructor(HashMap.class);
            ctor.setAccessible(true);
            EmailAliases emailAliases = (EmailAliases) ctor.newInstance(defaultAliases);
            emailAliases.printKeys();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

class EmailAliases {
    private Set<String> aliases;

    private EmailAliases(HashMap<String, String> h) {
        aliases = h.keySet();
    }

    public void printKeys() {
        Logger.printl("Mail keys: ");
        for (String k : aliases) {
            Logger.printl(k);
        }
    }
}
