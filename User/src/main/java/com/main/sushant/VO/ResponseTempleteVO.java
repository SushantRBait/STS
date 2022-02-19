package com.main.sushant.VO;

import com.main.sushant.model.User;

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