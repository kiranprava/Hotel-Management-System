
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AddDriver extends JFrame implements ActionListener{
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox availablecombo,gencombo,bedcombo,availcombo;
    JButton adddriver,cancel;
    AddDriver(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("ADD DRIVERS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        JLabel lblname =new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblname.setBounds(60,70,180,30);
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
        
        JLabel lblage =new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblage.setBounds(60,110,180,30);
        add(lblage);
        
        tfage=new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
        JLabel lblgender =new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblgender.setBounds(60,150,180,30);
        add(lblgender);
        
        String genderOptions[]={"Male","Female"};
        gencombo=new JComboBox(genderOptions); 
        gencombo.setBounds(200,150,150,30);
        gencombo.setBackground(Color.WHITE);
        add(gencombo);
        
        JLabel lblcompany =new JLabel("Car Company");
        lblcompany.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblcompany.setBounds(60,190,180,30);
        add(lblcompany);
        
        tfcompany=new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);
        
        JLabel lbltype =new JLabel("Car Model");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbltype.setBounds(60,230,180,30);
        add(lbltype);
        
        tfmodel=new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);
        
        JLabel lblavailable =new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblavailable.setBounds(60,270,180,30);
        add(lblavailable);
        
        String availableOptions[]={"Available","Busy"};
        availcombo=new JComboBox(availableOptions); 
        availcombo.setBounds(200,270,150,30);
        availcombo.setBackground(Color.WHITE);
        add(availcombo);
        
        JLabel lbllocation =new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbllocation.setBounds(60,310,180,30);
        add(lbllocation);
        
        tflocation=new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);
        
        
        adddriver=new JButton("Add Driver");
        adddriver.setBackground(Color.BLACK);
        adddriver.setForeground(Color.WHITE);
        adddriver.setBounds(60,370,130,30);
        adddriver.addActionListener(this);
        add(adddriver);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2= i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(400,30,500,300);
        add(label);
        
        setBounds(300,200,980,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==adddriver){
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String)gencombo.getSelectedItem();
            String company=tfcompany.getText();
            String model=tfmodel.getText();
            String available=(String)availcombo.getSelectedItem();
            String location=tflocation.getText();
           
            
            try{
                Conn c=new Conn();
                String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New driver added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
            
         public static void main(String args[]){
            new AddDriver();
    }
    
}
