package com.bulbul.examportal.repository.acl;


import com.bulbul.examportal.entity.acl.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentName(String departmentName);

    /**
     * For case insensitive by department name we user IgnoreCase
     * Its Spring JPA Magic
     */
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
