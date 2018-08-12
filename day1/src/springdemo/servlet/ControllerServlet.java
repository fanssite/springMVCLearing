package springdemo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import springdemo.controller.InputProductController;
import springdemo.controller.SaveProductController;
import springdemo.service.SaveProductAction;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/product_input", "/product_save"})
public class ControllerServlet extends HttpServlet {
    private final static long serialVersionUID = 1511L;
    private SaveProductAction productService = new SaveProductAction();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String dispatchUrl = null;
        String uri = request.getRequestURI();
        int lastindex = uri.lastIndexOf(uri);
        String action = uri.substring(lastindex + 1);

        if (action.equals("product_save")) {
            SaveProductController controller = new SaveProductController();
            dispatchUrl = controller.handlerRequest(request, response);
            productService.save();
        } else if (action.equals("product_input")) {
            InputProductController controller = new InputProductController();
            dispatchUrl = controller.handlerRequest(request, response);
        }
        if (dispatchUrl != null) {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
}