package br.pucpr.prog4.forum.models.dao;

public interface DaoManager 
{
    void iniciar() throws DaoException;
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    
    AssuntoDao getAssuntoDao();
    TopicoDao getTopicoDao();
    MensagemDao getMensagemDao();
    
}
