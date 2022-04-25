package com.codewithdurgesh.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.entities.Post;
import com.codewithdurgesh.blog.payloads.ApiResponse;
import com.codewithdurgesh.blog.payloads.PostDto;
import com.codewithdurgesh.blog.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	PostService postservice;
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId){
		PostDto cretePost=postservice.createPost(postDto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(cretePost,HttpStatus.CREATED);
		
	}
	//get post by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		List<PostDto> posts=postservice.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
	}
	//get post by category
		@GetMapping("/category/{categoryId}/posts")
		public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
			List<PostDto> posts=postservice.getPostsByCategory(categoryId);
			return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
			
		}
	//get all posts
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPost(){
		
		return new ResponseEntity<List<PostDto>>(this.postservice.getAllPost(), HttpStatus.OK);
		
	}
	//get post by id
	@GetMapping("/posts/{postId}")
     public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		
		return new ResponseEntity<PostDto>(this.postservice.getPost(postId), HttpStatus.OK);
     }
	//delete
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postservice.deletePost(postId);
		return new ApiResponse("post deleted", true);
		
	}
	//PUt Mapping
		@PutMapping("/posts/{postId}")
		public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
			PostDto updatedPost=this.postservice.updatePost(postDto, postId);
			return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
			
		}
		
}
