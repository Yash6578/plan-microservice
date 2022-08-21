package in.ashokit.planmicroservice.service;

import in.ashokit.planmicroservice.entity.Plan;

import java.util.List;

public interface PlanService {
    boolean save(Plan plan);
    boolean update(Plan plan);
    boolean delete(Long id);
    boolean changeStatus(Long id, String status);
    Plan findById(Long id);
    List<Plan> getAll();
}
