package com.abel.model.dto.system;

import java.io.Serial;
import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CaptchaDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 514056027L;

    /**
     * 验证码key
     */
    @NotBlank(message = "验证码key不能为空")
    private String key;

    /**
     * 验证码图片中的文本
     */
    @NotBlank(message = "验证码不能为空")
    private String captcha;

}
