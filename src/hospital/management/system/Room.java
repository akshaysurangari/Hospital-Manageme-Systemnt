package hospital.management.system;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Room extends JFrame
{
    JTable table;
    Room()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        add(panel);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(600,200,200,200);
        panel.add(label);


        table=new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(Color.GRAY);
        table.setForeground(Color.WHITE);
        panel.add(table);

        try
        {
            Conn c=new Conn();
            String q="select * from Room";
            ResultSet rs=c.stmt.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        JLabel label1=new JLabel("Room no");
        label1.setBounds(12,15,80,15);
        label1.setFont(new Font("Italic",Font.BOLD,14));
        label1.setForeground(Color.BLACK);
        panel.add(label1);


        JLabel label2=new JLabel("Availability");
        label2.setBounds(140,15,80,15);
        label2.setFont(new Font("Italic",Font.BOLD,14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);


        JLabel label3=new JLabel("Price");
        label3.setBounds(290,15,80,15);
        label3.setFont(new Font("Italic",Font.BOLD,14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);



        JLabel label4=new JLabel("Bed Type");
        label4.setBounds(400,15,80,15);
        label4.setFont(new Font("Italic",Font.BOLD,14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);


        JButton back=new JButton("BACK");
        back.setBounds(200,500,120,30);
        back.setFont(new Font("Italic",Font.BOLD,14));
        panel.add(back);
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent E)
            {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);
    }




    public static void main(String[] args)
    {
        new Room();
    }

}
