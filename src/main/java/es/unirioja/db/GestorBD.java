package es.unirioja.db;

import es.unirioja.paw.model.Articulo;
import es.unirioja.paw.model.ExcepcionDeAplicacion;
import java.util.List;

public interface GestorBD {

    public Articulo getArticulo(String id) throws ExcepcionDeAplicacion;

    public List<Articulo> getArticulos() throws ExcepcionDeAplicacion;

}
