package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepo extends JpaRepository<Devis, Long> {
    /*Facture findFactureDevisByFaAndFactDevId(String id);
    @Query(value = "SELECT * FROM facture_devis f WHERE f.facId LIKE %:search%", nativeQuery = true)
    Page<Facture> findAllFacByFactureId(Pageable pageableRequest, @Param("search") String search);
    Devis findDevisById(int id);
    @Query(value = "SELECT * FROM facture_devis d WHERE d.devis_id LIKE %:search%", nativeQuery = true)
    Page<Devis> findAllDevisById(Pageable pageableRequest, @Param("search") String search);
*/
    Devis findByCodeDevis (String codeDevis);
}
