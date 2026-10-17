package com.cesde.crocheteriasmaho.model.entity;

import com.cesde.crocheteriasmaho.model.base.BaseEntity;
import com.cesde.crocheteriasmaho.model.embeddable.Direccion;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Cliente extends BaseEntity {
<<<<<<< HEAD
=======

>>>>>>> fe7712d5133bc93aa01b9cb78db02c31bc95f005
    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 150)
    private String correo;

    @Embedded
    private Direccion direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;
}
