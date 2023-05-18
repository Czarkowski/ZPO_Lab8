package com.example.ZPO_Lab8.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @OneToOne
    private Rate rate;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    @OneToMany()
//    @JoinColumn(name = "id_wlasciciela")
    private List<Email> emails = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "studenci_kursy",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "kurs_id")
    )
    private List<Course> courses = new ArrayList<>();

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Imie: %s Nazwisko: %s\nEmails:", firstName,lastName));
        emails.forEach(email -> {
            stringBuilder.append("\n\t").append(email.getEmail());
        });
        return stringBuilder.toString();
    }
}
