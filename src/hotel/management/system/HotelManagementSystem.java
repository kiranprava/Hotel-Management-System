
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
    
    JButton next;

      HotelManagementSystem(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel label=new JLabel(i1);
        label.setBounds(0,0,1366,565);
        add(label);

        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("serif", Font.PLAIN, 40));
        label.add(text);

        next =new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.setFont(new Font ("serif", Font.PLAIN, 24));
        next.addActionListener(this);
        label.add(next);

        setSize(1366,565);
        setLayout(null);
        setVisible(true);
        setLocation(100,100);


        while(true){
            text.setVisible(false);
            try{
            Thread.sleep(500);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
            text.setVisible(true);
            try{
            Thread.sleep(500);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
            text.setVisible(true);
        }


      }
      
        public void actionPerformed(ActionEvent e){
         
             setVisible(false);
             new Login();
         
     }
    public static void main(String[] args) {
       new HotelManagementSystem();
    }

}
