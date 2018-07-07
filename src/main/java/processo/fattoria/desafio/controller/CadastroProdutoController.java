/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processo.fattoria.desafio.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import processo.fattoria.desafio.modelo.Produto;
import processo.fattoria.desafio.service.ProdutoService;

/**
 *
 * @author usuario
 */
@RestController
public class CadastroProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("cadastroProduto")
    public ModelAndView cadastroProdutoGet() {
        ModelAndView modelAndView = new ModelAndView("cadastroProduto");
        return modelAndView;
    }

    @PostMapping("/cadastroProduto")
    public ModelAndView cadastroProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("nome");
        long preco = Long.valueOf(request.getParameter("preco"));
        int quantidade = Integer.valueOf(request.getParameter("quantidade"));
        Calendar dataCadastro = Calendar.getInstance();
        Produto produto = new Produto(nome, preco, quantidade, dataCadastro);
        produtoService.salvar(produto);
        ModelAndView modelAndView = new ModelAndView("CadastroProdutoController");
        return modelAndView;
    }
}
