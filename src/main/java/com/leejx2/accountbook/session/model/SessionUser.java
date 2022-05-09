package com.leejx2.accountbook.session.model;

import java.sql.Timestamp;

import com.leejx2.accountbook.common.Constants;
import com.leejx2.accountbook.rest.model.User;

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
public class SessionUser extends User {
	public SessionUser (User user) {
		super(
			user.getUserId(),
			user.getLoginId(),
			user.getUserName(),
			user.getPasswd(),
			user.getTargetAmount(),
			user.getMonthLife(),
			user.getDayLife(),
			user.getStartDate(),
			user.getLivExpDepositId(),
			user.getLivExpDepositName()
		);
	}
	private String JSEESIONID;
	private Timestamp creationDate;
	private String sessionStatus = Constants.SESSION_STATUS_INVALID;
	private String loginResult = Constants.LOGIN_RESULT_FAIL;
	private String loginFailMessage = Constants.LOGIN_FAIL_ERROR;
}
