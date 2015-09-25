/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.models;

import br.pucpr.prog4.forum.models.dao.DaoFactory;
import br.pucpr.prog4.forum.models.dao.DaoManager;
import br.pucpr.prog4.forum.models.dao.MensagemDao;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author lucas.ribeiro
 */
public class MensagemManagerImpl implements MensagemManager{

    
    public List<Mensagem> getMensagensPorTopico(Topico topico) {
        List<Mensagem> mensagens;
        
        DaoManager mg = DaoFactory.getInstance();
        
        try{
            mg.iniciar();
            MensagemDao dao = mg.getMensagemDao();
            mensagens = dao.getMensagensPorTopico(topico);
            
            mg.confirmarTransação();
            mg.encerrar();
            return mensagens;
        }catch(Exception e){
            mg.abortarTransação();
            return null;
        }
    }
    
}
