
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DashBoard {
    
    JFrame frm = new JFrame("TubeMerch Shop");
    JPanel panelMain = new JPanel(new BorderLayout());
    JTextField tfUname;
    JPasswordField tfPword;
    JLabel toplabel,toplabel1,ytlogo,select,your,youtuber,welcome,featured;
    JPanel mainpanel,topanel,sidepanel,sidepanel2,box1,box2,panel3;
    JButton profile,cart,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;

    
    public DashBoard(final ResultSet rs, final Connection conn){
       SwingUtilities.invokeLater(new Runnable()  {
            public void run(){
       
       frm.setTitle("TubeMerchShop");
       frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
       frm.setSize(1000, 500);
       frm.setResizable(false);
       
       mainpanel = new JPanel();
       mainpanel.setLayout(null);

       
       topanel = new JPanel();
       topanel.setLayout(null);
       topanel.setBackground(Color.DARK_GRAY);
       topanel.setBounds(0, 0, 1000, 120);
       
       toplabel = new JLabel();
       ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/yt 2 icon.png")).getImage().getScaledInstance(500, 100, Image.SCALE_SMOOTH));
       toplabel.setIcon(imageIcon);
       toplabel.setBounds(250, 0, 1000, 120);

       sidepanel = new JPanel();
       sidepanel.setLayout(null);
       sidepanel.setBackground(Color.GRAY);
       sidepanel.setBounds(0, 100, 200, 2000);
              
       select = new JLabel("SELECT");
       select.setForeground(Color.WHITE);
       select.setFont(new Font("Geomanist Black",Font.BOLD,45));
       select.setBounds(10, 50, 200, 100);
       
       your = new JLabel("YOUR");
       your.setForeground(Color.WHITE);
       your.setFont(new Font("Geomanist Black",Font.BOLD,30));
       your.setBounds(10, 100, 200, 100);
       
       youtuber = new JLabel("YOUTUBER");
       youtuber.setForeground(Color.WHITE);
       youtuber.setFont(new Font("Geomanist Black",Font.BOLD,28));
       youtuber.setBounds(10, 150, 2000, 100);
       
       box1= new JPanel();
       box1.setBackground(null);
       box1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
       box1.setBounds(10, 220, 180, 130);
       
       box2= new JPanel();
       box2.setBackground(Color.WHITE);
       box2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
       box2.setBounds(10, 220, 180, 35);
       
       
       welcome = new JLabel("WELCOME");
       welcome.setForeground(Color.DARK_GRAY);
       welcome.setBackground(Color.WHITE);
       welcome.setFont(new Font("Geomanist Black",Font.PLAIN,25));
       welcome.setBounds(40, 190, 2000, 100);
       
       
       profile = new JButton("PROFILE");
       ImageIcon profileicon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png")).getImage().getScaledInstance(28,28, Image.SCALE_SMOOTH));
       profile.setIcon(profileicon);
       profile.setFont(new Font("Geomanist Black",Font.PLAIN,20));
       profile.setBorderPainted(false);
       profile.setContentAreaFilled(false);
       profile.setFocusable(false);
       profile.setFocusPainted(false);
       profile.setOpaque(false);
       profile.setForeground(Color.WHITE);
       profile.setBounds(10, 255, 180, 50);
       profile.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               frm.dispose();
               new RegisterForm(rs,conn,1);
           }
       });
       
       cart = new JButton("CART");
       ImageIcon carticon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Cart icon.png")).getImage().getScaledInstance(28,28, Image.SCALE_SMOOTH));
       cart.setIcon(carticon);
       cart.setFont(new Font("Geomanist Black",Font.PLAIN,20));
       cart.setBorderPainted(false);
       cart.setContentAreaFilled(false);
       cart.setFocusPainted(false);
       cart.setOpaque(false);
       cart.setFocusable(false);
       cart.setForeground(Color.WHITE);
       cart.setBounds(4, 295, 180, 50);
       cart.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
              frm.dispose();
               new Cart(rs, conn);
           }
       });
       
       sidepanel2 = new JPanel();
       sidepanel2.setLayout(new GridBagLayout());
       GridBagConstraints cst = new GridBagConstraints();
       cst.insets=new Insets(10,50,10,10);
       sidepanel2.setBackground(Color.WHITE);
       sidepanel2.setBounds(200, 120, 800, 350);
       
       panel3= new JPanel();
       panel3.setBounds(450, 130, 300, 35);
       panel3.setBackground(Color.WHITE);
       featured= new JLabel("Featured Youtubers");
       featured.setForeground(Color.DARK_GRAY);
       featured.setFont(new Font("Geomanist Black",Font.BOLD,25));  
       panel3.add(featured);
       
       
       ImageIcon yticon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/yt icon.png")).getImage().getScaledInstance(45,35, Image.SCALE_SMOOTH));
       Font fnt= new Font("Century Gothic",Font.BOLD,20);
       btn1 = new JButton("Congshop1");
       btn1.setIcon(yticon);
       btn1.setFont(fnt);
       btn1.setFocusable(false);
       btn1.setBackground(Color.DARK_GRAY);
       btn1.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 0; 
       sidepanel2.add(btn1,cst);
       btn1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               frm.dispose();
               new Receipt(rs,conn);
           }
       });
       
       btn2 = new JButton("Congshop2");
       btn2.setIcon(yticon);
       btn2.setFont(fnt);
       btn2.setFocusable(false);
       btn2.setBackground(Color.DARK_GRAY);
       btn2.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 1; 
       sidepanel2.add(btn2,cst);
       
       btn3 = new JButton("Congshop3");
       btn3.setIcon(yticon);
       btn3.setFont(fnt);
       btn3.setFocusable(false);
       btn3.setBackground(Color.DARK_GRAY);
       btn3.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 2; 
       sidepanel2.add(btn3,cst);
       
       btn4 = new JButton("Congshop4");
       btn4.setIcon(yticon);
       btn4.setFont(fnt);
       btn4.setFocusable(false);
       btn4.setBackground(Color.DARK_GRAY);
       btn4.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 0;
       cst.gridy = 3; 
       sidepanel2.add(btn4,cst);
       
       btn5 = new JButton("Congshop5");
       btn5.setIcon(yticon);
       btn5.setFont(fnt);
       btn5.setFocusable(false);
       btn5.setBackground(Color.DARK_GRAY);
       btn5.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 2;
       cst.gridy = 0; 
       sidepanel2.add(btn5,cst);
       
       btn6 = new JButton("Congshop6");
       btn6.setIcon(yticon);
       btn6.setFont(fnt);
       btn6.setFocusable(false);
       btn6.setBackground(Color.DARK_GRAY);
       btn6.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 2;
       cst.gridy = 1; 
       sidepanel2.add(btn6,cst);
       
       btn7= new JButton("Congshop7");
       btn7.setIcon(yticon);
       btn7.setFont(fnt);
       btn7.setFocusable(false);
       btn7.setBackground(Color.DARK_GRAY);
       btn7.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 2;
       cst.gridy = 2; 
       sidepanel2.add(btn7,cst);
       
       btn8 = new JButton("Congshop8");
       btn8.setIcon(yticon);
       btn8.setFont(fnt);
       btn8.setFocusable(false);
       btn8.setBackground(Color.DARK_GRAY);
       btn8.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 2;
       cst.gridy = 3; 
       sidepanel2.add(btn8,cst);
       
       btn9 = new JButton("Congshop9");
       btn9.setIcon(yticon);
       btn9.setFont(fnt);
       btn9.setFocusable(false);
       btn9.setBackground(Color.DARK_GRAY);
       btn9.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 3;
       cst.gridy = 0; 
       sidepanel2.add(btn9,cst);
       
       btn10 = new JButton("Congshop10");
       btn10.setIcon(yticon);
       btn10.setFont(fnt);
       btn10.setFocusable(false);
       btn10.setBackground(Color.DARK_GRAY);
       btn10.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 3;
       cst.gridy = 1; 
       sidepanel2.add(btn10,cst);
       
       btn11 = new JButton("Congshop11");
       btn11.setIcon(yticon);
       btn11.setFont(fnt);
       btn11.setFocusable(false);
       btn11.setBackground(Color.DARK_GRAY);
       btn11.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 3;
       cst.gridy = 2; 
       sidepanel2.add(btn11,cst);
       
       btn12 = new JButton("Congshop12");
       btn12.setIcon(yticon);
       btn12.setFont(fnt);
       btn12.setFocusable(false);
       btn12.setBackground(Color.DARK_GRAY);
       btn12.setForeground(Color.WHITE);
       cst.fill = GridBagConstraints.HORIZONTAL;
       cst.gridx = 3;
       cst.gridy = 3; 
       sidepanel2.add(btn12,cst);

       
       frm.add(mainpanel);
       mainpanel.add(topanel);
       topanel.add(toplabel);
       mainpanel.add(sidepanel);
       mainpanel.add(panel3);
       mainpanel.add(sidepanel2);
       sidepanel.add(select);
       sidepanel.add(your);
       sidepanel.add(youtuber);
       sidepanel.add(welcome);
       sidepanel.add(profile);
       sidepanel.add(cart); 
       sidepanel.add(box2);
       sidepanel.add(box1);
       
       frm.setLocationRelativeTo(null);
       frm.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/yt icon.png")));
       frm.setVisible(true);

    }
    });    
}}