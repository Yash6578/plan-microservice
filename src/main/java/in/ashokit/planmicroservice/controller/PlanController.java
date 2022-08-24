package in.ashokit.planmicroservice.controller;

import in.ashokit.planmicroservice.Constant.Constant;
import in.ashokit.planmicroservice.entity.Plan;
import in.ashokit.planmicroservice.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    PlanService planService;

    @PostMapping("/save")
    ResponseEntity<String> save(@RequestBody Plan plan) {
        String message;
        HttpStatus httpStatus;

        if(planService.save(plan)) {
            message = Constant.DATA_SAVED;
            httpStatus = HttpStatus.CREATED;
        }
        else {
            message = Constant.DATA_NOT_SAVED;
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
            message = Constant.DATA_UPDATED;
            httpStatus = HttpStatus.OK;
        }
        else {
            message = Constant.DATA_NOT_UPDATED;
            httpStatus = HttpStatus.NO_CONTENT;
        }
        return ResponseEntity.status(httpStatus).body(message);
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        String message;
        HttpStatus httpStatus;

        if(planService.delete(id)) {
            message = Constant.DATA_DELETED;
            httpStatus = HttpStatus.OK;
        }
        else {
            message = Constant.DATA_NOT_DELETED;
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
            message = Constant.STATUS_CHANGED;
            httpStatus = HttpStatus.OK;
        }
        else {
            message = Constant.STATUS_NOT_CHANGED;
            httpStatus = HttpStatus.ACCEPTED;
        }
        return ResponseEntity.status(httpStatus).body(message);
    }
}
