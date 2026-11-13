package com.eduardo.estoque.controller;
import com.eduardo.estoque.model.Produto;
import com.eduardo.estoque.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins="*")
public class ProdutoController {
  private final ProdutoService service;
  public ProdutoController(ProdutoService s){this.service=s;}
  @GetMapping public List<Produto> listar(){return service.listar();}
  @PostMapping public ResponseEntity<Produto> criar(@Valid @RequestBody Produto p){return ResponseEntity.ok(service.criar(p));}
  @GetMapping("/{id}") public Produto buscar(@PathVariable Long id){return service.buscar(id);}
  @PostMapping("/{id}/entrada") public Produto entrada(@PathVariable Long id, @RequestParam int qtd){return service.entrada(id,qtd);}
  @PostMapping("/{id}/saida") public Produto saida(@PathVariable Long id, @RequestParam int qtd){return service.saida(id,qtd);}
  @GetMapping("/alerta/abaixo-do-minimo") public List<Produto> alerta(){return service.abaixoDoMinimo();}
}
