package com.likelion.likelionassignmentcrud.Student.domain.repository;

import com.likelion.likelionassignmentcrud.Student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
