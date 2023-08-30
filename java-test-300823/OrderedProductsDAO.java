package org.example;

import java.sql.*;

public class OrderedProductsDAO {

    String url = "jdbc:mysql://localhost:3306/gainsight";

    public void displayOrderedProductById(int productId){


        try (

                Connection con = DriverManager.getConnection(url,"root","Vaishnavi@123");
                PreparedStatement preparedStatement = con.prepareStatement("select * from product inner join ordered_products on product.prod_id=ordered_products.prod_id\n" +
                        "where product.prod_id = ?"))
        {
            preparedStatement.setInt(1,productId);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5));



                System.out.println(product);
            }


        } catch (SQLException e) {

        }



    }


    public void displayOrderedProductsByOrderDate(String orderDate){

        try (

                Connection con = DriverManager.getConnection(url,"root","Vaishnavi@123");
                PreparedStatement preparedStatement = con.prepareStatement("select * from Product PROD, ordered_products OREREDPROD, orders ORDERS where PROD.prod_id = OREREDPROD.prod_id and OREREDPROD.order_id = ORDERS.order_id and ORDERS.order_date = ?"))
        {
            preparedStatement.setString(1,orderDate);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5));

                System.out.println("name : "+rs.getString(2)+"     product_price : " + rs.getDouble(4) +"    date : "+ rs.getString(9));

                System.out.println(product);
            }


        } catch (SQLException e) {

        }




    }



}
