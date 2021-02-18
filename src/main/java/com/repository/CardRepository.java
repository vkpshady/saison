package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.CardHitDetail;



@Repository
public interface CardRepository extends JpaRepository<CardHitDetail, String> {
	
	@Query(value ="SELECT * from Card_Hit_Detail limit ?1 offset ?2" , nativeQuery = true)
	List<CardHitDetail> findStats(int limit,int start);
	
}
