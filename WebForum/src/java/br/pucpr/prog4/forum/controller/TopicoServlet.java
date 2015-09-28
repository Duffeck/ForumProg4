/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.controller;

import br.pucpr.prog4.forum.models.Topico;
import br.pucpr.prog4.forum.models.TopicoManagerImpl;
import br.pucpr.prog4.forum.models.dao.DaoManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas.ribeiro
 */
public class TopicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        TopicoManagerImpl manager = new TopicoManagerImpl();
        Topico topico = new Topico();
        topico.setId(Integer.parseInt(request.getParameter("topico").trim()));
        topico = manager.getTopicoCompleto(topico);
        
        request.setAttribute("topico", topico);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/topico.jsp");
        rd.forward(request, response);
    }

}
