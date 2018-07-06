/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processo.fattoria.desafio.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import processo.fattoria.desafio.modelo.Produto;
import processo.fattoria.desafio.service.ProdutoService;

/**
 *
 * @author usuario
 */
@RestController
public class ListarProdutosController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("listarProduto")
    public ModelAndView listarProdutoGet() {
        ModelAndView modelAndView = new ModelAndView("listarProduto");
        ArrayList<Produto> produtos = (ArrayList<Produto>) produtoService.buscarTodos();
        modelAndView.addObject("listaProdutos", produtos);
        return modelAndView;
    }
    
    

}
