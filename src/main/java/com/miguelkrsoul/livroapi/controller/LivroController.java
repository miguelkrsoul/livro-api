package com.biblioteca.livroapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
