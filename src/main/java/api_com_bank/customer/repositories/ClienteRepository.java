package api_com_bank.customer.repositories;

import api_com_bank.customer.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
}
