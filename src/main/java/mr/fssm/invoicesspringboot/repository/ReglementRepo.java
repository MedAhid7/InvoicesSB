package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.Reglement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReglementRepo extends JpaRepository <Reglement, Long>{
}
