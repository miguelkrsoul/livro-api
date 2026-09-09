package com.miguelkrsoul.livroapi.controller;

import com.miguelkrsoul.livroapi.model.Livro;
import com.miguelkrsoul.livroapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @GetMapping
    public List<Livro> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro novoLivro) {
        return repository.findById(id)
                .map(livro -> {
                    livro.setTitulo(novoLivro.getTitulo());
                    livro.setAutor(novoLivro.getAutor());
                    return ResponseEntity.ok(repository.save(livro));
                })
                .orElse(ResponseEntity.notFound().build());
    }
  }
