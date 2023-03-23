package bd;

import es.unirioja.db.GestorBD;
import es.unirioja.paw.model.Articulo;
import es.unirioja.paw.model.ExcepcionDeAplicacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorBDImpl implements GestorBD {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Articulo getArticulo(String codigoArticulo) throws ExcepcionDeAplicacion {
        Articulo a = new Articulo();
        try ( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrosa?serverTimezone=UTC", "root", "root")) {
//            PreparedStatement ps = con.prepareStatement("select nombre from articulo where CODIGO = ?");
//            ps.setString(1, codigoArticulo);
            String sql = "select nombre from articulo where CODIGO = '" + codigoArticulo + "'";
            System.out.println("Query: " + sql);
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a.setNombre(rs.getString(1));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            throw new ExcepcionDeAplicacion(ex);
        }
        return a;
    }

    @Override
    public List<Articulo> getArticulos() throws ExcepcionDeAplicacion {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
