package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Discharge extends JFrame
{
    Discharge()
    {
        JPanel panel =new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        add(panel);

        JLabel label=new JLabel("Check-Out");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("italic",Font.BOLD,20));
        label.setForeground(Color.BLACK);
        panel.add(label);


        JLabel label1=new JLabel("ID:");
        label1.setBounds(30,80,150,20);
        label1.setFont(new Font("italic",Font.BOLD,14));
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        Choice ch=new Choice();
        ch.setBounds(200,80,150,25);
        panel.add(ch);

        try
        {
            Conn c=new Conn();
            String q="select * from patient_info";
            ResultSet rs=c.stmt.executeQuery(q);
            while(rs.next())
            {
                ch.add(rs.getString("number"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        JLabel label2=new JLabel("Room Number:");
        label2.setBounds(30,130,150,20);
        label2.setFont(new Font("italic",Font.BOLD,14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        JLabel rn=new JLabel("");
        rn.setBounds(200,130,150,20);
        rn.setFont(new Font("italic",Font.BOLD,14));
        rn.setForeground(Color.BLACK);
        panel.add(rn);




        JLabel label3=new JLabel("In Time:");
        label3.setBounds(30,180,150,20);
        label3.setFont(new Font("italic",Font.BOLD,14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        JLabel Intime=new JLabel("");
        Intime.setBounds(200,180,350,20);
        Intime.setFont(new Font("italic",Font.BOLD,14));
        Intime.setForeground(Color.BLACK);
        panel.add(Intime);


        JLabel label4=new JLabel("Out Time:");
        label4.setBounds(30,230,150,20);
        label4.setFont(new Font("italic",Font.BOLD,14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);

        Date date=new Date();
        JLabel outtime=new JLabel(""+date);
        outtime.setBounds(200,230,350,20);
        outtime.setFont(new Font("italic",Font.BOLD,14));
        outtime.setForeground(Color.BLACK);
        panel.add(outtime);

        JButton discharge=new JButton("Discharge");
        discharge.setBounds(30,300,120,20);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               Conn c=new Conn();
               try
               {
                   String q="delete from patient_info where number='"+ch.getSelectedItem()+"'";
                   c.stmt.executeUpdate(q);
                   c.stmt.executeUpdate("update room set Availability='Available' where roomno='"+rn.getText()+"'");
                   JOptionPane.showMessageDialog(null,"Discharged Successfully");
                   setVisible(false);
               }
               catch(Exception E)
               {
                   E.printStackTrace();
               }
           }
        });

        JButton check=new JButton("Check");
        check.setBounds(170,300,120,20);
        panel.add(check);
        check.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Conn c=new Conn();
                try
                {
                    ResultSet rs=c.stmt.executeQuery("select * from patient_info where number='"+ch.getSelectedItem()+"'");
                    while(rs.next())
                    {
                        rn.setText(rs.getString("roomno"));
                        Intime.setText(rs.getString("time"));
                    }
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
        });


        JButton back=new JButton("Back");
        back.setBounds(300,300,120,20);
        panel.add(back);
        back.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               setVisible(false);
           }

        });

        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Discharge();
    }

}
