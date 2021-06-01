package prueba.SistemaDeClientes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import modelo.*;
import servicio.ClienteServicio;

@DisplayName("Tests clase Repositorio Cliente")
public class ClienteServicioTest {

	private final ClienteServicio clienteServicio = new ClienteServicio();

	@Test
	public void agregarClienteTest() {
		Cliente pepe = new Cliente("1.222.333-1", "Pepe", "Rios", 29, CategoriaEnum.Activo );
		String respuestaServicio = clienteServicio.agregarCliente(pepe);
		assertEquals("Cliente se ha creado", respuestaServicio);
	}
	@Test
	public void agregarClienteNullTest() {
		Cliente pepe = new Cliente();
		String respuestaServicio = clienteServicio.agregarCliente(pepe);
		assertEquals("null", respuestaServicio);
	}
}