package com.example.gestionDeInmuebles.service;

import com.example.gestionDeInmuebles.entity.Predio;
import com.example.gestionDeInmuebles.entity.TipoPredio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface TipoPredioService {

    public TipoPredio getTipoPredio(UUID id);

    public List<TipoPredio> getTipoPredioList();

    public TipoPredio createTipoPredio(TipoPredio tpredio);
}
