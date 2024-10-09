/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package remotedestopclient;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author TUẤN QUỲNH CODER
 */
class Authentication extends JFrame implements ActionListener{
    private Socket cSocket=null;
    DataOutputStream passchk=null;
    DataInputStream verification=null;
    String verify="";
    JButton submit;
    JPanel panel;
    JLabel labe1,labe11;
    String width="",height="";
    JTextField text1;
    
    Authentication(Socket cSocket)
    {
        labe11= new JLabel();
        labe11.setText("Password");
        text1=new JTextField(15);
        this.cSocket=cSocket;
        labe1=new JLabel();
        labe1.setText("");
        this.setLayout(new BorderLayout());
        submit = new JButton("submit");
        panel = new JPanel(new GridLayout(2,1));
        panel.add(labe11);
        panel.add(text1);
        panel.add(labe1);
        panel.add(submit);
        add(panel,BorderLayout.CENTER);
        submit.addActionListener(this);
        setTitle("Login form");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       String value1=text1.getText();
        try {
            passchk= new DataOutputStream(cSocket.getOutputStream());
            verification = new DataInputStream(cSocket.getInputStream());
            passchk.writeUTF(value1);
            verify=verification.readUTF();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(verify.equals("valid"))
        {
            try {
                width=verification.readUTF();
                height=verification.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            CreateFrame abc = new CreateFrame(cSocket,width,height);
            dispose();
        }else
        {
            System.out.println("please enter valid password");
            JOptionPane.showMessageDialog(this,"password is incorre","Error",JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
  

}
