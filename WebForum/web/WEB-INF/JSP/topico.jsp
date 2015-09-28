<%-- 
    Document   : topico
    Created on : 25/09/2015, 13:33:42
    Author     : lucas.ribeiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <title>Tópicos - Web Fórum</title>
    </head>
    <body>
        <div>
            <h1>The Fórum</h1>
        </div>
        <div>
            <c:choose>
                <c:when test="${topico != null}">
                <table>
                    <tr>
                        <th>
                            Usuário
                        </th>
                        <th>
                            Conteúdo
                        </th>
                        <th>
                            Data
                        </th>
                    </tr>
                    <tr>
                        <td>${topico.criador}</td>
                        <td style="text-align: center;"><b>${topico.titulo}</b><br />${topico.conteudo}</td>
                        <td style="text-align: center;">${topico.data}</td>
                    </tr>
                </table>
                    <hr>
                    <table>
                    <c:forEach var="mensagem" items="${topico.mensagens}">
                        <tr>
                            <td>${mensagem.criador}</td>
                            <td style="text-align: center;">${mensagem.conteudo}</td>
                            <td style="text-align: center;">${mensagem.data}</td>
                        </tr>
                    </c:forEach>
                </table>
                </c:when>
                <c:otherwise>
                    Nenhum tópico registrado!
                </c:otherwise>
            </c:choose>
        </div>
        
    </body>
</html>
