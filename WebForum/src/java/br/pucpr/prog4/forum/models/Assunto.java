/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models;

import br.pucpr.prog4.forum.enums.AssuntoEnum;

public class Assunto {
    
    private AssuntoEnum assuntoEnum;
    private int totalTopicos, totalMensagens;
    private Topico ultimoTopico;
    
    public Assunto(AssuntoEnum assuntoEnum){
        this.assuntoEnum = assuntoEnum;
    }

    public AssuntoEnum getAssuntoEnum() {
        return assuntoEnum;
    }

    public void setAssuntoEnum(AssuntoEnum assuntoEnum) {
        this.assuntoEnum = assuntoEnum;
    }

    public int getTotalTopicos() {
        return totalTopicos;
    }

    public void setTotalTopicos(int totalTopicos) {
        this.totalTopicos = totalTopicos;
    }

    public int getTotalMensagens() {
        return totalMensagens;
    }

    public void setTotalMensagens(int totalMensagens) {
        this.totalMensagens = totalMensagens;
    }

    public Topico getUltimoTopico() {
        return ultimoTopico;
    }

    public void setUltimoTopico(Topico ultimoTopico) {
        this.ultimoTopico = ultimoTopico;
    }
    
    
}
