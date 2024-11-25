package pe.edu.i202222124.cl1_jpa_data_conca_chavarria_jheremy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String Name;

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

    private String District;

    private Integer Population;
}

