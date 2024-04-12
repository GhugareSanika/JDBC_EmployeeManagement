package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;    
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    
    Choice CEmpId;
    JButton delete,back;
    RemoveEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelEmpId = new JLabel("Employee Id");
        labelEmpId.setBounds(50, 50, 100, 30);
        add(labelEmpId);
         
        CEmpId = new Choice();
        CEmpId.setBounds(200, 50, 150, 30);
        add(CEmpId);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                CEmpId.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Phone");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empid = '"+CEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        CEmpId.addItemListener(new ItemListener (){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from employee where empid = '"+CEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);

                    while(rs.next()){
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(80, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/organization-flat-icon_1262-18775.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3); //Can't add image directly on screen,convert it into ImageIcon 
        image.setBounds(350,0,600,400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);  
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
        try{
            Conn c = new Conn();
            String query = "delete from employee where empId = '"+CEmpId.getSelectedItem()+"'";
            int rowsAffected = c.s.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete employee information");
            }
            setVisible(false);
            new Home();
        } catch(SQLException e){
            e.printStackTrace();
            }
        }

    }
    public static void main(String[] args){
        new RemoveEmployee();
    }
}
