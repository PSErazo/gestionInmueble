package com.example.gestionDeInmuebles.repository;

import com.example.gestionDeInmuebles.entity.TipoPredio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoPredioRepository extends JpaRepository<TipoPredio, UUID> {

}
