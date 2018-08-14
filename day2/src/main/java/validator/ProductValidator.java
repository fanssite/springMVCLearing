package validator;

import form.ProductForm;

import java.util.ArrayList;
import java.util.List;

public class ProductValidator {
	public List<String> validate(ProductForm productForm) {
		List<String> errors = new ArrayList<String>();
		String name = productForm.getname();
		if (name == null || name.trim().isEmpty()) {
			errors.add("name must be filled");
		}
		String price = String.valueOf(productForm.getprice());
		if (price == null || price.trim().isEmpty()) {
			errors.add("product should have a price");
		} else
			try {
				Float.parseFloat(price);
			} catch (NumberFormatException e) {
				errors.add("Invalid price value");
			}
		return errors;
	}
}
