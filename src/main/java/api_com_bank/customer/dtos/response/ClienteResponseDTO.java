package api_com_bank.customer.dtos.response;

import lombok.Data;

@Data
public class ClienteResponseDTO {
    // Datos de Persona
    private Long id; // PK de Persona
    private String nombre;
    private String genero;
    private Integer edad;
    private String identificacion;
    private String direccion;
    private String telefono;

    // Datos específicos de Cliente
    private String clienteId;
    private Boolean estado;
}
