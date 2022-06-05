package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepo extends JpaRepository <Services, Long>{
}
