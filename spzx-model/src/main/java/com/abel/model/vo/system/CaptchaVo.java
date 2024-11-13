package com.abel.model.vo.system;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CaptchaVo {

    /**
     * 验证码key
     */
    private String key;

    /**
     * 验证码base64
     */
    private String base64;

}
