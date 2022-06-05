package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepo extends JpaRepository<Fournisseur, String> {

}
