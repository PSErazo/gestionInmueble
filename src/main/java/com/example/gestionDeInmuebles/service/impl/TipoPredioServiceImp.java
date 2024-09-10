package com.example.gestionDeInmuebles.service.impl;

import com.example.gestionDeInmuebles.entity.TipoPredio;
import com.example.gestionDeInmuebles.repository.TipoPredioRepository;
import com.example.gestionDeInmuebles.service.TipoPredioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoPredioServiceImp implements TipoPredioService {

    @Autowired
    private TipoPredioRepository  tipoPredioRepository;

    @Override
    public TipoPredio getTipoPredio(UUID id) {
        TipoPredio tipoPredio = tipoPredioRepository.findById(id).get();
        return tipoPredio;
    }

    @Override
    public List<TipoPredio> getTipoPredioList() {
        List<TipoPredio> tipoPredioList = tipoPredioRepository.findAll();
        return tipoPredioList;
    }

    @Override
    public TipoPredio createTipoPredio(TipoPredio tpredio) {
        tipoPredioRepository.save(tpredio);
        return tpredio;
    }
}
