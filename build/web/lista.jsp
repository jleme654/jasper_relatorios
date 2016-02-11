<%-- 
    Document   : lista
    Created on : 03/11/2015, 15:50:44
    Author     : jrleme
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.k19.relatorios.Cliente"%>
<%@page import="br.com.k19.relatorios.RelatorioDeClientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista</title>
    </head>
    <body>
        <h1>Lista</h1>
        <%
            RelatorioDeClientes r = new RelatorioDeClientes();
            List<Cliente> lista = r.getLista();
            
            
            for(Cliente c: lista){
                out.print(c.getNome());out.print(" | ");out.print(c.getEmail());out.print(" | ");out.print(c.getTelefone());%><br /><%
            }
            
        %>
    </body>
</html>
