package com.example.tp2.service;

import com.example.tp2.modele.Article;
import com.example.tp2.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public void saveArticle(Article article){
        articleRepository.save(article);
    }

    public List<Article> listArticle(){
        return articleRepository.findAll();
    }

    public Article showOneArticle(int id){
        return articleRepository.findById(id).get();
    }

    public void deleteOneArticle(int id){
        articleRepository.deleteById(id);
    }

    public void updateStockProduit(int id,int qte){
        articleRepository.updateStockProduit(id,qte);
    }

    public void venteProduit(int id,int qte){
        articleRepository.venteProduit(id,qte);
    }

    public void prixTotal(int id,int qte){
        articleRepository.prixTotal(id,qte);
    }
}
