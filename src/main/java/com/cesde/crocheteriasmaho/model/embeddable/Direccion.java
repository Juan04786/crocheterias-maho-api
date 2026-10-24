package com.cesde.crocheteriasmaho.model.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Direccion {

    private String calle;

    private String ciudad;

    private String departamento;

    private String codigoPostal;
}
