package VEHICULOS;

public class vehiculos {
    String placa;
    String marca;
    double cilindraje;
    String combustible;
    String color;
    String propietario;

    public vehiculos() {
    }

    public vehiculos(String placa, String marca, double cilindraje, String combustible, String color, String propietario) {
        this.placa = placa;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.combustible = combustible;
        this.color = color;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void mostrarDatosVehiculo(){
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Cilindraje: " + cilindraje);
        System.out.println("Combustible: " + combustible);
        System.out.println("Color: " + color);
        System.out.println("Propietario: " + propietario);
        System.out.println("\n");
    }
}
