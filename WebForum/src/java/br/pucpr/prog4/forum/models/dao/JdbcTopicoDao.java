/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.models.Assunto;
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
public class JdbcTopicoDao implements TopicoDao{
    Connection conexão;
    
    public JdbcTopicoDao(Connection conexão){
        this.conexão = conexão;
    }

    public List<Topico> getTopicosPorAssunto(Assunto assunto) {
        List<Topico> topicos = new ArrayList<Topico>();
        Topico topico;
        String sql = "SELECT * FROM topicos WHERE ID_ASSUNTO = ?";
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = conexão.prepareStatement(sql);
            ps.setInt(1, assunto.getId());
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                topicos.add(criarObjeto(rs));
            }
        }catch(SQLException e){
            throw new DaoException("Erro ao recuperar tópicos do banco de dados!");
        }
        return topicos;
    }

    public Topico getTopicoCompleto(Topico topico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Topico criarObjeto(ResultSet rs) {
        Topico topico = new Topico();
        try{
            topico.setConteudo(rs.getString("CONTEUDO"));
            topico.setCriador(rs.getString("CRIADOR"));
            topico.setId(rs.getInt("ID_TOPICO"));
            topico.setTitulo(rs.getString("TITULO"));
            Assunto assunto = new Assunto();
            assunto.setId(rs.getInt("ID_ASSUNTO"));
            //topico.setAssunto(JdbcDaoManager.getInstance().getAssuntoDao().getAssuntoCompleto(assunto));
            topico.setData(new java.util.Date(rs.getDate("DATA").getTime()));
            topico.setMensagens(JdbcDaoManager.getInstance().getMensagemDao().getMensagensPorTopico(topico));
            
        }catch(SQLException e){
            throw new DaoException("Ocorreu um erro ao construir tópicos recuperados da base de dados!");
        }
        return topico;
    }
    
}
