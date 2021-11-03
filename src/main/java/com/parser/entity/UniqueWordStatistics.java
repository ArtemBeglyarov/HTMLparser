package com.parser.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="statistic word")
public class UniqueWordStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
