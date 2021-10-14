
package tienda.servicios;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;


public class ProductoServicio {
    private ProductoDAO dao;

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }
    public Collection<Producto> listarProductos() throws Exception{
        try{
            Collection<Producto> productos = dao.listarProductos();
            return productos;
        }catch(Exception e){
            throw e;
        }
    }
   
    public void imprimirProductos() throws Exception{
        try {
            Collection<Producto> productos = listarProductos();
            if(productos.isEmpty()){
                throw new Exception("No existen productos para imprimir");
            }else{
                for (Producto p : productos) {
                    System.out.println(p);  
                }
            }
        } catch (Exception e) {
        }
    }
    
    public Collection<Producto> listarNombreYPrecio() throws Exception{
            try {
                Collection<Producto> productos = dao.listarNombreYPrecio();
                return productos;
            } catch (Exception e) {
                throw e;
            }
    }
    
    public void imprimirNombreYPrecio() throws Exception{
        try {
            Collection<Producto> productos = listarNombreYPrecio();
            if(productos.isEmpty()){
                throw new Exception("No hay productos para mostrar");
            }else{
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
        }
    }
    
    public Collection<Producto> listarPreciosEspecificos() throws Exception{
        try {
            Collection<Producto> productos = dao.listarPreciosCondicion();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirPreciosEspecificos() throws Exception{
        try {
            Collection<Producto> productos = listarPreciosEspecificos();
            if(productos.isEmpty()){
                throw new Exception("No hay productos para mostrar");
            }else{
                for (Producto p : productos) {
                    System.out.println(p); 
                }
            }
        } catch (Exception e) {
        }
    }
    
    public Collection<Producto> listarPortatiles() throws Exception{
        try {
            Collection<Producto> productos = dao.listarPortatiles();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirPortatiles() throws Exception{
        try {
            Collection<Producto> productos = listarPortatiles();
            if(productos.isEmpty()){
                throw new Exception("No se encuentran portátiles");
            }else{
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
        }
    }
    
    public void productoMasBarato() throws Exception{
        try {
            Producto p1 = dao.productoMasBarato();
            System.out.println(p1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void crearProducto(int codigo, String nombre, double precio, int codigoFabricante) throws Exception{
        try {
            Producto p = new Producto();
            p.setCodigo(codigo);
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(codigoFabricante);
            dao.guardarProducto(p);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Producto buscarProductoPorId(Integer codigo) throws Exception{
        try {
            if(codigo == null){
                throw new Exception("Debe indicar el código");
            }else{
                Producto p = dao.buscarProductoPorCodigo(codigo);
                return p;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarProducto(int codigo, String nombreNuevo, double precioNuevo, int codigoFabricanteNuevo ) throws Exception{
        try {
            Producto p = buscarProductoPorId(codigo);
            p.setNombre(nombreNuevo);
            p.setPrecio(precioNuevo);
            p.setCodigoFabricante(codigoFabricanteNuevo);
            dao.modificarProducto(p);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
}
