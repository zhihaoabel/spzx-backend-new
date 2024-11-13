package com.abel.model.vo.system;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;

@Data
public class LoginVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 989367016L;
    
    private String token;

    private String refreshToken;

}
