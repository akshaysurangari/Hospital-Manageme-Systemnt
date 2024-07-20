package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame
{


    Department()
    {
        JPanel panel= new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        add(panel);


        JTable table =new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(Color.GRAY);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Italic",Font.BOLD,14));
        panel.add(table);


        try
        {
            Conn c=new Conn();
            String q="select * from department";
            ResultSet rs=c.stmt.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }


        JLabel label1=new JLabel("Department");
        label1.setBounds(85,11,105,20);
        label1.setFont(new Font("Italic",Font.BOLD,14));
        panel.add(label1);
        label1.setForeground(Color.BLACK);


        JLabel label2=new JLabel("Phone Number");
        label2.setBounds(400,11,105,20);
        label2.setFont(new Font("Italic",Font.BOLD,14));
        panel.add(label2);
        label2.setForeground(Color.BLACK);


        JButton back=new JButton("BACK");
        back.setBounds(400,410,130,40);
        back.setFont(new Font("Italic",Font.BOLD,16));
        panel.add(back);
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent E)
            {
                setVisible(false);
            }
        });




        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);

    }




    public static void main(String[] args)
    {
        new Department();
    }
}
