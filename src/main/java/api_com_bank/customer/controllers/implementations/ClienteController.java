package api_com_bank.customer.controllers.implementations;

import api_com_bank.customer.controllers.contracts.IClienteController;
import api_com_bank.customer.dtos.request.ClienteRequestDTO;
import api_com_bank.customer.dtos.response.ClienteResponseDTO;
import api_com_bank.customer.dtos.response.ResponseDTO;
import api_com_bank.customer.services.contracts.IClienteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClienteController implements IClienteController {

    private final IClienteServices clienteServices;

    @Override
    public ResponseEntity<ResponseDTO> create(ClienteRequestDTO clienteRequestDTO) {
        ResponseDTO response = clienteServices.create(clienteRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseDTO> update(ClienteRequestDTO clienteRequestDTO) {
        ResponseDTO response = clienteServices.update(clienteRequestDTO);
        HttpStatus status = response.getRc().equals("00") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(response, status);
    }

    @Override
    public ResponseEntity<ResponseDTO> delete(String clienteId) {
        ResponseDTO response = clienteServices.delete(clienteId);
        HttpStatus status = response.getRc().equals("00") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(response, status);
    }

    @Override
    public ResponseEntity<ClienteResponseDTO> findById(String clienteId) {
        ClienteResponseDTO cliente = clienteServices.findById(clienteId);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
