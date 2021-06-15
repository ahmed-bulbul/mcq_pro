package com.bulbul.examportal.schedular;


import com.bulbul.examportal.repository.acl.AttendanceRepository;
import com.bulbul.examportal.repository.acl.UserRepository;
import com.bulbul.examportal.entity.acl.Attendance;
import com.bulbul.examportal.entity.acl.User;
import com.bulbul.examportal.service.acl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



@Component
@Transactional
public class AttendanceScheduler {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    /**
     * Link ::
     * Scheduled specific time :: https://stackoverflow.com/questions/26147044/spring-cron-expression-for-every-day-101am
     * https://docs.oracle.com/cd/E12058_01/doc/doc.1014/e12030/cron_expressions.htm
     * 0 15 10 ? * MON-FRI  	Fire at 10:15 AM every Monday, Tuesday, Wednesday, Thursday and Friday
     *
     * */

    private final Logger LOGGER =
            LoggerFactory.getLogger(AttendanceScheduler.class);



    @Scheduled(cron = "0 35 15 ? * MON", zone="Asia/Dhaka") // every monday 3:15PM will be called
    public void insertHolidaysAttendance() throws Exception {

        Calendar c1 = Calendar.getInstance();
        LocalDate localDate = LocalDate.now();
        Long todayAttends = this.attendanceRepository.getHolidaysInsertedData(localDate);

        if ((c1.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)  || (c1.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)) {

            if(todayAttends>0){
                LOGGER.info("Attendance Data Already inserted");
            }else {
                List<User> userList = userService.fetchUserList();

                List<Attendance> attendanceList = new ArrayList<>();

                for (User user: userList){
                    Attendance attendance = new Attendance();

                    attendance.setStatus("WEEKEND");
                    attendance.setUser(user);
                    attendanceList.add(attendance);
                }
                attendanceRepository.saveAll(attendanceList);
            }
        } else {
            System.out.println("Today is working Day");
        }

    }
}
