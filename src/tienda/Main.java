package tienda;

import java.util.Scanner;
import tienda.menu.Menu;
import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;

public class Main {

    public static void main(String[] args) throws Exception {
        ProductoServicio p = new ProductoServicio();
        FabricanteServicio f = new FabricanteServicio();
        Menu m = new Menu();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;
        do{
        m.mostrarMenu();
        opcion = leer.nextInt();
         switch (opcion) {
                case 1:
                    p.listarProductos();
                    
                    break;
                case 2:
                    p.listarNombreYPrecio();
                    
                    break;
                case 3:
                    p.listarPreciosEspecificos();
                    
                    break;
                case 4:
                    p.listarPortatiles();
                    
                    break;
                case 5:
                    p.productoMasBarato();
                    
                    break;
                case 6:
                    p.crearProducto(115, "Notebook Bangho", 12000d, 7);
                    
                    break;
                case 7:
                    f.crearFabricante(9, "Compaq");
                    
                    break;
                case 8:
                    p.modificarProducto(2, "Disco duro SATA", 400d, 2);
                    
                    break;
                case 9:
                    System.out.println("Gracias por utilizar la aplicación");
                    break;
                default:
                    System.out.println("Debe seleccionar una opción entre 1 y 9");
                    
            }
        
        }while(opcion < 9);

    }

}
