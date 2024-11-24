
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Scanner;

public class RegisterForm {
    
    public RegisterForm(final ResultSet rs, final Connection conn, final int count){
        SwingUtilities.invokeLater(new Runnable()  {
            public void run(){
                
        final JFrame frm = new JFrame("Registeration Form");
        final JPanel panelMain = new JPanel(new BorderLayout());
        final JTextField tffn,phoneno,email,username,pass,bday,address,province,city,barangay,postal,detail;
        final JLabel toplabel,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18;
        final JPanel mainpanel,topanel,sidepanel,varia,profile,add,add2,btns;
        final JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
        final JComboBox Gender,month,day,year,Region;
        String[] gender = {"Male","Female"};
        String[] region = {"Metro Manila","Mindanao","North Luzon","South Luzon","Visayas"};
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(10, 5, 3, 3);
        mainpanel = new JPanel();
        mainpanel.setLayout(null);
       
       //top panel
       topanel = new JPanel();
       topanel.setLayout(null);
       topanel.setBackground(Color.DARK_GRAY);
       topanel.setBounds(0, 0, 1000, 120);
       
       toplabel = new JLabel();
       ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/yt 2 icon.png")).getImage().getScaledInstance(500, 100, Image.SCALE_SMOOTH));
       toplabel.setIcon(imageIcon);
       toplabel.setBounds(250, 0, 1000, 120);

       //sidepanel
       sidepanel = new JPanel();
       sidepanel.setLayout(null);
       sidepanel.setBackground(Color.GRAY);
       sidepanel.setBounds(0, 100, 200, 2000);
              
       lb1 = new JLabel("REGISTER");
       lb1.setForeground(Color.WHITE);
       lb1.setFont(new Font("Geomanist Black",Font.BOLD,40));
       lb1.setBounds(10, 50, 200, 100);
       
       lb2 = new JLabel("FORM");
       lb2.setForeground(Color.WHITE);
       lb2.setFont(new Font("Geomanist Black",Font.BOLD,30));
       lb2.setBounds(10, 100, 200, 100);

       btns= new JPanel();
       btn1 = new JButton("SUBMIT");
       btns.setOpaque(false);
       btns.setBounds(20, 220, 150, 140);
       //ImageIcon profileicon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png")).getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH));
       //profile.setIcon(profileicon);
       btn1.setFont(new Font("century Gothic",Font.BOLD,15));
       btn1.setFocusable(false);
       btn1.setBackground(Color.DARK_GRAY);
       btn1.setForeground(Color.WHITE);
       btn1.setForeground(Color.WHITE);
       btn1.setPreferredSize(new Dimension(100, 30));
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 0;
       btns.add(btn1);

       btn3 = new JButton("Clear");
       //ImageIcon profileicon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png")).getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH));
       //profile.setIcon(profileicon);
       btn3.setFont(new Font("century Gothic",Font.BOLD,15));
       btn3.setFocusable(false);
       btn3.setBackground(Color.DARK_GRAY);
       btn3.setForeground(Color.WHITE);
       btn3.setForeground(Color.WHITE);
       btn3.setPreferredSize(new Dimension(100, 30));
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 1;
       btns.add(btn3);
       
       
       btn2 = new JButton("← BACK");
       //ImageIcon carticon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Cart icon.png")).getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH));
       //cart.setIcon(carticon);
       btn2.setFocusable(false);
       btn2.setBackground(Color.DARK_GRAY);
       btn2.setForeground(Color.WHITE);
       btn2.setFont(new Font("century Gothic",Font.BOLD,15));
       btn2.setForeground(Color.WHITE);
       btn2.setPreferredSize(new Dimension(100, 30));
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 2;
       btns.add(btn2);
       
       //profile panel
       
       profile= new JPanel();
       profile.setBackground(Color.white);
       lb3= new JLabel("Profile",JLabel.CENTER);
       lb3.setForeground(Color.WHITE);
       lb3.setBackground(Color.DARK_GRAY);
       lb3.setPreferredSize(new Dimension(150, 40));
       lb3.setOpaque(true);
       lb3.setFont(new Font("Geomanist Black",Font.BOLD,25));
       profile.add(lb3);
       profile.setBounds(200, 120, 400, 500);
       ImageIcon profileico = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png")).getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH));
       lb3.setIcon(profileico);
 
       //fullname
       lb4= new JLabel("Full Name",JLabel.CENTER);
       lb4.setPreferredSize(new Dimension(80, 20));
       lb4.setBackground(Color.DARK_GRAY);
       lb4.setOpaque(true);
       lb4.setFont(new Font("century gothic",Font.BOLD,15));
       lb4.setForeground(Color.white);
       tffn= new JTextField();
       tffn.setPreferredSize(new Dimension(150, 25));
       
       //gender
       lb5= new JLabel("Gender",JLabel.CENTER);
       lb5.setPreferredSize(new Dimension(80, 20));
       lb5.setBackground(Color.DARK_GRAY);
       lb5.setOpaque(true);
       lb5.setFont(new Font("century gothic",Font.BOLD,15));
       lb5.setForeground(Color.white);
       Gender = new JComboBox(gender);
       Gender.setBackground(Color.WHITE);
       Gender.setForeground(Color.BLACK);
       
       //Birthday
       JPanel panel = new JPanel();
       lb6= new JLabel("Birthday",JLabel.CENTER);
       lb6.setPreferredSize(new Dimension(80, 20));
       lb6.setBackground(Color.DARK_GRAY);
       lb6.setOpaque(true);
       lb6.setFont(new Font("century gothic",Font.BOLD,15));
       lb6.setForeground(Color.white);   
       bday= new JTextField();
       bday.setPreferredSize(new Dimension(150, 25));
       
       //Phone Number
       lb7= new JLabel("Phone Number",JLabel.CENTER);
       lb7.setPreferredSize(new Dimension(100, 20));
       lb7.setBackground(Color.DARK_GRAY);
       lb7.setOpaque(true);
       lb7.setFont(new Font("century gothic",Font.BOLD,12));
       lb7.setForeground(Color.white);   
       phoneno= new JTextField();
       phoneno.setPreferredSize(new Dimension(150, 25));
       
       //Email
       lb8= new JLabel("Email",JLabel.CENTER);
       lb8.setPreferredSize(new Dimension(100, 20));
       lb8.setBackground(Color.DARK_GRAY);
       lb8.setOpaque(true);
       lb8.setFont(new Font("century gothic",Font.BOLD,15));
       lb8.setForeground(Color.white);   
       email= new JTextField();
       email.setPreferredSize(new Dimension(150, 25));
       
       //Username
       lb9= new JLabel("Username",JLabel.CENTER);
       lb9.setPreferredSize(new Dimension(100, 20));
       lb9.setBackground(Color.DARK_GRAY);
       lb9.setOpaque(true);
       lb9.setFont(new Font("century gothic",Font.BOLD,15));
       lb9.setForeground(Color.white);   
       pass= new JTextField();
       pass.setPreferredSize(new Dimension(150, 25));
      
       //Password
       lb10= new JLabel("Password",JLabel.CENTER);
       lb10.setPreferredSize(new Dimension(100, 20));
       lb10.setBackground(Color.DARK_GRAY);
       lb10.setOpaque(true);
       lb10.setFont(new Font("century gothic",Font.BOLD,15));
       lb10.setForeground(Color.white);   
       username= new JTextField();
       username.setPreferredSize(new Dimension(150, 25));
       
       //profile panel
       varia= new JPanel(new GridBagLayout());
       varia.setOpaque(false);
       varia.setBounds(150, 60, 400, 500);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 0;
       varia.add(lb4, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 0;
       varia.add(tffn);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 1;
       varia.add(lb5, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 1;
       cst.ipady = 1;
       varia.add(Gender, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 2;
       varia.add(lb6, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 2;
       varia.add(bday, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 3;
       varia.add(lb7, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 3;
       varia.add(phoneno, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 4;
       varia.add(lb8, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 4;
       varia.add(email, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 5;
       varia.add(lb9, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 5;
       varia.add(username, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 6;
       varia.add(lb10, cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 6;
       varia.add(pass, cst);
       
       //Address panel
       
       add= new JPanel();
       add.setBackground(Color.white);
       lb11= new JLabel("Address",JLabel.CENTER);
       lb11.setForeground(Color.WHITE);
       lb11.setBackground(Color.DARK_GRAY);
       lb11.setPreferredSize(new Dimension(150, 40));
       lb11.setOpaque(true);
       lb11.setFont(new Font("Geomanist Black",Font.BOLD,25));
       add.add(lb11);
       add.setBounds(600, 120, 400, 500);
       ImageIcon addressicon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/address.png")).getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH));
       lb11.setIcon(addressicon);
       
       //Region
       lb12= new JLabel("Region",JLabel.CENTER);
       lb12.setPreferredSize(new Dimension(80, 20));
       lb12.setBackground(Color.DARK_GRAY);
       lb12.setOpaque(true);
       lb12.setFont(new Font("century gothic",Font.BOLD,15));
       lb12.setForeground(Color.white);
       Region = new JComboBox(region);
       Region.setBackground(Color.WHITE);
       Region.setForeground(Color.BLACK);
       
       //Province
       lb13= new JLabel("Province",JLabel.CENTER);
       lb13.setPreferredSize(new Dimension(80, 20));
       lb13.setBackground(Color.DARK_GRAY);
       lb13.setOpaque(true);
       lb13.setFont(new Font("century gothic",Font.BOLD,15));
       lb13.setForeground(Color.white);
       province= new JTextField();
       province.setPreferredSize(new Dimension(150, 25));
       
       //City/Municipality
       lb14= new JLabel("City/Municipality",JLabel.CENTER);
       lb14.setPreferredSize(new Dimension(80, 20));
       lb14.setBackground(Color.DARK_GRAY);
       lb14.setOpaque(true);
       lb14.setFont(new Font("century gothic",Font.BOLD,11));
       lb14.setForeground(Color.white);
       city= new JTextField();
       city.setPreferredSize(new Dimension(150, 25));
       
       //Barangay
       lb15= new JLabel("Barangay",JLabel.CENTER);
       lb15.setPreferredSize(new Dimension(80, 20));
       lb15.setBackground(Color.DARK_GRAY);
       lb15.setOpaque(true);
       lb15.setFont(new Font("century gothic",Font.BOLD,15));
       lb15.setForeground(Color.white);
       barangay= new JTextField();
       barangay.setPreferredSize(new Dimension(150, 25));
       
       //PostalCode
       lb16= new JLabel("Postal Code",JLabel.CENTER);
       lb16.setPreferredSize(new Dimension(80, 20));
       lb16.setBackground(Color.DARK_GRAY);
       lb16.setOpaque(true);
       lb16.setFont(new Font("century gothic",Font.BOLD,12));
       lb16.setForeground(Color.white);
       postal= new JTextField();
       postal.setPreferredSize(new Dimension(150, 25));
       
       //Detail Address
       lb17= new JLabel("Detail Address",JLabel.CENTER);
       lb17.setPreferredSize(new Dimension(80, 20));
       lb17.setBackground(Color.DARK_GRAY);
       lb17.setOpaque(true);
       lb17.setFont(new Font("century gothic",Font.BOLD,11));
       lb17.setForeground(Color.white);
       detail= new JTextField();
       detail.setPreferredSize(new Dimension(150, 25));
       lb18= new JLabel("House number/streetname",JLabel.CENTER);
       lb18.setPreferredSize(new Dimension(80, 20));
       lb18.setBackground(Color.white);
       lb18.setOpaque(true);
       lb18.setFont(new Font("century gothic",Font.BOLD,10));
       lb18.setForeground(Color.DARK_GRAY);
       
       address = new JTextField();
       address.setText("(" + Region.getSelectedItem().toString() + ")," + province.getText().toString() + "," + city.getText().toString() + "," +
                barangay.getText().toString() + "," + detail.getText().toString());

       add2 = new JPanel(new GridBagLayout());
       add2.setOpaque(false);
       add2.setBounds(500, 48, 500, 500);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 0;
       add2.add(lb12,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 0;
       add2.add(Region,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 1;
       add2.add(lb13,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 1;
       add2.add(province,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 2;
       add2.add(lb14,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 2;
       add2.add(city,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 3;
       add2.add(lb15,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 3;
       add2.add(barangay,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 4;
       add2.add(lb16,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 4;
       add2.add(postal,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 5;
       add2.add(lb17,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 1;
       cst.gridy = 5;
       add2.add(detail,cst);
       
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.insets = new Insets(0, 0, 0, 0);
       cst.gridx = 1;
       cst.gridy = 6;
       add2.add(lb18,cst);
       if(count == 1){
           lb1.setText("Profile");
           lb2.setText("");
           ResultSet rs2;
                try {
                    Statement stmt = conn.createStatement();
                    rs2 = stmt.executeQuery("Select * from tbl_user Where username='" + rs.getString("Username")+ "'");
                    if (rs2.next()) {                        
                        tffn.setText(rs.getString("fullname"));  
                        phoneno.setText(rs.getString("phone"));
                        username.setText(rs.getString("username"));
                        email.setText(rs.getString("email"));
                        if(rs.getString("gender")== "Male"){
                         Gender.setSelectedIndex(0);   
                        }else{
                         Gender.setSelectedIndex(1);     
                        }
                        pass.setText(rs.getString("password"));
                        bday.setText(rs.getString("birthday"));
                    } else {
                       Scanner scan = new Scanner(rs.getString("address"));
                        // initialize the string delimiter
                        scan.useDelimiter(",");
                       // Printing the tokenized Strings
                       while(scan.hasNext()){

                       if(scan.next().toString().equalsIgnoreCase("Metro Manila")){
                         Region.setSelectedIndex(0);   
                       }
                       else if(scan.next().toString().equalsIgnoreCase("Mindanao")){
                         Region.setSelectedIndex(1);     
                       } 
                       else if(scan.next().toString().equalsIgnoreCase("North Luzon")){
                         Region.setSelectedIndex(2);     
                       } 
                       else if(scan.next().toString().equalsIgnoreCase ("South Luzon")){
                         Region.setSelectedIndex(3);     
                       } 
                       else if(scan.next().toString().equalsIgnoreCase("Visayas")){
                         Region.setSelectedIndex(4);     
                       }
                        else{    
                        }
                       province.setText(scan.next().toString());
                       city.setText(scan.next().toString());
                       barangay.setText(scan.next().toString());
                       postal.setText(scan.next().toString());
                       detail.setText(scan.next().toString());
                        }
                       
                        // closing the scanner stream
                        scan.close();
}
                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(frm, "Error in SQL Statement!" + ae);
                }
                btn1.setText("Update");
                btn1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        //if (tffn.getText().toString().isEmpty() || phoneno.getText().toString().isEmpty() || email.getText().toString().isEmpty() 
                        //        || username.getText().toString().isEmpty() || pass.getText().toString().isEmpty() || Gender.getSelectedIndex() == -1
                        //        || Region.getSelectedIndex() == -1 || province.getText().toString().isEmpty() || city.getText().toString().isEmpty() 
                        //        || barangay.getText().toString().isEmpty() || detail.getText().toString().isEmpty()) {
                        //    JOptionPane.showMessageDialog(frm, "Invalid input!");
                        //} else {
                            try {
                               
                                Statement stmt = conn.createStatement();
                                stmt.executeUpdate("Update tbl_user set username='" + username.getText().toString() + "',password= '"+ pass.getText().toString()  + "',fullname='"+ tffn.getText().toString() + "',gender='" 
                                        + Gender.getSelectedItem().toString() + "',birthday='"+ bday.getText().toString() + "',phone='" + phoneno.getText().toString() + "',email='" + email.getText().toString() 
                                        + "',address='" + address.getText().toString() + "'");        
                                frm.dispose();
                                if (count == 1){
                                    JOptionPane.showMessageDialog(frm, "Successfully Updated! "+ "Redirecting to the Main Menu");
                                    new DashBoard(rs,conn); 
                                }else{
                                    JOptionPane.showMessageDialog(frm, "Successfully Registered! ");
                                    new Main();  
                                 }          
                            } catch (Exception ae) {
                                JOptionPane.showMessageDialog(frm, "Error in SQL Statement!" + ae);
                            }
                        //}
                    }
                });
                btn3.setVisible(false);
                btn2.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        frm.dispose();
                        new DashBoard(rs,conn);
                    }
                });
       
       }else{
           btn1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        if (tffn.getText().toString().isEmpty() || phoneno.getText().toString().isEmpty() || email.getText().toString().isEmpty() 
                                || username.getText().toString().isEmpty() || pass.getText().toString().isEmpty() || Gender.getSelectedIndex() == -1
                                || Region.getSelectedIndex() == -1 || province.getText().toString().isEmpty() || city.getText().toString().isEmpty() 
                                || barangay.getText().toString().isEmpty() || detail.getText().toString().isEmpty()) {
                            JOptionPane.showMessageDialog(frm, "Invalid input!");
                        } else {
                            try {
                               
                                Statement stmt = conn.createStatement();
                                stmt.executeUpdate("INSERT INTO tbl_user(username,password,fullname,gender,birthday,phone,email,address) VALUES('" 
                                        + username.getText().toString() + "', '" + pass.getText().toString()  + "','" + tffn.getText().toString() + "','" + Gender.getSelectedItem().toString() + "','"+
                                        bday.getText().toString() + "', '" + phoneno.getText().toString() + "', '" + email.getText().toString() + "', '" + address.getText().toString() + "')");
                                
                                frm.dispose();
                                if (count == 1){
                                    JOptionPane.showMessageDialog(frm, "Successfully Registered! "+ "Redirecting to the DashBoard");
                                    //new MainPanel(rs,conn); 
                                }else{
                                    JOptionPane.showMessageDialog(frm, "Successfully Registered! ");
                                    new Main();  
                                 }          
                            } catch (Exception ae) {
                                JOptionPane.showMessageDialog(frm, "Error in SQL Statement!" + ae);
                            }
                        }
                    }
                });
       
       btn3.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        tffn.setText("");
                        phoneno.setText("");
                        email.setText("");
                        username.setText("");
                        pass.setText("");
                        province.setText("");
                        city.setText("");
                        barangay.setText("");
                        bday.setText("");
                        postal.setText("");
                        detail.setText("");
                    }
                });
       
       btn2.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        frm.dispose();
                        new Main();
                    }
                });
       }
      
       
       mainpanel.add(topanel);
       topanel.add(toplabel);
       mainpanel.add(sidepanel);
       sidepanel.add(lb1);
       sidepanel.add(lb2);
       sidepanel.add(btns);
       mainpanel.add(varia);
       mainpanel.add(profile);
       mainpanel.add(add2);
       mainpanel.add(add);
       
       
       frm.setSize(1000, 500);
       frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frm.setLocationRelativeTo(null);
       frm.add(mainpanel);
       frm.setVisible(true);
       frm.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/yt icon.png")));
    
     }});
  
}}

