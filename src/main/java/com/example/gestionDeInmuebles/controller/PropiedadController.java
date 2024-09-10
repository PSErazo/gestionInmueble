package com.example.gestionDeInmuebles.controller;

import com.example.gestionDeInmuebles.controller.dto.PredioDTO;
import com.example.gestionDeInmuebles.controller.dto.PropiedadDTO;
import com.example.gestionDeInmuebles.entity.Propiedad;
import com.example.gestionDeInmuebles.service.PropiedadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "propiedad")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    private final Logger logger = LoggerFactory.getLogger(PropiedadController.class);

                /* OBTIENES TODAS LAS PROPIEDADES POR EL ID DE LA EMPRESA*/

    @GetMapping
    @RequestMapping(value="consultarpropiedad", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> GetPropiedades(@RequestHeader("empresa_id") UUID empresaid,
                                            @RequestHeader("usuario_id") UUID usuarioid){
        List<PropiedadDTO> propiedadList = this.propiedadService.getPropiedades(empresaid)
                .stream()
                .map(propiedad -> PropiedadDTO.builder()
                        .idpropiedad(propiedad.getIdpropiedad())
                        .nombrepropiedad(propiedad.getNombrepropiedad())
                        .ubigeo(propiedad.getUbigeo())
                        .precioCompra(propiedad.getPrecioCompra())
                        .build())
                .toList();

        return ResponseEntity.ok(propiedadList);
    }


                /* OBTIENES TODAS LAS PROPIEDADES CON SUS PREDIOS*/

    @GetMapping
    @RequestMapping(value="consultarpropiedadandpredio", method = RequestMethod.GET)
    public ResponseEntity<?> GetPropiedadesAndPredio(@RequestHeader("empresa_id") UUID empresaid,
                                                     @RequestHeader("usuario_id") UUID usuarioid){
        List<PropiedadDTO> propiedadList = this.propiedadService.getPropiedades(empresaid)
                .stream()
                .map(propiedad -> PropiedadDTO.builder()
                        .nombrepropiedad(propiedad.getNombrepropiedad())
                        .ubigeo(propiedad.getUbigeo())
                        .precioCompra(propiedad.getPrecioCompra())
                        .predioList(propiedad.getPredioList())
                        .build()).toList();

        return ResponseEntity.ok(propiedadList);
    }

                /*OBTIENES LOS PREDIOS POR ID DE LA PROPIEDAD*/

    @GetMapping
    @RequestMapping(value="consultarprediobypropiedad/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> GetPropiedades(@PathVariable UUID id){
        List<PredioDTO> predioList = this.propiedadService.getPredioByPropiedad(id)
                .stream()
                .map(predio -> PredioDTO.builder()
                        .idpredio(predio.getIdpredio())
                        .partida(predio.getPartida())
                        .direccion(predio.getDireccion())
                        .nombreTipoPredio(predio.getTipoPredio().getNombretipo())
                        .tipoPredio(predio.getTipoPredio())
                        .build()).toList();
        return ResponseEntity.ok(predioList);
    }


                /* CREAS UNA NUEVA PROPIEDAD*/

    @PostMapping
    @RequestMapping(value = "createpropiedad", method = RequestMethod.POST)
    public ResponseEntity<?> createPropiedad(@RequestHeader("empresa_id") UUID empresaid,
                                             @RequestHeader("usuario_id") UUID usuarioid,
                                             @RequestBody PropiedadDTO propiedadDTO){
        Date date = new Date();
        Propiedad propiedad =new Propiedad();
        propiedad.setIdempresa(empresaid);
        propiedad.setIdusuario(usuarioid);
        propiedad.setUbigeo(propiedadDTO.getUbigeo());
        propiedad.setNombrepropiedad(propiedadDTO.getNombrepropiedad());
        propiedad.setPrecioCompra(propiedadDTO.getPrecioCompra());
        propiedad.setFechaHoraCreacion(date);
        propiedad.setIdUsuarioCreacion(usuarioid);
        this.propiedadService.createPropiedad(propiedad);
        return ResponseEntity.ok(propiedad);
    }

            /*ACTUALIZAS UNA PROPIEDAD POR EL ID DE LA PROPIEDAD */

    @PutMapping
    @RequestMapping(value = "updatepropiedad/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePropiedad(@PathVariable UUID id,
                                             @RequestHeader("usuario_id") UUID usuarioid,
                                             @RequestBody PropiedadDTO propiedadDTO){

        Propiedad propiedad = propiedadService.getPropiedadById(id);

        Date date = new Date();
        if(propiedadDTO.getUbigeo() != null)  propiedad.setUbigeo(propiedadDTO.getUbigeo());
        if(propiedadDTO.getNombrepropiedad() != null)  propiedad.setNombrepropiedad(propiedadDTO.getNombrepropiedad());
        if(propiedadDTO.getPrecioCompra()!=null) propiedad.setPrecioCompra(propiedadDTO.getPrecioCompra());
        propiedad.setFechaHoraUltimaModificacion(date);
        propiedad.setIdUsuarioUltimaModificacion(usuarioid);
        this.propiedadService.createPropiedad(propiedad);
        return ResponseEntity.ok(propiedad);
    }

}
