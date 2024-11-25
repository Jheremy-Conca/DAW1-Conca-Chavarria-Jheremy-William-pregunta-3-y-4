package pe.edu.i202222124.cl1_jpa_data_conca_chavarria_jheremy.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "countrylanguage")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguagePK id;

    @ManyToOne
    @MapsId("CountryCode")
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;
    private String IsOfficial;
    private Double Percentage;
}
