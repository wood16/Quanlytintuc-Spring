package com.example.springboot.api;

import com.example.springboot.dto.NewsDTO;
import com.example.springboot.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
//@CrossOrigin
@RequestMapping(path = "/api/news", produces = "application/json")
public class NewsAPI {

    @Autowired
    private INewService newService;

    @GetMapping
    public List<NewsDTO> getAllNewsDTO(){
        return newService.findAll();
    }

    @GetMapping("/{id}")
    public NewsDTO getNewsDTOById(@PathVariable("id") Long id){
        return newService.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public NewsDTO putNewsDTO(@RequestBody NewsDTO newsDTO){
        return newService.save(newsDTO);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public NewsDTO postNewsDTO(@RequestBody NewsDTO newsDTO){
        return newService.save(newsDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteNewsDTOById(@PathVariable("id") Long id){
        newService.deleteById(id);
    }
}
