package servicio;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Exportador {


	public List<Cliente> cargarDatos(String ruta) {

		//String ruta = "/Users/carolina/eclipse-workspace/1Prueba/"+filename;

		String linea;

		List<Cliente> listaCarga = new ArrayList<Cliente>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			linea = br.readLine();
			while (linea != null) {
				//System.out.println(linea);
				String[] items = linea.split(",");
				Cliente cliente = new Cliente();
				cliente.setRunCliente(items[0]);
				cliente.setNombreCliente(items[1]);
				cliente.setApellidoCliente(items[2]);
				cliente.setAnosCliente(Integer.parseInt(items[3].substring(0,1)));
				cliente.setNombreCategoria(CategoriaEnum.valueOf(items[4]));
				listaCarga.add(cliente);
				//clienteServicio.agregarCliente(cliente);
				linea=br.readLine();
			}
			//System.out.println(listaCarga);
			//clienteServicio.setListaClientes(listaCarga);


		}catch(FileNotFoundException ex) {
			System.err.println(ex.getMessage());
			System.out.println("Archivo no existe");
		}catch(IOException ex) {
			System.err.println(ex.getMessage());
			System.out.println("Error al leer archivo");
		}return listaCarga;
	}

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {

	}
}
