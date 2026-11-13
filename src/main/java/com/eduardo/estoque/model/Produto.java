package com.eduardo.estoque.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
@Entity
public class Produto {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message="Nome é obrigatório") private String nome;
  private String categoria;
  @Min(0) private Integer quantidade = 0;
  @DecimalMin("0.0") private BigDecimal preco;
  @Min(0) private Integer estoqueMinimo = 0;
  // Getters e Setters
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
  public String getCategoria(){return categoria;} public void setCategoria(String c){this.categoria=c;}
  public Integer getQuantidade(){return quantidade;} public void setQuantidade(Integer q){this.quantidade=q;}
  public BigDecimal getPreco(){return preco;} public void setPreco(BigDecimal p){this.preco=p;}
  public Integer getEstoqueMinimo(){return estoqueMinimo;} public void setEstoqueMinimo(Integer e){this.estoqueMinimo=e;}
  public boolean isAbaixoDoMinimo(){ return quantidade != null && estoqueMinimo != null && quantidade < estoqueMinimo; }
}
