package com.parser.repository;

import com.parser.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository  extends JpaRepository<Url,Long> {
}
