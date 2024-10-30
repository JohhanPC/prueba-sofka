package api_com_bank.customer.dtos.request;

import lombok.Data;

@Data
public class ClienteRequestDTO {
    // Datos de Persona
    private String nombre;
    private String genero;
    private Integer edad;
    private String identificacion;
    private String direccion;
    private String telefono;

    // Datos específicos de Cliente
    private String clienteId;
    private String contrasena;
    private Boolean estado;
}
