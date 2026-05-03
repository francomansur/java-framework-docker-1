<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h2>Bem-vindo, ${sessionScope.usuarioLogado.login}!</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/usuarios">Gerenciar Usuários</a></li>
        <li><a href="${pageContext.request.contextPath}/login?logout=true">Sair</a></li>
    </ul>
</body>
</html>
