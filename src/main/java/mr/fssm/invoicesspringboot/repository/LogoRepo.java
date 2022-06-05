package mr.fssm.invoicesspringboot.repository;

import mr.fssm.invoicesspringboot.entities.Logo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogoRepo extends JpaRepository <Logo, Long>{
}
