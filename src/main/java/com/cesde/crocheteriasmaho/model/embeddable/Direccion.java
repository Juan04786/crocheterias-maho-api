package com.cesde.crocheteriasmaho.model.embeddable;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public class Direccion {

    @Column(length = 120)
        private String calle;

    @Column(length = 60)
        private String ciudad;

    @Column(name = "codigo_postal", length = 20)
        private String codigoPostal;
  }
=======
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Direccion {

    private String calle;

    private String ciudad;

    private String departamento;

    private String codigoPostal;
}
>>>>>>> fe7712d5133bc93aa01b9cb78db02c31bc95f005
