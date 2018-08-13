package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputProductController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request,
			HttpServletResponse response) {
		return "/view/jsp/ProductForm.jsp";
	}
}
