package in.ashokit.planmicroservice.controller;

import in.ashokit.planmicroservice.service.PlanCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/category")
public class PlanCategoryController {

    @Autowired
    PlanCategoryService planCategoryService;

    @GetMapping("/dropdown")
    ResponseEntity<Map<Long, String>> getCategoryDropDownMap() {
        return ResponseEntity.ok().body(planCategoryService.getCategoriesDropDown());
    }
}
