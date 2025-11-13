
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Dashboard extends JFrame implements ActionListener{
     Dashboard(){
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2= i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,1550,1000);
        add(label);
        
        JLabel text=new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("Tahoma", Font.PLAIN, 40));
        label.add(text);
        
        JMenuBar nb = new JMenuBar();
        nb.setBounds(0,0,1550,30);
        label.add(nb);
        
        JMenu hotel= new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        nb.add(hotel);
        
        JMenuItem reception= new JMenu("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin= new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        nb.add(admin);
        
       JMenuItem addemployee= new JMenu("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms= new JMenu("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers= new JMenu("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
         
        setLayout(null);
        setBounds(0,0,1550,1000);
        setVisible(true);
     }
     

     public void actionPerformed(ActionEvent ae){
         if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
         }else if(ae.getActionCommand().equals("ADD ROOMS")){
             new AddRooms();
         }else if(ae.getActionCommand().equals("ADD DRIVERS")){
             new AddDriver();
         }else if(ae.getActionCommand().equals("RECEPTION")){
             new Reception();
         }
     }
     
    public static void main(String [] args){
        new Dashboard();
    }
}
