package com.example.tp2.service;

import com.example.tp2.modele.Categorie;
import com.example.tp2.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired //fait une injection de dependance c-a-d permet d'utiliser les fonction de CategorieRepository
    private CategorieRepository categorieRepository;
    //les methodes CRUD
    //Methode Create
    public void saveCategorie(Categorie categorie){
        categorieRepository.save(categorie);//methode pour faire la sauvegarde
    }

    //Methode Read
    public List<Categorie> categorieList(){
        return categorieRepository.findAll();//fonction permettant de lister tous les categories
    }

    //Methode Update
    public Categorie showOneCategorie(int id){
        return categorieRepository.findById(id).get();
    }

    //Methode Delete
    public void deleteCategorie(int id){
        categorieRepository.deleteById(id);
    }
}
