package com.example.springboot.util;

import com.example.springboot.dto.CommentDTO;
import com.example.springboot.entity.CommentEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    public CommentDTO toDTO(CommentEntity commentEntity){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setContent(commentEntity.getContent());
        commentDTO.setLiked(commentEntity.getLiked());

        return commentDTO;
    }
}
