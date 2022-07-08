package org.example.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {

    private Integer id;

    private String title;

    private String author;

    private BigDecimal price;
}
