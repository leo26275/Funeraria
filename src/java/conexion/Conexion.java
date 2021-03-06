package conexion;

import java.sql.*;

public class Conexion {

    private static Connection conexion = null;
    private static final ResultSet rs = null;
    private static Statement sentencia = null;
    private static final PreparedStatement ps = null;
    private static final String url = "jdbc:postgresql://localhost:5432/fune";
    private static final String usuario = "postgres";
    private static final String password = "root";

    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            // Obtener la conexion
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("conectando a la DB");
        } catch (SQLException ex) {
        } catch (Exception e) {
        }
        return conexion;
    }

    public static void cerrarConexiones() {
        System.out.println("----------------------------");
        if (sentencia != null) {
            
            try {
                sentencia.close();
                System.out.println("Sentencia cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar el Statement" + e);
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la bd" + e);
            }
        }
        if (rs != null) {
            try {
                rs.close();
                System.out.println("Rs cerrado");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la bd" + e);
            }
        }
        System.out.println("----------------------------");
    }
}
