package pe.cibertec.i202222124.cl2_conca_chavarria_jheremy_william.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmActor {

    @EmbeddedId
    private FilmActorId id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
}

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class FilmActorId {
    private Integer filmId;
    private Integer actorId;
}
