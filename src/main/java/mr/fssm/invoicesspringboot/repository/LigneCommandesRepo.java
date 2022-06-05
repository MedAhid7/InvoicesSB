package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.LigneCommandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandesRepo extends JpaRepository <LigneCommandes, String>{
}
