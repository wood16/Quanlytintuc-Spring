package com.example.springboot.service.impl;

import com.example.springboot.dto.RoleDTO;
import com.example.springboot.entity.RoleEntity;
import com.example.springboot.repository.RoleRepository;
import com.example.springboot.service.IRoleService;
import com.example.springboot.util.RoleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleConverter roleConverter;

    @Override
    public List<RoleDTO> findAll() {
        List<RoleDTO> listDTO = new ArrayList<>();
        List<RoleEntity> listEntity = roleRepository.findAll();
        for(RoleEntity element : listEntity){
            listDTO.add(roleConverter.toDTO(element));
        }
        return listDTO;
    }

//    thu bat loi o day
    @Override
    public RoleDTO findById(Long id) {
        Optional<RoleEntity> roleEntity = roleRepository.findById(id);
//        de if thi khong bat duoc loi o ExceptionHandler (vd la NewService)
//        if(roleEntity.isPresent()){
            return roleConverter.toDTO(roleEntity.get());
//        }
//        return null;
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        RoleEntity roleEntity = roleConverter.toEntity(roleDTO);
        return roleConverter.toDTO(roleRepository.save(roleEntity));
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
