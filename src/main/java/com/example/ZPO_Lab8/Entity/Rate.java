package com.example.ZPO_Lab8.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String value;


}
