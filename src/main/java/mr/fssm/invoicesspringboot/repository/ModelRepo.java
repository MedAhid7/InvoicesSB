package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepo extends JpaRepository <Modele, String>{
}
