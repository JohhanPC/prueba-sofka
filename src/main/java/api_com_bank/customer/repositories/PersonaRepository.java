package api_com_bank.customer.repositories;

import api_com_bank.customer.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
