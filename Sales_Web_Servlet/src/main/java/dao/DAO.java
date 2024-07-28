/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Account;
import entity.Category;
import entity.Product;
import context.DatabaseUtil;

public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product ORDER BY id DESC";
        try {
            new DatabaseUtil();
			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
        	new DatabaseUtil();
 			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Account> getAllAccount() {
    	List<Account> list = new ArrayList<>();
    	String query = "select * from Account where isAdmin = 0";
    	try {
        	new DatabaseUtil();
 			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                		rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)
                        ));
            }
        } catch (Exception e) {
        }
        return list;
	}
    
    
    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where cateID = ?\n"
                + "order by id desc";
        try {
        	new DatabaseUtil();
			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByID(String id) {
        String query = "select * from product\n"
                + "where id = ?";
        		
        try {
        	new DatabaseUtil();
			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Account getAccountByID(String id) {
    	 String query = "select * from Account\n"
                 + "where uID = ?";
    	 try {
         	new DatabaseUtil();
 			conn = DatabaseUtil.getConnection();
             ps = conn.prepareStatement(query);
             ps.setString(1, id);
             rs = ps.executeQuery();
             while (rs.next()) {
                 return new Account(rs.getInt(1),
                         rs.getString(2),
                         rs.getString(3),
                         rs.getInt(4),
                         rs.getInt(5));
             }
         } catch (Exception e) {
         }
		return null;
	}
    
    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where [name] like ?";
        try {
        	new DatabaseUtil();
			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+ txtSearch+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Product getLast() {
        String query = "select top 1 * from product\n"
                + "order by id desc";
        try {
        	new DatabaseUtil();
			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Account login(String user, String pass) {
        String query = "select * from account\n"
                + "where [user] = ?\n"
                + "and pass = ?";
        try {
        	new DatabaseUtil();
 			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Account checkAccountExist(String user) {
        String query = "select * from account\n"
                + "where [user] = ?\n";
        try {
        	new DatabaseUtil();
 			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void singup(String user, String pass) {
        String query = "insert into account\n"
                + "values(?,?,0,0)";
        try {
        	new DatabaseUtil();
 			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }


    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();
        for (Product o : list) {
        	System.out.println(o);
        }
    }

	public void deleteProduct(String pid) {
		String query = "delete from product\n"
                + "where id = ?";
        try {
        	new DatabaseUtil();
 			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
	}

	public void insertProduct(String name, String image, double price, String title, String description,
			int category) {
		String query = "INSERT [dbo].[product] \n"
                + "([name], [image], [price], [title], [description], [cateID])\n"
                + "VALUES(?,?,?,?,?,?)";
        try {
        	new DatabaseUtil();
 			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, category);
            ps.executeUpdate();
        } catch (Exception e) {
        }
	}

	public void updateProduct(String name, String image, double price, String title, String description, String category,
			int id) {
		String query = "update product\n"
                + "set [name] = ?,\n"
                + "[image] = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "[description] = ?,\n"
                + "cateID = ?\n"
                + "where id = ?";
        try {
        	new DatabaseUtil();
 			conn = DatabaseUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
	}

	public void updateAccount(int id, int isSell) {
		String query = "UPDATE Account SET isSell = ? WHERE uId = ?";
		 try {
	        	new DatabaseUtil();
	 			conn = DatabaseUtil.getConnection();
	            ps = conn.prepareStatement(query);
	            ps.setInt(1, isSell);
	            ps.setInt(2, id);
	            ps.executeUpdate();
	        } catch (Exception e) {
	        }
	}
}

