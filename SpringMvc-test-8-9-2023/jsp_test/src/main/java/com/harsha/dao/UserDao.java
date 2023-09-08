package com.harsha.dao;


import com.harsha.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDao {

    String url = "jdbc:mysql://localhost:3306/gainsight";
    public boolean validateUser(User user) throws ClassNotFoundException {


        int count =0;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception ex)
        {

        }
        try (
                Connection con = DriverManager.getConnection(url,"root","Vaishnavi@123");
                PreparedStatement preparedStatement = con.prepareStatement("select count(*) from users where username=? and password = ?"))
        {


            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            ResultSet rs = preparedStatement.executeQuery();



            System.out.println(user.getPassword());
            System.out.println(user.getUsername());

            if(rs.next()){
                count = rs.getInt(1);
            }



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(count);
        return count==1;

    }
}
