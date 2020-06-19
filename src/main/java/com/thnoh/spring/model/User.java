package com.thnoh.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @NotEmpty(message = "The username must not be null")
    private String username;

    @NotEmpty(message = "The password must not be null")
    private String password;

    @NotEmpty(message = "The email must not be null")
    private String email;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(unique = true, name="shippingAddress")
    private ShippingAddress shippingAddress;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(unique = true,name = "cart_id")
    private Cart cart;

    private boolean enabled=false;

    private String authority;
}
