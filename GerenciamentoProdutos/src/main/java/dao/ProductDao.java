package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/projeto1?useSSL=false&amp";
	private String user = "root";
	private String password = "root";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void insertProduct(Product product) {
		String create = "insert into produtoteste (barcode, name, category, price, quantity) values (?,?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setInt(1, product.getBarcode());
			pst.setString(2, product.getName());
			pst.setString(3, product.getCategory());
			pst.setFloat(4, product.getPrice());
			pst.setInt(5, product.getQuantity());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateProduct(Product product) {
		String update = "update produtoteste set barcode = ?, name = ?, category = ?, price = ?, quantity = ? where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);

			pst.setInt(1, product.getBarcode());
			pst.setString(2, product.getName());
			pst.setString(3, product.getCategory());
			pst.setFloat(4, product.getPrice());
			pst.setInt(5, product.getQuantity());
			pst.setInt(6, product.getId());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteProduct(Product product) {
		String delete = "delete from produtoteste where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);

			pst.setInt(1, product.getId());
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getProduct(Product product) {
		String read2 = "select * from produtoteste where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, product.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				product.setId(rs.getInt(1));
				product.setBarcode(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setCategory(rs.getString(4));
				product.setPrice(rs.getFloat(5));
				product.setQuantity(rs.getInt(6));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<Product> listProducts() {
		ArrayList<Product> lista = new ArrayList<>();
		String read = "select * from produtoteste order by id;";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String barcode = rs.getString(2);
				String name = rs.getString(3);
				String category = rs.getString(4);
				String price = rs.getString(5);
				String quantity = rs.getString(6);

				lista.add(new Product(Integer.parseInt(id), Integer.parseInt(barcode), name, category,
						Float.parseFloat(price), Integer.parseInt(quantity)));
			}
			con.close();
			return lista;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
}
