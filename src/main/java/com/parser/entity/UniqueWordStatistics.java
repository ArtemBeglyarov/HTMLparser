package com.parser.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@Table(name ="statistic_word")
@AllArgsConstructor
@NoArgsConstructor
public class UniqueWordStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "word")
    private String word;
    @Column(name = "count")
    private int count;

    @Override
    public String toString() {
        return word + "-" + count +'\'' ;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_url")
    private Url url;
}
