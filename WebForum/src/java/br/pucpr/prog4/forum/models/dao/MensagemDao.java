/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.models.Mensagem;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

/**
 *
 * @author lucas.ribeiro
 */
public interface MensagemDao {
    
    public List<Mensagem> getMensagensPorTopico(Topico topico);
    public Mensagem getLastMensagem(Topico topico);
}
