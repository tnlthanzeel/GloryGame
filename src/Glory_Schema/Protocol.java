/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Glory_Schema;

/**
 *
 * @author Arthath
 */
public class Protocol {
    
    
    
    /**
     * Creates a new instance of Protocol
     */
    private String message="";
    public Protocol() 
    {
        
    }
    
    public String RegisterPacket(int x,int y)
    {
        message="Hello"+x+","+y;
        return message;
    }
    public String UpdatePacket(int x,int y,int id,int dir)
    {
        message="Update"+x+","+y+"-"+dir+"|"+id;
        return message;
    }
    public String ShotPacket(int id)
    {
        message="Shot"+id;
        return message;
    }
    
    public String RemoveClientPacket(int id)
    {
        message="Remove"+id;
        return message;
    }
    public String ExitMessagePacket(int id)
    {
        message="Exit"+id;
        return message;
    }
    
}
