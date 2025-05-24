
package sistematickets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://shinkansen.proxy.rlwy.net:23994/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "dHqqodLUzWdoNvpYemIHRrsJaIcOFWhS";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a Railway");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
            return null;
        }
    }
}
