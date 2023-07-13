package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import dao.PessoaDAO;
import domain.Pessoa;

@WebServlet(urlPatterns = "/pessoas/*")
public class PessoaController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private PessoaDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao = new PessoaDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(req, resp);
                    break;
                case "/insercao":
                    insere(req, resp);
                    break;
                case "/remocao":
                    remove(req, resp);
                    break;
                case "/edicao":
                    apresentaFormEdicao(req, resp);
                    break;
                case "/atualizacao":
                    atualize(req, resp);
                    break;
                default:
                    lista(req, resp);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
	}
	
	private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pessoa> listaPessoas = dao.getAll();
        request.setAttribute("listaPessoas", listaPessoas);
        request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pessoa/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pessoa/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String ocupacao = request.getParameter("ocupacao");
        
        Pessoa pessoa = new Pessoa(nome, telefone, estado, cidade, ocupacao);
        dao.insert(pessoa);
        response.sendRedirect("lista");
    }
	
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Pessoa pessoa = dao.get(id);
        request.setAttribute("pessoa", pessoa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pessoa/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String ocupacao = request.getParameter("ocupacao");
        
        Pessoa pessoa = new Pessoa(id, nome, telefone, estado, cidade, ocupacao);
        dao.update(pessoa);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Pessoa pessoa = new Pessoa(id);
        dao.delete(pessoa);
        response.sendRedirect("lista");
    }

}
