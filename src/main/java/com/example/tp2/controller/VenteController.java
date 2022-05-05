package com.example.tp2.controller;

import com.example.tp2.modele.Vente;
import com.example.tp2.service.ArticleService;
import com.example.tp2.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class VenteController {
    @Autowired
    VenteService venteService;
    @Autowired
    ArticleService articleService;

    @GetMapping("/vente/afficher")
    public String ShowVente(Model model){
        model.addAttribute("listVente",venteService.listVente());

        return "/vente/ListeVente";
    }

    @GetMapping("/vente/form/{id}")
    public String afficherForm(@PathVariable("id")int id, Model model){
        model.addAttribute("UneArticle",articleService.showOneArticle(id));
        return "vente/FormVente";
    }

    @PostMapping("/vente/creer")
    public String ajouterVente(Vente vente){
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        articleService.venteProduit(vente.getArticleId(),vente.getQteVendu());
        articleService.prixTotal(vente.getArticleId(),vente.getQteVendu());
        return "redirect:/vente/afficher";
    }

    @PostMapping("/ventetotal/creer")
    public String total(Vente vente){
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        //articleService.venteProduit(vente.getArticleId(),vente.getQteVendu());
        articleService.prixTotal(vente.getArticleId(),vente.getQteVendu());
        return "redirect:/vente/afficher";
    }

}
