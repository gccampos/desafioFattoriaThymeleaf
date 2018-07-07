/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processo.fattoria.desafio.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author usuario
 */
@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private long preco;
    private int quantidade;
    private Calendar dataCadastro;

    public Produto() {
    }

    public Produto(String nome, long preco, int quantidade, Calendar dataCadastro) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(long preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public long getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

}
