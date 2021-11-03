package com.parser.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "url")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

}
