/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas.ribeiro
 */
public class JdbcDaoManager implements DaoManager{
    
    private JdbcAssuntoDao assuntoDao;
    private Connection conexão;
    private static JdbcDaoManager instancia = new JdbcDaoManager();
    
    private JdbcDaoManager(){}
    
    public static JdbcDaoManager getInstance(){
        return instancia;
    }
    
    @Override
    public void iniciar() throws DaoException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/theforum";//nome do schema
            conexão = DriverManager.getConnection(url, "root", "");
            conexão.setAutoCommit(false);
        }catch(Exception e){
            throw new DaoException("Ocorreu um erro ao conectar ao banco de dados:" + 
                    e.getMessage());
        }
    }
    
    @Override
    public void encerrar() {
        try {
            if(!conexão.isClosed())
                conexão.close();
        } catch (SQLException e) {
            throw new DaoException("Ocorreu um erro ao encerrar conexão com o banco de dados:" + 
                    e.getMessage());
        }
    }

    @Override
    public void confirmarTransação() {
        try{
            conexão.commit();
        }catch(SQLException e){
            throw new DaoException("Erro ao confirmar a transação!");
        }
    }

    @Override
    public void abortarTransação() {
        try{
            conexão.rollback();
        }catch(SQLException e){
           throw new DaoException("Erro ao confirmar a transação!");
        }
        
    }

    public AssuntoDao getAssuntoDao() {
        return new JdbcAssuntoDao(conexão);
    }

    public TopicoDao getTopicoDao() {
        return new JdbcTopicoDao(conexão);
    }

    public MensagemDao getMensagemDao() {
        return new JdbcMensagemDao(conexão);
    }
    
}
