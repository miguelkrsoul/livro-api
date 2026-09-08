package com.miguelkrsoul.livroapi.repository;

import com.miguelkrsoul.livroapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
