package com.codewithdurgesh.blog.services;

import java.util.List;

import com.codewithdurgesh.blog.entities.Category;
import com.codewithdurgesh.blog.entities.Post;
import com.codewithdurgesh.blog.entities.User;
import com.codewithdurgesh.blog.payloads.PostDto;

public interface PostService {
	//create
	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	
	//updatePost
	Post updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//list of post
	List<Post> getAllPost();
	//get single post
	Post getPost(Integer postId);
	//list of posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	//list of posts by User
	List<PostDto> getPostsByUser(Integer userId);
	
}
