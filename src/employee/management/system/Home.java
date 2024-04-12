package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    JButton view,add,update,remove;
    Home(){
       
       setLayout(null);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home_page.jpg"));
       Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3); //Can't add image directly on screen,convert it into ImageIcon 
       image.setBounds(0,0,1120,630);
       add(image);
       
       JLabel heading = new JLabel("Employee management System");
       heading.setBounds(630,20,400,40);
       heading.setFont(new Font("Raleway",Font.BOLD,25));
       image.add(heading);
       
       add = new JButton("Add Employees");
       add.setBounds(650,80,150,40); 
       add.addActionListener(this);
       add.setBackground(Color.LIGHT_GRAY);
       add.setForeground(Color.BLACK);
       image.add(add);
        
       view = new JButton("View Employee");
       view.setBounds(820,80,150,40);
       view.addActionListener(this);
       view.setBackground(Color.LIGHT_GRAY);
       view.setForeground(Color.BLACK);
       image.add(view);
       
       update = new JButton("update Employee");
       update.setBounds(650,140,150,40);
       update.addActionListener(this);
       update.setBackground(Color.LIGHT_GRAY);
       update.setForeground(Color.BLACK);
       image.add(update);
       
       remove = new JButton("remove Employee");
       remove.setBounds(820,140,150,40);
       remove.addActionListener(this);
       remove.setBackground(Color.LIGHT_GRAY);
       remove.setForeground(Color.BLACK);
       image.add(remove);
       
       setSize(1120,630);
       setLocation(250,100);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==add){
           setVisible(false);
           new AddEmployee();
       }else if(ae.getSource()==view){
           setVisible(false);
           new ViewEmployee();
       }else if(ae.getSource()==update){
           setVisible(false);
           new ViewEmployee();
       }else{
           setVisible(false);
           new RemoveEmployee();
       } 
    }
    
    public static void main(String args[]){
       new Home();
    }
}
