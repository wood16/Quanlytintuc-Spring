package com.example.springboot.util;

import com.example.springboot.dto.RoleDTO;
import com.example.springboot.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
    public RoleEntity toEntity(RoleDTO roleDTO){
        RoleEntity roleEntity = new RoleEntity();
        if(roleDTO.getId() != null){
            roleEntity.setId(roleDTO.getId());
        }
        roleEntity.setCode(roleDTO.getCode());
        roleEntity.setRoleName(roleDTO.getRoleName());
        return roleEntity;
    }

    public RoleDTO toDTO(RoleEntity roleEntity){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(roleEntity.getId());
        roleDTO.setCode(roleEntity.getCode());
        roleDTO.setRoleName(roleEntity.getRoleName());
        return roleDTO;
    }
}
