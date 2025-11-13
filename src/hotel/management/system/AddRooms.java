
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AddRooms extends JFrame implements ActionListener{
    JTextField tfroomno,tfprice;
    JComboBox availablecombo,cleancombo,bedcombo;
    JButton addroom,cancel;
    AddRooms(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lblroomno =new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblroomno.setBounds(60,80,180,30);
        add(lblroomno);
        
        tfroomno=new JTextField();
        tfroomno.setBounds(200,80,150,30);
        add(tfroomno);
        
        JLabel lblavailable =new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblavailable.setBounds(60,130,180,30);
        add(lblavailable);
        
        String availableoptions[]={"Available","Occupied"};
        availablecombo=new JComboBox(availableoptions); 
        availablecombo.setBounds(200,130,180,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lblclean =new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblclean.setBounds(60,180,180,30);
        add(lblclean);
        
        String cleanOptions[]={"Cleaned","Dirty"};
        cleancombo=new JComboBox(cleanOptions); 
        cleancombo.setBounds(200,180,180,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
        JLabel lblprice =new JLabel("Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblprice.setBounds(60,230,180,30);
        add(lblprice);
        
        tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        JLabel lbltype =new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbltype.setBounds(60,280,180,30);
        add(lbltype);
        
        String bedOptions[]={"Single Bed","Double Bed"};
        bedcombo=new JComboBox(bedOptions); 
        bedcombo.setBounds(200,280,180,30);
        bedcombo.setBackground(Color.WHITE);
        add(bedcombo);
        
        addroom=new JButton("Add Room");
        addroom.setBackground(Color.BLACK);
        addroom.setForeground(Color.WHITE);
        addroom.setBounds(60,350,130,30);
        addroom.addActionListener(this);
        add(addroom);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel label=new JLabel(i1);
        label.setBounds(400,30,500,300);
        add(label);
        
        setBounds(330,200,940,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addroom){
            String roomno=tfroomno.getText();
            String available=(String)availablecombo.getSelectedItem();
            String clean=(String)cleancombo.getSelectedItem();
            String price=tfprice.getText();
            String bedtype=(String)bedcombo.getSelectedItem();
            
            
            try{
                Conn c=new Conn();
                String query="insert into room values('"+roomno+"','"+available+"','"+clean+"','"+price+"','"+bedtype+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New room added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
            
         public static void main(String args[]){
            new AddRooms();
    }
    
}
