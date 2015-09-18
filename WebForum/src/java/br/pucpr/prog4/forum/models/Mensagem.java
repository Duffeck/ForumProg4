/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */

package br.pucpr.prog4.forum.models;

import java.util.Date;

/**
 *
 * @author lucas.ribeiro
 */
public class Mensagem extends Topico{

    private int idtopico;
    public Mensagem(String titulo, String criador, String conteudo, Date data, Assunto assunto, int idtopico) {
        super(titulo, criador, conteudo, data, assunto);
        this.idtopico = idtopico;
    }

    public int getIdtopico() {
        return idtopico;
    }

    public void setIdtopico(int idtopico) {
        this.idtopico = idtopico;
    }
    
}
