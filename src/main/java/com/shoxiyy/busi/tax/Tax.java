package com.shoxiyy.busi.tax;

import jakarta.persistence.*;

@Entity
@Table(name = "taxes")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long multiplier;


}
