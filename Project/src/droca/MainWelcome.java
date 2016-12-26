package droca;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MainWelcome extends javax.swing.JFrame {

    public MainWelcome() {
        this.setUndecorated(true);
        initComponents();
        func();
        func1();
    }
        private void func()
        {
            
            Runnable runner = new Runnable(){
        @Override
        public void run() {
      while(true)
      {   try {
          
          if(cntr!=-1)
             cntr++;
          else break;
          Thread.sleep(1000);
          } catch (InterruptedException ex) {
              Logger.getLogger(MainWelcome.class.getName()).log(Level.SEVERE, null, ex);
          }
}    
         
            }
    };
    Thread t = new Thread(runner, "Code Executer");
    t.start();
        }
               private void func1()
        {
            
            Runnable runner = new Runnable(){
        @Override
        public void run() {
                while(true)
                {
                    System.out.println(cntr);
                    if(cntr>3)
                {
                    JOptionPane.showMessageDialog(null, "Click On the title to begin", "Begin Here", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(MainWelcome.class.getResource("/droca/up1.png")));
                break;
                }
                    if(cntr>3 || cntr==-1)break;
                }
            
            }
    };
    Thread t = new Thread(runner, "Code Executer");
    t.start();
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        titleLable = new javax.swing.JLabel();
        imgLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        mainPanel.setBackground(new java.awt.Color(249, 191, 59));
        mainPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        titleLable.setBackground(new java.awt.Color(249, 191, 59));
        titleLable.setFont(new java.awt.Font("Agency FB", 1, 60)); // NOI18N
        titleLable.setText("Dynamic Ranking of Classification Algorithms");
        titleLable.setToolTipText("Click Here!");
        titleLable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleLableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                titleLableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                titleLableMouseExited(evt);
            }
        });
        titleLable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                titleLableMouseMoved(evt);
            }
        });

        imgLabel.setBackground(new java.awt.Color(249, 191, 59));
        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/droca/algos3.png"))); // NOI18N

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
                .addGap(171, 171, 171)
                .addComponent(imgLabel)
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(titleLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addComponent(titleLable)
                        .addGap(18, 18, 18))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(closeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(imgLabel)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void titleLableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLableMouseMoved

    }//GEN-LAST:event_titleLableMouseMoved

    private void titleLableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLableMouseClicked
        cntr=-1;
        this.setVisible(false);
        this.dispose();
         new LoginFrame().setVisible(true);
    }//GEN-LAST:event_titleLableMouseClicked

    private void titleLableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLableMouseEntered
        titleLable.setForeground(Color.RED);
    }//GEN-LAST:event_titleLableMouseEntered

    private void titleLableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLableMouseExited
         titleLable.setForeground(Color.BLACK);
    }//GEN-LAST:event_titleLableMouseExited

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
System.exit(0);
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
            java.util.logging.Logger.getLogger(MainWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWelcome().setVisible(true);
            }
        });
    }
int cntr=0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel titleLable;
    // End of variables declaration//GEN-END:variables
}
