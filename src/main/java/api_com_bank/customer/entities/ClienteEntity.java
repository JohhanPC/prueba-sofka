package api_com_bank.customer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENTE")
@EqualsAndHashCode(callSuper = true)
public class ClienteEntity extends PersonaEntity {

    @Column(name = "CLIENTE_ID", nullable = false, unique = true)
    private String clienteId; // Clave única para Cliente

    @Column(name = "CONTRASENA", nullable = false)
    private String contrasena;

    @Column(name = "ESTADO", nullable = false)
    private Boolean estado;
}
