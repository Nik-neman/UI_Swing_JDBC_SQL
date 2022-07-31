package viev;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VievAdapter {

    public static String[][] resSetToArray(ResultSet resultSet) throws SQLException {
        String[][] data;
        int count = 1;
        int strings = 0;

        // Количество строк в результирующем запросе
        resultSet.last();
        strings = resultSet.getRow();
        resultSet.beforeFirst();

        data = new String[strings][4];

        // Перебор строк с данными
            for (int i = 0; i < strings; i++) {
                resultSet.next();
                data[i][0] = "" + (i + 1);
                for (int j = 1; j <= 3; j++){
                    data[i][j] =  resultSet.getObject(j).toString();

//                    System.out.print(resultSet.getObject(j) + " ");
                }
//                System.out.println();
            }
//        System.out.println(data);
        return data;
    }
}
