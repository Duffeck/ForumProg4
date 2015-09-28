/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.models.Mensagem;
import br.pucpr.prog4.forum.models.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas.ribeiro
 */
public class JdbcMensagemDao implements MensagemDao{
    
    Connection conexão;
    
    public JdbcMensagemDao(Connection conexão){
        this.conexão = conexão;
    }
    
    public List<Mensagem> getMensagensPorTopico(Topico topico) {
        List<Mensagem> mensagens = new ArrayList<Mensagem>(0);
        String sql = "SELECT * FROM mensagens WHERE ID_TOPICO = ? ORDER BY mensagens.DATA";
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = conexão.prepareStatement(sql);
            ps.setInt(1, topico.getId());
            
            rs = ps.executeQuery();
            while(rs.next()){
                mensagens.add(criarObjetos(rs));
            }
            
            return mensagens;
        }catch(SQLException e){
            throw new DaoException("Erro ao recuperar mensagens do banco de dados!");
        }
    }

    private Mensagem criarObjetos(ResultSet rs) {
        Mensagem mensagem = new Mensagem();
        
        try{
            mensagem.setConteudo(rs.getString("CONTEUDO"));
            mensagem.setCriador(rs.getString("CRIADOR"));
            mensagem.setData(new java.sql.Date(rs.getDate("DATA").getTime()));
            mensagem.setId(rs.getInt("ID_MENSAGEM"));
            mensagem.setIdtopico(rs.getInt("ID_TOPICO"));
            return mensagem;
        }catch(SQLException e){
            throw new DaoException("Erro ao criar objetos do banco de dados!");
        }
    }

    public Mensagem getLastMensagem(Topico topico) {
        List<Mensagem> mensagens = new ArrayList<Mensagem>(0);
        String sql = "SELECT * FROM mensagens WHERE ID_TOPICO = ?";
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = conexão.prepareStatement(sql);
            ps.setInt(1, topico.getId());
            
            rs = ps.executeQuery();
            while(rs.next()){
                mensagens.add(criarObjetos(rs));
            }
            
            return null;
        }catch(SQLException e){
            throw new DaoException("Erro ao recuperar mensagens do banco de dados!");
        }
    }
    
}
