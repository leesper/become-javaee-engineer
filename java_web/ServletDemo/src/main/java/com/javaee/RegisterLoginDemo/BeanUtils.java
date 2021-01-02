package com.javaee.RegisterLoginDemo;

import java.util.Map;

public class BeanUtils {
    public static void populate(User user, Map<String, String[]> map) throws Exception {
        if (user == null) {
            throw new NullPointerException();
        }

        String[] params = map.get("username");
        if (params == null || params.length == 0) {
            throw new Exception("username missed");
        }
        user.setUsername(params[0]);

        params = map.get("password");
        if (params == null || params.length == 0) {
            throw new Exception("password missed");
        }
        user.setPassword(params[0]);

        params = map.get("email");
        if (params == null || params.length == 0) {
            throw new Exception("email missed");
        }
        user.setEmail(params[0]);

        params = map.get("name");
        if (params == null || params.length == 0) {
            throw new Exception("name missed");
        }
        user.setName(params[0]);

        params = map.get("gender");
        if (params == null || params.length == 0) {
            throw new Exception("gender missed");
        }
        user.setGender(params[0]);

        params = map.get("birthday");
        if (params == null || params.length == 0) {
            throw new Exception("birthday missed");
        }
        user.setBirthday(params[0]);
    }
}
