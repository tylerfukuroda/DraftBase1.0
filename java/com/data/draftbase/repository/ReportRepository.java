package com.data.draftbase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.data.draftbase.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{
	
	@Query("Select r From Report r Where r.userId = :userId")
	public List<Report> findByUserId(@Param("userId") Long userId);
	
	@Query("Select r From Report r Where r.id = :id")
	public Optional<Report> findByReportId(@Param("id") Long id);
	
	@Query("Select r From Report r Where r.playerId = :playerId")
	public List<Report> findByPlayerId(@Param("playerId")Long playerId);
}
