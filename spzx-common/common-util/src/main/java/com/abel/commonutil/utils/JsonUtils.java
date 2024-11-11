package com.abel.commonutil.utils;

import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {

    // 定义敏感字段
    private static final Set<String> SENSITIVE_FIELDS = Set.of(
            "password", "phone", "email", "idCard"
    );

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }

        try {
            return JSON.toJSONString(obj,
                    JSONWriter.Feature.PrettyFormat,
                    JSONWriter.Feature.WriteMapNullValue,
                    JSONWriter.Feature.WriteNullListAsEmpty
            );
        } catch (Exception e) {
            log.error("JSON序列化失败", e);
            return String.valueOf(obj);
        }
    }

    public static String toSafeJson(Object obj) {
        if (obj == null) {
            return null;
        }

        try {
            // 复制对象，避免修改原对象
            Object copy = JSON.parse(JSON.toJSONString(obj));

            // 如果是Map，处理敏感字段
            if (copy instanceof Map<?, ?>) {
                @SuppressWarnings("unchecked")
                Map<String, Object> map = (Map<String, Object>) copy;
                map.forEach((key, value) -> {
                    if (SENSITIVE_FIELDS.contains(key)) {
                        map.put(key, "******");
                    }
                });
            }

            return toJson(copy);
        } catch (Exception e) {
            log.error("安全JSON序列化失败", e);
            return String.valueOf(obj);
        }
    }
}
