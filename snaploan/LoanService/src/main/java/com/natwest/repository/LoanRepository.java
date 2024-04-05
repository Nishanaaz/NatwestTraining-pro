package com.natwest.repository;

import com.natwest.entity.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanRequest, Long> {

    boolean existsByUserName(String userName);

    LoanRequest findByUserName(String userName);


}
