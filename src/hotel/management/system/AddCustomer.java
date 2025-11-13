
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener{
    
   JComboBox comboid;
   JTextField tfnumber,tfname,tfcountry,tfdeposit;
   JRadioButton rbmale,rbfemale;
   Choice croom;
   JLabel checkintime;
   JButton add,back;
   
    AddCustomer(){
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(35,80,100,30);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);
        
        String options[]={"Aadhar Card","Password","Driving Liscense","Voter-id Card","Ration Card"};
        comboid=new JComboBox(options); 
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(35,120,100,30);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber);
        
        tfnumber=new JTextField();
        tfnumber.setBounds(200,120,150,30);
        add(tfnumber);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(35,160,100,30);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,160,150,30);
        add(tfname);
        
        JLabel lblgen=new JLabel("Gender");
        lblgen.setBounds(35,200,100,30);
        lblgen.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgen);
        
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,200,70,30);
        rbmale.setFont(new Font("Raleway",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(280,200,100,30);
        rbfemale.setFont(new Font("Raleway",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(35,240,100,30);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,30);
        add(tfcountry);
        
        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(35,280,150,30);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);
        
        croom=new Choice();
        
        try{
            Conn c=new Conn();
            String q="select * from room where availablity='Available'";
            ResultSet rs=c.s.executeQuery(q);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280, 150, 30);
        add(croom);
        
        JLabel lbltime=new JLabel("Checkin Time");
        lbltime.setBounds(35,320,150,30);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);
        
        Date date=new Date();
        
        checkintime=new JLabel(" "+ date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
        add(checkintime);
        
        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(35,360,100,30);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);
        
        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,360,150,30);
        add(tfdeposit);
        
        add=new JButton("Add");
        add.setBounds(50,420,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(200,420,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2= i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(400,50,300,400);
        add(label);
        
        setBounds(350,200,800,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==add){
        String id=(String)comboid.getSelectedItem();
        String number=tfnumber.getText();
        String name=tfname.getText();
        String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
        }else if(rbfemale.isSelected()){
            gender="Female";
        }
        String country=tfcountry.getText();
        String roomnumber=(String)croom.getSelectedItem();
        String time=checkintime.getText();
        String deposit=tfdeposit.getText();
        
        try{
            Conn c=new Conn();
            String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+roomnumber+"','"+time+"','"+deposit+"')";
            String query1="update room set availablity ='Occupied' where roomnumber='"+roomnumber+"'";
            c.s.executeUpdate(query);
            c.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
            setVisible(false);
            new Reception();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        }else if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
      public static void main(String args[]){
        new AddCustomer();
    }
}
