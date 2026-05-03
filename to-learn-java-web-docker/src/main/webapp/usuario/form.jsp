<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="br.com.tolearn.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Usuário</title>
</head>
<body>
    <%
        Usuario usuario = (Usuario) request.getAttribute("usuario");
        boolean isEdicao = usuario != null && usuario.getId() != null;
    %>
    <h2><%= isEdicao ? "Editar" : "Novo" %> Usuário</h2>

    <form method="post" action="${pageContext.request.contextPath}/usuarios">
        <% if (isEdicao) { %>
            <input type="hidden" name="id" value="<%= usuario.getId() %>" />
        <% } %>
        <input type="hidden" name="acao" value="<%= isEdicao ? "alterar" : "inserir" %>" />

        <label>Login:
            <input type="text" name="login" value="<%= isEdicao ? usuario.getLogin() : "" %>" required />
        </label><br/>
        <label>Senha:
            <input type="password" name="senha" value="" />
        </label><br/>
        <button type="submit"><%= isEdicao ? "Salvar" : "Cadastrar" %></button>
        <a href="${pageContext.request.contextPath}/usuarios">Cancelar</a>
    </form>
</body>
</html>
