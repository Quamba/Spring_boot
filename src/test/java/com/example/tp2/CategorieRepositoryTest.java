package com.example.tp2;

import com.example.tp2.modele.Categorie;
import com.example.tp2.repository.CategorieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class CategorieRepositoryTest {

    @Autowired
    CategorieRepository categorieRepository;

    @Test
    public void SaveCategorieTest(){
        Categorie categorie=Categorie.builder().designation("cosmetique").build();
        categorieRepository.save(categorie);
        Assertions.assertThat(categorie.getId()).isGreaterThan(0);
    }
}
