package in.ashokit.planmicroservice.repository;

import in.ashokit.planmicroservice.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepo extends JpaRepository<Plan, Long> {
}
