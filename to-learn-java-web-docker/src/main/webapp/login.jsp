<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>

    <% if (request.getAttribute("erro") != null) { %>
        <p style="color:red;">${erro}</p>
    <% } %>

    <form method="post" action="${pageContext.request.contextPath}/login">
        <label>Login: <input type="text" name="login" required /></label><br/>
        <label>Senha: <input type="password" name="senha" required /></label><br/>
        <button type="submit">Entrar</button>
    </form>
</body>
</html>
