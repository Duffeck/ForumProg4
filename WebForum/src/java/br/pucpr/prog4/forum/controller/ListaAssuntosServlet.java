/*
 * Desenvolvido por Lucas Duffeck Ribeiro para a disciplina de Programacao 4
 * BSI - PUC PR - 4o Per�odo.
 */
package br.pucpr.prog4.forum.controller;

import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.AssuntoManagerImpl;
import br.pucpr.prog4.forum.models.dao.DaoManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaAssuntosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AssuntoManagerImpl manager = new AssuntoManagerImpl();
        List<Assunto> assuntos = manager.getListaDeAssuntos();
        if(assuntos.size()>0)
            request.setAttribute("assuntos", assuntos);
        else
            request.setAttribute("assuntos", null);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/mainPage.jsp");
        rd.forward(request, response);
    }
    
}
