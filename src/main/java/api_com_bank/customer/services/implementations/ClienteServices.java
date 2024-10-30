package api_com_bank.customer.services.implementations;

import api_com_bank.customer.dtos.request.ClienteRequestDTO;
import api_com_bank.customer.dtos.response.ClienteResponseDTO;
import api_com_bank.customer.dtos.response.ResponseDTO;
import api_com_bank.customer.entities.ClienteEntity;
import api_com_bank.customer.mappers.ClienteMapper;
import api_com_bank.customer.repositories.ClienteRepository;
import api_com_bank.customer.services.contracts.IClienteServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class ClienteServices implements IClienteServices {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServices(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ResponseDTO create(ClienteRequestDTO clienteRequestDTO) {
        ResponseDTO response = new ResponseDTO();
        try {
            log.info("Creando cliente: {}", clienteRequestDTO);
            ClienteEntity clienteEntity = ClienteMapper.INSTANCE.toEntity(clienteRequestDTO);
            log.info("Cliente Entity antes de guardar: " + clienteEntity);

            clienteRepository.save(clienteEntity);

            response.setMessage("Cliente creado exitosamente");
            response.setRc("00"); // "00" es un código comúnmente usado para éxito
            response.setDate(new Date());

        } catch (Exception ex) {
            response.setMessage("Error al crear el cliente: " + ex.getMessage());
            response.setRc("99"); // "99" puede indicar un error general
            response.setDate(new Date());
        }
        return response;
    }

    @Override
    public ResponseDTO update(ClienteRequestDTO clienteRequestDTO) {
        ResponseDTO response = new ResponseDTO();
        try {
            Optional<ClienteEntity> clienteOptional = clienteRepository.findById(clienteRequestDTO.getClienteId());
            if (clienteOptional.isPresent()) {
                clienteOptional.get();
                ClienteEntity clienteToUpdate;
                clienteToUpdate = ClienteMapper.INSTANCE.toEntity(clienteRequestDTO);
                clienteToUpdate.setId(clienteOptional.get().getId()); // Asegura que se conserva el ID original
                clienteRepository.save(clienteToUpdate);

                response.setMessage("Cliente actualizado exitosamente");
                response.setRc("00");
            } else {
                response.setMessage("Cliente no encontrado");
                response.setRc("01");
            }
        } catch (Exception ex) {
            response.setMessage("Error al actualizar el cliente: " + ex.getMessage());
            response.setRc("99");
        }
        response.setDate(new Date());
        return response;
    }

    @Override
    public ResponseDTO delete(String clienteId) {
        ResponseDTO response = new ResponseDTO();
        try {
            Optional<ClienteEntity> clienteOptional = clienteRepository.findById(clienteId);
            if (clienteOptional.isPresent()) {
                clienteRepository.delete(clienteOptional.get());
                response.setMessage("Cliente eliminado exitosamente");
                response.setRc("00");
            } else {
                response.setMessage("Cliente no encontrado");
                response.setRc("01");
            }
        } catch (Exception ex) {
            response.setMessage("Error al eliminar el cliente: " + ex.getMessage());
            response.setRc("99");
        }
        response.setDate(new Date());
        return response;
    }

    @Override
    public ClienteResponseDTO findById(String clienteId) {
        try {
            Optional<ClienteEntity> clienteOptional = clienteRepository.findById(clienteId);
            return clienteOptional.map(ClienteMapper.INSTANCE::toDto).orElse(null);
        } catch (Exception ex) {
            log.error("Error al buscar el cliente: {}", ex.getMessage());
            return null;
        }
    }

}
