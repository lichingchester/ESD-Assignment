/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author lichi
 */
public class ItemsBean {
    String itemID;
    String itemName;
    String desc;
    String category;
    String designerName;
    double price;
    String path;
    String size;
    
    public void setItemID(String value){
        this.itemID = value;
    }
    public String getItemID(){
        return itemID;
    }
    
    public void setItemName(String value){
        this.itemName = value;
    }
    public String getItemName(){
        return itemName;
    }
    
    public void setDesc(String value){
        this.desc = value;
    }
    public String getDesc(){
        return desc;
    }
    
    public void setCategory(String value){
        this.category = value;
    }
    public String getCategory(){
        return category;
    }
    
    public void setDesignerName(String value){
        this.designerName = value;
    }
    public String getDesignerName(){
        return designerName;
    }
    
    public void setPrice(double value){
        this.price = value;
    }
    public double getPrice(){
        return price;
    }
    
    public void setPath(String value){
        this.path = value;
    }
    public String getPath(){
        return path;
    }
    
    public void setSize(String value){
        this.size = value;
    }
    public String getSize(){
        return size;
    }
}
