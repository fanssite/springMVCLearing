package springdemo.controller;

import springdemo.domain.Product;
import springdemo.form.ProductForm;
import springdemo.validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SaveProductController implements Controller {
    @Override
    public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
        ProductForm productForm = new ProductForm();
        productForm.setname(request.getParameter("name"));
        productForm.setdescription(request.getParameter("description"));
        productForm.setprice(Float.parseFloat(request.getParameter("price")));

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
        }else{
            request.setAttribute("errors",errors);
            request.setAttribute("form",productForm);
            return "/jsp/ProductForm.jsp";
        }
    }
}
