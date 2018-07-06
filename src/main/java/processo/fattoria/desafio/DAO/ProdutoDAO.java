/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processo.fattoria.desafio.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import processo.fattoria.desafio.modelo.Produto;

/**
 *
 * @author usuario
 */
@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto where p.nome=?1")
    public Produto buscarPorNome(String nome);
}
