package com.example.tp2.service;


import com.example.tp2.modele.Vente;
import com.example.tp2.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    @Autowired
    VenteRepository venteRepository;

    public void saveVente(Vente vente){
        venteRepository.save(vente);
    }

    public List<Vente> listVente(){
        return venteRepository.findAll();
    }

    public Vente showOneVente(int id){
        return venteRepository.findById(id).get();
    }

    public void deleteOneVente(int id){
        venteRepository.deleteById(id);
    }
}
