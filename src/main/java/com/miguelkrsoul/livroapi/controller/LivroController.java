package com.miguelkrsoul.livroapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.miguelkrsoul.livroapi.Livro;
import com.miguelkrsoul.livroapi.LivroRepository;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*")
public class LivroController {

    @Autowired
    private LivroRepository repo;

    @GetMapping
    public List<Livro> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        return repo.save(livro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @GetMapping("/{id}")
    public Livro buscar(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}
