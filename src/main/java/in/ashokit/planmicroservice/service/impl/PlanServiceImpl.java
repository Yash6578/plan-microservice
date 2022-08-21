package in.ashokit.planmicroservice.service.impl;

import in.ashokit.planmicroservice.entity.Plan;
import in.ashokit.planmicroservice.repository.PlanRepo;
import in.ashokit.planmicroservice.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepo planRepo;

    @Override
    public boolean save(Plan plan) {
        return planRepo.save(plan).getId() != null;
    }

    @Override
    public boolean update(Plan plan) {
        return save(plan);
    }

    @Override
    public boolean delete(Long id) {
        boolean status = false;

        try {
            planRepo.deleteById(id);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean changeStatus(Long id, String status) {
        Plan plan = findById(id);
        if(plan != null) {
            plan.setActiveSw(status);
            return save(plan);
        }
        return false;
    }

    @Override
    public Plan findById(Long id) {
        Optional<Plan> plan = planRepo.findById(id);
        return plan.orElse(null);
    }

    @Override
    public List<Plan> getAll() {
        return planRepo.findAll();
    }
}
