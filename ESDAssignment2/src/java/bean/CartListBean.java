/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Wang
 */
public class CartListBean {
   // String listId;
    String name;
    String price;
    //String quantity;
    //String desc;
    String size;
    
   // public void setListId(String listId){
    //    this.listId = listId;
   // }
    
   // public String getListId(){
   //     return listId;
  //  }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setPrice(String price){
        this.price = price;
    }
    
    public String getPrice(){
        return price;
    }
    
   // public void setQuantity(String quantity){
    //    this.quantity = quantity;
   // }
    
   // public String getQuantity(){
  //      return quantity;
 //   }
    
  //  public void setDesc(String desc){
 //       this.desc = desc;
 //   }
    
 //   public String getDesc(){
 //       return desc;
//    }
    
    public void setSize(String size){
        this.size = size;
    }
    
    public String getSize(){
        return size;
    }
}
