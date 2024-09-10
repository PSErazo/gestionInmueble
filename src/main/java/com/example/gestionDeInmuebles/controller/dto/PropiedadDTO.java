package com.example.gestionDeInmuebles.controller.dto;

import com.example.gestionDeInmuebles.entity.Predio;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PropiedadDTO {

    private UUID idpropiedad;
    private UUID idempresa;
    private UUID idusuario;
    @JsonProperty("ubigeo")
    private String ubigeo;
    @JsonProperty("nombrePropiedad")
    private String nombrepropiedad;
    @JsonProperty("precioInicial")
    private Double precioCompra;
    private Date fechaHoraCreacion;
    private Date fechaHoraUltimaModificacion;
    private UUID idUsuarioCreacion;
    private UUID idUsuarioUltimaModificacion;
    @JsonProperty("listaPredio")
    private List<Predio> predioList = new ArrayList<>();
}
