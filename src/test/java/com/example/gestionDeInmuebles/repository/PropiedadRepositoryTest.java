package com.example.gestionDeInmuebles.repository;

import com.example.gestionDeInmuebles.entity.Predio;
import com.example.gestionDeInmuebles.entity.Propiedad;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropiedadRepositoryTest {

    @Autowired
    PropiedadRepository propiedadRepository;

    @Test
    public void savePropiedad(){
        Propiedad propiedad = Propiedad.builder()
                        .ubigeo("010102")
                                .build();

        propiedadRepository.save(propiedad);
    }
    @Test
    public void getPropiedades(){
        List<Propiedad> propiedades = propiedadRepository.findAll();
        System.out.println("Propiedades = " + propiedades);
    }


}