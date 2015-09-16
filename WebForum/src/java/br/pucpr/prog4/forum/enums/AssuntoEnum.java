/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.enums;

/**
 *
 * @author lucas.ribeiro
 */
public enum AssuntoEnum {
    PC(1, "pc", "Jogos de Computador"),
    JOGOSDEMESA(2, "jm", "Jogos de Mesa"),
    PLAYSTATION(3, "ps", "Jogos de PlayStation"),
    XBOX(4, "xb", "Jogos de Xbox"),
    DS(5, "3d", "Jogos de 3DS");
    
    private int id;
    private String sigla, descrição;
    
    private AssuntoEnum(int id, String sigla, String descrição){
        this.id = id;
        this.sigla = sigla;
        this.descrição = descrição;
    }
    
    @Override
    public String toString(){
        return this.descrição;
    }

    public int getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }
}
