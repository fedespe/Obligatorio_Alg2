package Clases;

public class DataCenter extends Ubicable{
	private String empresa;
	private int capacidadCPUenHoras;
	private int costoCPUporHora;
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getCapacidadCPUenHoras() {
		return capacidadCPUenHoras;
	}
	public void setCapacidadCPUenHoras(int capacidadCPUenHoras) {
		this.capacidadCPUenHoras = capacidadCPUenHoras;
	}
	public int getCostoCPUporHora() {
		return costoCPUporHora;
	}
	public void setCostoCPUporHora(int costoCPUporHora) {
		this.costoCPUporHora = costoCPUporHora;
	}
	public DataCenter(String nombre, double coordX, double coordY, String empresa, int capacidadCPUenHoras,
			int costoCPUporHora) {
		super(nombre, coordX, coordY);
		this.empresa = empresa;
		this.capacidadCPUenHoras = capacidadCPUenHoras;
		this.costoCPUporHora = costoCPUporHora;
	}
	
	
}
