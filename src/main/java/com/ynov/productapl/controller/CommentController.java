package com.ynov.productapl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.productapl.model.Comment;
import com.ynov.productapl.model.Product;
import com.ynov.productapl.service.CommentService;
import com.ynov.productapl.service.ProductService;

@RestController
public class CommentController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CommentService commentService;

	@PostMapping("/comment/{id}")
	public Product addComment(@PathVariable("id") Integer id, @RequestBody Comment comment) {
	
		Product existingProduct = productService.getProduct(id).get();
		existingProduct.getComments().add(comment);
		return productService.upsert(existingProduct);
	}
	
	//@DeleteMapping("/comment/{id}")
	// public void delete (@PathVariable("id") Integer id){
	// commentService.deleteComment(id);
	@DeleteMapping("/comment/{id_comment}/product/{id_product}")
    public void delete(@PathVariable("id_comment") Integer id_comment,@PathVariable("id_product") Integer id_product) {
        Comment c= commentService.getComment(id_comment).get();
        Product p = productService.getProduct(id_product).get();
        p.getComments().remove(c);
        p=productService.upsert(p);
    }
}
