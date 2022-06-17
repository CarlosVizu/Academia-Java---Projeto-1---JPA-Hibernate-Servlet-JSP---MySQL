import java.util.ArrayList;

import dao.ProductDao;
import model.Product;

public class Main {

	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		Product product = new Product();
		
		product.setId(4);
		dao.getProduct(product);
		
		System.out.println(product.getId());
		System.out.println(product.getBarcode());
		System.out.println(product.getName());
		System.out.println(product.getCategory());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());		
		
		product.setCategory("Teste");
		
		dao.updateProduct(product);
		
		System.out.println(product.getCategory());

		/*
		 * ProductDao dao = new ProductDao(); ArrayList<Product> lista = new
		 * ArrayList<Product>(); System.out.println(dao.listProducts());
		 */
		
		/*for(int i=0; i < lista.size(); i++){
		
			lista.get(i).getBarcode();
			lista.get(i).getName();
			lista.get(i).getCategory();
			lista.get(i).getPrice();
			lista.get(i).getQuantity();
		
			System.out.println(lista);
		}*/
		
	}

}
