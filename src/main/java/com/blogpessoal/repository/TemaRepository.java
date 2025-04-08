package com.blogpessoal.repository;

import com.blogpessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
    boolean existsByDescription(String description);
}