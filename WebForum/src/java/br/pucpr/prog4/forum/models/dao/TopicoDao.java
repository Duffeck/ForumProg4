/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

/**
 *
 * @author lucas.ribeiro
 */
public interface TopicoDao {
    
    public List<Topico> getTopicosPorAssunto(Assunto assunto);
    public Topico getTopicoCompleto(Topico topico);
    
}
