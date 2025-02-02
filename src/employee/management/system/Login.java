package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername,tfpassword;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
        
        tfusername=new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(150,70,150,30);
        add(tfpassword);
        
        JButton login=new JButton("Login");
        login.setBounds(150,140,150,30);
        login.addActionListener(this);
        login.setBackground(Color.DARK_GRAY);
        login.setForeground(Color.WHITE);
        add(login);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/302-3026464_png-file-svg-login-member-icon-png.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3); //Can't add image directly on screen,convert it into ImageIcon 
        image.setBounds(350,10,200,200);
        add(image);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent on){
       try{
           String username = tfusername.getText();
           String password = tfpassword.getText();
           
           Conn c = new Conn();
           String query = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'";
           
           //Execute the  mySql query and store it into rs
           
           ResultSet rs = c.s.executeQuery(query);
           if(rs.next()){
               setVisible(false);
               new Home().setVisible(true);
           }else{
               JOptionPane.showMessageDialog(null, "Invelid username and password");
               setVisible(false);
           }
       }catch(Exception e){ 
           e.printStackTrace();
       }
    }
    public static void main(String args[]){
        new Login();
    }
}   
