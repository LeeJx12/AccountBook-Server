package com.leejx2.accountbook.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leejx2.accountbook.rest.model.Deposit;
import com.leejx2.accountbook.rest.service.DepositService;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class DepositController {

	@Autowired
	private DepositService depositService;
	
	@GetMapping("/rest/deposit/{userId}")
	@ResponseBody
	public List<Deposit> getDeposits(@PathVariable("userId") String userId) {
		return depositService.getDeposits(userId);
	}
	
	@GetMapping("/rest/deposit/{userId}/{depositId}")
	@ResponseBody
	public Deposit getDeposit(@PathVariable("userId") String userId, @PathVariable("depositId") String depositId) {
		return depositService.getDeposit(userId, depositId);
	}
	
	@PostMapping("/rest/deposit")
	public void addDeposit(@RequestBody Deposit deposit) {
		depositService.addDeposit(deposit);
	}
	
	@PutMapping("/rest/deposit")
	public void editDeposit(@RequestBody Deposit deposit) {
		depositService.editDeposit(deposit);
	}
	
	@DeleteMapping("/rest/deposit")
	public void delDeposit(@ModelAttribute("params") Deposit deposit) {
		depositService.delDeposit(deposit);
	}
}
