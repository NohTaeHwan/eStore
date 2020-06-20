package com.thnoh.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "shippingAddress")
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shippingAddress_id")
    private int id;

    //@NotEmpty(message = "address must not be null")
    private String address;

    //@NotEmpty(message = "country must not be null")
    private String country;

    //@NotEmpty(message = "zipCode must not be null")
    private String zipCode;

}
