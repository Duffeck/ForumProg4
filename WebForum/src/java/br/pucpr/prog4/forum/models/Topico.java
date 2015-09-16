/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */

package br.pucpr.prog4.forum.models;
import br.pucpr.prog4.forum.enums.AssuntoEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author lucas.ribeiro
 */
public class Topico {
    private String titulo, criador, conteudo;
    private Date data;
    private AssuntoEnum assunto;
    private List<Mensagem> mensagens;

    public Topico(String titulo, String criador, String conteudo, Date data, AssuntoEnum assunto) {
        this.titulo = titulo;
        this.criador = criador;
        this.conteudo = conteudo;
        this.data = data;
        this.assunto = assunto;
        mensagens = new ArrayList<Mensagem>(0);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public AssuntoEnum getAssunto() {
        return assunto;
    }

    public void setAssunto(AssuntoEnum assunto) {
        this.assunto = assunto;
    }
    
    public List<Mensagem> getMensagens(){
        return mensagens;
    }
    
    public boolean addMensagem(Mensagem mensagem){
        return mensagens.add(mensagem);
    }
}
