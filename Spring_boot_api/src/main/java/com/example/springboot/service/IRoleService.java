package com.example.springboot.service;

import com.example.springboot.dto.RoleDTO;

import java.util.List;

public interface IRoleService {
    List<RoleDTO> findAll();
    RoleDTO findById(Long id);
    RoleDTO save(RoleDTO roleDTO);
    void deleteById(Long id);
}
