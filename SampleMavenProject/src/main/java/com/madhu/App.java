package com.madhu;

import java.util.ResourceBundle;

public class App {
     
	public int userLogin(String in_user, String in_pwd)
	{
		ResourceBundle rb=ResourceBundle.getBundle("config");
		String UserName=rb.getString("username");
		String Password=rb.getString("password");
		
		if(in_user.equals(UserName) && in_pwd.equals(Password))
			return 1;
		else
			return 0;
	}
}
