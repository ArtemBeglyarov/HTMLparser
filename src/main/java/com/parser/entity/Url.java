package com.parser.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;

@Data
@Entity
@Table(name = "url")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "link")
    private String url;
    @OneToMany(mappedBy = "url",fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE, orphanRemoval = true)
    private Collection<UniqueWordStatistics> words = new LinkedList<>();

    @Override
    public String toString() {
        return "id=" + id + ": "+ url;

    }
}
