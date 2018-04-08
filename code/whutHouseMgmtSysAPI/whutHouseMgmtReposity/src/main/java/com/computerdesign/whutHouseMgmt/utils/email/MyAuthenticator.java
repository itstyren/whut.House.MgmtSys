package com.computerdesign.whutHouseMgmt.utils.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author wanhaoran
 * @date 2018年4月8日 上午9:47:10
 * 
 */
public class MyAuthenticator extends Authenticator{

	String userName=null;  
    String password=null;  
       
    public MyAuthenticator(){  
    }  
    public MyAuthenticator(String username, String password) {   
        this.userName = username;   
        this.password = password;   
    }   
    protected PasswordAuthentication getPasswordAuthentication(){  
        return new PasswordAuthentication(userName, password);  
    }  
}
