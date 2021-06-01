package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import modelo.Cliente;

public class ExportadorCsv extends Exportador {

	public void exportar(String fileName, List<Cliente> listaClientes) {

		Scanner teclado = new Scanner(System.in);
		// System.out.println("Ingrese la carpeta donde desea guardar el
		// clientes.txt\n");
		// String ruta = teclado.nextLine();
		System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
		String ruta = teclado.nextLine();

		// String[] parts = ruta.split("\n");

		// se exporta a la ruta src/directorio/archivo
		File directorio = new File(ruta);

		if (directorio.exists() == false) {
			try {
				directorio.mkdir();
				System.out.println("Se logró con éxito");
			} catch (Exception e) {
				System.out.println("Error al crear directorio, lo sentimos");
			}
		}

		File archivo = new File( ruta + "/" + fileName);
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (Exception e) {
				System.out.println("No se puede crear porque: " + e.getMessage());
			}
		}

		try {
			BufferedWriter filew = new BufferedWriter(new FileWriter(archivo));

			/*for (int i = 0; i < listaClientes.size(); i++) {
                filew.write("\n" + listaClientes.get(i));
            }*/

			String impresioncsv ="";
			for (Cliente cliente : listaClientes) {
				impresioncsv += cliente.getRunCliente()+","+cliente.getNombreCliente()+","+cliente.getApellidoCliente()+","+cliente.getAnosCliente()+","+cliente.getNombreCategoria()+"\n";

			}
			filew.write(impresioncsv);
			filew.close();
		} catch (IOException e) {
			System.out.println("El fichero no existe" + e.getMessage());
		}

	}
}