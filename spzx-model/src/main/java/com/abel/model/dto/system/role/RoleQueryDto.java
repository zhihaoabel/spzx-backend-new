package com.abel.model.dto.system.role;

import java.io.Serial;

import com.abel.model.dto.base.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoleQueryDto extends BaseDTO {

    @Serial
    private static final long serialVersionUID = 953779832L;

    private String name;

    private String code;
}
