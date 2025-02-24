package com.data.draftbase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.data.draftbase.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{
	

	public List<Report> findByUserId(Long userId);
	public Optional<Report> findByReportId(Long id);
	public List<Report> findByPlayerId(Long playerId);
}
