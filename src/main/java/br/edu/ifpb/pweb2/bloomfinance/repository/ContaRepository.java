package br.edu.ifpb.pweb2.bloomfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.bloomfinance.model.Conta;
import br.edu.ifpb.pweb2.bloomfinance.model.Correntista;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    //busca uma conta pelo correntista
    Conta findByCorrentista(Correntista correntista);

    //busca uma conta pelo número, já trazendo as transações associadas
    @Query("from Conta c left join fetch c.transacoes where c.numero = :numero")
    Conta findByNumeroWithTransacoes(String numero);

    //busca uma conta pelo id, também carregando as transações
    @Query("select distinct c from Conta c left join fetch c.transacoes where c.id = :id")
    Conta findByIdWithTransacoes(Long id);
}
