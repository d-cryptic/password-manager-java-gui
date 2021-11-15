// Imports 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PasswordManager implements ActionListener {
    
    // Store password class reference 
    HashtablePassword data = new HashtablePassword(15,0.5F,0);

    JFrame frame;
    JFrame frame2;
    Container conn1,conn2;
    JLabel lAcc,lPass;
    JTextArea encryptPasswdArea, genePassArea, searchPassArea;
    JButton PassGeneBtn,PassEncryptBtn, PassStoreBtn, PassSearchBtn, AccAddBtn, PassDeleteBtn;
    JTextField tAcc, tPass;
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    // Frame settings 
    public static void FrameGUI(JFrame frame) {
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
    }

    // container settings 
    public static void ContainerGUI(Container conn) {
        conn.setVisible(true);
        conn.setBackground(Color.getHSBColor(20.4f, 10.5f, 12.9f));
        conn.setLayout(null);
    }

    // buttons settings
    public void GUIButtonSetting(JButton btn) {
        btn.setBackground(Color.LIGHT_GRAY);
        btn.setForeground(Color.BLACK);
        Font fn = new Font("Arial", Font.PLAIN, 15);
        btn.setFont(fn);
        Cursor crs = new Cursor(Cursor.HAND_CURSOR);
        btn.setCursor(crs);
    }

    // GUI of Store password 
    public void StoringGUI() {
        frame2 = new JFrame("Store your passwords");
        frame2.setBounds(1400, 700, 600, 500);
        frame2.setSize(500, 400);
        FrameGUI(frame2);
        conn2 = frame2.getContentPane();
        ContainerGUI(conn2);
        Font fn = new Font("Arial", Font.BOLD, 20);

        // Account textField and label 
        lAcc = new JLabel("ENTER ACCOUNT NAME");
        lAcc.setBounds(100, 23, 480, 50);
        lAcc.setFont(fn);
        conn2.add(lAcc);

        tAcc = new JTextField();
        tAcc.setBounds(100, 70, 300, 80);
        tAcc.setFont(fn);
        tAcc.setForeground(Color.DARK_GRAY);
        conn2.add(tAcc);

        //Account password textField and label
        lPass = new JLabel("ENTER ACCOUNT PASSWORD");
        lPass.setBounds(100, 160, 480, 50);
        lPass.setFont(fn);
        conn2.add(lPass);

        tPass = new JTextField();
        tPass.setBounds(100, 200, 300, 80);
        tPass.setFont(fn);
        tPass.setForeground(Color.DARK_GRAY);
        conn2.add(tPass);

        AccAddBtn = new JButton("STORE");
        AccAddBtn.setBounds(170, 290, 150, 50);
        conn2.add(AccAddBtn);
        GUIButtonsSetting(AccAddBtn);

    }
    
    // for password generator and encryption 
    public void textArea(String Pass, JTextArea TA) {
        TA.setText(Pass);
        Font fn = new Font("Arial", Font.BOLD, 20);
        TA.setWrapStyleWord(true);
        TA.setLineWrap(true);
        TA.setCaretPosition(0);
        TA.setEditable(false);
        TA.setFont(fn);
    }
    
    PasswordManager() {
        frame = new JFrame("Password Manager");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/icon.png"));
//        frame.setBounds(300, 100, 700, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(580,630);
        FrameGUI(frame);

        conn1 = frame.getContentPane();
        ContainerGUI(conn1);


        //Generator buttons settings
        PassGeneBtn = new JButton("GENERATE PASSWORD");
        PassGeneBtn.setBounds(160, 80, 220, 70);
        conn1.add(PassGeneBtn);
        GUIButtonsSetting(PassGeneBtn);


        // generating password 
        PassGeneBtn.addActionListener(e -> {
        if(PassGeneBtn ==e.getSource())
        {
            try{
                int len = Integer.parseInt(JOptionPane.showInputDialog("Enter the password length"));
                if(len>8)
                {
                    //  password generator class reference
                    PasswordGenerator pass = new PasswordGenerator();
                    String passwd = pass.generatePassword(len);
                    genePassArea = new JTextArea(5,4);
                    textArea(passwd,genePassArea);
                    JOptionPane.showMessageDialog(conn1,new JScrollPane(genePassArea),"Copy your password",JOptionPane.INFORMATION_MESSAGE);

                }
                else JOptionPane.showMessageDialog (conn1,"Password length must be greater than 8!","Invalid Input Error",JOptionPane.WARNING_MESSAGE);

            }
            catch(Exception ex){JOptionPane.showMessageDialog(conn1,ex.getMessage(),"EXIT!",JOptionPane.ERROR_MESSAGE);}
        }

    }
    );

    

}