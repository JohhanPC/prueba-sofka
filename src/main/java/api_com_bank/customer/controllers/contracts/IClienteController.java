package api_com_bank.customer.controllers.contracts;

import api_com_bank.customer.dtos.request.ClienteRequestDTO;
import api_com_bank.customer.dtos.response.ClienteResponseDTO;
import api_com_bank.customer.dtos.response.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/v1/clientes")
public interface IClienteController {

    @PostMapping(path = "/create")
    ResponseEntity<ResponseDTO> create(@RequestBody ClienteRequestDTO clienteRequestDTO);

    @PutMapping(path = "/update")
    ResponseEntity<ResponseDTO> update(@RequestBody ClienteRequestDTO clienteRequestDTO);

    @DeleteMapping(path = "/delete/{clienteId}")
    ResponseEntity<ResponseDTO> delete(@PathVariable String clienteId);

    @GetMapping(path = "/findById/{clienteId}")
    ResponseEntity<ClienteResponseDTO> findById(@PathVariable String clienteId);

}
