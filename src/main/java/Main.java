import controller.DatabaseHandler;
import viev.ProductTable;
import viev.VievAdapter;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet resSet;
        resSet = dbHandler.getProduct();
        System.out.println(resSet);




        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                ProductTable.createGUI(VievAdapter.resSetToArray(resSet));
            }
        });
    }
}
