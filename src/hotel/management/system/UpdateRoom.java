
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener{
    Choice ccustomer;
    JTextField tfroom,tfavailable,tfstatus;
    JButton check,back,update;
            
    UpdateRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(30,20,200,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lblid=new JLabel("Customer Id");
        lblid.setBounds(30,80,100,20);
        add(lblid);
        
        ccustomer=new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
        try{
            Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from customer");
           while (rs.next()){
               ccustomer.add(rs.getString("number"));
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(30,130,100,20);
        add(lblroom);
        
        tfroom=new JTextField();
        tfroom.setBounds(200, 130, 150, 25);
        add(tfroom);
        
        JLabel lblname=new JLabel("Availability");
        lblname.setBounds(30,180,100,20);
        add(lblname);
        
        tfavailable=new JTextField();
        tfavailable.setBounds(200, 180, 150, 25);
        add(tfavailable);
        
        JLabel lblcheckin=new JLabel("Cleaning Status");
        lblcheckin.setBounds(30,230,100,20);
        add(lblcheckin);
        
        tfstatus=new JTextField();
        tfstatus.setBounds(200, 230, 150, 25);
        add(tfstatus);
        
        
        check=new JButton("Check");
        check.setBounds(30,300,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);
        
        update=new JButton("Update");
        update.setBounds(150,300,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBounds(270,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
       Image i2= i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(400,50,500,300);
        add(label);
       
        setBounds(300,200,980,450);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent e){
         if(e.getSource()==check){
             String id=ccustomer.getSelectedItem();
             String query="select * from customer where number='"+id+"'";
             try{
                 Conn c=new Conn();
                 ResultSet rs=c.s.executeQuery(query);  
                 while(rs.next()){
                     tfroom.setText(rs.getString("room_number"));
                 }
                 ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                 while(rs2.next()){
                     tfavailable.setText(rs2.getString("availablity"));
                     tfstatus.setText(rs2.getString("cleaning_status"));
                 }
             }catch(Exception ex){
                 ex.printStackTrace();
             }
         }else if(e.getSource()==update){
             String number=ccustomer.getSelectedItem();
             String room=tfroom.getText();
             String availablity=tfavailable.getText();
             String status=tfstatus.getText();
             try{
                 Conn c=new Conn();
                 c.s.executeUpdate("update room set roomnumber='"+room+"',availablity='"+availablity+"',cleaning_status='"+status+"' where roomnumber='"+room+"'");
                 
                 JOptionPane.showMessageDialog(null, "Data updated successfully");
                 
                 setVisible(false);
                 new Reception();
                 
             }catch(Exception ex){
                 ex.printStackTrace();
             }
         }else {
             setVisible(false);
             new Reception();
         }
     }
    public static void main(String args[]){
        new UpdateRoom();
    }
}
