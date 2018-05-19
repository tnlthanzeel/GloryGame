/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Glory_Schema;

import java.net.*;
/**
 *
 * @author Ak
 */
public class GloryClient extends GloryElement {
   
    public static void main(String args[]){
        try{
        Socket clientSocket = new Socket("127.0.0.7",7777);
        }
        catch (Exception e){}
    }
    
}
