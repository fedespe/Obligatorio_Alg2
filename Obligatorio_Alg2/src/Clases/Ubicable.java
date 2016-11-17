package Clases;

public class Ubicable {
	private String nombre;
	private double coordX;
	private double coordY;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCoordX() {
		return coordX;
	}
	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}
	public double getCoordY() {
		return coordY;
	}
	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}
	public Ubicable(String nombre, double coordX, double coordY) {
		super();
		this.nombre = nombre;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coordX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(coordY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Ubicable o=(Ubicable)obj;
        if(this.coordX==o.getCoordX() && this.coordY==o.getCoordY())
            return true;
        return false;
	}
}
