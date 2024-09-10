package com.example.gestionDeInmuebles.service.impl;

import com.example.gestionDeInmuebles.entity.Predio;
import com.example.gestionDeInmuebles.repository.PredioRepository;
import com.example.gestionDeInmuebles.service.PredioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PredioServiceImp implements PredioService {

    @Autowired
    private PredioRepository predioRepository;


    @Override
    public Predio createPredio(Predio predio) {
        this.predioRepository.save(predio);
        return predio;
    }

    @Override
    public Predio getPredioById(UUID id) {
        Predio predio = this.predioRepository.findById(id).get();
        return predio;
    }

}
