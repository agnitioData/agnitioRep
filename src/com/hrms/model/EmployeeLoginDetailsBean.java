package com.hrms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hrms.action.LoginAction;
import com.opensymphony.xwork2.ActionSupport;

@Entity
@Table(name="UserData")
public class EmployeeLoginDetailsBean extends ActionSupport implements Serializable {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = -5697872173777111355L;
	
	@Id
    @GeneratedValue
    @Column(name="id")
	private String id;
	@Column(name="name")
    private String name;
	@Column(name="password")
    private String pwd;

 
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
     
    public String execute()
    {		
    	LoginAction l=new LoginAction();
    	String result = l.loginDetails(name, pwd);
    	return result;
    }
    
    @Override
    public void validate(){
        if("".equals(getName())){
            addFieldError("name", "UserName can't be empty");
        }
        if("".equals(getPwd())){
            addFieldError("pwd", "Password can't be empty");
        }
    }
}
