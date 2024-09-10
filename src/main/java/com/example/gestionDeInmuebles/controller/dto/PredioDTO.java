package com.example.gestionDeInmuebles.controller.dto;

import com.example.gestionDeInmuebles.entity.Propiedad;
import com.example.gestionDeInmuebles.entity.TipoPredio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredioDTO {

    private UUID idpredio;
    private String partida;
    private String direccion;
    private Date fechaHoraCreacion;
    private Date fechaHoraUltimaModificacion;
    private UUID idUsuarioCreacion;
    private UUID idUsuarioUltimaModificacion;
    private Propiedad propiedad;
    private String nombreTipoPredio;
    private TipoPredio tipoPredio;
}
