package com.leejx2.accountbook.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leejx2.accountbook.rest.model.DepositHistory;
import com.leejx2.accountbook.rest.model.User;
import com.leejx2.accountbook.rest.service.DepositHistoryService;

@RestController
public class DepositHistoryController {

	@Autowired
	private DepositHistoryService depositHistoryService;
	
	@GetMapping("/rest/hist/{depositId}")
	@ResponseBody
	public List<DepositHistory> getDepositHistory(@PathVariable("depositId") String depositId) {
		return depositHistoryService.getDepositHistory(depositId);
	}
	
	@GetMapping("/rest/hist/{depositId}/{historyId}")
	@ResponseBody
	public DepositHistory getDepositHistory(@PathVariable("depositId") String depositId, @PathVariable("historyId") String historyId) {
		return depositHistoryService.getDepositHistory(depositId, historyId);
	}
	
	@PostMapping("/rest/hist")
	public void addDepositHistory(@RequestBody DepositHistory depositHistory) {
		depositHistoryService.addDepositHistory(depositHistory);
	}
	
	@PutMapping("/rest/hist")
	public void editDepositHistory(@RequestBody DepositHistory depositHistory) {
		depositHistoryService.editDepositHistory(depositHistory);
	}
	
	@DeleteMapping("/rest/hist")
	public void delDepositHistory(@ModelAttribute("params") DepositHistory depositHistory) {
		depositHistoryService.delDepositHistory(depositHistory);
	}
}
