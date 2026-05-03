# Fluxo da Aplicação

## Login

```
Acessa localhost:8080
  → login.jsp (formulário)
    → clica "Entrar"
      → LoginController → UsuarioService.autenticar() → UsuarioDAO → banco
        → [ok]   salva sessão → home.jsp
        → [erro]  volta login.jsp com mensagem
```

---

## CRUD de Usuários

```
home.jsp → clica "Gerenciar Usuários"
  → UsuarioController → UsuarioService.listar() → UsuarioDAO → banco
    → lista.jsp (tabela com usuários)

lista.jsp → clica "Novo"
  → form.jsp (vazio)
    → preenche e clica "Salvar"
      → UsuarioController → UsuarioService.inserir() → UsuarioDAO → banco
        → volta para lista.jsp

lista.jsp → clica "Editar"
  → UsuarioController → UsuarioService.buscarPorId() → UsuarioDAO → banco
    → form.jsp (preenchido)
      → altera e clica "Salvar"
        → UsuarioController → UsuarioService.alterar() → UsuarioDAO → banco
          → volta para lista.jsp

lista.jsp → clica "Deletar"
  → UsuarioController → UsuarioService.deletar() → UsuarioDAO → banco
    → volta para lista.jsp
```

---

## Logout

```
home.jsp → clica "Sair"
  → LoginController → invalida sessão → login.jsp
```
