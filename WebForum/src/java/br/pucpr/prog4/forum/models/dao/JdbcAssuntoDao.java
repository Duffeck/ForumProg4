/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.enums.AssuntoEnum;
import br.pucpr.prog4.forum.models.Assunto;
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
        for(AssuntoEnum assuntoEnum : AssuntoEnum.values()){
            assuntos.add(getAssunto(assuntoEnum));
        }
        return assuntos;
    }
    
    public Assunto getAssunto(AssuntoEnum assuntoEnum){
        String sql = "SELECT * FROM ?";
        Assunto assunto;
        ResultSet rs;
        
        PreparedStatement ps;
        try{
            ps = conexão.prepareStatement(sql);
            ps.setString(1, assuntoEnum.getSigla());
            
            rs = ps.executeQuery();
        }catch(SQLException e){
            throw new DaoException("Erro ao recuperar assuntos no banco de dados!");
        }
        
        assunto = criarObjeto(rs, assuntoEnum);
        
        return assunto;
    }

    private Assunto criarObjeto(ResultSet rs, AssuntoEnum assuntoEnum) {
        Assunto assunto;
        try{
            if(rs.next()){
                assunto = new Assunto(assuntoEnum);
                rs.last();
                assunto.setTotalTopicos(rs.getRow());
                //assunto.setTotalMensagens(JdbcDaoManager.getInstance().getMensagemDao().getPorTopico().size());
                //assunto.setUltimoTopico(JdbcDaoManager.getInstance().getTopicoDao().getPorId(rs.getInt("idtopicos")));
                return assunto;
            }
        }catch(Exception e){
            throw new DaoException("Erro ao processar arquivos recuperados do banco de dados!");
        }
        return null;
    }
}
