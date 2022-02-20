package com.example.springboot.api;

import com.example.springboot.entity.CommentEntity;
import com.example.springboot.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Transactional
@RestController
@RequestMapping(path = "/api/comment", produces = "application/json")
public class CommentAPI {

    private CommentRepository commentRepository;

    @Autowired
    public CommentAPI(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping
    public Iterable<CommentEntity> getAllCommentEntity(){
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public CommentEntity getCommentEntityById(@PathVariable("id") Long id){
        Optional<CommentEntity> commentEntity = commentRepository.findById(id);
        if(commentEntity.isPresent()){
            return commentEntity.get();
        }
        return null;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CommentEntity putCommentEntity(
            @RequestBody CommentEntity commentEntity){
        return commentRepository.save(commentEntity);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentEntity postCommentEntity(@RequestBody CommentEntity commentEntity){
        return commentRepository.save(commentEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentEntityById(@PathVariable("id") Long id){
        commentRepository.deleteById(id);
    }
}
