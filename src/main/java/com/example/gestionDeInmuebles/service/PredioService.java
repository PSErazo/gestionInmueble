package com.example.gestionDeInmuebles.service;

import com.example.gestionDeInmuebles.entity.Predio;
import com.example.gestionDeInmuebles.entity.Propiedad;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface PredioService {

    public Predio createPredio(Predio predio);
    public Predio getPredioById(UUID id);

}
