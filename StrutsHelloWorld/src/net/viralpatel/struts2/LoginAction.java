package net.viralpatel.struts2;

import com.opensymphony.xwork2.ActionSupport;
 
public class LoginAction extends ActionSupport {
    private String username;
    private String password;
 
    public String execute() {
 //url : http://localhost:8080/StrutsHelloWorld/Login.jsp
    	System.out.println("usernam="+username);
        if (this.username.equals("admin") 
                && this.password.equals("admin123")) {
            return "success";
        } else {
            addActionError(getText("error.login"));
            return "error";
        }
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}