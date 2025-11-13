
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class Department extends JFrame implements ActionListener{
    JTable  table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel l1=new JLabel("Department");
        l1.setBounds(180,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Budget");
        l1.setBounds(420,10,100,20);
        add(l1);
        
        table =new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        
        try{
            Conn c=new Conn();
            String query="select * from department  ";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
        back=new JButton("Back");
        back.setBounds(280,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setLayout(null);
        setBounds(400,200,700,480);
        setVisible(true);
}
    
     public void actionPerformed(ActionEvent e){
         setVisible(false);
         new Reception();
     }
    public static void main (String args[]){
        new Department();
    }
}

