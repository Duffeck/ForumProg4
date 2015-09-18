/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models.dao;

/**
 *
 * @author lucas.ribeiro
 */
public class DaoFactory {
    public static DaoManager getInstance(){return JdbcDaoManager.getInstance();}
}
