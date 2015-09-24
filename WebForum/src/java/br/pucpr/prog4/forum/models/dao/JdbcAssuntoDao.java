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
public class JdbcAssuntoDao implements AssuntoDao{
    
    Connection conexão;
    
    public JdbcAssuntoDao(Connection conexão){
        this.conexão = conexão;
    }
    
    public List<Assunto> getAssuntos() {
        List<Assunto> assuntos = new ArrayList<Assunto>();
        String sql = "SELECT assuntos.ID_ASSUNTO, assuntos.NOME, count(topicos.ID_TOPICO) FROM assuntos inner join topicos on topicos.ID_ASSUNTO = assuntos.ID_ASSUNTO";
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
        try{
        assunto.setDescrição(rs.getString("DESCRIÇÃO"));
        assunto.setNome(rs.getString("NOME"));
        assunto.setId(rs.getInt("ID_ASSUNTO"));
        }catch(SQLException e){
            throw new DaoException("Erro ao criar Assuntos a partir da base de dados!");
        }
        return assunto;
    }

    public Assunto getAssuntoCompleto(Assunto assunto) {
        String sql = "SELECT `theforum`.`assuntos`.ID_ASSUNTO, `theforum`.`assuntos`.NOME, count(`theforum`.`topicos`.ID_TOPICO), (SELECT `theforum`.`topicos`.ID_TOPICO FROM `theforum`.`topicos` WHERE (`theforum`.`assuntos`.ID_ASSUNTO = `theforum`.`topicos`.ID_ASSUNTO) ORDER BY `theforum`.`topicos`.DATA DESC LIMIT 1) AS id_topico\n" +
"	FROM `theforum`.`assuntos` INNER JOIN `theforum`.`topicos` ON `theforum`.`topicos`.ID_ASSUNTO = `theforum`.`assuntos`.ID_ASSUNTO WHERE `theforum`.`assuntos`.ID_ASSUNTO = ?";
        ResultSet rs;
        
        PreparedStatement ps;
        try{
            ps = conexão.prepareStatement(sql);
            ps.setInt(1, assunto.getId());
            
            rs = ps.executeQuery();
            assunto = criarObjeto(rs);
            Topico topico = new Topico();
            topico.setId(rs.getInt("id_topico"));
            assunto.setUltimoTopico(JdbcDaoManager.getInstance().getTopicoDao().getTopicoCompleto(topico));
        }catch(SQLException e){
            throw new DaoException("Erro ao recuperar assuntos no banco de dados!");
        }
        
        
        return assunto;
    }
}
