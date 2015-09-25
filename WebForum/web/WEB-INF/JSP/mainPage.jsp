<%-- 
    Document   : mainPage
    Created on : 28/08/2015, 13:23:39
    Author     : lucas.ribeiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <style type="text/css">
            h1 {
                color:darkblue;
                font-family: "Showcard Gothic";
            }

            body {
                background-color: lightgrey;
            }
            
            table {
                width: 700px;
                border-collapse: collapse;
                border: 2px solid black;
            }
            table td, table th {
                border: 1px solid black;
            }
              table tr:first-child th {
                border-top: 0;
            }
              table tr:last-child td {
                border-bottom: 0;
            }
            table tr td:first-child,table tr th:first-child {
                border-left: 0;
            }
            table tr td:last-child,table tr th:last-child {
                border-right: 0;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Página Inicial - Web Fórum</title>
    </head>
    <body>
        <div>
            <h1>The Fórum</h1>
        </div>
        <div>
            <c:choose>
                <c:when test="${assuntos != null}">
                    <table>
                <tr>
                    <th>
                        Assunto
                    </th>
                    <th>
                        Tópicos
                    </th>
                    <th>
                        Mensagens
                    </th>
                    <th>
                        Última Postagem
                    </th>
                </tr>
                        <c:forEach var="assunto" items="${assuntos}">
                            <c:set var="id" value="${assunto.id}" />
                            <tr>
                                <td title="${assunto.descrição}"><a href="topicos?assunto=${assunto.id}">${assunto.nome}</a></td>
                                <td style="text-align: center;">${assunto.totalTopicos}</td>
                                <td style="text-align: center;">${assunto.totalMensagens}</td>
                                <td>${assunto.ultimoTopico}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    </c:when>
                    <c:otherwise>
                        Não há assuntos cadastrados!
                    </c:otherwise>
            
            </c:choose>
        </div>
        
    </body>
</html>
