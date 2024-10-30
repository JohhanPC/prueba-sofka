package api_com_bank.customer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSONA")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK de Persona

    @Column(name = "NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "GENERO",nullable = false)
    private String genero;

    @Column(name = "EDAD",nullable = false)
    private Integer edad;

    @Column(name = "IDENTIFICACION", nullable = false, unique = true)
    private String identificacion;

    @Column(name = "DIRECCION",nullable = false)
    private String direccion;

    @Column(name = "TELEFONO",nullable = false)
    private String telefono;

}
