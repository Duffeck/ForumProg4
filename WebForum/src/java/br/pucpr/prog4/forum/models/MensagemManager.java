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
public interface MensagemManager {
    
    public List<Mensagem> getMensagensPorTopico(Topico topico);
}
