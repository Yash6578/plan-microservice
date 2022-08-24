package in.ashokit.planmicroservice.controller;

import in.ashokit.planmicroservice.Constant.PlanConstants;
import in.ashokit.planmicroservice.entity.Plan;
import in.ashokit.planmicroservice.properties.PlanProperties;
import in.ashokit.planmicroservice.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plan")
public class PlanController {

    PlanService planService;
    Map<String, String> planPropertiesMap;
    PlanController(PlanService planService, PlanProperties planProperties) {
        this.planService = planService;
        this.planPropertiesMap = planProperties.getConstants();
    }

    @PostMapping("/save")
    ResponseEntity<String> save(@RequestBody Plan plan) {
        String message;
        HttpStatus httpStatus;

        if(planService.save(plan)) {
            message = planPropertiesMap.get(PlanConstants.DATA_SAVED_SUCCESS);
            httpStatus = HttpStatus.CREATED;
        }
        else {
            message = planPropertiesMap.get(PlanConstants.DATA_SAVED_FAILURE);
            httpStatus = HttpStatus.ACCEPTED;
        }
        return ResponseEntity.status(httpStatus).body(message);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<Plan> getById(@PathVariable Long id) {
        Plan byId = planService.findById(id);
        HttpStatus httpStatus = HttpStatus.OK;

        if(null == byId) {
            httpStatus = HttpStatus.NO_CONTENT;
        }
        return ResponseEntity.status(httpStatus).body(byId);
    }

    @PutMapping("/update")
    ResponseEntity<String> update(@RequestBody Plan plan) {
        String message;
        HttpStatus httpStatus;

        if(planService.update(plan)) {
            message = planPropertiesMap.get(PlanConstants.DATA_UPDATED_SUCCESS);
            httpStatus = HttpStatus.OK;
        }
        else {
            message = planPropertiesMap.get(PlanConstants.DATA_UPDATED_FAILURE);
            httpStatus = HttpStatus.NO_CONTENT;
        }
        return ResponseEntity.status(httpStatus).body(message);
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        String message;
        HttpStatus httpStatus;

        if(planService.delete(id)) {
            message = planPropertiesMap.get(PlanConstants.DATA_DELETED_SUCCESS);
            httpStatus = HttpStatus.OK;
        }
        else {
            message = planPropertiesMap.get(PlanConstants.DATA_DELETED_FAILURE);
            httpStatus = HttpStatus.NO_CONTENT;
        }

        return ResponseEntity.status(httpStatus).body(message);
    }

    @GetMapping("/all")
    ResponseEntity<List<Plan>> getAll() {
        return ResponseEntity.ok().body(planService.getAll());
    }

    @GetMapping("/change-status/{id}/{status}")
    ResponseEntity<String> changeStatus(@PathVariable Long id, @PathVariable String status) {
        String message;
        HttpStatus httpStatus;

        if(planService.changeStatus(id, status)) {
            message = planPropertiesMap.get(PlanConstants.STATUS_CHANGED_SUCCESS);
            httpStatus = HttpStatus.OK;
        }
        else {
            message = planPropertiesMap.get(PlanConstants.STATUS_CHANGED_FAILURE);
            httpStatus = HttpStatus.ACCEPTED;
        }
        return ResponseEntity.status(httpStatus).body(message);
    }
}
