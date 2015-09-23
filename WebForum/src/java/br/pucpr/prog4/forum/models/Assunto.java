/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models;

public class Assunto {
    
    private String nome, descrição;
    private int totalTopicos, totalMensagens, id;
    private Topico ultimoTopico;
    
    public Assunto(){
        
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
