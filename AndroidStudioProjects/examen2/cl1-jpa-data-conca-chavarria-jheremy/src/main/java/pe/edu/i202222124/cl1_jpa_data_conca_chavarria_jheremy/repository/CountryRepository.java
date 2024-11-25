package pe.edu.i202222124.cl1_jpa_data_conca_chavarria_jheremy.repository;

import pe.edu.i202222124.cl1_jpa_data_conca_chavarria_jheremy.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, String> {
}
