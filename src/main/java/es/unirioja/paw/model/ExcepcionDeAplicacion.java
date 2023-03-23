package es.unirioja.paw.model;

public class ExcepcionDeAplicacion extends Exception {

    public ExcepcionDeAplicacion() {
        super();
    }

    public ExcepcionDeAplicacion(String msg) {
        super(msg);
    }

    public ExcepcionDeAplicacion(Exception nested) {
        super(nested);
    }

    public ExcepcionDeAplicacion(String msg, Exception nested) {
        super(msg, nested);
    }
}
