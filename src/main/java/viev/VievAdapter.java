package viev;

import java.sql.ResultSet;

public class VievAdapter {
    String[][] data = new String[][4];

    public static String[][] resSetToArray(ResultSet resultSet){
        ResultSet rs = st.executeQuery("select * from users");
        // Количество колонок в результирующем запросе
        int columns = rs.getMetaData().getColumnCount();
        // Перебор строк с данными
        while(rs.next()){
            for (int i = 1; i <= columns; i++){
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        System.out.println();
        if(rs != null)
            rs.close();
        if(st != null)
            st.close();
        if(con != null)
            con.close();
    }
        return null;
    }
}
