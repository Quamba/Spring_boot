package com.example.tp2.controller;

import com.example.tp2.modele.Approvisionnement;
import com.example.tp2.service.ApprovisionnementService;
import com.example.tp2.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ApprovisionnementController {
    @Autowired
    private ApprovisionnementService approvisionnementService;
    @Autowired
    private ArticleService articleService;

    //@PathVariable -->Permet de recuperer un parametrer
    //@ModelAttribute -->Permet de recuperer les attributs d'une classe

    @GetMapping("/approvisionnement/form/{id}")
    public String afficherForm(@PathVariable("id")int id,Model model){
        //System.out.println("*********************************id="+id);
        model.addAttribute("UneArticle",articleService.showOneArticle(id));
        return "Approvisionnement/FormAppro";
    }

    @PostMapping("/approvisionnement/creer")
    public String ajouterAppro(Approvisionnement approvisionnement){
        //System.out.println("*******************************id="+approvisionnement.getArticleId());
        approvisionnement.setDateAppro(LocalDate.now());
        approvisionnementService.saveAppro(approvisionnement);
        articleService.updateStockProduit(approvisionnement.getArticleId(),approvisionnement.getQteAppro());
        return "redirect:/article/afficher";
    }
}
