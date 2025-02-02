package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    
    Splash(){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel heading =new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
       heading.setBounds(80,30,1200,60);
       heading.setFont(new Font("serit",Font.PLAIN,60));
       heading.setForeground(Color.black);
       add(heading);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/what-are-employee-management-systems.jpg"));
       Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3); //Can't add image directly on screen,convert it into ImageIcon 
       image.setBounds(50,100,1050,500);
       add(image);
       
       JButton clickhere=new JButton("Click Here to Continue");
       clickhere.setBounds(400,400,300,70);
       clickhere.setBackground(Color.DARK_GRAY);
       clickhere.setForeground(Color.WHITE);
       clickhere.addActionListener(this);
       image.add(clickhere);
       
       setSize(1170,650);
       setLocation(200,50);
       setVisible(true);
       
//       while(true){
//           heading.setVisible(false);
//           try{
//               Thread.sleep(500);S
//           }catch(Exception e){
//           
//           }
//           S
//           heading.setVisible(true);
//           try{
//               Thread.sleep(500);
//           }catch(Exception'e){
//           
//           }
    }       
    
    public void actionPerformed(ActionEvent on){
       setVisible(false);
       new Login(); 
    }
    public static void main(String args[]){
        new Splash();
    }    
}