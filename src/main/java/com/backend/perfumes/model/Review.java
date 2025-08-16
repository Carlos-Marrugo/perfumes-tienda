package com.backend.perfumes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reviewes")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Clients client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "perfume_id")
    private Perfume perfume;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private String opnions;

    @Column(nullable = false)
    private LocalDate date;

    @PrePersist
    public void prePersist() {
        if(date == null) {
            date = LocalDate.now();
        }
    }

}