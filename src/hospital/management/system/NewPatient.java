package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class NewPatient extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField num, name, dise, depo;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;


    NewPatient() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        add(panel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelname = new JLabel("New Patient Form");
        labelname.setBounds(118, 11, 260, 53);
        labelname.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelname.setForeground(new Color(25, 25, 112));
        panel.add(labelname);


        JLabel labelid = new JLabel("ID :");
        labelid.setBounds(35, 76, 200, 16);
        labelid.setFont(new Font("Italic", Font.BOLD, 14));
        labelid.setForeground(Color.BLACK);
        panel.add(labelid);

        comboBox = new JComboBox(new String[]{"Aadhar card", "Voter id", "Driving Licence"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setFont(new Font("Italic", Font.PLAIN, 14));
        panel.add(comboBox);

        JLabel labelnum = new JLabel("Number :");
        labelnum.setBounds(35, 111, 200, 14);
        labelnum.setFont(new Font("Italic", Font.BOLD, 14));
        labelnum.setForeground(Color.BLACK);
        panel.add(labelnum);

        num = new JTextField();
        num.setBounds(271, 111, 150, 20);
        panel.add(num);

        JLabel labelname1 = new JLabel("Name :");
        labelname1.setBounds(35, 151, 150, 20);
        labelname1.setFont(new Font("Italic", Font.BOLD, 14));
        labelname1.setForeground(Color.BLACK);
        panel.add(labelname1);

        name = new JTextField();
        name.setBounds(271, 151, 150, 20);
        panel.add(name);


        JLabel gend = new JLabel("Gender :");
        gend.setBounds(35, 191, 200, 20);
        gend.setFont(new Font("Italic", Font.BOLD, 14));
        gend.setForeground(Color.BLACK);
        panel.add(gend);

        r1 = new JRadioButton("Male");
        r1.setBounds(271, 191, 80, 15);
        r1.setFont(new Font("Italic", Font.BOLD, 14));
        r1.setBackground(new Color(109, 164, 170));
        r1.setForeground(Color.WHITE);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(350, 191, 80, 15);
        r2.setBackground(new Color(109, 164, 170));
        r2.setFont(new Font("Italic", Font.BOLD, 14));
        r2.setForeground(Color.WHITE);
        panel.add(r2);


        JLabel labeldise = new JLabel("Disease :");
        labeldise.setBounds(35, 231, 200, 20);
        labeldise.setFont(new Font("Italic", Font.BOLD, 14));
        labeldise.setForeground(Color.BLACK);
        panel.add(labeldise);

        dise = new JTextField();
        dise.setBounds(271, 231, 150, 20);
        panel.add(dise);


        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35, 274, 200, 20);
        labelRoom.setFont(new Font("Italic", Font.BOLD, 14));
        labelRoom.setForeground(Color.BLACK);
        panel.add(labelRoom);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("select * from Room where Availability='Available' ");
            while (rs.next()) {
                c1.add(rs.getString("roomno"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271, 274, 150, 20);
        c1.setFont(new Font("Italic", Font.BOLD, 14));
        panel.add(c1);


        JLabel labelTime = new JLabel("Time :");
        labelTime.setBounds(35, 316, 200, 20);
        labelTime.setFont(new Font("Italic", Font.BOLD, 14));
        labelTime.setForeground(Color.BLACK);
        panel.add(labelTime);


        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(271, 316, 200, 20);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Italic", Font.BOLD, 14));
        panel.add(date);


        JLabel labeldepo = new JLabel("Deposit :");
        labeldepo.setBounds(35, 359, 200, 20);
        labeldepo.setFont(new Font("Italic", Font.BOLD, 14));
        labeldepo.setForeground(Color.BLACK);
        panel.add(labeldepo);

        depo = new JTextField();
        depo.setBounds(271, 359, 150, 20);
        panel.add(depo);


        b1 = new JButton("ADD");
        b1.setBounds(100, 430, 120, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Cancel ");
        b2.setBounds(260, 430, 120, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);


        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            Conn c = new Conn();
            String radbtn = null;
            if (r1.isSelected()) {
                radbtn = "Male";
            } else if (r2.isSelected()) {
                radbtn = "Female";
            } else {
                JOptionPane.showMessageDialog(null, "Choose gender");
            }
            String s1=(String)comboBox.getSelectedItem();
            String s2=num.getText();
            String s3=name.getText();
            String s4=radbtn;
            String s5=dise.getText();
            String s6=c1.getSelectedItem();
            String s7=date.getText();
            String s8=depo.getText();


            try
            {
                String q="insert into patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1="update Room set availability =  'Occupied' where roomno="+s6;
                c.stmt.executeUpdate(q);
                c.stmt.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }
            catch(Exception E)
            {
                E.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }

    }


    public static void main(String[] args) {
        new NewPatient();
    }

}
