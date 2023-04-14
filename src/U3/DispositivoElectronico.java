package U3;

abstract class DispositivoElectronico extends Producto {
    private String marca;
    private String modelo;

    public DispositivoElectronico(String nombre, double precio, String marca, String modelo) {
        super(nombre, precio);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre() + ", Marca: " + marca + ", Modelo: " + modelo + ", Precio: $" + getPrecio());
    }
}