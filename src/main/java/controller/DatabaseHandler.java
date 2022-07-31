package controller;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()  throws  ClassNotFoundException, SQLException {

        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort +"/" +dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public ResultSet getProduct(){

        ResultSet resSet = null;

        String select = "SELECT productName, product.productModel, productPrice FROM product JOIN productprice ON product.productModel = productprice.productModel";

        try {
            Statement statement = getDbConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            resSet = statement.executeQuery(select);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
