<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, br.com.tolearn.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuários</title>
</head>
<body>
    <h2>Lista de Usuários</h2>
    <a href="${pageContext.request.contextPath}/usuarios?acao=form">Novo Usuário</a>
    <br/><br/>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Ações</th>
        </tr>
        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            if (usuarios != null) {
                for (Usuario u : usuarios) {
        %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getLogin() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/usuarios?acao=form&id=<%= u.getId() %>">Editar</a>
                <a href="${pageContext.request.contextPath}/usuarios?acao=deletar&id=<%= u.getId() %>"
                   onclick="return confirm('Confirmar exclusão?')">Excluir</a>
            </td>
        </tr>
        <% } } %>
    </table>
    <br/>
    <a href="${pageContext.request.contextPath}/home">Voltar</a>
</body>
</html>
