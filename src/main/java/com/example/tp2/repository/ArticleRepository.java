package com.example.tp2.repository;

import com.example.tp2.modele.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {
    @Modifying//precise que c'est une requete de modification
    @Transactional//obliger
    @Query("update Article a set a.qteStock=a.qteStock + :qte where a.id= :idd") //requete personnaliser
    void updateStockProduit(@Param("idd") int idd,@Param("qte") int qte);

    @Modifying//precise que c'est une requete de modification
    @Transactional//obliger
    @Query("update Article a set a.qteStock=a.qteStock - :qte where a.id= :idd") //requete personnaliser
    void venteProduit(@Param("idd") int idd,@Param("qte") int qte);

    @Modifying//precise que c'est une requete de modification
    @Transactional//obliger
    @Query("update Article a set a.prix=a.prix * :qte where a.id= :idd") //requete personnaliser
    void prixTotal(@Param("idd") int idd,@Param("qte") int qte);
}
