package api_com_bank.customer.services.contracts;

import api_com_bank.customer.dtos.request.ClienteRequestDTO;
import api_com_bank.customer.dtos.response.ClienteResponseDTO;
import api_com_bank.customer.dtos.response.ResponseDTO;

public interface IClienteServices {

    ResponseDTO create(ClienteRequestDTO clienteRequestDTO);

    ResponseDTO update(ClienteRequestDTO clienteRequestDTO);

    ResponseDTO delete(String clienteId);

    ClienteResponseDTO findById(String clienteId);

}
