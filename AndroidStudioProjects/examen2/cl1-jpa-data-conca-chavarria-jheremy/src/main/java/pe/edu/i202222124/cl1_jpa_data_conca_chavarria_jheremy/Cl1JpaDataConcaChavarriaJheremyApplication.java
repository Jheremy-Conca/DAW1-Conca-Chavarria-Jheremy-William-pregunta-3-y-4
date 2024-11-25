
package pe.edu.i202222124.cl1_jpa_data_conca_chavarria_jheremy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.i202222124.cl1_jpa_data_conca_chavarria_jheremy.entity.Country;
import pe.edu.i202222124.cl1_jpa_data_conca_chavarria_jheremy.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataConcaChavarriaJheremyApplication implements CommandLineRunner {

	// Se inyecta el repositorio de países
	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		// Se ejecuta la aplicación de Spring Boot
		SpringApplication.run(Cl1JpaDataConcaChavarriaJheremyApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		// 1. Usar `ifPresentOrElse()` para imprimir los idiomas hablados en Argentina o Perú
		System.out.println("Consultando idiomas en Argentina o Perú...");
		Optional<Country> argentina = countryRepository.findById("ARG");
		argentina.ifPresentOrElse(
				country -> {
					// Si Argentina existe, se imprimen sus idiomas
					System.out.println("Idiomas hablados en Argentina:");
					country.getLanguages().forEach(language -> System.out.println(language));
				},
				() -> {
					// Si Argentina no existe, se busca y muestran los idiomas de Perú
					System.out.println("Argentina no encontrado, consultando idiomas en Perú...");
					Optional<Country> peru = countryRepository.findById("PER");
					peru.ifPresent(country -> {
						System.out.println("Idiomas hablados en Perú:");
						country.getLanguages().forEach(language -> System.out.println(language));
					});
				}
		);

		// 2. Usar `deleteAllById()` para eliminar países y eliminar en cascada sus ciudades e idiomas
		System.out.println("\nEliminando países (Colombia y Argentina)...");
		// Descomenta si deseas realizar la eliminación
		countryRepository.deleteAllById(List.of("COL", "ARG"));
		System.out.println("Países eliminados: Colombia y Argentina");


	}
}
