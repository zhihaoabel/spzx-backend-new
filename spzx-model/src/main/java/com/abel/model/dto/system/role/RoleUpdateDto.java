package com.abel.model.dto.system.role;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleUpdateDto {

    @NotBlank(message = "角色ID不能为空")
    private String id;

    @NotBlank(message = "角色名称不能为空")
    private String name;

    private String description;
}
