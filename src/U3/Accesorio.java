package U3;

class Accesorio extends Producto{


    public Accesorio(String nombre, double precio) {
        super(nombre, precio);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre() + ", Precio: $" + getPrecio());
    }
}