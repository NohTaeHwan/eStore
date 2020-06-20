package com.thnoh.spring.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@Entity
public class CartItem implements Serializable {

    private static final long serialVersionUID = -6393373882385167845L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartItem_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    @JsonIgnore // cart reference의 사이클 형성을 막기 위해.
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    private int quantity;

    private double totalPrice;
}
