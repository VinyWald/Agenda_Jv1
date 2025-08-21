package controler;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controler", "/main", "/insert", "/insert2", "/select", "/update", "/delete", "/processaMateria", "/report" })
public class Controler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();

	public Controler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			adicionarContato(request, response);
		} else if (action.equals("/insert2")) {
			dao.atz(request.getParameter("ggg"));
			response.sendRedirect("main");
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else if (action.equals("/processaMateria")) {
			processarMateria(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JavaBeans contato = new JavaBeans(); // Criar novo objeto para cada requisição
		contato.setTipo(request.getParameter("tipo"));
		contato.setMat(request.getParameter("mat"));
		contato.setDesc(request.getParameter("desc"));
		
		String dataParam = request.getParameter("data");
		java.sql.Date sqlDate = java.sql.Date.valueOf(dataParam);
		contato.setData(sqlDate);
		
		dao.inserirContato(contato);
		response.sendRedirect("main");
	}

	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JavaBeans contato = new JavaBeans(); // Criar novo objeto para cada requisição
		contato.setIdcon(request.getParameter("idcon"));
		dao.selecionarContato(contato);
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("tipo", contato.getTipo());
		request.setAttribute("mat", contato.getMat());
		request.setAttribute("desc", contato.getDesc());
		request.setAttribute("data", contato.getData());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void processarMateria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	
		String materiaId = request.getParameter("materia");
		
		
		
		ArrayList<JavaBeans> lista = dao.listarMateria(materiaId);

		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("mt.jsp");
		rd.forward(request, response);
	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JavaBeans contato = new JavaBeans(); // Criar novo objeto para cada requisição
		contato.setIdcon(request.getParameter("idcon"));
		contato.setTipo(request.getParameter("tipo"));
		contato.setMat(request.getParameter("mat"));
		contato.setDesc(request.getParameter("desc"));

		String dataParam = request.getParameter("data");
		java.sql.Date sqlDate = java.sql.Date.valueOf(dataParam);
		contato.setData(sqlDate);
		
		dao.alterarContato(contato);
		response.sendRedirect("main");
	}

	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JavaBeans contato = new JavaBeans(); // Criar novo objeto para cada requisição
		contato.setIdcon(request.getParameter("idcon"));
		dao.deletarContato(contato);
		response.sendRedirect("main");
	}

	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline;filename=" + "contatos.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de trabalhos:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph(" Tipo "));
			PdfPCell col2 = new PdfPCell(new Paragraph(" Matéria"));
			PdfPCell col3 = new PdfPCell(new Paragraph(" Descrição"));
			PdfPCell col4 = new PdfPCell(new Paragraph(" Data"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);

			ArrayList<JavaBeans> lista = dao.listarContatos();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getTipo());
				tabela.addCell(lista.get(i).getMat());
				tabela.addCell(lista.get(i).getDesc());
				String dataFormatada = dateFormat.format(lista.get(i).getData());
			    tabela.addCell(dataFormatada);

			}

			documento.add(tabela);
			documento.close();

		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
}
