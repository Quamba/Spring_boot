package com.example.tp2.controller;

import com.example.tp2.modele.Article;
import com.example.tp2.modele.Users;
import com.example.tp2.service.ArticleService;
import com.example.tp2.service.CategorieService;
import com.example.tp2.service.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
//@RequestMapping("/article")
public class ArticleController {

    //--------------------SECURITY-------------------------------//
    @Autowired
    private SecurityUserDetailsService userDetailsManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        session.setAttribute(
                "error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
        );
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(Users users) {
        userDetailsManager.createUser(users);
        return "redirect:login";
    }
    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }
    //-----------------------------------------------------------//

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategorieService categorieService;
    @GetMapping("article/afficher")
    public String ShowArticle(Model model){
        model.addAttribute("listArticle",articleService.listArticle());

        return "/article/ListeArticle";
    }

    @GetMapping("article/form")
    public String articleForm(Model model){
        model.addAttribute("listCategorie",categorieService.categorieList());
        return "/article/FormulaireArticle";
    }

    @PostMapping("/article/save")
    public String ajouterArticle(Article article){
        article.setDateCreation(LocalDate.now());
        article.setQteStock(0);
        articleService.saveArticle(article);
        return "redirect:/article/afficher";
    }

    @GetMapping("article/update/{id}")
    public String formUpdate(@PathVariable("id") int id, Model model){
        model.addAttribute("UneArticle",articleService.showOneArticle(id));
        model.addAttribute("listCategorie",categorieService.categorieList());
        return "/article/formUpdate";
    }

    @PostMapping("/article/update")
    public String UpdateArticle(@ModelAttribute("article") Article article){
        articleService.saveArticle(article);
        return "redirect:/article/afficher";
    }

    @GetMapping("article/delete/{id}")
    public String deleteArticle(@PathVariable("id") int id){
        articleService.deleteOneArticle(id);
        return "redirect:/article/afficher";
    }

    @PostMapping("/article/nouveau")
    public String nouvelArticle(@ModelAttribute  Article article){
        return  "redirect:/article/form";
    }

}
