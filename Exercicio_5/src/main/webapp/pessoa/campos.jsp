<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${pessoa != null}">
                            Edição
                        </c:when>
			<c:otherwise>
                            Cadastro
                        </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${pessoa != null}">
		<input type="hidden" name="id" value="${pessoa.id}" />
	</c:if>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="45" maxlength="256"
			required value="${pessoa.nome}" /></td>
	</tr>
	<tr>
		<td><label for="telefone">Telefone</label></td>
		<td><input type="text" id="telefone" name="telefone" size="45" maxlength="15"
            required value="${pessoa.telefone}" /></td>
	</tr>
    <tr>
		<td><label for="estado">Estado</label></td>
		<td><input type="text" id="estado" name="estado" size="1" maxlength="2"
            required value="${pessoa.estado}" /></td>
	</tr>
	<tr>
		<td><label for="cidade">Cidade</label></td>
		<td><input type="text" id="cidade" name="cidade" size="45"  maxlength="50"
            required value="${pessoa.cidade}" /></td>
	</tr>
	<tr>
		<td><label for="ocupacao">Ocupação</label></td>
		<td><input type="text" id="ocupacao" name="ocupacao" size="45" maxlength="50"
            required value="${pessoa.ocupacao}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>