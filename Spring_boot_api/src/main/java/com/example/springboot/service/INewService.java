package com.example.springboot.service;

import com.example.springboot.dto.NewsDTO;

import java.util.List;

public interface INewService {
    List<NewsDTO> findAll();
    NewsDTO findById(Long id);
    NewsDTO save(NewsDTO newsDTO);
    void deleteById(Long id);
}
