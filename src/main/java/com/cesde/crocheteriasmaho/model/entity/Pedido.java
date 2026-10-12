package com.cesde.crocheteriasmaho.model.entity;

import com.cesde.crocheteriasmaho.model.base.BaseEntity;
import com.cesde.crocheteriasmaho.model.enums.EstadoPedido;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Pedido extends BaseEntity {
<<<<<<< HEAD
=======

>>>>>>> fe7712d5133bc93aa01b9cb78db02c31bc95f005
    @Column(nullable = false, precision = 10)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoPedido estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
        name = "pedido_producto",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;
}
<<<<<<< HEAD
=======

>>>>>>> fe7712d5133bc93aa01b9cb78db02c31bc95f005
