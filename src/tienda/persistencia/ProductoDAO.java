
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;


public final class ProductoDAO extends DAO {
    
    public void guardarProducto(Producto producto) throws Exception{
        try {
            if(producto == null){
                throw new Exception("Debe especificar un producto");
            }
            String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante)"
                    + "VALUES( '" +producto.getCodigo() + "', '" + producto.getNombre() + "', '" + producto.getPrecio()
                     + "', '" + producto.getCodigoFabricante() + "' );";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }
    public void modificarProducto(Producto producto) throws Exception{
        try {
            if(producto == null){
                throw new Exception("Debe indicar el producto a modificar");
            }
            String sql = "UPDATE producto SET"
                    + "nombre = '" + producto.getNombre() + "precio = '" + producto.getPrecio()
                    + "codigo_fabricante = '" + producto.getCodigoFabricante() + "'WHERE codigo = " + producto.getCodigo() + " ';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }
    public Collection<Producto> listarProductos() throws Exception{
        try {
            String sql = "SELECT nombre FROM producto";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while(resultado.next()){
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    public Collection<Producto> listarNombreYPrecio() throws Exception{
        try {
            String sql = "SELECT nombre, precio FROM producto";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while(resultado.next()){
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception ("Error de sistema");
        }
    }
    public Collection<Producto> listarPreciosCondicion() throws Exception{
         try {
            String sql = "SELECT nombre, precio FROM producto WHERE precio BETWEEN 120 AND 202";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while(resultado.next()){
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception ("Error de sistema");
        }
    }
    public Collection<Producto> listarPortatiles() throws Exception{
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE 'Portátil%'";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while(resultado.next()){
                producto = new Producto();
               producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);    
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    public Producto productoMasBarato() throws Exception{
        try {
            String sql = "SELECT nombre, precio FROM producto WHERE precio LIKE (SELECT MIN(precio) FROM producto)";
            consultarBase(sql);
            Producto producto = null;
            while(resultado.next()){
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    public Producto buscarProductoPorCodigo(Integer codigo) throws Exception{
        try {
            String sql = "SELECT * FROM producto"
                    + "WHERE codigo = '" + codigo + "'";
            consultarBase(sql);
            Producto p = null;
            while(resultado.next()){
                p = new Producto();
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return p;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
}
