package vistas;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MenuTemplate {




	protected Scanner sc = new Scanner(System.in);

	public abstract void listarClientes();

	public abstract void agregarCliente();

	public abstract void editarCliente();

	public abstract void cargarDatos();

	public abstract void exportarDatos();

	public abstract void terminarPrograma();

	public final void iniciarMenu() {

		System.out.println("\n1. Listar Clientes\n" 
				+ "2. Agregar Cliente\n" 
				+ "3. Editar Cliente\n"
				+ "4. Cargar Datos\n" 
				+ "5. Exportar Datos\n" 
				+ "6. Salir\n" 
				+ "Ingrese una opción: ");
		try {
			int opcionmenu = Integer.parseInt(sc.nextLine());

			switch (opcionmenu) {
			case 1:
				listarClientes();
				break;
			case 2:
				agregarCliente();
				break;
			case 3:
				editarCliente();
				break;
			case 4:
				cargarDatos();
				break;
			case 5:
				exportarDatos();
			case 6:
				terminarPrograma();
				break;
			default: System.out.println("La opción no es valida");
			}
		} catch (InputMismatchException e) {
			System.out.println("Debe ingresar númmero \n");
			sc.next();
		}
		iniciarMenu();
	}
}

