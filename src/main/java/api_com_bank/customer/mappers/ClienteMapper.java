package api_com_bank.customer.mappers;

import api_com_bank.customer.dtos.request.ClienteRequestDTO;
import api_com_bank.customer.dtos.response.ClienteResponseDTO;
import api_com_bank.customer.entities.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true), // ID se genera automáticamente
            @Mapping(target = "nombre", source = "nombre"),
            @Mapping(target = "genero", source = "genero"),
            @Mapping(target = "edad", source = "edad"),
            @Mapping(target = "identificacion", source = "identificacion"),
            @Mapping(target = "direccion", source = "direccion"),
            @Mapping(target = "telefono", source = "telefono"),
            @Mapping(target = "clienteId", source = "clienteId"),
            @Mapping(target = "contrasena", source = "contrasena"),
            @Mapping(target = "estado", source = "estado")
    })
    ClienteEntity toEntity(ClienteRequestDTO clienteRequestDTO);

    // Convierte la entidad de Cliente a DTO de respuesta
    ClienteResponseDTO toDto(ClienteEntity clienteEntity);

}
