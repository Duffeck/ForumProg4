/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models;

/**
 *
 * @author lucas.ribeiro
 */
public interface TopicoManager {
    
    public Topico cadastrar(Topico topico);
    
    public Topico selecionarPorID(int id);
    
    
}