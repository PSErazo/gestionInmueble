package com.example.gestionDeInmuebles.repository;


import com.example.gestionDeInmuebles.entity.Predio;
import com.example.gestionDeInmuebles.entity.Propiedad;
import com.example.gestionDeInmuebles.entity.TipoPredio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PredioRepositoryTest {

    @Autowired
    PredioRepository predioRepository;

    @Test
    public void savePredioP1(){
        Predio predio = Predio.builder()
                .direccion("calle los alcanfores 123")
                .build();
                predioRepository.save(predio);
    }

//    @Test
//    public void findPredioByPartida(){
//        Predio predio = predioRepository.findByPartida("123457").get();
//        System.out.println("Predio = " + predio);
//    }

    @Test
    public void savePredio(){
        Propiedad propiedad = Propiedad.builder()
                .ubigeo("010202")
                .nombrepropiedad("Miraflores")
                .build();
        TipoPredio tipoPredio = TipoPredio.builder()
                .nombretipo("Departamento")
                .descripcion("Departamento")
                .build();
        Predio predio = Predio.builder()
                .direccion("calle los alcantaras 777")
                .partida("123456")
                .propiedad(propiedad)
                .tipoPredio(tipoPredio)
                .build();
        predioRepository.save(predio);

    }
}