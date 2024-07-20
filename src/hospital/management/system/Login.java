package hospital.management.system;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JTextField user;
    JPasswordField pass;
    JButton b1,b2;

    Login()
    {
        JLabel nl=new JLabel("Username:");
        nl.setBounds(40,20,100,30);
        nl.setFont(new Font("Sans-serif", Font.BOLD,16));
        nl.setForeground(Color.BLACK);
        add(nl);
        JLabel password=new JLabel("Password:");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Sans-serif",Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add(password);

        user=new JTextField();
        user.setBounds(150,20,150,30);
        user.setFont(new Font("Sans-serif",Font.PLAIN,15));
        add(user);

        pass=new JPasswordField();
        pass.setBounds(150,70,150,30);
        pass.setFont(new Font("SANS-SERIF",Font.PLAIN,15));
        add(pass);

        ImageIcon hoslogo=new ImageIcon(ClassLoader.getSystemResource("icon/hospitallogo.png"));
        Image i1=hoslogo.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel label=new JLabel(i2);
        label.setBounds(320,-30,400,300);
        add(label);

        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.PLAIN,15));
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.PLAIN,15));
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(220,220,220));
        setSize(750,300);
        setLocation(400,270);

        setLayout(null);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            try
            {
                Conn c=new Conn();
                String use=user.getText();
                String pwd=pass.getText();
                String q="select * from login where id='"+use+"' and pwd='"+pwd+"' ";
                ResultSet rs=c.stmt.executeQuery(q);

                if(rs.next())
                {
                    new Reception();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }
            }
            catch(Exception E)
            {
                E.printStackTrace();
            }
        }
        else
        {
            System.exit(10);
        }

    }
    public static void main(String[] args)
    {
        new Login();

    }


}
