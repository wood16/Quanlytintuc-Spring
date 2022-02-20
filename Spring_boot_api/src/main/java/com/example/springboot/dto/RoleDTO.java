package com.example.springboot.dto;

public class RoleDTO extends BaseDTO{
    private String code;
    private String roleName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
