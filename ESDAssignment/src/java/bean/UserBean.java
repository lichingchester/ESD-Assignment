/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;

/**
 *
 * @author ken42
 */
public class UserBean implements Serializable{
    private String username,password,name,tel,email,address;
    
        public String getUsername() {  
            return username;  
        }  

        public void setUsername(String username) {  
            this.username = username; 
        }  

        public String getPassword() {  
            return password;  
        }  

        public void setName(String name) {  
            this.name = name; 
        }  

        public String getName() {  
            return name;  
        }  
        
        public void setPassword(String password) {  
            this.password = password;  
        }  
        
        public String getTel() {  
            return tel;  
        }  

        public void setTel(String tel) {  
            this.tel = tel;  
        }

        public String getEmail() {  
            return email;  
        }  

        public void setEmail(String email) {  
            this.email = email;  
        } 
        
        public String getAddress() {  
            return address;  
        }  

        public void setAddress(String address) {  
            this.address = address;  
        } 
}
