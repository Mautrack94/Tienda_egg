
package tienda.entidades;


public class Distribuidor {
    private String nombre;
    private String direccion;
    private Integer id;

    public Distribuidor() {
    }

    public Distribuidor(String nombre, String direccion, Integer id) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
