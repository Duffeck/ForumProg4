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
        <title>Escrever - Web Fórum</title>
    </head>
    <body>
        <div>
            <h1>The Fórum</h1>
        </div>
        <div>
            <table>
                <form method="POST" action="topicos">
                <tr>
                    <td>Nome: <input type="text" name="nome" /></td>
                    <td>Título: <input type="text" name="titulo" /></td>
                </tr>
                <tr>
                    <td colspan="2"><textarea name="conteudo" rows="8" cols="100"></textarea></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="assunto" value="${ae}"></td>
                    <td><button type="submit">Enviar</button></td>
                </tr>
            </form>
            </table>
        </div>
        
    </body>
</html>
