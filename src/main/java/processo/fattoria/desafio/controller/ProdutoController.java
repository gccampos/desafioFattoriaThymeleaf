/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processo.fattoria.desafio.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import processo.fattoria.desafio.modelo.Produto;
import processo.fattoria.desafio.service.ProdutoService;

/**
 *
 * @author usuario
 */
@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/thymeleaf")
    public String Thymeleaf(Model model) {
        model.addAttribute("produtoList", produtoService.buscarTodos());
        return "/produto/thymeleaf/thymeleaf";
    }

    @GetMapping("/form")
    public String getPaginaCadastro(Model model,
            @RequestParam(required = false, name = "id") Integer id) {

        if (id == null) {
            model.addAttribute("produto", new Produto());
        } else {
            Produto produto = produtoService.buscarPorId(id);
            model.addAttribute("produto", produtoService.buscarPorId(id));
        }
        return "/produto/thymeleaf/form";
    }

    @PostMapping("/form")
    public String postPaginaCadastro(Model model,
            @Valid Produto produto, BindingResult bindingresult) {
        System.out.println("Error = " + bindingresult.hasErrors());
        System.out.println(bindingresult.getFieldError());
        if (bindingresult.hasErrors()) {
            return "/produto/thymeleaf/form";
        }
        System.out.println("nome = " + produto.getNome());
        produto.setDataCadastro(Calendar.getInstance());
        produtoService.salvar(produto);
        return "redirect:thymeleaf";
    }

    @GetMapping("/delete")
    public String deletarProduto(Model model,
            @RequestParam("id") Integer id) {
        produtoService.deletarPorId(id);
        return "redirect:thymeleaf";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET, produces =  "text/Html")
    public String getHome() {
        return "/home";
    }
}
