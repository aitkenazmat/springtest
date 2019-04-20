package kz.hh.controller;


import kz.hh.document.Department;
import kz.hh.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/department")
public class DepartmentController {

    private DepartmentRepository departmentRepository;
    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/list")
    public List<Department> getList(){
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") String id){
        Department department = null;
        Optional<Department> departmentOptional = departmentRepository.findById(id);

        if (departmentOptional.isPresent()) {
            department = departmentOptional.get();
        }

        return department;
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }


    @PutMapping("/{id}")
    public void updateDepartment(@PathVariable("id") String id,@RequestBody Department newDepartment){
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (departmentOptional.isPresent()) {
            Department currentDepartment = departmentOptional.get();
            currentDepartment.setName(newDepartment.getName());
            departmentRepository.save(currentDepartment);
        }
    }
}
