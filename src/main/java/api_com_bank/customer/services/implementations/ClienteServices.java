package api_com_bank.customer.services.implementations;

import api_com_bank.customer.dtos.request.ClienteRequestDTO;
import api_com_bank.customer.dtos.response.ClienteResponseDTO;
import api_com_bank.customer.dtos.response.ResponseDTO;
import api_com_bank.customer.entities.ClienteEntity;
import api_com_bank.customer.exceptions.ClientErrorException;
import api_com_bank.customer.mappers.ClienteMapper;
import api_com_bank.customer.repositories.ClienteRepository;
import api_com_bank.customer.services.contracts.IClienteServices;
import api_com_bank.customer.utils.Messages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteServices implements IClienteServices {

    private final ClienteRepository clienteRepository;

    @Override
    public ResponseDTO create(ClienteRequestDTO clienteRequestDTO) {
        log.info("Creando cliente: {}", clienteRequestDTO);
        ClienteEntity clienteEntity = ClienteMapper.INSTANCE.toEntity(clienteRequestDTO);
        clienteRepository.save(clienteEntity);

        return new ResponseDTO(Messages.CLIENTE_CREADO, "00", new Date());
    }

    @Override
    public ResponseDTO update(ClienteRequestDTO clienteRequestDTO) {
        ClienteEntity clienteToUpdate = clienteRepository.findById(clienteRequestDTO.getClienteId())
                .orElseThrow(() -> new ClientErrorException(String.format(Messages.CLIENTE_NO_ENCONTRADO, clienteRequestDTO.getClienteId())));

        ClienteEntity clienteEntity = ClienteMapper.INSTANCE.toEntity(clienteRequestDTO);
        clienteEntity.setId(clienteToUpdate.getId()); // Mantiene el ID original
        clienteRepository.save(clienteEntity);

        return new ResponseDTO(Messages.CLIENTE_ACTUALIZADO, "00", new Date());
    }

    @Override
    public ResponseDTO delete(String clienteId) {
        ClienteEntity clienteToDelete = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ClientErrorException(String.format(Messages.CLIENTE_NO_ENCONTRADO, clienteId)));

        clienteRepository.delete(clienteToDelete);
        return new ResponseDTO(Messages.CLIENTE_ELIMINADO, "00", new Date());
    }

    @Override
    public ClienteResponseDTO findById(String clienteId) {
        return clienteRepository.findById(clienteId)
                .map(ClienteMapper.INSTANCE::toDto)
                .orElseThrow(() -> new ClientErrorException(String.format(Messages.CLIENTE_NO_ENCONTRADO, clienteId)));
    }
}
