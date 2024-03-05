package com.studentdata.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import com.studentdata.entity.StudentDetails;

public interface StudentRepositary extends JpaRepository<StudentDetails, Long>{

}
