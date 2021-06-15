package com.bulbul.examportal.repository.acl;

import com.bulbul.examportal.entity.acl.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface AttendanceRepository  extends JpaRepository<Attendance,Long> {

    @Query(value ="SELECT COUNT(ID) AS DATA FROM ATTENDANCE WHERE CREATED_AT=:localDate",nativeQuery=true)
    public Long  getHolidaysInsertedData(LocalDate localDate);
}
