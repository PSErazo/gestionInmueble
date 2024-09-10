package com.example.gestionDeInmuebles.service;

import com.example.gestionDeInmuebles.entity.Predio;
import com.example.gestionDeInmuebles.entity.Propiedad;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PropiedadService {
    public List<Propiedad> getPropiedades(UUID idEmpresa);
    public List<Predio> getPredioByPropiedad(UUID id);

    public Propiedad getPropiedadById(UUID id);

    public Propiedad createPropiedad(Propiedad propiedad);



}
