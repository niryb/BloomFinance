package br.edu.ifpb.pweb2.bloomfinance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.bloomfinance.model.Correntista;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

    Correntista findByEmail(String email);

    //busca todos os correntistas com perfil admin
    List<Correntista> findByAdminTrue();

    //busca todos os correntistas bloqueados
    List<Correntista> findByBloqueadoTrue();

    //busca correntistas que não estão bloqueados
    List<Correntista> findByBloqueadoFalse();

}
