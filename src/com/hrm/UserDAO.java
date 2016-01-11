package com.hrm;

import com.hrms.model.EmployeeLoginDetailsBean;

public interface UserDAO {
	 
    EmployeeLoginDetailsBean getUserByCredentials(String name, String password);
}
