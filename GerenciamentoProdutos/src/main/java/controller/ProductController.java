package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import model.Product;



@WebServlet(urlPatterns = {"/home, /new", "/insert", "/delete", "/edit", "/update", "/list"})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao dao = new ProductDao();
	Product product = new Product();

	public ProductController () {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		try {
			if (action.equals("/new")) {
				showNewForm(request, response);
			} else if (action.equals("/insert")) {
				insertProduct(request, response);
			} else if (action.equals("/delete")) {
				deleteProduct(request, response);
			} else if (action.equals("/edit")) {
				showEditForm(request, response);
			} else if (action.equals("/update")) {
				updateProduct(request, response);
			} else if (action.equals("/list")) {
				listProduct(request, response);
			} else {
				response.sendRedirect("index.html");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	private void insertProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		product.setBarcode(Integer.parseInt(request.getParameter("barcode")));
		product.setName(request.getParameter("name"));
		product.setCategory(request.getParameter("category"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));

		dao.insertProduct(product);
		response.sendRedirect("list");
	}
	
	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		ArrayList<Product> lista = dao.listProducts();
		request.setAttribute("lista", lista);

		RequestDispatcher rd = request.getRequestDispatcher("productlist.jsp");
		rd.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("insert.html");
		dispatcher.forward(request, response);
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String id = request.getParameter("id");
		System.out.println(id);
		product.setId(Integer.parseInt(id));
		dao.getProduct(product);

		request.setAttribute("id", product.getId());
		request.setAttribute("barcode", product.getBarcode());
		request.setAttribute("name", product.getName());
		request.setAttribute("category", product.getCategory());
		request.setAttribute("price", product.getPrice());
		request.setAttribute("quantity", product.getQuantity());

		request.setAttribute("product", product.getClass());
		
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);
	}



	private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		/*
		 * System.out.println(request.getParameter("id"));
		 * System.out.println(request.getParameter("barcode"));
		 * System.out.println(request.getParameter("name"));
		 * System.out.println(request.getParameter("category"));
		 * System.out.println(request.getParameter("price"));
		 * System.out.println(request.getParameter("quantity"));
		 */
		
		product.setId(Integer.parseInt((request.getParameter("id"))));
		product.setBarcode(Integer.parseInt((request.getParameter("barcode"))));
		product.setName(request.getParameter("name"));
		product.setCategory(request.getParameter("category"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		product.setQuantity(Integer.parseInt((request.getParameter("quantity"))));
		
		dao.updateProduct(product);
		response.sendRedirect("list");
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String id = request.getParameter("id");
		product.setId(Integer.parseInt(id));

		dao.deleteProduct(product);
		response.sendRedirect("list");
	}
}
