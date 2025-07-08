package br.edu.ifpb.pweb2.bloomfinance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.bloomfinance.model.Categoria;
import br.edu.ifpb.pweb2.bloomfinance.model.NaturezaCategoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    //busca categorias que estão ativas
    List<Categoria> findByAtivaTrue();

    //busca categoria pelo nome exato
    Categoria findByNome(String nome);

    //busca categorias por natureza (RECEITA, DESPESA - por exemplo)
    List<Categoria> findByNatureza(NaturezaCategoria natureza);
}