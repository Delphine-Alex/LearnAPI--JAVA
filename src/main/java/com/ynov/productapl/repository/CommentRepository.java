package com.ynov.productapl.repository;

import org.springframework.data.repository.CrudRepository;

import com.ynov.productapl.model.Comment;

public interface CommentRepository  extends CrudRepository<Comment, Integer>{

}
