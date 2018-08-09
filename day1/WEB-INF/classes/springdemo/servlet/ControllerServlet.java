package classes.springdemo.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.springdemo.domain.Product;
import classes.springdemo.form.ProductForm;

public class ControllerServlet extends HttpServlet{
	private final static long serialVersionUID = 1511L;
//	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		process(request,response);
	};
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		process(request,response);
	};
	public void process(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
	}
}