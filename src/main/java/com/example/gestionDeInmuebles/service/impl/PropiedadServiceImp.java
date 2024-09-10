package com.example.gestionDeInmuebles.service.impl;

import com.example.gestionDeInmuebles.entity.Predio;
import com.example.gestionDeInmuebles.entity.Propiedad;
import com.example.gestionDeInmuebles.repository.PropiedadRepository;
import com.example.gestionDeInmuebles.service.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PropiedadServiceImp implements PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;


    @Override
    public List<Propiedad> getPropiedades(UUID idEmpresa){
        List<Propiedad> propiedadList =  this.propiedadRepository.findByIdempresa(idEmpresa);
        return propiedadList;
    }



    @Override
    public List<Predio> getPredioByPropiedad(UUID id){
        Propiedad propiedad =  this.propiedadRepository.findById(id).get();
        List<Predio> predioList = propiedad.getPredioList();
        return predioList;
    }

    @Override
    public Propiedad getPropiedadById(UUID id) {
        Propiedad propiedad = this.propiedadRepository.findById(id).get();
        return propiedad;
    }


    @Override
    public Propiedad createPropiedad(Propiedad propiedad){
        this.propiedadRepository.save(propiedad);
        return propiedad;
    }
}
