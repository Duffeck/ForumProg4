/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Mensagem;
import br.pucpr.prog4.forum.models.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author lucas.ribeiro
 */
public class JdbcAssuntoDao implements AssuntoDao{
    
    Connection conexão;
    
    public JdbcAssuntoDao(Connection conexão){
        this.conexão = conexão;
    }
    
    public List<Assunto> getAssuntos() {
        List<Assunto> assuntos = new ArrayList<Assunto>();
        String sql = "SELECT `theforum`.`assuntos`.`ID_ASSUNTO`,\n" +
"    `theforum`.`assuntos`.`NOME`,\n" +
"    `theforum`.`assuntos`.`DESCRIÇÃO`,\n" +
"    (SELECT COUNT(`theforum`.`topicos`.ID_TOPICO) FROM `theforum`.`topicos` WHERE `theforum`.`topicos`.ID_ASSUNTO = `theforum`.`assuntos`.ID_ASSUNTO) as TOPICOS\n" +
"FROM `theforum`.`assuntos`";
        ResultSet rs;
        PreparedStatement ps;
        
        try{
            ps = conexão.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                
                assuntos.add(criarObjeto(rs));
            }
        }catch(SQLException e){
            throw new DaoException("Erro ao adquirir assuntos da base de dados!");
        }
        return assuntos;
        
    }
    
    /*public Assunto getAssunto(Assunto assunto){
        String sql = "SELECT * FROM ?";
        ResultSet rs;
        
        PreparedStatement ps;
        try{
            ps = conexão.prepareStatement(sql);
            
            
            rs = ps.executeQuery();
        }catch(SQLException e){
            throw new DaoException("Erro ao recuperar assuntos no banco de dados!");
        }
        
        assunto = criarObjeto(rs);
        
        return assunto;
    }*/

    private Assunto criarObjeto(ResultSet rs) {
        Assunto assunto = new Assunto();
        List<Topico> topicos;
        List<Mensagem> mensagens = new ArrayList<Mensagem>(0);
        try{
        assunto.setDescrição(rs.getString("DESCRIÇÃO"));
        assunto.setNome(rs.getString("NOME"));
        assunto.setId(rs.getInt("ID_ASSUNTO"));
        topicos = JdbcDaoManager.getInstance().getTopicoDao().getTopicosPorAssunto(assunto);
        List<Mensagem> aux;
        for(Topico topico : topicos){
            for(Mensagem mensagem : topico.getMensagens()){
                mensagens.add(mensagem);
            }
        }
        Collections.sort(mensagens, new Comparator<Mensagem>() {
        @Override
        public int compare(Mensagem  mensagem1, Mensagem  mensagem2)
        {

            return  mensagem1.getData().compareTo(mensagem2.getData());
        }
        });
        assunto.setUltimaMensagem(mensagens.get(mensagens.size()-1));
        assunto.setTotalTopicos(topicos.size());
        assunto.setTotalMensagens(mensagens.size());
        }catch(SQLException e){
            throw new DaoException("Erro ao criar Assuntos a partir da base de dados!");
        }
        return assunto;
    }

    public Assunto getAssuntoCompleto(Assunto assunto) {
        String sql = "SELECT * " +
"	FROM `theforum`.`assuntos` WHERE assuntos.ID_ASSUNTO = ?";
        ResultSet rs;
        
        PreparedStatement ps;
        try{
            ps = conexão.prepareStatement(sql);
            ps.setInt(1, assunto.getId());
            
            rs = ps.executeQuery();
            assunto = criarObjetok(rs);
            Topico topico = new Topico();
            topico.setId(rs.getInt("id_topico"));
            assunto.setUltimaMensagem(JdbcDaoManager.getInstance().getMensagemDao().getLastMensagem(topico));
        }catch(SQLException e){
            throw new DaoException("Erro ao recuperar assuntos no banco de dados!");
        }
        
        
        return assunto;
    }

    private Assunto criarObjetok(ResultSet rs) {
        Assunto assunto = new Assunto();
        try{
        assunto.setDescrição(rs.getString("DESCRIÇÃO"));
        assunto.setNome(rs.getString("NOME"));
        assunto.setId(rs.getInt("ID_ASSUNTO"));
        }catch(SQLException e){
            throw new DaoException("Erro ao criar Assuntos a partir da base de dados!");
        }
        return assunto;
    }
}
