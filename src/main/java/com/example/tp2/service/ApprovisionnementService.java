package com.example.tp2.service;

import com.example.tp2.modele.Approvisionnement;
import com.example.tp2.modele.Article;
import com.example.tp2.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {
    @Autowired
    ApprovisionnementRepository approvisionnementRepository;

    public void saveAppro(Approvisionnement approvisionnement){
        approvisionnementRepository.save(approvisionnement);
    }

    public List<Approvisionnement> listAppro(){
        return approvisionnementRepository.findAll();
    }

    public Approvisionnement showOneAppro(int id){
        return approvisionnementRepository.findById(id).get();
    }

    public void deleteOneAppro(int id){
        approvisionnementRepository.deleteById(id);
    }
}
