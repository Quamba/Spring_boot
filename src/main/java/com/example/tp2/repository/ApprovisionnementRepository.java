package com.example.tp2.repository;

import com.example.tp2.modele.Approvisionnement;
import com.example.tp2.modele.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovisionnementRepository extends JpaRepository<Approvisionnement,Integer> {

}
