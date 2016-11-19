/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ken42
 */
public class UserBean {
    private String id,pw,tel,email,address;
    
        public String getId() {  
            return id;  
        }  

        public void setId(String id) {  
            this.id = id; 
        }  

        public String getPw() {  
            return pw;  
        }  

        public void setPw(String pw) {  
            this.pw = pw;  
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
