/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb;

import com.tcc.pcv_ejb.dto.Categoria;
import com.tcc.pcv_ejb.dto.Cidade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luiz
 */
public class GerenciadorCategoria {
  
  private List<Categoria> categorias = new ArrayList<>();
  
  public void addCategoria(Categoria c) {
    categorias.add(c);
  }
  
  public int qtdCategorias(){
    return categorias.size();
  }
  
  public Categoria getCategoria(int i){
    return categorias.get(i);
  }
  
  public Cidade getCidadeFromCategoria(int i, int j) {
    return categorias.get(i).getCidade(j);
  }
  
  public Cidade getRandomCidadeFromCategoria(int i){
    return categorias.get(i).getRandomCidade();
  }
    
}
