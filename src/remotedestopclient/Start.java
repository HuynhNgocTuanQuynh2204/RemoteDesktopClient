/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package remotedestopclient;

import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author TUẤN QUỲNH CODER
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    static String port="4907";
    public static void main(String[] args) {
        
       String ip=JOptionPane.showInputDialog("please enter server ip");
       new Start().initialize(ip,Integer.parseInt(port));
       
    }
    public void initialize(String ip,int port)
    {
        try {
            Socket sc = new Socket(ip,port);
            System.out.println("Connecting to the server");
            Authentication frame1 = new Authentication(sc);
            frame1.setSize(300,80);
            frame1.setLocation(500,300);
            frame1.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
