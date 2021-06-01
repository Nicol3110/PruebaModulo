package vistas;

import java.util.Scanner;
import servicio.*;
import modelo.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import utilidades.Utilidad;
public class Menu extends MenuTemplate{


	private ClienteServicio clienteServicio = new ClienteServicio();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
//	private ExportadorCsv exportadorCsv = new ExportadorCsv();
//	private ExportadorCsv exportarTxt = new ExportadorCsv();
	private String filename1 = "DBClientes.csv";
	private String filename = "Clientes";
	private Scanner sc = new Scanner(System.in);

	@Override
	public void listarClientes() {
		// Llama metodo retornolistarClientes
		clienteServicio.retornolistarClientes();
		Utilidad.stopAndContinue();
	}

	@Override
	public void agregarCliente() {
		//System.out.print("llama agregar clientes");
		String run = "";
		String nombre = "";
		String apellido = "";
		int anios =0;
		//Solicita datos para crear nuevo cliente
		System.out.println("-------------Crear Cliente-------------\n\n");
		System.out.println ("Ingresa RUN del Cliente: ");
		run=sc.nextLine();
		System.out.println ("Ingresa Nombre del Cliente: ");
		nombre = sc.nextLine();
		System.out.println ("Ingresa Apellido del Cliente: ");
		apellido = sc.nextLine();
		System.out.println("Ingresa años como Cliente: ");
		anios= Integer.parseInt(sc.nextLine());
		System.out.println("---------------------------------------\n\n");
		CategoriaEnum categoria=CategoriaEnum.Activo;


		Cliente clienteAgregar = new Cliente(run, nombre, apellido, anios, categoria);
		clienteServicio.agregarCliente(clienteAgregar); 

	}


	@Override
	public void editarCliente() {

		System.out.println("-------------Editar Cliente-------------\n"
				+"Seleccione qué desea hacer:\n"
				+"1.-Cambiar el estado del Cliente\n"
				+"2.-Editar los datos ingresados del Cliente\n"
				+"Ingrese opcion:\n");

		int opcionEditar = Integer.parseInt(sc.nextLine());

		System.out.println("Ingrese RUN del Cliente a editar:");
		String runBuscar = sc.nextLine();
		//Ver si cliente a editar existe
		int posCliente = -1;
		List<Cliente> listaClientes = clienteServicio.getListaClientes();
		for(int i =0; i<listaClientes.size();i++) {
			if(listaClientes.get(i).getRunCliente().equals(runBuscar)) {
				posCliente=i;
			}
		}if (posCliente==-1) {
			System.out.println("Cliente no existe");
			Utilidad.stopAndContinue();
		} else {

			Cliente clienteEdit = listaClientes.get(posCliente);
			//System.out.print(clienteEdit);
			System.out.println("-----Actualizando estado del Cliente----\n");
			switch(opcionEditar) {
			case 1://Actualizar Estado de cliente
				if(clienteEdit.getNombreCategoria()==CategoriaEnum.Activo) {
					System.out.println("El estado actual es: "+clienteEdit.getNombreCategoria()
					+"\n1.-Si desea cambiar el estado del Cliente a Inactivo\n"
					+"2.-Si desea mantener el estado del cliente Activo\n"
					+"Ingrese opcion:\n"
					+"----------------------------------------\n");
					int opcionActivo = sc.nextInt();
					switch(opcionActivo) {
					case 1://Cliente Activo cambia a Inactivo
						clienteServicio.editarCliente(clienteEdit, null, null, null, 0, clienteEdit.getNombreCategoria());
						break;
					case 2://Cliente Activo se mantiene 
						System.out.println("Cliente se mantiene "+clienteEdit.getNombreCategoria());
						break;
					}
					Utilidad.stopAndContinue();
				}
				if(clienteEdit.getNombreCategoria()==CategoriaEnum.Inactivo) {
					System.out.println("El estado actual es: "+clienteEdit.getNombreCategoria()
					+"\n1.-Si desea cambiar el estado del Cliente a Activo\n"
					+"2.-Si desea mantener el estado del cliente Inactivo\n"
					+"Ingrese opcion:\n"
					+"----------------------------------------\n");
					int opcionInactivo = sc.nextInt();
					switch(opcionInactivo) {
					case 1://Cliente Inactico cambia a Activo
						clienteServicio.editarCliente(clienteEdit, null, null, null, 0, clienteEdit.getNombreCategoria());
						break;
					case 2://Cliente Activo se mantiene 
						System.out.println("Cliente se mantiene "+clienteEdit.getNombreCategoria());
						break;}
					Utilidad.stopAndContinue();
				};
				break;
			case 2://Editar Datos cliente
				System.out.println("----Actualizando datos del Cliente-----\n"
						+"1.-El RUN del Cliente es: "+clienteEdit.getRunCliente()
						+"\n2.-El Nombre del Cliente es :"+clienteEdit.getNombreCliente()
						+"\n3.-El Apellido del Cliente es: "+clienteEdit.getApellidoCliente()
						+"\n4.-Los años como Cliente son: "+clienteEdit.getAnosCliente()
						+"\nIngrese opcion a editar de los datos del cliente:\n" + 
						"----------------------------------------\n");
				int opcionDatos = sc.nextInt();
				switch(opcionDatos) {
				case 1://run
					System.out.println("Ingrese nuevo RUN del Cliente:");
					sc.nextLine();
					String newRut = sc.nextLine();
					clienteServicio.editarCliente(clienteEdit,newRut , null, null, 0, null);
					break;
				case 2: //nombre
					System.out.println("Ingrese nuevo nombre del Cliente:");
					sc.nextLine();
					String newNombre=sc.nextLine();
					clienteServicio.editarCliente(clienteEdit, null, newNombre, null, 0, null);
					break;
				case 3://apellido
					System.out.println("Ingrese nuevo apellido del CLiente:");
					sc.nextLine();
					String newApellido = sc.nextLine();
					clienteServicio.editarCliente(clienteEdit, null, null, newApellido, 0, null);
					break;
				case 4://anios
					System.out.println("Ingrese nuevos anios de Cliente:");
					sc.nextInt();
					int newAnios = sc.nextInt();
					clienteServicio.editarCliente(clienteEdit, null, null, null, newAnios, null);
					break;
				};

				break;
			}
		}
		Utilidad.stopAndContinue();
	} //Fin Editar




	@Override
	public void cargarDatos() {
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		String ruta = sc.nextLine();
		ruta = ruta + filename1;
		List<Cliente> listaCarga = archivoServicio.cargarDatos(ruta);
		System.out.println(listaCarga);

		for(Cliente cliente:listaCarga) {
			clienteServicio.agregarCliente(cliente);

		}
	}


	/*System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		//String ruta = sc.nextLine();
		String ruta = "/Users/nicolrojaszurita/";
		ruta = ruta+"/"+filename1;
		//System.out.print(ruta);
		List<Cliente> listaClientes = clienteServicio.getListaClientes();
		archivoServicio.cargarDatos(ruta, clienteServicio);*/

	@Override
	public void exportarDatos() {
		System.out.print("llama exportar datos");
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println();
		System.out.println("Elija una opcion para exportar:");

		//int opcionExportar = Integer.parseInt(sc.nextLine());

		sc.nextLine();

		System.out.println();
		System.out.println("---------Exportar Datos en Windows---------------");

		try {

			System.out.println("Ingrese la opción a exportar:");
			int opcionExportar = Integer.parseInt(sc.nextLine());            

			switch (opcionExportar) {
			case 1:// csv
				// System.out.println("Ingresa la ruta en donde desea exportar el archivo
				// clientes.csv:");
				// rutaDir = sc.nextLine();
				ExportadorCsv exportarCsv = new ExportadorCsv();
				exportarCsv.exportar(filename, clienteServicio.getListaClientes());

				System.out.println("Datos de clientes exportados correctamente en formato csv.");
				break;
			case 2:// txt

				ExportadorTxt exportarTxt = new ExportadorTxt();
				exportarTxt.exportar(filename, clienteServicio.getListaClientes());

				System.out.println("Datos de clientes exportados correctamente en formato txt.");
				break;
			default:
				System.out.println("Usted ingreso una opcion incorrecta entre 1 y 2");
			}
		} catch (InputMismatchException e) {
			System.out.println("Debes insertar un número\n");
			sc.next();
			Utilidad.stopAndContinue();

		}


		Utilidad.stopAndContinue();
	};
	@Override
	public void terminarPrograma() {
		System.out.print("Finalizando programa . . . ");


	};


}


