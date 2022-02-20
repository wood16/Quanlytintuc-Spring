package com.example.springboot.service.impl;

import com.example.springboot.dto.NewsDTO;
import com.example.springboot.entity.NewsEntity;
import com.example.springboot.repository.NewsRepository;
import com.example.springboot.service.INewService;
import com.example.springboot.util.NewConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewService implements INewService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public List<NewsDTO> findAll() {
        List<NewsEntity> list = newsRepository.findAll();
        List<NewsDTO> listDTO = new ArrayList<>();
        for(NewsEntity item : list){
            listDTO.add(newConverter.toDto(item));
        }
        return listDTO;
    }

    @Override
    public NewsDTO findById(Long id) {
        Optional<NewsEntity> newsEntity = newsRepository.findById(id);
        if (newsEntity.isPresent()){
            return newConverter.toDto(newsEntity.get());
        }
        return null;
    }

    @Override
    public NewsDTO save(NewsDTO newsDTO) {
        NewsEntity newsEntity = newConverter.toEntity(newsDTO);
        return newConverter.toDto(newsRepository.save(newsEntity));
    }

    @Override
    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }


}
