package com.example.weightness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class DatabaseHelper {

    public String getUsername(int id) {
        String username = "";
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection con= DriverManager.getConnection("jdbc:mysql://13.58.53.245:3306/weightness?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","janet","janet");
//here sonoo is database name, root is username and password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/weightness?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qqjanet1010");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from test where id = " + id);
            while(rs.next())
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2));
                username = rs.getString(2);

            con.close();
        }catch(Exception e){ System.out.println(e);}

        return username;
    }

    public boolean ifUserExist(String name) {
        boolean result = false;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/weightness?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qqjanet1010");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from login where username ='" + name + "'");
            while(rs.next()) {
                result = true;
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}


        return result;
    }

    public void userSignUp(String name, String pwd) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/weightness?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qqjanet1010");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("insert into login (username, password) values (\"" + name + "\", \"" + pwd + "\")");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    public boolean ifLoginValid(String name, String password) {
        boolean result = false;
        String pwd = "";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/weightness?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qqjanet1010");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select password from login where username = '" + name + "'");
            while(rs.next()) {
                pwd = rs.getString(1);
                if (pwd.equals(password)) {
                    result = true;
                }
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

        return result;
    }

    public String getGoal(String name) {
        String goal = "";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/weightness?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qqjanet1010");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from goal where username = '" + name + "'");
            while(rs.next()) {
                goal = rs.getString(2);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

        return goal;
    }

    public void setGoal(String name, String ugoal) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/weightness?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qqjanet1010");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("insert into goal (username, goal) values (\"" + name + "\", \"" + ugoal + "\")");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    public void setRecord(String username, String addDate, String weightness) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/weightness?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qqjanet1010");
            Statement stmt=con.createStatement();
            Date d = new SimpleDateFormat("MM/dd/yy").parse(addDate);
            stmt.executeUpdate("insert into record (username, date, weightness) values (\"" + username + "\", \"" + d + "\", \"" + weightness + "\")");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    public TreeMap<Date, String> getRecord(String username) {
        TreeMap<Date, String> treeMap = new TreeMap<Date, String>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/weightness?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qqjanet1010");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from record where username = " + username);
            while(rs.next()) {
                Date key = rs.getDate(2);
                String value = rs.getString(3);
                treeMap.put(key, value);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

        return treeMap;
    }
}
