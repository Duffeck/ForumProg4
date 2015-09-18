/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.models.Assunto;
import java.util.List;

/**
 *
 * @author lucas.ribeiro
 */
public interface AssuntoDao {
    public List<Assunto> getAssuntos();
}
