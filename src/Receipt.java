
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Receipt {
    
    
    public Receipt(final ResultSet rs, final Connection conn){
        final JFrame frm = new JFrame("TubeMerch Shop");
        JPanel panelMain = new JPanel(new BorderLayout());
        JTextField tfUname;
        JPasswordField tfPword;
        JLabel toplabel,toplabel1,ytlogo,select,your,youtuber,welcome,featured;
        JPanel mainpanel,topanel,sidepanel,sidepanel2,box1,box2,panel3;
        final JButton profile,cart,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
        
       frm.setTitle("TubeMerchShop");
       frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
       frm.setSize(250,500);
       frm.setResizable(false);
       
       mainpanel = new JPanel();
       mainpanel.setLayout(null);

       
       topanel = new JPanel();
       topanel.setLayout(null);
       topanel.setBackground(Color.darkGray);
       topanel.setBounds(0, 0, 250,120);
       
       /*toplabel = new JLabel();
       toplabel.setText("CREDIT CARD");
       toplabel.setFont(new Font("Geomanist Black",Font.BOLD,40));
       toplabel.setForeground(Color.WHITE);
       toplabel.setBounds(440, 0, 1000, 120);*/
       
       JLabel toplabel2 = new JLabel();
       toplabel2.setText("ORDER");
       toplabel2.setFont(new Font("Geomanist Black",Font.BOLD,30));
       toplabel2.setForeground(Color.WHITE);
       toplabel2.setBounds(100, -20, 1000, 120);
       
       JLabel toplabel3 = new JLabel();
       toplabel3.setText("SLIP");
       toplabel3.setFont(new Font("Geomanist Black",Font.BOLD,27));
       toplabel3.setForeground(Color.WHITE);
       toplabel3.setBounds(100, 20, 1000, 120);

       JLabel toplabel4 = new JLabel();
       ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shopping-cart-grey-hi.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
       toplabel4.setIcon(imageIcon);
       toplabel4.setBounds(10, -6, 1000, 120);
       
       sidepanel = new JPanel();
       sidepanel.setLayout(null);
       sidepanel.setBorder(BorderFactory.createLineBorder(Color.black));
       sidepanel.setBackground(Color.GRAY);
       sidepanel.setBounds(0, 100, 250, 2000);
              
       select = new JLabel("Product");
       select.setForeground(Color.WHITE);
       select.setFont(new Font("Geomanist Black",Font.BOLD,15));
       select.setBounds(90, -0, 200, 100);
       
       JLabel productname = new JLabel("Product Name: ");
       productname.setForeground(Color.WHITE);
       productname.setFont(new Font("Geomanist Black",Font.BOLD,15));
       productname.setBounds(10, 20, 200, 100);
       
       JLabel Description = new JLabel("Description: ");
       Description.setForeground(Color.WHITE);
       Description.setFont(new Font("Geomanist Black",Font.BOLD,15));
       Description.setBounds(10, 40, 200, 100);
       
       JLabel Quantity = new JLabel("Quantity: ");
       Quantity.setForeground(Color.WHITE);
       Quantity.setFont(new Font("Geomanist Black",Font.BOLD,15));
       Quantity.setBounds(10, 60, 200, 100);
       
       JLabel billing = new JLabel("Billing");
       billing.setForeground(Color.WHITE);
       billing.setFont(new Font("Geomanist Black",Font.BOLD,15));
       billing.setBounds(95, 90, 200, 100);
       
       JLabel name = new JLabel("Name: ");
       name.setForeground(Color.WHITE);
       name.setFont(new Font("Geomanist Black",Font.BOLD,15));
       name.setBounds(10, 110, 200, 100);
       
       JLabel number = new JLabel("Contact Number: ");
       number.setForeground(Color.WHITE);
       number.setFont(new Font("Geomanist Black",Font.BOLD,15));
       number.setBounds(10, 130, 200, 100);
       
       JLabel address = new JLabel("Address: ");
       address.setForeground(Color.WHITE);
       address.setFont(new Font("Geomanist Black",Font.BOLD,15));
       address.setBounds(10, 150, 200, 100);
       
       JLabel payment = new JLabel("Select Mode Of Payment: ");
       payment.setForeground(Color.WHITE);
       payment.setFont(new Font("Geomanist Black",Font.BOLD,15));
       payment.setBounds(10, 170, 200, 100);
       
       String mode[] ={"COD", "CREDIT CARD", "GCASH"};
       
       final JComboBox modeofpayment = new JComboBox(mode);
       modeofpayment.setBounds(60, 235, 100, 20);
       
       btn2 = new JButton("PLACE ORDER");
       btn2.setFocusable(false);
       btn2.setBackground(Color.DARK_GRAY);
       btn2.setForeground(Color.WHITE);
       btn2.setFont(new Font("century Gothic",Font.BOLD,15));
       btn2.setForeground(Color.WHITE);
       btn2.setBounds(18, 260, 200, 40);
        /*btn2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
              if(e.getSource() == modeofpayment.getSelectedIndex(1))){
                 
                  frm.dispose();
                  new CreditCard();
              } 
             
           }
       });*/
       
       btn3 = new JButton("BACK");
       btn3.setFocusable(false);
       btn3.setBackground(Color.DARK_GRAY);
       btn3.setForeground(Color.WHITE);
       btn3.setFont(new Font("century Gothic",Font.BOLD,15));
       btn3.setForeground(Color.WHITE);
       btn3.setBounds(18, 310, 200, 40);
       btn3.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                frm.dispose();
                new DashBoard(rs,conn);
           }
       });
       
       // do not touch !!!!
       /*JPanel rightsidepanel = new JPanel();
       rightsidepanel.setLayout(null);
       rightsidepanel.setBackground(Color.GRAY);
       rightsidepanel.setBounds(190,120, 800, 500);*/
       
       //Center Panel 
       
       frm.add(mainpanel);
       mainpanel.add(topanel);
       //topanel.add(toplabel,BorderLayout.CENTER);
       topanel.add(toplabel2);
       topanel.add(toplabel3);
       topanel.add(toplabel4);
       mainpanel.add(sidepanel);
       sidepanel.add(btn2);
       sidepanel.add(select);  
       sidepanel.add(productname);
       sidepanel.add(Description);
       sidepanel.add(Quantity);
       sidepanel.add(billing);
       sidepanel.add(name);
       sidepanel.add(number);
       sidepanel.add(address);
       sidepanel.add(payment);
       sidepanel.add(modeofpayment);
       sidepanel.add(btn3);
       //mainpanel.add(rightsidepanel);
       
       
       
       
       frm.setLocationRelativeTo(null);
       frm.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/yt icon.png")));
       frm.setVisible(true);

    }
}
