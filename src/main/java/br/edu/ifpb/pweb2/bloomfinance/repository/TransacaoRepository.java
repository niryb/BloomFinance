package br.edu.ifpb.pweb2.bloomfinance.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.bloomfinance.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findByContaId(Long contaId);

    List<Transacao> findByCategoriaNome(String nome);

    List<Transacao> findByDataBetween(LocalDate inicio, LocalDate fim);

    //retorna uma transação com base no id, carregando junto os dados da conta associada.
    @Query("select t from Transacao t join fetch t.conta where t.id = :id")
    Transacao findByIdWithConta(Long id);
}