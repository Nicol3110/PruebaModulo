package servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {

	List<Cliente> listaClientes;

	public ClienteServicio() {
		listaClientes = new ArrayList<Cliente>();
	}


	public ClienteServicio(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	//Getter devuelve una listaClientes
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	// Setter no se si lo neceisto.
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void retornolistarClientes() {
		if(this.listaClientes==null||this.listaClientes.size()==0||this.listaClientes.isEmpty()) {
			System.out.println("La lista de clientes esta vacia");
		}
		else {for (Cliente cliente : this.listaClientes) {
			System.out.println("-------------Datos del Cliente-------------\n" 
					+ "RUN del Cliente: "
					+ cliente.getRunCliente() + "\nNombre del Cliente: " + cliente.getNombreCliente()
					+ "\nApellido del cliente: " + cliente.getApellidoCliente() + "\nAños como Cliente: "
					+ cliente.getAnosCliente() + " años" + "\nCategoria del Cliente: "
					+ cliente.getNombreCategoria()+"\n\n");
		} 
		}
	}
	public String agregarCliente(Cliente cliente) {

		String run = cliente.getRunCliente();
		int posCliente =-1;
		if(cliente!=null) {
			if (this.listaClientes.size()==0){
				this.listaClientes.add(cliente);
				System.out.println("Se ha agregado cliente "+cliente.getRunCliente());
			}else {
				for (int i = 0; i < this.listaClientes.size();i++) {
					if(this.listaClientes.get(i).getRunCliente().equals(run)){
						posCliente = i;
					}
				}
				if(posCliente == -1) {
					this.listaClientes.add(cliente);
					System.out.print("Se ha agregado cliente "+cliente.getRunCliente());

				} else System.out.println("Cliente "+cliente.getRunCliente()+" ya se encuentra en el listado");

				return null;

			}
		}
		return "Cliente se ha creado";


	}




	public void editarCliente(Cliente cliente, String runN, String nombreN, String apellidoN,
			int anosN, CategoriaEnum nomCatN) {

		try { 
			if(cliente!=null&&nomCatN!=null) {
			}
			if(nomCatN==CategoriaEnum.Activo) {
				cliente.setNombreCategoria(CategoriaEnum.Inactivo);
				System.out.println("Cliente ha cambiado a Inactivo");}
			if(nomCatN==CategoriaEnum.Inactivo) {
				cliente.setNombreCategoria(CategoriaEnum.Activo);
				System.out.println("Cliente ha cambiado a Activo");}
		} catch (Exception e) {
			System.out.println("No se pudo cambiar la categoría" + e.getMessage());

		}
		if(cliente!=null&&runN!=null) {
			cliente.setRunCliente(runN);
			System.out.println("El nuevo rut del cliente es "+runN);
		}
		if(cliente!=null&&nombreN!=null) {
			cliente.setNombreCliente(nombreN);
			System.out.println("El nuevo nombre del cliente es "+nombreN);
		}
		if(cliente!=null&&apellidoN!=null) {
			cliente.setApellidoCliente(apellidoN);
			System.out.println("El nuevo apellido del cliente es "+apellidoN);
		}
		if(cliente!=null&&anosN!=0) {
			cliente.setAnosCliente(anosN);
			System.out.println("El nuevo anios del cliente es "+anosN);
		}
		else 
			System.out.println("");

	}
}