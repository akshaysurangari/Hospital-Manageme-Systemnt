package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class Employee extends JFrame
{


    Employee()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setLayout(null);
        panel.setBackground((Color.GRAY));
        add(panel);



        JTable table=new JTable();
        table.setBounds(10,34,980,450);
        table.setForeground(Color.WHITE);
        table.setBackground(Color.GRAY);
        table.setFont(new Font("italic",Font.BOLD,14));
        panel.add(table);


        try
        {
            Conn c=new Conn();
            String q="select * from employee";
            ResultSet rs=c.stmt.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        JLabel label1=new JLabel("Name");
        label1.setBounds(41,9,70,20);
        label1.setFont(new Font("italic",Font.BOLD,16));
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        JLabel label2=new JLabel("Age");
        label2.setBounds(180,9,70,20);
        label2.setFont(new Font("italic",Font.BOLD,16));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        JLabel label3=new JLabel("Phone Number");
        label3.setBounds(350,9,150,20);
        label3.setFont(new Font("italic",Font.BOLD,16));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        JLabel label4=new JLabel("Salary");
        label4.setBounds(530,9,150,20);
        label4.setFont(new Font("italic",Font.BOLD,16));
        label4.setForeground(Color.BLACK);
        panel.add(label4);


        JLabel label5=new JLabel("Gmail");
        label5.setBounds(700,9,150,20);
        label5.setFont(new Font("italic",Font.BOLD,16));
        label5.setForeground(Color.BLACK);
        panel.add(label5);


        JLabel label6=new JLabel("Aadhar no");
        label6.setBounds(830,9,150,20);
        label6.setFont(new Font("italic",Font.BOLD,16));
        label6.setForeground(Color.BLACK);
        panel.add(label6);


        JButton back=new JButton("BACK");
        back.setBounds(350,500,120,30);
        back.setFont(new Font("italic",Font.BOLD,16));
        panel.add(back);
        back.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               setVisible(false);
           }
        });

        setUndecorated(true);
        setSize(1000,600);
        setLayout(null);
        setLocation(350,230);
        setVisible(true);
    }







    public static void main(String[] args)
    {
        new Employee();
    }
}
