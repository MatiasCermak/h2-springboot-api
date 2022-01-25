package com.mcrmk.springboot.h2restaurants.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "restaurants")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Restaurant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @JsonProperty("hora_inicio")
    private String horaInicio;
    @JsonProperty("hora_fin")
    private String horaFin;
    @JsonProperty("fecha_creacion")
    private final Date fechaCreacion = Calendar.getInstance().getTime();
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
