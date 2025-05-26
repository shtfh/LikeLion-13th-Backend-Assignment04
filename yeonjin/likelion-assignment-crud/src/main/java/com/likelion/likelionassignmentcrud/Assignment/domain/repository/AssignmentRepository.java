package com.likelion.likelionassignmentcrud.Assignment.domain.repository;
//디빌ㅇ 연결하는 데

import com.likelion.likelionassignmentcrud.Assignment.domain.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}

