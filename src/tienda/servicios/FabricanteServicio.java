
package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;


public class FabricanteServicio {
    private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }
    public void crearFabricante(int codigo, String nombre) throws Exception{
        try {
            Fabricante f = new Fabricante();
            f.setCodigo(codigo);
            f.setNombre(nombre);
            dao.guardarFabricante(f);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
