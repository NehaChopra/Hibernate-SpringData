package com.quintifi.HibernateCRUD.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quintifi.HibernateCRUD.domain.Article;

@Service
public interface ArticleService{
	List<Article> getAllArticles(); 
	Article getArticleById(long articleId);
	Article addArticle(Article article);
	Article updateArticle(Article Article);
	void deleteArticle(long articleId);
}
