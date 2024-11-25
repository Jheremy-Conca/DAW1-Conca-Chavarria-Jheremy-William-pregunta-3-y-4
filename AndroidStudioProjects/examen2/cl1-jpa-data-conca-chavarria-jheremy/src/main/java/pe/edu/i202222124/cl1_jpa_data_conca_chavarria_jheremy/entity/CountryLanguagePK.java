package pe.edu.i202222124.cl1_jpa_data_conca_chavarria_jheremy.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguagePK implements Serializable {

    @Column(name = "CountryCode")
    private String CountryCode;

    private String Language;
}
