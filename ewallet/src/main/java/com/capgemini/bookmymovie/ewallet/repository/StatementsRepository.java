package com.capgemini.bookmymovie.ewallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bookmymovie.ewallet.pojo.Statement;

@Repository
public interface StatementsRepository extends JpaRepository<Statement, Integer> {

}
