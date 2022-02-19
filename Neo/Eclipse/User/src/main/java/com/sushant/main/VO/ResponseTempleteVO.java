package com.sushant.main.VO;

import com.sushant.main.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTempleteVO {

	private User user;
	private Department department;
	
	
}
