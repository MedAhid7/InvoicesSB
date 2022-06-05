package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, String> {
}
