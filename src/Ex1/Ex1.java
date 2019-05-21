/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author navar
 */
public class Ex1 {

    private final static String user = "alumne";
    private final static String password = "alualualu";
    //private final static String database = "jdbc:mysql://192.168.56.101:3306/beer";
    //private final static String f_salida = "C:\\Users\\infor04\\Desktop\\consultas.txt";
    private final static String database = "jdbc:mysql://db4free.net:3306/programacio";
    private final static String f_salida = "C:\\Users\\navar\\OneDrive\\Escritorio\\consultas.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try (Connection con = DriverManager.getConnection(database, user, password)) {
            boolean salir = false;
            while (!salir) {

                switch (pedirOpcion()) {
                    case 1:
                        actualizar_serves(con);
                        break;
                    case 2:
                        consultar_drinker(con);
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getMessage());
            System.out.println(Arrays.toString(ex.getStackTrace()));
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error no controlado");
            System.out.println(ex.getMessage());
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }

    }

    public static int pedirOpcion() {
        Scanner lector = new Scanner(System.in);
        System.out.println("------------------------------------------------------");
        System.out.println("1) Actualizar SERVES");
        System.out.println("2) Consultar DRINKER");
        System.out.println("3) Salir");
        System.out.println("------------------------------------------------------");
        System.out.print("Introduce una opción: ");
        return lector.nextInt();
    }

    public static void actualizar_serves(Connection con) throws SQLException {
        Scanner lector = new Scanner(System.in);
        System.out.print("¿Cuantas actualizaciones quiere hacer?: ");
        int n = lector.nextInt();

        try (PreparedStatement pst = con.prepareStatement("update Serves set price=? where bar=? and beer=?")) {
            //boolean estado_previo = con.getAutoCommit();
            try {
                con.setAutoCommit(false);
                System.out.println("Actualiza los precios de las cervezas:");
                for (int i = 0; i < n; i++) {
                    System.out.println("### Actualización " + (i + 1) + "###");
                    System.out.print("Nombre de la cerveza: ");
                    pst.setString(3, lector.next());
                    System.out.print("Nombre del bar: ");
                    pst.setString(2, lector.next());
                    System.out.print("Nuevo precio: ");
                    pst.setFloat(1, lector.nextFloat());
                    pst.executeUpdate();
                }
                con.commit();
                System.out.println("### Fin actualización ###");
            } catch (SQLException ex) {
                System.out.println("Transacción abortada");
                con.rollback();
            } finally {
                con.setAutoCommit(true);
                //con.setAutoCommit(estado_previo);
            }
        }
    }

    public static void consultar_drinker(Connection con) throws IOException, SQLException {
        try (FileWriter txt = new FileWriter(f_salida, true);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from Drinker")) {

            System.out.println("En la tabla DRINKER tenemos los siguiente datos:\n");
            txt.write("En la tabla DRINKER tenemos los siguiente datos:\n\n");
            while (rs.next()) {
                System.out.println("Nombre del cliente: " + rs.getString(1));
                txt.write("Nombre del cliente: " + rs.getString(1) + "\n");
                System.out.println("   Dirección: " + rs.getString(2) + "\n");
                txt.write("   Dirección: " + rs.getString(2) + "\n\n");
            }

        }

    }
}
