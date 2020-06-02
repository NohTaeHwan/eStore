package com.thnoh.spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private int id;

    @NotEmpty(message = "The Product name must not be null")
    private String name;

    private String category;

    @Min(value = 0, message = "The Product price must not be under zero")
    private int price;

    @NotEmpty(message = "The Product manufacturer must not be null")
    private String manufacturer;

    @Min(value = 0, message = "The Product stock must not be under zero")
    private int unitInStock;

    private String description;

    @Transient
    private MultipartFile productImage;

    private String imageFilename;

}
