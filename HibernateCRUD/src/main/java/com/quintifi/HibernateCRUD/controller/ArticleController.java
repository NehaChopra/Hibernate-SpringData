package com.quintifi.HibernateCRUD.controller;

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

import com.quintifi.HibernateCRUD.domain.Article;
import com.quintifi.HibernateCRUD.service.ArticleService;

@RestController
@RequestMapping(value = "/user")
public class ArticleController{
	
	@Autowired
	ArticleService articleService;
	
	@GetMapping("/article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id){
		Article article = articleService.getArticleById(id);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	
	@GetMapping("/articles")
	public ResponseEntity<List<Article>> getAllArticles(){
		List<Article> articles = articleService.getAllArticles();
		return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
	}
	
	@PostMapping("/article")
	public ResponseEntity<Article> addArticle(@RequestBody Article article){
		Article createdArticle = articleService.addArticle(article);
		return new ResponseEntity<Article>(createdArticle, HttpStatus.OK);
	}
	
	@PutMapping("/article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article){
		Article createdArticle = articleService.updateArticle(article);
		return new ResponseEntity<Article>(createdArticle, HttpStatus.OK);
	}
	
	@DeleteMapping("/article")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id){
		articleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
