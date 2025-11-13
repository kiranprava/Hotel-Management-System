
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
    JButton checkout,back;
    
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel lblid=new JLabel("customer Id");
         lblid.setBounds(30,80,100,30);
         add(lblid);
         
        ccustomer=new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);
        
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2= i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(310,80,20,20);
        add(label);
        
        JLabel lblroom=new JLabel("Room Number");
         lblroom.setBounds(30,130,100,30);
         add(lblroom);
         
         lblroomnumber=new JLabel("");
         lblroomnumber.setBounds(150,130,100,30);
         add(lblroomnumber);
         
         
         JLabel lblcheckin=new JLabel("Checkin Time");
         lblcheckin.setBounds(30,180,100,30);
         add(lblcheckin);
         
         lblcheckintime=new JLabel("");
         lblcheckintime.setBounds(150,180,150,30);
         add(lblcheckintime);
         
         JLabel lblcheckout=new JLabel("Checkout Time");
         lblcheckout.setBounds(30,240,100,30);
         add(lblcheckout);
         
         Date date=new Date();
         lblcheckouttime=new JLabel(""+ date);
         lblcheckouttime.setBounds(150,240,150,30);
         add(lblcheckouttime);
         
          try{
            Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from customer");
           while (rs.next()){
               ccustomer.add(rs.getString("number"));
               lblroomnumber.setText(rs.getString("room_number"));
               lblcheckintime.setText(rs.getString("checkin_time"));
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
         
        checkout=new JButton("Checkout");
        checkout.setBounds(30,280,120,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        back=new JButton("Back");
        back.setBounds(170,280,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5= i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);
         
         
        setBounds(300,200,800,400);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==checkout){
            String query ="delete from customer where number ='"+ccustomer.getSelectedItem()+"'";
            String query1="update room set availablity='Available' where roomnumber='"+lblroomnumber.getText()+"'";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                
                JOptionPane.showMessageDialog(null, "Checkout Done");
                
                setVisible(false);
                 new Reception();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String args[]){
        new Checkout();
    }
}
