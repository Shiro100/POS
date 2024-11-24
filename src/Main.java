import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Main {
    
    final static String jdbc_driver = "org.apache.derby.jdbc.ClientDriver";
    final static String dbUrl = "jdbc:derby://localhost:1527/db_pos";
    
    static Connection conn = null;
    static Statement stmt = null;
    static final String username = "root";
    static final String password = "root";
    
    JFrame frm = new JFrame("TubeMerch Shop");
    JPanel panelMain = new JPanel(new BorderLayout());
    JTextField tfUname;
    JPasswordField tfPword;
    
    public Main(){
        
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/yt 2 icon.png")).getImage().getScaledInstance(300, 60, Image.SCALE_SMOOTH));
        label.setIcon(imageIcon);
        panel.setBackground(Color.DARK_GRAY);
        panel.add(label);
        panel.setPreferredSize(new Dimension(400, 70));
        panelMain.add(panel,BorderLayout.PAGE_START);
        
        JPanel panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5,0,5,5);
        JLabel lblUname = new JLabel();
        ImageIcon profileicon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png")).getImage().getScaledInstance(25,25, Image.SCALE_SMOOTH));
        lblUname.setIcon(profileicon);
        JLabel lblPword = new JLabel();
        ImageIcon passicon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/keylogo.png")).getImage().getScaledInstance(25,25, Image.SCALE_SMOOTH));
        lblPword.setIcon(passicon);
        tfUname = new JTextField();
        tfPword = new JPasswordField();
        
        tfUname.setPreferredSize(new Dimension(200,25));
        tfPword.setPreferredSize(new Dimension(200,25));
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0; cst.gridy = 0;
        panel1.add(lblUname,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 1; cst.gridy = 0; 
        panel1.add(tfUname,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0; cst.gridy = 1;
        panel1.add(lblPword,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 1; cst.gridy = 1;
        panel1.add(tfPword,cst);
        
        JPanel panel2 = new JPanel(new GridBagLayout());
        
        
        JButton btnReg = new JButton("Not yet Register? Click Here");
        btnReg.setFont(new Font("Century Gothic",Font.ITALIC,10));
        btnReg.setOpaque(false);
        btnReg.setContentAreaFilled(false);
        btnReg.setBorder(null);
        btnReg.setBorderPainted(false);
        btnReg.setHorizontalAlignment(SwingConstants.LEFT);
        btnReg.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                frm.dispose();
                new RegisterForm(null, conn, 0);
            }
        
        });
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0; cst.gridy = 1;
       
        panel2.add(btnReg,cst);
        
        
        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Century Gothic",Font.BOLD,15));
        btnLogin.setForeground(Color.white);
        btnLogin.setBackground(Color.DARK_GRAY);
        
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ResultSet rs;
                try {
                    conn = DriverManager.getConnection(dbUrl);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("Select * from tbl_user Where username='" + tfUname.getText() + "' AND password= '" + tfPword.getText() + "'");
                    if (rs.next()) {
                        frm.dispose();
                        new DashBoard(rs,conn);
                    } else {
                        JOptionPane.showMessageDialog(frm, "Login Failed");
                    }
                    
                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(frm, "Error in SQL Statement!" + ae);
                } 
   
            }
        });
         
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0; cst.gridy = 0;
        
        panel2.add(btnLogin,cst);

        panelMain.add(panel1,BorderLayout.CENTER);
        panelMain.add(panel2,BorderLayout.PAGE_END);
        
        frm.setSize(400, 250);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/yt icon.png")));
        frm.add(panelMain);
        frm.setVisible(true);
        
        try {
            Class.forName(jdbc_driver);
            JOptionPane.showMessageDialog(frm, "Connecting to the database...");
            conn = DriverManager.getConnection(dbUrl);

            if (conn != null) {
                JOptionPane.showMessageDialog(frm, "Connected to the database!");
            } else {
                JOptionPane.showMessageDialog(frm, "Could not connect to the database...");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frm, "Error in connecting to the database!");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });

    }
        
}
