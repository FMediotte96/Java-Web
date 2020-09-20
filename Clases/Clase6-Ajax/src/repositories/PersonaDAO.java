package repositories;

import java.util.ArrayList;

import domain.Persona;

public class PersonaDAO {

	public PersonaDAO() {
	}
	
	/**
	 * Buscar personas
	 * @param campoBuscador
	 * @return ArrayList de personas
	 */
	public ArrayList<Persona> buscarPersonas(String campoBuscador) {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona(1,"Juan","j@gmail.com","12341234"));
		personas.add(new Persona(2,"Maria","m@gmail.com","12341234"));
		personas.add(new Persona(3,"Facundo","f@gmail.com","39436162"));
		return personas;

	}
	

}
