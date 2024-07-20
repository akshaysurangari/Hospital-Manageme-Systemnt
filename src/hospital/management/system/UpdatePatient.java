package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdatePatient extends JFrame
{
    UpdatePatient()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        add(panel);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1=new JLabel("Update Patient Details");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("italic",Font.BOLD,20));
        label1.setForeground(Color.BLACK);
        panel.add(label1);


        JLabel label2=new JLabel("Name:");
        label2.setBounds(25,88,100,25);
        label2.setFont(new Font("italic",Font.BOLD,14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        Choice ch=new Choice();
        ch.setBounds(248,85,100,25);
        panel.add(ch);

        try
        {
            Conn c=new Conn();
            String q="select * from patient_info";
            ResultSet rs=c.stmt.executeQuery(q);
            while(rs.next())
            {
                ch.add(rs.getString("name"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        JLabel label3=new JLabel("Room no:");
        label3.setBounds(25,129,100,14);
        label3.setFont(new Font("italic",Font.BOLD,14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);


        JTextField rm=new JTextField();
        rm.setBounds(248,129,140,20);
        panel.add(rm);

        JLabel label4=new JLabel("In-Time:");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("italic",Font.BOLD,14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);


        JTextField intime=new JTextField();
        intime.setBounds(248,174,140,20);
        panel.add(intime);

        JLabel label5=new JLabel("Amount paid(Rs):");
        label5.setBounds(25,216,200,14);
        label5.setFont(new Font("italic",Font.BOLD,14));
        label5.setForeground(Color.BLACK);
        panel.add(label5);


        JTextField amt=new JTextField();
        amt.setBounds(248,216,140,20);
        panel.add(amt);


        JLabel label6=new JLabel("Pending Amount(Rs):");
        label6.setBounds(25,261,200,14);
        label6.setFont(new Font("italic",Font.BOLD,14));
        label6.setForeground(Color.BLACK);
        panel.add(label6);


        JTextField pamt=new JTextField();
        pamt.setBounds(248,261,140,20);
        panel.add(pamt);

        JButton check=new JButton("CHECK");
        check.setBounds(168,378,89,23);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=ch.getSelectedItem();
                String q="select * from patient_info where name='"+id+"'";
                try
                {
                    Conn c=new Conn();
                    ResultSet rs=c.stmt.executeQuery(q);
                    while(rs.next())
                    {
                        rm.setText(rs.getString("roomno"));
                        intime.setText(rs.getString("Time"));
                        amt.setText(rs.getString("deposit"));
                    }
                    ResultSet rs1=c.stmt.executeQuery("select * from room where roomno='"+rm.getText()+"'");
                    while(rs1.next())
                    {
                        String charge=rs1.getString("price");
                        String dep=amt.getText();
                        int pend=Integer.parseInt(charge)-Integer.parseInt(dep);
                        pamt.setText(""+pend);
                    }
                }
                catch(Exception E )
                {
                    E.printStackTrace();
                }
            }
        });

        JButton update=new JButton("Update");
        update.setBounds(281,378,89,23);
        panel.add(update);
        update.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Conn c=new Conn();
                    String q=ch.getSelectedItem();
                    String rmno=rm.getText();
                    String time=intime.getText();
                    String amnt=amt.getText();
                    ResultSet crs=c.stmt.executeQuery("select * from patient_info where name='"+q+"'");
                    /*while(crs.next()) {
                        String s = crs.getString("Roomno");
                        String p = "update Room set availability= 'Available' where roomno=" + s;
                        c.stmt.executeUpdate(p);

                    }*/
                    c.stmt.executeUpdate("update patient_info set roomno='" + rmno + "', Time='" + time + "',deposit='" + amnt + "' where name='" + q + "' ");
                  /*  String f="update Room set availability='Occupied' where roomno=" + rmno;
                    c.stmt.executeUpdate(f);*/
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
        });


        JButton back=new JButton("Back");
        back.setBounds(56,378,89,23);
        panel.add(back);
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }

        });

        setUndecorated(true);
        setSize(950,500);
        setLocation(400,250);
        setLayout(null);
        setVisible(true);
    }




    public static void main(String[] args)
    {
        new UpdatePatient();
    }
}
