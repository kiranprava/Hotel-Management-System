
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;


public class Room extends JFrame implements ActionListener{
    JTable  table;
    JButton back;
    Room(){
        getContentPane().setBackground(Color.WHITE);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2= i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(500,0,600,600);
        add(label);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Availability");
        l2.setBounds(120,10,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);
        
         JLabel l4=new JLabel("Price");
        l4.setBounds(330,10,100,20);
        add(l4);
        
         JLabel l5=new JLabel("Bed Type");
        l5.setBounds(410,10,100,20);
        add(l5);
        
        table =new JTable ();
        table.setBounds(0,40,500,400);
        add(table);
        
        try{
            Conn c=new Conn();
            String query="select * from room";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
        back=new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setLayout(null);
        setBounds(300,200,1050,600);
        setVisible(true);
}
    
     public void actionPerformed(ActionEvent e){
         setVisible(false);
         new Reception();
     }
    public static void main (String args[]){
        new Room();
    }
}
