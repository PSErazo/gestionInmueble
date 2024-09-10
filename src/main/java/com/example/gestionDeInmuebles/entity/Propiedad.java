package com.example.gestionDeInmuebles.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Propiedad {

    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID idpropiedad;
    private UUID idempresa;
    private UUID idusuario;

    @Column(
            nullable = false
    )
    private String ubigeo;

    @Column(
            nullable = false
    )
    private String nombrepropiedad;

    private Double precioCompra;

    private Date fechaHoraCreacion;
    private Date fechaHoraUltimaModificacion;
    private UUID idUsuarioCreacion;
    private UUID idUsuarioUltimaModificacion;

    @OneToMany(mappedBy = "propiedad", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Predio> predioList = new ArrayList<>();
}
