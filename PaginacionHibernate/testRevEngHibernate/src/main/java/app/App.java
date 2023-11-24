package app;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.hibernate.Session;

import Model.City;
import Model.Country;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//iniciamos sesion
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();
		
		System.out.println("Numero de registros por pag. : ");
		int numRegistros = scanner.nextInt();
		scanner.nextLine();
		
		boolean salir = false;
		int pagActual = 1;
		
		while (!salir) {
			List<City> listCity = obtenerResultados(laSesion, pagActual, numRegistros); //Solicitamos los registros
			
			for (City city : listCity) {
				System.out.println("ID: " + city.getId() + ", Nombre: " + city.getName() + ", Distrito: " + city.getDistrict() + ", Censo: " + city.getPopulation());
			}
		
		
			System.out.println("\n<S/s> Avanzar Pag. | <A/a> Retroceder Pag | <G/g> Ir a la Pag introducida | <Q/q> Salir del programa");
			String opcion = scanner.nextLine().toLowerCase(Locale.ROOT);
		
			switch (opcion) {
		
				case "s":
				
					pagActual++;
					break;
				
				case "a":
				
					if(pagActual>1) {
						pagActual--;
					} else {
						System.out.println("\nNo puedes retroceder."
								+ "Estas en la primera pagina.\n");
						
					}
					break;
			
				case "g":
				
					System.out.println("A que pagina quieres ir: ");
					int pagina = scanner.nextInt();
					scanner.nextLine();
					pagActual = pagina;
					break;
				
				case "q":
					
					System.out.println("Bye!");
					salir = true;
					break;
				
				default:
					System.out.println("Opcion no valida");
				
				
				}
		}
		
		//close sesion
		laSesion.close();
		

	}
	
	//devuelve la lista con el numero de registros pasado 
	private static List<City> obtenerResultados(Session sesion, int pagina, int numRegistros){
		int primeraPag = (pagina - 1) * numRegistros;
		
		return sesion.createQuery("FROM City").setFirstResult(primeraPag).setMaxResults(numRegistros).list();
	}

}
