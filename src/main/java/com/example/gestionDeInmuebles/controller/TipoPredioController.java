package com.example.gestionDeInmuebles.controller;

import com.example.gestionDeInmuebles.controller.dto.TipoPredioDTO;
import com.example.gestionDeInmuebles.entity.TipoPredio;
import com.example.gestionDeInmuebles.service.TipoPredioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "tipopredio")
public class TipoPredioController {

    @Autowired
    private TipoPredioService tipoPredioService;

    @GetMapping
    @RequestMapping(value = "consultatipopredio", method = RequestMethod.GET)
    public ResponseEntity<?> GetTipoPredio(){
        List<TipoPredio> tipoPredioList = tipoPredioService.getTipoPredioList();
        return ResponseEntity.ok(tipoPredioList);
    }

    @PostMapping
    @RequestMapping(value = "creartipopredio", method = RequestMethod.POST)
    public ResponseEntity<?> createTipoPredio(@RequestBody TipoPredioDTO tipoPredioDTO){
        Date date = new Date();

        TipoPredio tipoPredio = new TipoPredio();
        tipoPredio.setDescripcion(tipoPredioDTO.getDescripcion());
        tipoPredio.setNombretipo(tipoPredioDTO.getNombretipo());
        tipoPredio.setIdUsuarioCreacion(tipoPredioDTO.getIdUsuarioCreacion());
        tipoPredio.setFechaHoraCreacion(date);

        this.tipoPredioService.createTipoPredio(tipoPredio);
        return ResponseEntity.ok(tipoPredio);
    }

}
