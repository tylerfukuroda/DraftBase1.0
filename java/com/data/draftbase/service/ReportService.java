package com.data.draftbase.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.draftbase.entity.Report;
import com.data.draftbase.repository.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	ReportRepository reportRepository;
	
	public Report createReport(Long playerId, Long userId, String summary, Double grade) {
		LocalDateTime dateCreated = LocalDateTime.now();
		Report newReport = new Report(playerId, userId, summary, grade, dateCreated);
		return reportRepository.save(newReport);
	}
	
	public void deleteReport(Report report) {
		reportRepository.delete(report);
	}
	
	public List<Report> findByUserId(Long userId){
		return reportRepository.findByUserId(userId);
	}
	
	public List<Report> findByPlayerId(Long playerId){
		return reportRepository.findByPlayerId(playerId);
	}
	
	public Optional<Report> findByReportId(Long reportId){
		return reportRepository.findByReportId(reportId);
	}
	
	public Report updateReport(Long id, String summary, Double grade){
		
		Report report = reportRepository.findByReportId(id)
				.orElseThrow(() -> new IllegalArgumentException("Report not found"));
		report.setSummary(summary);
		report.setGrade(grade);
		
		return reportRepository.save(report);
	}
	
	public List<Report> getAllReports(){
		return reportRepository.findAll();
	}
	
	
}
