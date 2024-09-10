package com.example.gestionDeInmuebles.repository;

import com.example.gestionDeInmuebles.entity.Predio;
import com.example.gestionDeInmuebles.entity.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PropiedadRepository extends JpaRepository<Propiedad, UUID> {

    List<Propiedad> findByIdempresa(UUID idEmpresa);



}
