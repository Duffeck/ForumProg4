/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models;

import br.pucpr.prog4.forum.models.dao.AssuntoDao;
import br.pucpr.prog4.forum.models.dao.DaoFactory;
import br.pucpr.prog4.forum.models.dao.DaoManager;
import java.util.List;

/**
 *
 * @author lucas.ribeiro
 */
public class AssuntoManagerImpl implements AssuntoManager{
    
    @Override
    public List<Assunto> getListaDeAssuntos(){
        List<Assunto> assuntos;
        DaoManager mg = DaoFactory.getInstance();
        
        try{
            mg.iniciar();
            AssuntoDao dao = mg.getAssuntoDao();
            assuntos = dao.getAssuntos();
            
            mg.confirmarTransação();
            mg.encerrar();
            
            return assuntos;
        }catch(Exception e){
            mg.abortarTransação();
            return null;
        }
        
    }

    public Assunto getAssuntoCompleto(Assunto assunto) {
        DaoManager mg = DaoFactory.getInstance();
        
        try{
            mg.iniciar();
            AssuntoDao dao = mg.getAssuntoDao();
            assunto = dao.getAssuntoCompleto(assunto);
            
            mg.confirmarTransação();
            mg.encerrar();
            
            return assunto;
        }catch(Exception e){
            mg.abortarTransação();
            return null;
        }
    }
    
}
