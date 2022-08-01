import controller.DatabaseHandler;
import viev.ProductTable;
import viev.VievAdapter;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet resSet;
        resSet = dbHandler.getProduct();
        String[][] dataNull = {{"Отсуцтвует соединение с базой данных или неверная база данных"}};
        String[] columnNamesNull = {"Произошла ошибка! Данные не получены."};
        String[] columnNames = {
                "№ п/п",
                "Наименование",
                "Артикул",
                "Цена"
        };

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                try {
                    String[][] data = VievAdapter.resSetToArray(resSet);
                    if (data != null) {
                        ProductTable.createGUI(data, columnNames);
                    }  else {
                        ProductTable.createGUI(dataNull, columnNamesNull);
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                finally {
                    try {
                        if(resSet != null) {resSet.close();}
                        if(dbHandler.dbConnection != null) {dbHandler.dbConnection.close();}
                        if(dbHandler.statement != null) {dbHandler.statement.close();}
                    } catch (SQLException  throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
    }
}
