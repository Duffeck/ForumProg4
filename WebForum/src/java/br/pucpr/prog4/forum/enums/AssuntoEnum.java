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
    DS("ds", "Nintendo 3DS"),
    XBOX("xbox", "Microsoft Xbox"),
    PLAYSTATION("playstation", "Sony Playstation"),
    PC("pc", "Computador"),
    JOGOSDEMESA("jogos_de_mesa", "Jogos de Tabuleiro");
    
    private String nome, sigla;
    
    private AssuntoEnum(String sigla, String nome){
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }
}
