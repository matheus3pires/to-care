package br.com.ToCare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "localizacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Localizacao {

    @Id
    private UUID id;

    @Column(nullable = false, precision = 9, scale = 6)
    private Double latitude;

    @Column(nullable = false, precision = 9, scale = 6)
    private Double longitude;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Cuidador cuidador;

}
