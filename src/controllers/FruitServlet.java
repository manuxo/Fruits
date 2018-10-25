package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.entities.Fruit;
import services.FruitService;
import services.IFruitService;

@WebServlet("/fruits")
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IFruitService fruitService = null;
	
    public FruitServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		this.fruitService = new FruitService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Fruit> fruits = this.fruitService.findAll();
		request.setAttribute("fruits", fruits);
		request.setAttribute("title", "Fruits - List");
		request.getRequestDispatcher("fruits/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
