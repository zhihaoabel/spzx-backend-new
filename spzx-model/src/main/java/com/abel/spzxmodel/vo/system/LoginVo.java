package com.abel.spzxmodel.vo.system;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginVo implements Serializable {

    private static final long serialVersionUID = 989367016L;
    
    private String token;

    private String refreshToken;

}
