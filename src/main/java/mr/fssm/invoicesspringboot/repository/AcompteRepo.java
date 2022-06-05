package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.Acompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcompteRepo extends JpaRepository <Acompte, Long>{
}
