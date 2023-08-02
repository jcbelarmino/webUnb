<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="br.unb.calculadora.framework.CalculadoraUtil"%>
<%@ page import="br.unb.calculadora.framework.Nodo"%>
<%
// Parâmetros do formulário

	try {
	    String expr = request.getParameter("expr");
	    if(expr!=null){
			Nodo n = CalculadoraUtil.criarOperacao(expr.replaceAll("\\s+", ""));
		// Exibindo mensagem de sucesso
		out.println("<h1>resultado</h1>");
		out.println("<p>resultado:</p>" + n.calcula());
		}
	} catch (Exception e) {
		e.printStackTrace();
		// Exibindo mensagem de erro em caso de falha
		out.println("<h1>Erro no Cadastro</h1>");
		out.println("<p>Ocorreu um erro ao cadastrar o aluno.</p>");
	} finally {
		// Fechando os recursos
	}
%>

<h2>Formulário de Cadastro de Aluno</h2>
<form action="calculadora.jsp" method="post">
	<label for="nome">Expressão:</label> <input type="text" name="expr" required><br>

 <input type="submit"
		value="Cadastrar">
</form>
