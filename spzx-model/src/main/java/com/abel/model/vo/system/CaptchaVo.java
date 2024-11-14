package com.abel.model.vo.system;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CaptchaVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 70662029L;

    /**
     * 验证码key
     */
    private String key;

    /**
     * 验证码base64
     */
    private String base64;

}
