package com.example.ZPO_Lab8.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    @ManyToOne
//    @JoinColumn(name = "student_id")
    private Student student;
}
