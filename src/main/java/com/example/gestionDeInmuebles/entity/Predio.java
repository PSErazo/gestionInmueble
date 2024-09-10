package com.example.gestionDeInmuebles.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(
        name = "predio",

        uniqueConstraints = @UniqueConstraint(
                name = "partida_unique",
                columnNames = "partida"
        )

)
public class Predio {

    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID idpredio;
    @Column(
            nullable = false
    )
    private String partida;
    @Column(
            nullable = false
    )
    private String direccion;

//    @JsonProperty("fecha_creacion_p")
    private Date fechaHoraCreacion;
    private Date fechaHoraUltimaModificacion;
    private UUID idUsuarioCreacion;
    private UUID idUsuarioUltimaModificacion;

    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "idpropiedad",
            referencedColumnName = "idpropiedad",
            foreignKey = @ForeignKey(
            name = "predio_propiedad"
            )
    )
    @JsonIgnore
    private Propiedad propiedad;

    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "idtipopredio",
            referencedColumnName = "idtipopredio",
            foreignKey = @ForeignKey(
                    name = "predio_tipopredio"
            )
    )
    @JsonIgnore
    private TipoPredio tipoPredio;

}
