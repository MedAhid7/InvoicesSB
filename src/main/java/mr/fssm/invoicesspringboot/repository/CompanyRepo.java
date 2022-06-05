package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, String> {
}
