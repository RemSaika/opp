package U3;


class Consolas extends DispositivoElectronico {
    private int ram;

    public Consolas(String nombre, double precio, String marca, String modelo, int ram) {
        super(nombre, precio, marca, modelo);
        this.ram = ram;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
