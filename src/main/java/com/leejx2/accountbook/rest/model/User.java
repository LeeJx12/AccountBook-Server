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
public class User {
	private String userId;
	private String loginId;
	private String userName;
	private String passwd;
	private int targetAmount = 0;
	private int monthLife = 0;
	private int dayLife = 0;
	private Timestamp startDate;
	private String livExpDepositId;
	private String livExpDepositName;
}
