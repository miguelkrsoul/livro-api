package com.miguelkrsoul.livroapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.miguelkrsoul.livroapi.model.Livro;
import com.miguelkrsoul.livroapi.repository.LivroRepository;

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
    
    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        return repo.findById(id).map(l -> {
            l.setTitulo(livroAtualizado.getTitulo());
            l.setAutor(livroAtualizado.getAutor());
            l.setCapaUrl(livroAtualizado.getCapaUrl());
            l.setDescricao(livroAtualizado.getDescricao());
            l.setConteudo(livroAtualizado.getConteudo());
            return repo.save(l);
        }).orElseThrow();
    }

    @GetMapping("/{id}")
    public Livro buscar(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}
