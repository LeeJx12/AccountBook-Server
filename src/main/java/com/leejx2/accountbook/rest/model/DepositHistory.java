package com.leejx2.accountbook.rest.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepositHistory {
	private String hitoryId;
	private String depositId;
	private String variant;
	private int amount;
	private String description;
	private String refDepositId;
	private Timestamp depDate;
}
