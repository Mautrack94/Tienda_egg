
package tienda.menu;

import java.util.Scanner;
import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;


public class Menu {
    int opcion;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ProductoServicio p = new ProductoServicio();
    FabricanteServicio f = new FabricanteServicio();
    
    public void mostrarMenu() throws Exception{
       
        System.out.println("Menú de opciones:"
                + "\n1) Mostrar todos los productos"
                + "\n2) Mostrar los nombres y precios de los productos"
                + "\n3) Mostrar productos cuyo precio esté entre 120 y 202"
                + "\n4) Mostrar todos los portátiles disponibles"
                + "\n5) Mostrar el producto más barato"
                + "\n6) Ingresar un producto nuevo"
                + "\n7) Ingresar un fabricante nuevo"
                + "\n8) Editar un producto"
                + "\n9) Salir");
        
        
           
        
        
    }
}
