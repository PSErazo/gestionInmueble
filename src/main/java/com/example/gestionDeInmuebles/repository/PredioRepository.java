package com.example.gestionDeInmuebles.repository;

import com.example.gestionDeInmuebles.entity.Predio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PredioRepository extends JpaRepository <Predio, UUID> {

}
