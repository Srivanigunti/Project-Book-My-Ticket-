package com.capgemini.bookmymovie.ewallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bookmymovie.ewallet.pojo.Ewallet;

@Repository
public interface EwalletRepository extends JpaRepository<Ewallet, Integer> {

}
