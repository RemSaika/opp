package U3;


// Clase padre Producto
public abstract class Producto {
    protected String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract void mostrarInformacion();

    public String toString() {
        return "(Nombre: " + nombre +  ",  Precio: " + precio + ")";
    }
}
