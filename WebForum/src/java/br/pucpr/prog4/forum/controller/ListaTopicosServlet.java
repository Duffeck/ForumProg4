/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.controller;

import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import br.pucpr.prog4.forum.models.TopicoManagerImpl;
import br.pucpr.prog4.forum.models.dao.DaoFactory;
import br.pucpr.prog4.forum.models.dao.DaoManager;
import br.pucpr.prog4.forum.models.dao.TopicoDao;
import com.mysql.jdbc.StringUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas.ribeiro
 */
public class ListaTopicosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Assunto assunto = new Assunto();
        int id = Integer.parseInt(request.getParameter("assunto").trim());
        assunto.setId(id);
        TopicoManagerImpl mg = new TopicoManagerImpl();
        List<Topico> topicos = mg.getTopicosPorAssunto(assunto);
        if(topicos.size()>0){
            request.setAttribute("topicos", topicos);
            request.setAttribute("idassunto", assunto.getId());
        }else
            request.setAttribute("topicos", null);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/topicos.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        int idassunto = Integer.parseInt(request.getParameter("assunto").trim());
        if(nome != null && titulo != null && conteudo != null){
            TopicoManagerImpl manager = new TopicoManagerImpl();
            
            Topico topico = new Topico();
            
            topico.setConteudo(conteudo);
            topico.setCriador(nome);
            topico.setData(new java.util.Date());
            topico.setTitulo(titulo);
            
            Assunto assunto = new Assunto();
            assunto.setId(idassunto);
            
            topico.setAssunto(assunto);
            
            manager.inserirTopico(topico);
            
            List<Topico> topicos = manager.getTopicosPorAssunto(assunto);
            request.setAttribute("topicos", topicos);
            request.setAttribute("idassunto", assunto.getId());
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/topicos.jsp");
        rd.forward(request, response);
        }else{
            request.setAttribute("ae", idassunto);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/escreverTopico.jsp");
            rd.forward(request, response);
        }
       
    }

   
}
