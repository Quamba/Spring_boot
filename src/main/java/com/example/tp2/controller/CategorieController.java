package com.example.tp2.controller;

import com.example.tp2.modele.Article;
import com.example.tp2.modele.Categorie;
import com.example.tp2.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

   @GetMapping("/afficher")
    public String ShowCategorie(Model model){
        model.addAttribute("listCategorie",categorieService.categorieList());
        return "Categorie/ListeCategories";
    }

    @GetMapping("/form")
    public String showFormulaire(){
       return "Categorie/FormulaireCategorie";
    }

    @PostMapping("/save")
    public String SaveCategorie(Categorie categorie){
       categorieService.saveCategorie(categorie);
       return "redirect:/categorie/afficher";
    }

    @GetMapping("/update/{id}") //Recuperer le parametre de la vue dans le controlleur
    public String formUpdate(@PathVariable("id") int id,Model model){
       model.addAttribute("UneCategorie",categorieService.showOneCategorie(id));
       return "Categorie/formUpdate";
    }

    @PostMapping("/update")
    public String UpdateCategorie(@ModelAttribute("categorie") Categorie categorie){
       categorieService.saveCategorie(categorie);
       return "redirect:/categorie/afficher";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategorie(@PathVariable("id") int id){
       categorieService.deleteCategorie(id);
        return "redirect:/categorie/afficher";
    }
    @PostMapping("/nouveau")
    public String nouvelleCategorie(@ModelAttribute Categorie categorie){
        return  "redirect:/categorie/form";
    }

    @PostMapping("/return")
    public String retourCategorie(@ModelAttribute  Categorie categorie){
        return  "redirect:/categorie//afficher";
    }

}
