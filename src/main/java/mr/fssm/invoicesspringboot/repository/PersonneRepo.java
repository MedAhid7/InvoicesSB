package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepo extends JpaRepository<Personne, String> {
}
