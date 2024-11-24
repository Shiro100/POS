
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Cart {
    
    
    public Cart(final ResultSet rs, final Connection conn){
        final JFrame frm = new JFrame("TubeMerch Shop");
        JPanel panelMain = new JPanel(new BorderLayout());
        JTextField tfUname;
        JPasswordField tfPword;
        JLabel toplabel,toplabel1,ytlogo,select,your,youtuber,welcome,featured;
        JPanel mainpanel,topanel,sidepanel,sidepanel2,box1,box2,panel3;
        JButton profile,cart,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
        
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
              
       select = new JLabel("MY ");
       select.setForeground(Color.WHITE);
       select.setFont(new Font("Geomanist Black",Font.BOLD,40));
       select.setBounds(10, 50, 200, 100);
       
       your = new JLabel("ORDERS");
       your.setForeground(Color.WHITE);
       your.setFont(new Font("Geomanist Black",Font.BOLD,45));
       your.setBounds(4, 100, 200, 100);
       
       
       btn2 = new JButton("← BACK");
       btn2.setFocusable(false);
       btn2.setBackground(Color.DARK_GRAY);
       btn2.setForeground(Color.WHITE);
       btn2.setFont(new Font("century Gothic",Font.BOLD,15));
       btn2.setForeground(Color.WHITE);
       btn2.setBounds(30, 255, 150, 50);
       btn2.setPreferredSize(new Dimension(100, 30));
       btn2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               frm.dispose();
               new DashBoard(rs, conn);
           }
       });
       
        String[] columnNames = {"Product Name", "Description", "Quantity", "Price", "Mode of Payment", "Status"};
        
        Object [][] data ={};
        
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(600,300));
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
       
       // panel where it contains the table
       JPanel rightsidepanel = new JPanel();
       
       rightsidepanel.setBounds(250,125, 700, 500);
       
       //Center Panel 
       
       frm.add(mainpanel);
       mainpanel.add(topanel);
       topanel.add(toplabel);
       mainpanel.add(sidepanel);
       sidepanel.add(btn2);
       sidepanel.add(select);
       sidepanel.add(your);
       mainpanel.add(rightsidepanel);
       rightsidepanel.add(scrollPane);
       
       
       
       frm.setLocationRelativeTo(null);
       frm.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/yt icon.png")));
       frm.setVisible(true);

     }
 }

