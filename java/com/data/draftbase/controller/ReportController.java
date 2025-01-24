package com.data.draftbase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.draftbase.entity.Report;
import com.data.draftbase.service.ReportService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/report_api")
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("/players/reports/all_reports")
	public ResponseEntity<List<Report>> getAllReports(){
		List<Report> allReports = reportService.getAllReports();
		System.out.println("All reports requested.");
		return ResponseEntity.ok(allReports);
	}
	
	@GetMapping("/players/reports/report_id/{id}")
	public ResponseEntity<Optional<Report>> findReportByReportId(Long reportId){
		Optional<Report> reportsById = reportService.findByReportId(reportId);
		return ResponseEntity.ok(reportsById);
	}
	
	@GetMapping("/players/reports/user_id/{id}")
	public ResponseEntity<List<Report>> findReportByUserId(Long userId){
		List<Report> reportsByUserId = reportService.findByUserId(userId);
		return ResponseEntity.ok(reportsByUserId);
	}
	
	@GetMapping("/players/reports/player_id/{id}")
	public ResponseEntity<List<Report>> findReportByPlayerId(Long playerId){
		List<Report> reportsByPlayerId = reportService.findByPlayerId(playerId);
		return ResponseEntity.ok(reportsByPlayerId);
	}
	
	@DeleteMapping("/players/reports/delete")
	public ResponseEntity<Void> deleteReport(Report report){
		reportService.deleteReport(report);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping()
	public ResponseEntity<Report> updateReport(@RequestBody Long id, String summary, Double grade){
		try {
			Report updateReport = reportService.updateReport(id, summary, grade);
			return ResponseEntity.ok(updateReport);
		} catch(EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping()
	public ResponseEntity<Report> createReport(Long playerId, Long userId, String summary, Double grade){
		Report newReport = reportService.createReport(playerId, userId, summary, grade);
		return ResponseEntity.ok(newReport);
	}
}
