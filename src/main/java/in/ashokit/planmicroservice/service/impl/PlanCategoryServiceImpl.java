package in.ashokit.planmicroservice.service.impl;

import in.ashokit.planmicroservice.entity.PlanCategory;
import in.ashokit.planmicroservice.repository.PlanCategoryRepo;
import in.ashokit.planmicroservice.service.PlanCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlanCategoryServiceImpl implements PlanCategoryService {

    @Autowired
    PlanCategoryRepo planCategoryRepo;

    @Override
    public Map<Long, String> getCategoriesDropDown() {
        List<PlanCategory> all = planCategoryRepo.findAll();
        Map<Long, String> dropDown = new HashMap<>();

        all.forEach((planCategory)-> dropDown.put(planCategory.getId(), planCategory.getName()));

        return dropDown;
    }
}
