package com.bulbul.examportal.controller.acl;


import com.bulbul.examportal.entity.acl.Department;
import com.bulbul.examportal.error.DepartmentNotFoundException;
import com.bulbul.examportal.service.acl.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * This is logger
     * getting all logger information via this
     * */
    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    /**
     * save Department data as passing data via request body by json format
     * it's post-mapping
    * */
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    /**
     * Get all department data
     * using GetMapping annotation
    * */
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    /**
     * Get Department Data By Department Id
     * **/
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    /**
     * Deleting department by department id
     * only passing department id
     * */
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department delete successfully";
    }

    /**
     * This endpoint for updating department
     * and passing after slash department id
     * */
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);

    }

    /**
     * Get Department by department name
     * This endpoint fetch department by department name and also IgnoreCase
     * */
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
