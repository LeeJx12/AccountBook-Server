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
public class Deposit {
	private String depositId;
	private String userId;
	private String depositName;
	private String description;
	private int amount;
	private String depositTypeId;
	private String depositTypeName;
	private Timestamp startDate;
	private Timestamp endDate;
	private String company;
	private int expamount;
}
