package U3;

import java.util.ArrayList;
import java.util.Arrays;

class Tienda {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void agregarProducto(Producto[] producto) {
        productos.addAll(Arrays.asList(producto));
    }

    public void mostrarCatalogo() {
        System.out.println("Catálogo de productos:");
        for (Producto producto : productos) {
            producto.mostrarInformacion();
        }
    }
}