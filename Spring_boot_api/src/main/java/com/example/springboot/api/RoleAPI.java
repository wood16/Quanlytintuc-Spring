package com.example.springboot.api;

import com.example.springboot.dto.RoleDTO;
import com.example.springboot.entity.RoleEntity;
import com.example.springboot.repository.RoleRepository;
import com.example.springboot.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping(path = "/api/role", produces = "application/json")
public class RoleAPI {

    @Autowired
    private IRoleService roleService;

    @GetMapping
    public List<RoleDTO> getAllRoleDTO(){
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public RoleDTO getRoleDTOById(@PathVariable("id") Long id){
        return roleService.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public RoleDTO putRoleDTO(@RequestBody RoleDTO roleDTO){
        return roleService.save(roleDTO);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO postRoleDTO(@RequestBody RoleDTO roleDTO){
        return roleService.save(roleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRoleDTOById(@PathVariable("id") Long id){
        roleService.deleteById(id);
    }
}
