package utilidades;


public class Utilidad {

	public static void stopAndContinue() {
		timeToWait();
		cleanScreen();

	}
	private static void cleanScreen() {
		int i = 0;
		for (i=0; i<20; i++) {
			System.out.println("");
		}
		System.out.flush();		
	}
	private static void timeToWait() {
		int timeWait = 10;
		try {
			for (int i = 0; i < timeWait; i++) {
				Thread.sleep(150);
			}
		} catch (InterruptedException ie) {
			System.out.println("Tiempo de espera interrumpido");
		}
	}
}