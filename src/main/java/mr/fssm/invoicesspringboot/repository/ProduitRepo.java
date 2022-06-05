package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo extends JpaRepository <Produit, Long>{
}
