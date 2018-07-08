/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processo.fattoria.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import processo.fattoria.desafio.DAO.ProdutoDAO;
import processo.fattoria.desafio.modelo.Produto;

/**
 *
 * @author usuario
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoDAO produtoDAO;

    public Produto buscarPorNome(String nome) {
        return produtoDAO.buscarPorNome(nome);
    }

    public Page<Produto> buscarTodos(Pageable pgbl) {
        return produtoDAO.findAll(pgbl);
    }

    public Produto buscarPorId(Integer id) {
        return  produtoDAO.buscarPorId(id);
    }

    public void salvar(Produto p) {
        produtoDAO.save(p);

    }
    public void deletarPorObjeto(Produto p){
        produtoDAO.delete(p);
    }
    public void deletarPorId(Integer id){
        produtoDAO.deleteById(id);
    }
}
