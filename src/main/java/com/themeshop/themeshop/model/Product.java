package com.themeshop.themeshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="products")
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank(message = "Product Không thể bỏ trống")
    private String name;

    @DecimalMin(value = "0", inclusive = false, message="Giá tiền phải lớn hơn 0")
    private double price;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    @NotBlank(message="Mô tả ngắn không được bỏ trống")
    private String shortDescription;

    private String image;
    @Min(value = 1, message = "Số lượng phải lớn hơn bằng 1")
    private long quantity;
    private long sold;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderDetail> orderDetails;
}
