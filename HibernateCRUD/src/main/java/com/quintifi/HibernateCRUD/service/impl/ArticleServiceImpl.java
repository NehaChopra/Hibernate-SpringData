package com.quintifi.HibernateCRUD.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.quintifi.HibernateCRUD.domain.Article;
import com.quintifi.HibernateCRUD.repository.ArticleRepository;
import com.quintifi.HibernateCRUD.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public List<Article> getAllArticles() {
		List<Article> articles = new ArrayList<Article>();
		articleRepository.findAll().forEach(article -> articles.add(article));
		return articles;
	}

	@Override
	public Article getArticleById(long articleId) {
		return articleRepository.findById(articleId).get();
	}

	@Override
	public Article addArticle(Article article) {
		List<Article> exitingArticle = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory());
		if(exitingArticle.size() > 0) {
			return exitingArticle.get(0);
		}else {
			return articleRepository.save(article);
		}
	}

	@Override
	public Article updateArticle(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public void deleteArticle(long articleId) {
		articleRepository.deleteById(articleId);
	}
}
