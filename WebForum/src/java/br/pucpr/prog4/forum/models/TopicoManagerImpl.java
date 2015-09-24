/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models;

import br.pucpr.prog4.forum.models.dao.DaoFactory;
import br.pucpr.prog4.forum.models.dao.DaoManager;
import br.pucpr.prog4.forum.models.dao.TopicoDao;
import java.util.List;

/**
 *
 * @author lucas.ribeiro
 */
public class TopicoManagerImpl implements TopicoManager{

    public List<Topico> getTopicosPorAssunto(Assunto assunto) {
        List<Topico> topicos;
        DaoManager mg = DaoFactory.getInstance();
        
        try{
            mg.iniciar();
            TopicoDao dao = mg.getTopicoDao();
            
            topicos = dao.getTopicosPorAssunto(assunto);
            
            mg.confirmarTransação();
            mg.encerrar();
            
            return topicos;
        }catch(Exception e){
            mg.abortarTransação();
            return null;
        }
    }

    public Topico getTopicoCompleto(Topico topico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
