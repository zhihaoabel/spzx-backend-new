package com.abel.spzxmodel.dto.system;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 893969648L;

    private String userName;
    private String password;

}