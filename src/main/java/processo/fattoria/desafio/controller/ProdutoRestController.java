/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processo.fattoria.desafio.controller;

import java.util.Calendar;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import processo.fattoria.desafio.modelo.Produto;
import processo.fattoria.desafio.service.ProdutoService;

/**
 *
 * @author usuario
 */
@RestController
public class ProdutoRestController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listarProduto")
    public Page<Produto> listarProduto(Pageable page) {
        return produtoService.buscarTodos(page);
    }

    @RequestMapping(value = "/listarProduto/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletarProduto(@PathVariable("id") Integer id) {
        produtoService.deletarPorId(id);
    }

    @GetMapping("/listarProduto/{id}")
    public Produto getProduto(@PathVariable("id") Integer id) {
        return produtoService.buscarPorId(id);
    }

    @PostMapping(value = "/listarProduto")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastroProduto(@RequestBody @Valid Produto produto) {
        produto.setDataCadastro(Calendar.getInstance());
        produtoService.salvar(produto);
    }
}
