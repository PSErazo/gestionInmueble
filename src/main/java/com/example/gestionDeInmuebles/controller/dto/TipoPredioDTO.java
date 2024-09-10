package com.example.gestionDeInmuebles.controller.dto;

import com.example.gestionDeInmuebles.entity.Predio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoPredioDTO {

    private UUID idtipopredio;
    private String nombretipo;
    private String descripcion;
    private Date fechaHoraCreacion;
    private Date fechaHoraUltimaModificacion;
    private UUID idUsuarioCreacion;
    private UUID idUsuarioUltimaModificacion;
    private List<Predio> predioList;
}
