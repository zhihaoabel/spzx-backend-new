package com.abel.common.util;

import java.util.function.Supplier;

public class AssertUtil {
    public static void isNull(Object obj, String message) {
        if (obj == null) {
            throw new RuntimeException(message);
        }
    }

    public static void isEmpty(String str, String message) {
        if (str == null || str.isEmpty()) {
            throw new RuntimeException(message);
        }
    }

    public static void notNull(Object obj, Supplier<String> messageSupplier) {
        if (obj == null) {
            throw new RuntimeException(messageSupplier.get());
        }
    }

    public static void notEmpty(String str, Supplier<String> messageSupplier) {
        if (str == null || str.isEmpty()) {
            throw new RuntimeException(messageSupplier.get());
        }
    }

    

}
