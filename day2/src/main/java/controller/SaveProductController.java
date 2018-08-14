package controller;

import domain.Product;
import form.ProductForm;
import validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SaveProductController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request,
			HttpServletResponse response) {
		ProductForm productForm = new ProductForm();
		productForm.setname(request.getParameter("name"));
		productForm.setdescription(request.getParameter("description"));
		if(request.getParameter("price") != null) {
			productForm.setprice(Float.parseFloat(request.getParameter("price")));
		}else {
			productForm.setprice(0);
		}
		ProductValidator productValidator = new ProductValidator();
		List<String> errors = productValidator.validate(productForm);
		if (errors.isEmpty()) {
			Product product = new Product();
			product.setName(productForm.getname());
			product.setDescription(productForm.getdescription());
			try {
				product.setPrice(productForm.getprice());
			} catch (NumberFormatException e) {
				System.out.print("nums type error");
			}
			request.setAttribute("product", product);
			return "/jsp/ProductDetails.jsp";
		} else {
			request.setAttribute("errors", errors);
			request.setAttribute("form", productForm);
			return "/view/jsp/ProductForm.jsp";
		}
	}
}
