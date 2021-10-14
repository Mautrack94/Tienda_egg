
package tienda.persistencia;

import tienda.entidades.Fabricante;


public final class FabricanteDAO extends DAO {
    public void guardarFabricante(Fabricante fabricante) throws Exception{
        try {
            if(fabricante == null){
                throw new Exception("Debe indicar un fabricante");
            } 
            String sql = "INSERT INTO fabricante (codigo, nombre)"
                    + "VALUES( '" + fabricante.getCodigo() + "', '" + fabricante.getNombre() + "' );";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }
    public void modificarFabricante(Fabricante fabricante) throws Exception{
        try {
            if(fabricante == null){
                throw new Exception("Debe indicar el fabricante que quiere modificar");
            }
            String sql = "UPDATE fabricante SET "
                    + "nombre = '" + fabricante.getNombre() + "'WHERE codigo = '" + fabricante.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }
    public void eliminarFabricante(int codigo) throws Exception{
        try {
            String sql = "DELETE FROM fabricante WHERE codigo = '" + codigo + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }
    
    
}
