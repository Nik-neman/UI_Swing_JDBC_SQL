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

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                try {
                    ProductTable.createGUI(VievAdapter.resSetToArray(resSet));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
