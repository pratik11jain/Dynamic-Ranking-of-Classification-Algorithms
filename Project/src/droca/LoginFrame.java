
package droca;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame {

    public LoginFrame() {
        this.setUndecorated(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        isAdmin = new javax.swing.JRadioButton();
        pass = new javax.swing.JPasswordField();
        name = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        mainPanel.setBackground(new java.awt.Color(249, 191, 59));
        mainPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        loginButton.setBackground(new java.awt.Color(249, 191, 59));
        loginButton.setText("Login");
        loginButton.setToolTipText("Login");
        loginButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        isAdmin.setBackground(new java.awt.Color(249, 191, 59));
        isAdmin.setText("Login as Admin");

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        nameLabel.setBackground(new java.awt.Color(249, 191, 59));
        nameLabel.setText("Username");

        passLabel.setBackground(new java.awt.Color(249, 191, 59));
        passLabel.setText("Password");

        titleLabel.setBackground(new java.awt.Color(249, 191, 59));
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/droca/Picture1_8.png"))); // NOI18N
        titleLabel.setToolTipText("DROCA");

        closeButton.setBackground(new java.awt.Color(255, 0, 0));
        closeButton.setText("X");
        closeButton.setToolTipText("Close");
        closeButton.setFocusable(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(409, 409, 409)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(nameLabel)
                                                .addGap(57, 57, 57)
                                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(passLabel)
                                                .addGap(57, 57, 57)
                                                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(453, 453, 453)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(isAdmin))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 541, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(closeButton)
                        .addContainerGap())))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton)
                .addGap(111, 111, 111)
                .addComponent(titleLabel)
                .addGap(100, 100, 100)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pass)
                    .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(isAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed

    }//GEN-LAST:event_passActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
boolean notFound=true;
        try {        
                    Class.forName("java.sql.Driver");
                }catch (ClassNotFoundException ex) {
    try {
        Logger lgr = Logger.getLogger(LoginFrame.class.getName());
        lgr.addHandler(new FileHandler("%t/droca.log"));
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
    } catch (IOException | SecurityException ex1) {
        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex1);
    }
                }	
                Connection con;
                Statement st;
                ResultSet rs;

                 try {
                    con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
                  st = con.createStatement();
           rs = st.executeQuery("SELECT * from passtab;");

        if(isAdmin.isSelected())
        {
            while(rs.next())
            {
                if(rs.getBoolean(3))
                if(name.getText().equalsIgnoreCase(rs.getString(1)))
                {
                    if(rs.getString(2).equals(String.valueOf(pass.getPassword())))
                    {
                        notFound=false;
                    new NewJFrame(true).setVisible(true);
                    this.dispose();
                    break;
                    }
                }
            }
        }
        else
        {
            while(rs.next())
            {

                if(!rs.getBoolean(3))
                if(name.getText().equalsIgnoreCase(rs.getString(1)))
                {
                    if(rs.getString(2).equals(String.valueOf(pass.getPassword())))
                    {
                        notFound=false;
                    new NewJFrame(false).setVisible(true);
                    this.dispose();
                    break;
                    }
                }
            }
        }
if(notFound)
{
    JOptionPane.showConfirmDialog(rootPane,"Incorrect Username or Password!\nPlease try again." ,"Unable to Login!",  JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
    name.setText(null);
    pass.setText(null);
    isAdmin.setSelected(false);
    notFound=false;
}    }catch(SQLException | HeadlessException e)
    {
    try {
        Logger lgr = Logger.getLogger(LoginFrame.class.getName());
        lgr.addHandler(new FileHandler("%t/droca.log"));
        lgr.log(Level.SEVERE, e.getMessage(), e);
    } catch (IOException | SecurityException ex) {
        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_closeButtonActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JRadioButton isAdmin;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
