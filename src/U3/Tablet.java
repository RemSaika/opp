package U3;

class Tablet extends DispositivoElectronico {
    private int almacenamiento;

    public Tablet(String nombre, double precio, String marca, String modelo, int almacenamiento) {
        super(nombre, precio, marca, modelo);
        this.almacenamiento = almacenamiento;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
}