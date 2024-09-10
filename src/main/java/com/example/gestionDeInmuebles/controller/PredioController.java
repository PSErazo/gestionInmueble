package com.example.gestionDeInmuebles.controller;

import com.example.gestionDeInmuebles.controller.dto.PredioDTO;
import com.example.gestionDeInmuebles.entity.Predio;
import com.example.gestionDeInmuebles.entity.TipoPredio;
import com.example.gestionDeInmuebles.service.PredioService;
import com.example.gestionDeInmuebles.service.TipoPredioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(path = "predio")
public class PredioController {

    @Autowired
    private PredioService predioService;

    @Autowired
    private TipoPredioService tipoPredioService;

                /*CREAR UN NUEVO PREDIO ASOCIANDOLO A UNA PROPIEDAD Y UN TIPO DE PREDIO*/
    @PostMapping
    @RequestMapping(value = "crearpredio", method = RequestMethod.POST)
    public ResponseEntity<?> createPredio(@RequestBody PredioDTO predioDTO){
        Date date = new Date();

        Predio predio =  Predio.builder()
                .partida(predioDTO.getPartida())
                .direccion(predioDTO.getDireccion())
                .fechaHoraCreacion(date)
                .idUsuarioCreacion(UUID.randomUUID())
                .propiedad(predioDTO.getPropiedad())
                .tipoPredio(predioDTO.getTipoPredio())
                .build();

        this.predioService.createPredio(predio);
        return ResponseEntity.ok(predio);
    }

                /* ACTUALIZAR PREDIO POR ID */
    @PutMapping
    @RequestMapping(value = "updatepredio/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePredio(@PathVariable UUID id, @RequestBody PredioDTO predioDTO){

        Predio predio = predioService.getPredioById(id);

        Date date = new Date();
        if(predioDTO.getDireccion() != null)  predio.setDireccion(predioDTO.getDireccion());
        if(predioDTO.getPartida() != null)  predio.setPartida(predioDTO.getPartida());
        if(predioDTO.getTipoPredio() !=null) predio.setTipoPredio(predioDTO.getTipoPredio());


        /* Se trae y se actualiza ambos objetos - ambas tablas, ***mejorar esto***, investigar, otro modo es hacientolo por @querys en el repository,
        * investigar si hay otras formas mas eficientes*/

        /* Actualizar tipo de predio*/
        if (predioDTO.getTipoPredio() !=null) {
            UUID idTipoPredio = predioDTO.getTipoPredio().getIdtipopredio();
            TipoPredio tipoPredio = tipoPredioService.getTipoPredio(idTipoPredio);
            predio.setTipoPredio(tipoPredio);
        }
        predio.setFechaHoraUltimaModificacion(date);
        predio.setIdUsuarioUltimaModificacion(predioDTO.getIdUsuarioUltimaModificacion());
        this.predioService.createPredio(predio);
        return ResponseEntity.ok(predio);
    }

}
