package modelo;

public class Cliente {

	//Identificador unico
	private String runCliente;
	private String nombreCliente	;
	private String apellidoCliente;
	private int anosCliente;
	private CategoriaEnum nombreCategoria;

	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, 
			int anosCliente, CategoriaEnum nombreCategoria) {
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.anosCliente = anosCliente;
		this.nombreCategoria = nombreCategoria;
	} 
	//Constructor Vacio
	public Cliente() {

	}

	public String getRunCliente() {
		return runCliente;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public int getAnosCliente() {
		return anosCliente;
	}

	public void setAnosCliente(int anosCliente) {
		this.anosCliente = anosCliente;
	}

	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public String toString() {
		return "Cliente [runCliente=" + runCliente + ", nombreCliente=" + 
				nombreCliente + ", apellidoCliente="+ apellidoCliente + ", "
				+ "anosCliente=" + anosCliente + ", nombreCategoria=" + 
				nombreCategoria + "]";
	}

}

