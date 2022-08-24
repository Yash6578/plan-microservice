package in.ashokit.planmicroservice.repository;

import in.ashokit.planmicroservice.entity.PlanCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Long> {
}
