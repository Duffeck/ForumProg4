/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models;

import java.util.List;

/**
 *
 * @author lucas.ribeiro
 */
public interface TopicoManager {
    
    public List<Topico> getTopicosPorAssunto(Assunto assunto);
    
    public Topico getTopicoCompleto(Topico topico);
    
    public Topico inserirTopico(Topico topico);
}
