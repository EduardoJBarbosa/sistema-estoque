package com.eduardo.estoque.service;
import com.eduardo.estoque.model.Produto;
import com.eduardo.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProdutoService {
  private final ProdutoRepository repo;
  public ProdutoService(ProdutoRepository repo){this.repo=repo;}
  public List<Produto> listar(){return repo.findAll();}
  public Produto criar(Produto p){ if(p.getQuantidade()==null) p.setQuantidade(0); return repo.save(p); }
  public Produto buscar(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado: "+id)); }
  // Entrada de estoque: soma
  public Produto entrada(Long id, int qtd){ Produto p=buscar(id); p.setQuantidade(p.getQuantidade()+qtd); return repo.save(p); }
  // Saída de estoque: subtrai, mas não deixa ficar negativo - regra de negócio importante
  public Produto saida(Long id, int qtd){ Produto p=buscar(id); if(p.getQuantidade() < qtd) throw new RuntimeException("Estoque insuficiente. Atual: "+p.getQuantidade()); p.setQuantidade(p.getQuantidade()-qtd); return repo.save(p); }
  public List<Produto> abaixoDoMinimo(){ return repo.findAll().stream().filter(Produto::isAbaixoDoMinimo).toList(); }
}
