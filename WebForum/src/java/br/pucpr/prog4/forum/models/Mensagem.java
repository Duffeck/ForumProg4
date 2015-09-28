/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */

package br.pucpr.prog4.forum.models;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author lucas.ribeiro
 */
public class Mensagem {

    private int idtopico, id;
    private String criador, conteudo;
    private Date data;
    
    public Mensagem() {
    }

    public int getIdtopico() {
        return idtopico;
    }

    public void setIdtopico(int idtopico) {
        this.idtopico = idtopico;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData() {
        String myData;
        myData = DateFormat.getDateInstance().format(this.data);
        return myData; 
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 
    
}
