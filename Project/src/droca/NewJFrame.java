
package droca;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.SimpleLogistic;
import weka.classifiers.lazy.IBk;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.meta.Bagging;
import weka.classifiers.meta.LogitBoost;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;

public class NewJFrame extends javax.swing.JFrame {
    static  float std=0;
    static  float kurt1=0;
    static  float skew1=0;
    static  double skewness=0;
    static  double kurtosis=0;
    private boolean closeFlag=true;
    int length;
    private int foundDid;
    static int knn_backup=1;
 static
    {
        try {
            Connection con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from classifier;");
            rs.last();
            classifierCnt=rs.getInt(1);
            rs = st.executeQuery("SELECT * from dataset;");
            if(rs.next())
            {
                rs.last();
                noOfDset = rs.getInt(1);
            }
            else noOfDset = 0;
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public NewJFrame(boolean isAdmin) {
        this.setUndecorated(true);
        initComponents();
        adminPanel.setVisible(isAdmin);
       jProgressBar1.setVisible(false);
    }

    public NewJFrame() {
        this.setUndecorated(true);
        initComponents();
      jProgressBar1.setVisible(false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        adminPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        appendButton = new javax.swing.JButton();
        addLabel = new javax.swing.JLabel();
        appendLabel = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        userPanel = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        precrecaccRBtn = new javax.swing.JRadioButton();
        recRBtn = new javax.swing.JRadioButton();
        acctimeRBtn = new javax.swing.JRadioButton();
        timeRBtn = new javax.swing.JRadioButton();
        precRBtn = new javax.swing.JRadioButton();
        chooseLabel = new javax.swing.JLabel();
        accRBtn = new javax.swing.JRadioButton();
        titleLabel = new javax.swing.JLabel();
        anotherButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        classifierButton = new javax.swing.JButton();
        datasetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(249, 191, 59));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        mainPanel.setBackground(new java.awt.Color(249, 191, 59));
        mainPanel.setMaximumSize(new java.awt.Dimension(1366, 768));
        mainPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        adminPanel.setBackground(new java.awt.Color(249, 191, 59));

        addButton.setBackground(new java.awt.Color(249, 191, 59));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/droca/add2.png"))); // NOI18N
        addButton.setToolTipText("Add Historical datasets");
        addButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addButton.setFocusable(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        appendButton.setBackground(new java.awt.Color(249, 191, 59));
        appendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/droca/append1.png"))); // NOI18N
        appendButton.setToolTipText("Append to Knowledge Base");
        appendButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        appendButton.setFocusable(false);
        appendButton.setPreferredSize(new java.awt.Dimension(59, 59));
        appendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appendButtonActionPerformed(evt);
            }
        });

        addLabel.setBackground(new java.awt.Color(249, 191, 59));
        addLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        addLabel.setText("ADD");
        addLabel.setFocusable(false);
        addLabel.setMaximumSize(new java.awt.Dimension(250, 20));

        appendLabel.setBackground(new java.awt.Color(249, 191, 59));
        appendLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        appendLabel.setText("APPEND");
        appendLabel.setFocusable(false);
        appendLabel.setMaximumSize(new java.awt.Dimension(250, 20));

        jProgressBar1.setFocusCycleRoot(true);
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(addLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(appendLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(appendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(appendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appendLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        userPanel.setBackground(new java.awt.Color(249, 191, 59));

        jButton3.setBackground(new java.awt.Color(249, 191, 59));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setText("Generate Ideal Ranking");
        jButton3.setToolTipText("Generate Ideal Ranking");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setEnabled(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        uploadButton.setBackground(new java.awt.Color(249, 191, 59));
        uploadButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        uploadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/droca/upload1.png"))); // NOI18N
        uploadButton.setToolTipText("Upload New Dataset");
        uploadButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        uploadButton.setFocusable(false);
        uploadButton.setMaximumSize(new java.awt.Dimension(102, 23));
        uploadButton.setMinimumSize(new java.awt.Dimension(102, 23));
        uploadButton.setPreferredSize(new java.awt.Dimension(102, 23));
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(249, 191, 59));
        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setText("5 fold - Generated Vs Ideal");
        jButton4.setToolTipText("Compare 5fold vs 10fold Cross - Validation");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setEnabled(false);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(249, 191, 59));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Generated Vs Ideal");
        jButton2.setToolTipText("Generated Vs Ideal");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setEnabled(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(249, 191, 59));
        jButton6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton6.setText("Accuracy Vs. Accuracy+Time");
        jButton6.setToolTipText("Accuracy Vs. Accuracy+Time");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setEnabled(false);
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(249, 191, 59));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("UPLOAD");
        jLabel5.setFocusable(false);
        jLabel5.setMaximumSize(new java.awt.Dimension(250, 20));

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, userPanelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3, jButton4});

        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        userPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3, jButton4});

        precrecaccRBtn.setBackground(new java.awt.Color(249, 191, 59));
        buttonGroup1.add(precrecaccRBtn);
        precrecaccRBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        precrecaccRBtn.setText("Accuracy, Precision & Recall");
        precrecaccRBtn.setFocusable(false);
        precrecaccRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precrecaccRBtnActionPerformed(evt);
            }
        });

        recRBtn.setBackground(new java.awt.Color(249, 191, 59));
        buttonGroup1.add(recRBtn);
        recRBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        recRBtn.setText("Recall");
        recRBtn.setFocusable(false);
        recRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recRBtnActionPerformed(evt);
            }
        });

        acctimeRBtn.setBackground(new java.awt.Color(249, 191, 59));
        buttonGroup1.add(acctimeRBtn);
        acctimeRBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        acctimeRBtn.setText("Accuracy and Time");
        acctimeRBtn.setFocusable(false);
        acctimeRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acctimeRBtnActionPerformed(evt);
            }
        });

        timeRBtn.setBackground(new java.awt.Color(249, 191, 59));
        buttonGroup1.add(timeRBtn);
        timeRBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        timeRBtn.setText("Execution Time");
        timeRBtn.setFocusable(false);
        timeRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeRBtnActionPerformed(evt);
            }
        });

        precRBtn.setBackground(new java.awt.Color(249, 191, 59));
        buttonGroup1.add(precRBtn);
        precRBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        precRBtn.setText("Precision");
        precRBtn.setFocusable(false);

        chooseLabel.setBackground(new java.awt.Color(249, 191, 59));
        chooseLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chooseLabel.setText("Choose ranking parameters as given below:");
        chooseLabel.setFocusable(false);
        chooseLabel.setMaximumSize(new java.awt.Dimension(250, 20));

        accRBtn.setBackground(new java.awt.Color(249, 191, 59));
        buttonGroup1.add(accRBtn);
        accRBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        accRBtn.setText("Accuracy");
        accRBtn.setFocusable(false);

        titleLabel.setBackground(new java.awt.Color(249, 191, 59));
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/droca/fulldroca3.png"))); // NOI18N
        titleLabel.setFocusable(false);

        anotherButton.setBackground(new java.awt.Color(249, 191, 59));
        anotherButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        anotherButton.setText("Upload Another Dataset");
        anotherButton.setToolTipText("Upload Another Dataset");
        anotherButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        anotherButton.setEnabled(false);
        anotherButton.setFocusable(false);
        anotherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anotherButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(249, 191, 59));
        logoutButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setToolTipText("Logout");
        logoutButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logoutButton.setFocusable(false);
        logoutButton.setPreferredSize(new java.awt.Dimension(141, 21));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        closeButton.setBackground(new java.awt.Color(255, 0, 0));
        closeButton.setText("X");
        closeButton.setToolTipText("Close");
        closeButton.setFocusable(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        classifierButton.setBackground(new java.awt.Color(249, 191, 59));
        classifierButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        classifierButton.setText("Display Available Classifiers");
        classifierButton.setToolTipText("Logout");
        classifierButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        classifierButton.setFocusable(false);
        classifierButton.setPreferredSize(new java.awt.Dimension(141, 21));
        classifierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classifierButtonActionPerformed(evt);
            }
        });

        datasetButton.setBackground(new java.awt.Color(249, 191, 59));
        datasetButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        datasetButton.setText("Display Historical Datasets");
        datasetButton.setToolTipText("Upload Another Dataset");
        datasetButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        datasetButton.setFocusable(false);
        datasetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datasetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(titleLabel)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(chooseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(adminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181)
                                .addComponent(closeButton)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(accRBtn)
                                    .addComponent(precRBtn)
                                    .addComponent(timeRBtn)
                                    .addComponent(recRBtn)
                                    .addComponent(acctimeRBtn)
                                    .addComponent(precrecaccRBtn))
                                .addGap(85, 85, 85))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(datasetButton)
                                .addGap(43, 43, 43)
                                .addComponent(classifierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(anotherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        mainPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {anotherButton, classifierButton, datasetButton});

        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(adminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(closeButton)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(chooseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(accRBtn)
                        .addGap(18, 18, 18)
                        .addComponent(timeRBtn)
                        .addGap(18, 18, 18)
                        .addComponent(precRBtn)
                        .addGap(18, 18, 18)
                        .addComponent(recRBtn)
                        .addGap(18, 18, 18)
                        .addComponent(acctimeRBtn)
                        .addGap(18, 18, 18)
                        .addComponent(precrecaccRBtn))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datasetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classifierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(anotherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(titleLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_uploadButtonActionPerformed
    if(closeFlag==false)
        JOptionPane.showMessageDialog(null, "Some Processes are still running\nPlease try again", "Cannot Upload now!", JOptionPane.ERROR_MESSAGE, null);
    else{
        closeFlag=false;
    if(accRBtn.isSelected() ||acctimeRBtn.isSelected() ||precRBtn.isSelected()||timeRBtn.isSelected()||recRBtn.isSelected()||precrecaccRBtn.isSelected())
    {    
        Connection con = null;
        ResultSet rs=null,rs1=null,rs2;
        Statement st=null,st1=null,st2;
        
        int algo[]=new int[classifierCnt];
        for(int n=0;n<classifierCnt;n++)algo[n]=n;
     
        if(acctimeRBtn.isSelected())//changed
        {
            String a=null;
            while (a==null)
            {
                a=JOptionPane.showInputDialog(null, "Choose the value that represents the amount of accuracy you are willing to trade for a 10 times speedup or slowdown. \nPermitted values -> ( 0.1 , 1 , 10 ) \nFor example, value = 10% means that the user is willing to trade 10% of accuracy for 10 times speedup/slowdown.", "Enter Compromise", JOptionPane.QUESTION_MESSAGE);
                
                try{
                
                if(a==null)
                {
                   closeFlag=true;
                   return;
                }
                accd=Float.parseFloat(a); //convert to int    
                if(accd==1||accd==10||accd==0.1f)
                {}
                else 
                {
                    JOptionPane.showMessageDialog(null, "Please select a value from the following\n( 0.1 , 1 , 10 )", "Invalid Value", JOptionPane.ERROR_MESSAGE);
                    a=null;
                }
                }catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Please select a value from the following\n( 0.1 , 1 , 10 )", "Invalid Value", JOptionPane.ERROR_MESSAGE);
                    a=null;
                }
            }
        }

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","arff");
        fileChooser.setFileFilter(filter);
        
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            file_upload = fileChooser.getSelectedFile();
            if(file_upload.toString().endsWith(".arff"))
            {
                if(file_upload.length() == 0)
                {
                    int dialogResult=JOptionPane.showConfirmDialog(null, "Empty arff file..Do you want to try again?","Warning",1);
                    if(dialogResult == JOptionPane.YES_OPTION)
                        uploadButtonActionPerformed(evt);
                }   
        
            try {
                con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
                st = con.createStatement();
                st1 = con.createStatement();
                rs = st.executeQuery("SELECT * from dataset;");
                rs.beforeFirst();
                flagUpload=false;
            while(rs.next())
            {
                if(rs.getString(2).equals(file_upload.getName().split(".arff")[0]))
                {
                    int temp=foundDid=Integer.parseInt(rs.getString(1));
                    if(accRBtn.isSelected())
                        rs1=st1.executeQuery("select * from sorted_best_acc where Did="+temp+"");
            //acc n time
                    else if(acctimeRBtn.isSelected())
                    {
                        if(NewJFrame.fold==10)
                        {
                            if(NewJFrame.accd==0.1f)
                            rs1=st1.executeQuery("select * from sorted_best_accd1 where Did="+temp+"");
                
                            else if(NewJFrame.accd==1)
                                rs1=st1.executeQuery("select * from sorted_best_accd2 where Did="+temp+"");

                            else if(NewJFrame.accd==10)
                                rs1=st1.executeQuery("select * from sorted_best_accd3 where Did="+temp+""); 
                        }
                    else if(NewJFrame.fold==5)
                        rs1=st1.executeQuery("select * from sorted_best5 where Did="+temp+"");
                    }
            //precision
                    else if(precRBtn.isSelected())
                        rs1=st1.executeQuery("select * from sorted_bestp where Did="+temp+"");
            
            //recall
                    else if(recRBtn.isSelected())
                        rs1=st1.executeQuery("select * from sorted_bestr where Did="+temp+"");

            //time
                    else if(timeRBtn.isSelected())
                        rs1=st1.executeQuery("select * from sorted_best_time where Did="+temp+"");
            
             //recall + precision + acc
                    else if(precrecaccRBtn.isSelected())
                        rs1=st1.executeQuery("select * from sorted_bestpra where Did="+temp+"");
                rs1.next();
                st2 = con.createStatement();
                rs2 = st2.executeQuery("select * from classifier;");
                int cnt=0;
                for(int i=0;i<classifierCnt;i++)
                {
                    rs2.beforeFirst();
                    while(rs2.next())
                    {
                        if(rs2.getInt(1)==Integer.parseInt(rs1.getString(i+2))+1)
                        {
                            if(NewJFrame.fold==10)
                            {
                                Knn.ranking[cnt][0]=cnt;
                                Knn.graph_val[cnt]=rs2.getInt(1)-1;
                                Knn.ranking[cnt][1]=rs2.getString(2);
                                Knn.ranking[cnt][2]=Knn.ranking[cnt][1];
                                
                                cnt++;
                            }
                        }
                    }    
                }
                flagUpload=true;
                Ranking r1 = new Ranking();
                r1.setVisible(false);
                uploadButton.setEnabled(false);
                jButton3.setEnabled(true);
                anotherButton.setEnabled(true);
                //jButton6.setEnabled(true);
                r1.setVisible(true);
                break;
                }
            }
              
            if(!flagUpload)
            {
                rs.last();
                PreparedStatement ps=con.prepareStatement("insert into dataset values(?,?)");
                ps.setString(1, rs.getRow()+1+"");
                ps.setString(2,file_upload.getName().split(".arff")[0]);
                ps.execute();
                characteristics(file_upload, false,false);
                Ranking r1 = new Ranking();
                uploadButton.setEnabled(false);
                jButton3.setEnabled(true);
                anotherButton.setEnabled(true);
                //jButton6.setEnabled(true);
                dbFunc();
                r1.setVisible(true);
            } 
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }     
        }
        else
        {
            int dialogResult=JOptionPane.showConfirmDialog(null, "Not an arff file..Do you want to try again?","Warning",1);
            if(dialogResult == JOptionPane.YES_OPTION)
                uploadButtonActionPerformed(evt);
        }
        }
        else 
            closeFlag=false;
        
    }
    
    else
        JOptionPane.showMessageDialog(null, "Please Select a ranking parameter first!", "Parameter not selected", JOptionPane.ERROR_MESSAGE, null);
    
    closeFlag=true;
    }
    }//GEN-LAST:event_uploadButtonActionPerformed
private void dbFunc()
{
    Runnable runner =new Runnable(){
        @Override
        public void run() 
        {
            idealFlag=true;
            addToDb(file_upload);
            arr();
            accuracy_1();
            precision_1();
            time_1();
            recall_1();
            prec_rec_acc_1();
            idealFlag=false;
        }
    };
    Thread t =new Thread(runner, "Code Executer");
    t.start();
}
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    if(closeFlag==false)
        JOptionPane.showMessageDialog(null, "Some Processes are still running\nPlease try again", "Cannot Close now", JOptionPane.INFORMATION_MESSAGE, null);
    else
    {
        closeFlag=false;
        Connection con;
        Statement st = null;
        ResultSet rs=null;
        int r=0;
        boolean emptyflag=false;
    
    int selectedVal=JOptionPane.showConfirmDialog(rootPane,"All Available data will be deleted!" ,"Are you sure?",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
    if(selectedVal==0)
    {
        try {
                Class.forName("java.sql.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        JFileChooser fchooser = new JFileChooser();
        fchooser.setMultiSelectionEnabled(true);
            
        if (fchooser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION)
        {
            closeFlag=true;
            return;
        }
        files = fchooser.getSelectedFiles();
                   
        try {
                con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
                st = con.createStatement();
                rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 0");
                rs = st.executeQuery("truncate dataset_table;");
                rs = st.executeQuery("truncate char_tab;");
                rs = st.executeQuery("truncate norm_tab;");
                rs = st.executeQuery("truncate dataset;");
                rs = st.executeQuery("truncate sorted_best_accd1;");
                rs = st.executeQuery("truncate sorted_best_accd2;");
                rs = st.executeQuery("truncate sorted_best_accd3;");
                rs = st.executeQuery("truncate sorted_best_acc;");
                rs = st.executeQuery("truncate sorted_best5;");
                rs = st.executeQuery("truncate sorted_bestp;");
                rs = st.executeQuery("truncate sorted_bestr;");
                rs = st.executeQuery("truncate sorted_bestpra;");
                rs = st.executeQuery("truncate sorted_best_time;");
                rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(DROCA.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
            
        if(fchooser.getSelectedFile().toString().endsWith(".arff"))
        {
            try {
                    con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
                    for(int i=0;i<files.length;i++)
                    {
                        emptyflag=false;
                        if(files[i].length() == 0)
                        {
                            emptyflag=true;
                            r++;
                            invalidFlag=true;
                        }
                        if(emptyflag!=true)
                        {
                            invalidFlag=false;
                            PreparedStatement ps=con.prepareStatement("insert into dataset values(?,?)");
                            ps.setString(1, (i+1-r)+"");
                            ps.setString(2,files[i].getName().split(".arff")[0]);
                            ps.execute();
                        }
                    }
                }
                 catch (SQLException ex) {
                    Logger lgr = Logger.getLogger(DROCA.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }
             
            func();
        }
        else
        {
            int dialogResult=JOptionPane.showConfirmDialog(null, "Not an arff file..Do you want to try again?","Warning",1);
            if(dialogResult == JOptionPane.YES_OPTION)
                addButtonActionPerformed(evt);
        }
    }
    //if user presses no            
        if(invalidFlag)
        {
            int dialogResult=JOptionPane.showConfirmDialog(null, "empty file! Do you want to try again?","Warning",1);
            if(dialogResult == JOptionPane.YES_OPTION)
                addButtonActionPerformed(evt);
        }
        closeFlag=true;
    }
    }//GEN-LAST:event_addButtonActionPerformed
        private void func()
        {
        Runnable runner = new Runnable(){
        @Override
        public void run() {
            closeFlag=false;
            jProgressBar1.setVisible(true);
            int no=files.length;
            for(int i=0;i<files.length;i++)
            {
                jProgressBar1.setValue(((int)(((i+1)*100)/no))-1);
                if(files[i].length() != 0)
                {
                    addToDb(files[i]);
                    characteristics(files[i], true,false);
                }
            }
            jProgressBar1.setValue(100);
            jProgressBar1.setVisible(false);
            if(invalidFlag!=true)
            {
                normal();
                arr();
                accuracy();
                precision();
                recall();
                time();
                prec_rec_acc();
            }
            closeFlag=true;
            }
    };
    Thread t = new Thread(runner, "Code Executer");
    t.start();
        }
   private void addToDb(File file1)
    {
    double diff=0,diff1=0,diff2=0,starttime,endtime,starttime1,endtime1,starttime2,endtime2;
    Connection con;
    Statement st;
    ResultSet rs;
    double acc=0;
    double acc2=0;
    double sumtp,sumtn,sumfp,sumfn;

    Instances tr;
    double accuracy,precision,recall;
    BufferedReader b;
try{
        String path1=file1.getPath();
        b=new BufferedReader(new FileReader(path1));
        tr  = new Instances (b);
        tr.setClassIndex(tr.numAttributes()-1);
        b.close();
        for(int i=0;i<classifierCnt;i++)
        {
            sumtp=sumtn=sumfp=0;
            sumfn=0;
            accuracy=precision=recall=0;
            switch(i)
            {
                case 0:
                NaiveBayes obj1=new NaiveBayes();
                starttime=System.currentTimeMillis();
                obj1.buildClassifier(tr);
                endtime=System.currentTimeMillis();
                Evaluation eval1= new Evaluation(tr);
                Evaluation eval11= new Evaluation(tr);
                starttime1=System.currentTimeMillis();
                eval1.crossValidateModel(obj1, tr, 5, new Random(1));
                endtime1=System.currentTimeMillis();
                diff1=endtime1-starttime1;
                acc2=eval1.pctCorrect();
                starttime2=System.currentTimeMillis();
                eval11.crossValidateModel(obj1, tr, 10, new Random(1));
                endtime2=System.currentTimeMillis();
                diff2=endtime2-starttime2;
                diff=endtime-starttime;
                for(int ii=0;ii<tr.numAttributes();ii++)
                {
                    sumtp+=eval11.numTruePositives(ii);
                    sumfn+=eval11.numFalseNegatives(ii);
                }
                precision=eval11.weightedPrecision();
                acc=eval11.pctCorrect();
                recall=sumtp/(sumtp+sumfn);
                break;
                    
                case 1:
                SimpleLogistic obj13=new SimpleLogistic();
                starttime=System.currentTimeMillis();
                obj13.buildClassifier(tr);
                endtime=System.currentTimeMillis();
                Evaluation eval33= new Evaluation(tr);
                Evaluation eval23= new Evaluation(tr);
                starttime1=System.currentTimeMillis();
                eval33.crossValidateModel(obj13, tr, 5, new Random(1));
                endtime1=System.currentTimeMillis();
                diff1=endtime1-starttime1;
                acc2=eval33.pctCorrect();
                starttime2=System.currentTimeMillis();
                eval23.crossValidateModel(obj13, tr, 10, new Random(1));
                endtime2=System.currentTimeMillis();
                diff2=endtime2-starttime2;
                diff=endtime-starttime;
                precision=eval23.weightedPrecision();
                for(int ii=0;ii<tr.numAttributes();ii++)
                {
                    sumtp+=eval23.numTruePositives(ii);
                    sumfn+=eval23.numFalseNegatives(ii);
                }
                recall=sumtp/(sumtp+sumfn);
                acc=eval23.pctCorrect();
                break;

                case 2:
                SMO  obj9=new SMO();
                starttime=System.currentTimeMillis();
                obj9.buildClassifier(tr);
                endtime=System.currentTimeMillis();
                Evaluation eval9= new Evaluation(tr);
                Evaluation eval19= new Evaluation(tr);
                starttime1=System.currentTimeMillis();
                eval9.crossValidateModel(obj9, tr, 5, new Random(1));
                endtime1=System.currentTimeMillis();
                diff1=endtime1-starttime1;
                acc2=eval9.pctCorrect();
                starttime2=System.currentTimeMillis();
                eval19.crossValidateModel(obj9, tr, 10, new Random(1));
                endtime2=System.currentTimeMillis();
                diff2=endtime2-starttime2;
                diff=endtime-starttime;
                precision=eval19.weightedPrecision();
                for(int ii=0;ii<tr.numAttributes();ii++)
                {
                    sumtp+=eval19.numTruePositives(ii);
                    sumfn+=eval19.numFalseNegatives(ii);
                }
                recall=sumtp/(sumtp+sumfn);
                acc=eval19.pctCorrect();
                break;

                case 3:
                IBk obj2=new IBk();
                starttime=System.currentTimeMillis();
                obj2.buildClassifier(tr);
                endtime=System.currentTimeMillis();
                Evaluation eval2= new Evaluation(tr);
                Evaluation eval12= new Evaluation(tr);
                starttime1=System.currentTimeMillis();
                eval2.crossValidateModel(obj2, tr, 5, new Random(1));
                endtime1=System.currentTimeMillis();
                diff1=endtime1-starttime1;
                acc2=eval2.pctCorrect();
                starttime2=System.currentTimeMillis();
                eval12.crossValidateModel(obj2, tr, 10, new Random(1));
                endtime2=System.currentTimeMillis();
                diff2=endtime2-starttime2;
                diff=endtime-starttime;
                precision=eval12.weightedPrecision();
                 for(int ii=0;ii<tr.numAttributes();ii++)
                {
                    sumtp+=eval12.numTruePositives(ii);
                    sumfn+=eval12.numFalseNegatives(ii);
                }
                recall=sumtp/(sumtp+sumfn);
                acc=eval12.pctCorrect();
                break;
                case 4:
                AdaBoostM1 obj4=new AdaBoostM1();
                starttime=System.currentTimeMillis();
                obj4.buildClassifier(tr);
                endtime=System.currentTimeMillis();
                Evaluation eval4= new Evaluation(tr);
                Evaluation eval14= new Evaluation(tr);
                starttime1=System.currentTimeMillis();
                eval4.crossValidateModel(obj4, tr, 5, new Random(1));
                endtime1=System.currentTimeMillis();
                diff1=endtime1-starttime1;
                acc2=eval4.pctCorrect();
                starttime2=System.currentTimeMillis();
                eval14.crossValidateModel(obj4, tr, 10, new Random(1));
                endtime2=System.currentTimeMillis();
                diff2=endtime2-starttime2;
                diff=endtime-starttime;
                precision=eval14.weightedPrecision();
                for(int ii=0;ii<tr.numAttributes();ii++)
                {
                    sumtp+=eval14.numTruePositives(ii);
                    sumfn+=eval14.numFalseNegatives(ii);
                }
                recall=sumtp/(sumtp+sumfn);
                acc=eval14.pctCorrect();
                break;

                case 5:
                LogitBoost obj5=new LogitBoost();
                starttime=System.currentTimeMillis();
                obj5.buildClassifier(tr);
                endtime=System.currentTimeMillis();
                Evaluation eval5= new Evaluation(tr);
                Evaluation eval15= new Evaluation(tr);
                starttime1=System.currentTimeMillis();
                eval5.crossValidateModel(obj5, tr, 5, new Random(1));
                endtime1=System.currentTimeMillis();
                diff1=endtime1-starttime1;
                acc2=eval5.pctCorrect();
                starttime2=System.currentTimeMillis();
                eval15.crossValidateModel(obj5, tr, 10, new Random(1));
                endtime2=System.currentTimeMillis();
                diff2=endtime2-starttime2;
                diff=endtime-starttime;
                precision=eval15.weightedPrecision();
                for(int ii=0;ii<tr.numAttributes();ii++)
                {
                    sumtp+=eval15.numTruePositives(ii);
                    sumfn+=eval15.numFalseNegatives(ii);
                }
                recall=sumtp/(sumtp+sumfn);
                acc=eval15.pctCorrect();
                break;

                case 6:
                PART obj6=new PART();
                starttime=System.currentTimeMillis();
                obj6.buildClassifier(tr);
                endtime=System.currentTimeMillis();
                Evaluation eval6= new Evaluation(tr);
                Evaluation eval16= new Evaluation(tr);
                starttime1=System.currentTimeMillis();
                eval6.crossValidateModel(obj6, tr, 5, new Random(1));
                endtime1=System.currentTimeMillis();
                diff1=endtime1-starttime1;
                acc2=eval6.pctCorrect();
                starttime2=System.currentTimeMillis();
                eval16.crossValidateModel(obj6, tr, 10, new Random(1));
                endtime2=System.currentTimeMillis();
                diff2=endtime2-starttime2;
                diff=endtime-starttime;
                precision=eval16.weightedPrecision();
                for(int ii=0;ii<tr.numAttributes();ii++)
                {
                    sumtp+=eval16.numTruePositives(ii);
                    sumfn+=eval16.numFalseNegatives(ii);
                }
                recall=sumtp/(sumtp+sumfn);
                acc=eval16.pctCorrect();
                break;

                case 7:
                J48 obj3=new J48();
                starttime=System.currentTimeMillis();
                obj3.buildClassifier(tr);
                endtime=System.currentTimeMillis();
                Evaluation eval3= new Evaluation(tr);
                Evaluation eval13= new Evaluation(tr);
                starttime1=System.currentTimeMillis();
                eval3.crossValidateModel(obj3, tr, 5, new Random(1));
                endtime1=System.currentTimeMillis();
                diff1=endtime1-starttime1;
                acc2=eval3.pctCorrect();
                starttime2=System.currentTimeMillis();
                eval13.crossValidateModel(obj3, tr, 10, new Random(1));
                endtime2=System.currentTimeMillis();
                diff2=endtime2-starttime2;
                diff=endtime-starttime;
                precision=eval13.weightedPrecision();
                for(int ii=0;ii<tr.numAttributes();ii++)
                {
                    sumtp+=eval13.numTruePositives(ii);
                    sumfn+=eval13.numFalseNegatives(ii);
                }
                recall=sumtp/(sumtp+sumfn);
                acc=eval13.pctCorrect();
                break;
        
        
        case 8:  
         try {
                RandomForest obj7=new RandomForest();
                con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
                st = con.createStatement();
                obj7.buildClassifier(tr);
                Evaluation eval17= new Evaluation(tr);
                eval17.crossValidateModel(obj7, tr, 10, new Random(1));
                rs = st.executeQuery("SELECT * from RF_table where Dname='"+file1.getName().split(".arff")[0]+"'");
                rs.next();
                acc=Double.parseDouble(rs.getString(2));
                acc2=Double.parseDouble(rs.getString(3));
                precision=Double.parseDouble(rs.getString(4));
                for(int ii=0;ii<tr.numAttributes();ii++)
                {
                        sumtp+=eval17.numTruePositives(ii);
                        sumfn+=eval17.numFalseNegatives(ii);
                }
                recall=sumtp/(sumtp+sumfn);
            }
            catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        break;
        
    case 9:
        Bagging obj8=new Bagging();
        starttime=System.currentTimeMillis();
        obj8.buildClassifier(tr);
        endtime=System.currentTimeMillis();
        Evaluation eval8= new Evaluation(tr);
        Evaluation eval18= new Evaluation(tr);
        starttime1=System.currentTimeMillis();
        eval8.crossValidateModel(obj8, tr, 5, new Random(1));
        acc2=eval8.pctCorrect();
        endtime1=System.currentTimeMillis();
        diff1=endtime1-starttime1;
        starttime2=System.currentTimeMillis();
        eval18.crossValidateModel(obj8, tr, 10, new Random(1));
        endtime2=System.currentTimeMillis();
        diff2=endtime2-starttime2;
        diff=endtime-starttime;
        precision=eval18.weightedPrecision();
        for(int ii=0;ii<tr.numAttributes();ii++)
        {
            sumtp+=eval18.numTruePositives(ii);
            sumfn+=eval18.numFalseNegatives(ii);
        }
        recall=sumtp/(sumtp+sumfn);
        acc=eval18.pctCorrect();
        break;
      
        }
        try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT did from dataset where name='"+file1.getName().split(".arff")[0]+"'");
            rs.next();
            String did= rs.getString(1);
            PreparedStatement ps=con.prepareStatement("insert into dataset_table values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1,did);
            ps.setString(2,i+1+"");
            ps.setString(3,Double.toString(acc));
            ps.setString(4,Double.toString(precision));
            ps.setString(5,Double.toString(recall));
            if(diff!=0)
                ps.setDouble(6,diff/1000);
            else
                ps.setDouble(6,0.001);
            if(diff1!=0)
                ps.setDouble(7,diff1/1000);
            else
                ps.setDouble(7,0.001);
            if(diff2!=0)
                ps.setDouble(8,diff2/1000);
            else
                ps.setDouble(8,0.001);
                
            ps.setString(9,Double.toString(acc2));
            ps.execute();
            }
        catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
} 
    } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
 
   private void time()
    {
        Connection con = null;
        Statement st = null;
        Statement st2 = null;
        Statement st3 = null;
        Statement st1 = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3=null;
        PreparedStatement ps=null;
        try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
            rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 0");
            rs = st.executeQuery("truncate sorted_best_time;");
            rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
            con.close();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        try {
            int i=0,k=1,j,t2=0;
            int index[]=new int[classifierCnt];
            double t1=0;
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
            rs=  st.executeQuery("SELECT * FROM dataset_table");
            rs.beforeFirst();
          
        while(rs.next())
        {
            time[i++]=Double.parseDouble(rs.getString(6))+Double.parseDouble(rs.getString(8));
            if(i==classifierCnt)
            {
                for(int pp=0;pp<classifierCnt;pp++)
                index[pp]=pp;
                for(i=0; i<classifierCnt; i++)
                {
                    for(j=1; j<classifierCnt; j++)
                    {
                        if(time[j-1] > time[j])
                        {
                            t1 = time[j-1];
                            time[j-1]=time[j];
                            time[j]=t1;

                            t2 = index[j-1];
                            index[j-1]=index[j];
                            index[j]=t2;
                        }
                    }
                }
                
            ps=con.prepareStatement("insert into sorted_best_time values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,k+"");
            for(i=0,j=2;i<classifierCnt;i++,j++)
                ps.setString(j,(index[i])+"");
            ps.execute();
            k++;
            j=0;
            i=0;
            }
        }
        con.close();
        }
        catch (SQLException | NumberFormatException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    private void time_1()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps=null;
        
        try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
            int i=0,k=1,id,t2=0,j;
            double t1=0;
            int index[]=new int[classifierCnt];
        
            rs=  st.executeQuery("SELECT * FROM dataset_table");
            rs.last();
            id=rs.getInt(1);
            rs.absolute(rs.getRow()-classifierCnt);
            
        for(int pp=0;pp<classifierCnt;pp++)
            index[pp]=pp;
              
        while(rs.next())
            time[i++]=Double.parseDouble(rs.getString(6))+Double.parseDouble(rs.getString(8));
        
        for(i=0; i<classifierCnt; i++)
        {
            for(j=1; j<classifierCnt; j++)
            {
                if(time[j-1] > time[j])
                {
                    t1 = time[j-1];
                    time[j-1]=time[j];
                    time[j]=t1;

                    t2 = index[j-1];
                    index[j-1]=index[j];
                    index[j]=t2;
                }
            }
        }
            ps=con.prepareStatement("insert into sorted_best_time values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,id+"");
            for(i=0,j=2;i<classifierCnt;i++,j++)  
                ps.setString(j,(index[i])+"");
            ps.execute();
            con.close();
        }
        catch (SQLException | NumberFormatException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    private void prec_rec_acc()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps=null;
        try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
            rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 0");
            rs = st.executeQuery("truncate sorted_bestpra;");
            rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
            con.close();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
            
            int i=0,j,t2=0,k=1;
            double t1=0;
            int index[]=new int[classifierCnt];
            rs=  st.executeQuery("SELECT * FROM dataset_table");
            rs.beforeFirst();
          
        while(rs.next())
        {
            acc[i]=Double.parseDouble(rs.getString(3));
            rec[i]=Double.parseDouble(rs.getString(5));
            pre[i]=Double.parseDouble(rs.getString(4));
            precRecAcc[i]=(acc[i]/100)+pre[i]+rec[i];
            i++;
            if(i==classifierCnt)
            {
        for(int pp=0;pp<classifierCnt;pp++)
            index[pp]=pp;
        
        for(i=0; i<classifierCnt; i++)
        {
            for(j=1; j<classifierCnt; j++)
            {
                if(precRecAcc[j-1] <= precRecAcc[j])
                {
                    t1 = precRecAcc[j-1];
                    precRecAcc[j-1]=precRecAcc[j];
                    precRecAcc[j]=t1;
                    
                    t2 = index[j-1];
                    index[j-1]=index[j];
                    index[j]=t2;
                }
            }
        }   
        
            ps=con.prepareStatement("insert into sorted_bestpra values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,k+"");
            for(i=0,j=2;i<classifierCnt;i++,j++)
                ps.setString(j,(index[i])+"");
            ps.execute();
            k++;
            j=0;
            i=0;
        }
        }
        con.close(); }
        catch (SQLException | NumberFormatException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    private void prec_rec_acc_1()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps=null;
        
        try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
           
            int i=0,id,k=1,j,t2=0;
            double t1=0;
            int index[]=new int[classifierCnt];
            rs=  st.executeQuery("SELECT * FROM dataset_table");
            rs.last();
            id=rs.getInt(1);
            rs.absolute(rs.getRow()-classifierCnt);
          
        for(int pp=0;pp<classifierCnt;pp++)
            index[pp]=pp;
      
        while(rs.next())
        {
            acc[i]=Double.parseDouble(rs.getString(3));
            rec[i]=Double.parseDouble(rs.getString(5));
            pre[i]=Double.parseDouble(rs.getString(4));
            precRecAcc[i]=(acc[i]/100)+pre[i]+rec[i];
            i++;
        }
        for(i=0; i<classifierCnt; i++)
        {
            for(j=1; j<classifierCnt; j++)
            {
                if(precRecAcc[j-1] <= precRecAcc[j])
                {
                    t1 = precRecAcc[j-1];
                    precRecAcc[j-1]=precRecAcc[j];
                    precRecAcc[j]=t1;

                    t2 = index[j-1];
                    index[j-1]=index[j];
                    index[j]=t2;
                }
            }
        }
       
            ps=con.prepareStatement("insert into sorted_bestpra values(?,?,?,?,?,?,?,?,?,?,?)");  
            ps.setString(1,id+"");
            for(i=0,j=2;i<classifierCnt;i++,j++)    
                ps.setString(j,(index[i])+"");
            ps.execute();
              con.close(); }
        catch (SQLException | NumberFormatException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    private void accuracy()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps=null;
        try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();

            rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 0");
           rs = st.executeQuery("truncate sorted_best_acc;");
            rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
            con.close();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
            
            int i=0,k=1,j,t2=0;
            double t1=0;
            int index[]=new int[classifierCnt];
            rs=  st.executeQuery("SELECT * FROM dataset_table");
            rs.beforeFirst();

            while(rs.next())
            {
                acc[i++]=Double.parseDouble(rs.getString(3));
                if(i==classifierCnt)
                {
                    for(int pp=0;pp<classifierCnt;pp++)
                        index[pp]=pp;
       
                    for(i=0; i<classifierCnt; i++)
                    {
                        for(j=0; j<classifierCnt-1; j++)
                        {
                            if(acc[j] <= acc[j+1])
                            {
                                t1 = acc[j+1];
                                acc[j+1]=acc[j];
                                acc[j]=t1;

                                t2 = index[j+1];
                                index[j+1]=index[j];
                                index[j]=t2;
                            }
                        }
                    }
                    ps=con.prepareStatement("insert into sorted_best_acc values(?,?,?,?,?,?,?,?,?,?,?)");
                    ps.setString(1,k+"");
                    for(i=0,j=2;i<classifierCnt;i++,j++)
                    ps.setString(j,(index[i])+"");
                    ps.execute();
                    k++;
                    j=0;
                    i=0;
                }
            }
            con.close();      
        }
        catch (SQLException | NumberFormatException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
private void accuracy_1()
{
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps=null;
        
    try {
        con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
        st = con.createStatement();
           
        int i=0,id,k=1,j,t2=0;
        double t1=0;
        int index[]=new int[classifierCnt];
        rs=  st.executeQuery("SELECT * FROM dataset_table");
        
        rs.last();
        id=rs.getInt(1);
        rs.absolute(rs.getRow()-classifierCnt);
          
        for(int pp=0;pp<classifierCnt;pp++)
            index[pp]=pp;
        
        while(rs.next())
            acc[i++]=Double.parseDouble(rs.getString(3));
        
        for(i=0; i<classifierCnt; i++)
        {
            for(j=0; j<classifierCnt-1; j++)
            {
                if(acc[j] <= acc[j+1])
                {
                    t1 = acc[j+1];
                    acc[j+1]=acc[j];
                    acc[j]=t1;

                    t2 = index[j+1];
                    index[j+1]=index[j];
                    index[j]=t2;
                }
            }
        }
        ps=con.prepareStatement("insert into sorted_best_acc values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,id+"");
        for(i=0,j=2;i<classifierCnt;i++,j++)  
            ps.setString(j,(index[i])+"");
        ps.execute();
        con.close();   
    }
    catch (SQLException | NumberFormatException ex) {
        Logger lgr = Logger.getLogger(DROCA.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
    }
}
    
private void precision()
{
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    PreparedStatement ps=null;
    try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
            rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 0");
            rs = st.executeQuery("truncate sorted_bestp;");
            rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
            con.close();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
            int i=0,k=1,t2=0,j;
            double t1=0;
            int index[]=new int[classifierCnt];
            rs=  st.executeQuery("SELECT * FROM dataset_table");
            rs.beforeFirst();
          
            while(rs.next())
            {
                pre[i++]=Double.parseDouble(rs.getString(4));
                if(i==classifierCnt)
                {
                    for(int pp=0;pp<classifierCnt;pp++)
                    index[pp]=pp;
        
                    for(i=0; i<classifierCnt; i++)
                    {
                    for(j=0; j<classifierCnt-1; j++)
                    {
                        if(pre[j] <= pre[j+1])
                        {
                            t1 = pre[j];
                            pre[j]=pre[j+1];
                            pre[j+1]=t1;

                            t2 = index[j];
                            index[j]=index[j+1];
                            index[j+1]=t2;
                        }
                    }
            }
            ps=con.prepareStatement("insert into sorted_bestp values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,k+"");
            for(i=0,j=2;i<classifierCnt;i++,j++)
            ps.setString(j,(index[i])+"");
            ps.execute();
            k++;
            j=0;
            i=0;
        }
        }
        con.close();  
    }
    catch (SQLException | NumberFormatException ex) {
        Logger lgr = Logger.getLogger(DROCA.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
    }
}
    
private void precision_1()
{
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps=null;
        
    try {
        con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
        st = con.createStatement();
           
        int i=0,id,k=1,j,t2=0;
        double t1=0;
        int index[]=new int[classifierCnt];
            
        rs=  st.executeQuery("SELECT * FROM dataset_table");
        rs.last();
        id=rs.getInt(1);
        rs.absolute(rs.getRow()-classifierCnt);
          
        for(int pp=0;pp<classifierCnt;pp++)
            index[pp]=pp;
        
        while(rs.next())
            pre[i++]=Double.parseDouble(rs.getString(4));
        
        for(i=0; i<classifierCnt; i++)
        {
            for(j=0; j<classifierCnt-1; j++)
            {
                if(pre[j] <= pre[j+1])
                {
                    t1 = pre[j];
                    pre[j]=pre[j+1];
                    pre[j+1]=t1;

                    t2 = index[j];
                    index[j]=index[j+1];
                    index[j+1]=t2;
                }
            }
        }
        ps=con.prepareStatement("insert into sorted_bestp values(?,?,?,?,?,?,?,?,?,?,?)");       
        ps.setString(1,id+"");
        for(i=0,j=2;i<classifierCnt;i++,j++)
            ps.setString(j,(index[i])+"");
        ps.execute();
        con.close();
        }
        catch (SQLException | NumberFormatException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
}
    
private void recall()
{
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps=null;
    try {
        con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
        st = con.createStatement();
        rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 0");
        rs = st.executeQuery("truncate sorted_bestr;");
        rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
        con.close();
        } 
        catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        try{
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
            double acc[]=new double[classifierCnt];
            int i=0,k=1,j,t2=0;
            double t1=0;
            int index[]=new int[classifierCnt];
            rs=  st.executeQuery("SELECT * FROM dataset_table");
            rs.beforeFirst();
      
            while(rs.next())
            {   
                rec[i++]=Double.parseDouble(rs.getString(5));
                if(i==classifierCnt)
                {
                    for(int pp=0;pp<classifierCnt;pp++)
                        index[pp]=pp;
        
                    for(i=0; i<classifierCnt; i++)
                    {
                        for(j=0; j<classifierCnt-1; j++)
                        {
                            if(rec[j] <= rec[j+1])
                            {
                                t1 = rec[j];
                                rec[j]=rec[j+1];
                                rec[j+1]=t1;

                                t2 = index[j];
                                index[j]=index[j+1];
                                index[j+1]=t2;
                            }   
                        }
                    }
                    ps=con.prepareStatement("insert into sorted_bestr values(?,?,?,?,?,?,?,?,?,?,?)"); 
                    ps.setString(1,k+"");
                    for(i=0,j=2;i<classifierCnt;i++,j++)
                        ps.setString(j,(index[i])+"");
                    ps.execute();
                    k++;
                    j=0;
                    i=0;
                }
            }
            con.close();       
        }
    catch (SQLException | NumberFormatException ex) {
    Logger lgr = Logger.getLogger(DROCA.class.getName());
    lgr.log(Level.SEVERE, ex.getMessage(), ex);
    }
}
    
private void recall_1()
{
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps=null;
        
    try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
           
            int i=0,id,k=1,t2=0,j;
            double t1=0;
            int index[]=new int[classifierCnt];
            rs=st.executeQuery("SELECT * FROM dataset_table");
        
            rs.last();
            id=rs.getInt(1);
            rs.absolute(rs.getRow()-classifierCnt);
          
            for(int pp=0;pp<classifierCnt;pp++)
                index[pp]=pp;
        
            while(rs.next())
                rec[i++]=Double.parseDouble(rs.getString(5));
        
            for(i=0; i<classifierCnt; i++)
            {
                for(j=0; j<classifierCnt-1; j++)
                {
                    if(rec[j] <= rec[j+1])
                    {
                        t1 = rec[j];
                        rec[j]=rec[j+1];
                        rec[j+1]=t1;

                        t2 = index[j];
                        index[j]=index[j+1];
                        index[j+1]=t2;
                    }
                }
            }
            ps=con.prepareStatement("insert into sorted_bestr values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,id+"");
            for(i=0,j=2;i<classifierCnt;i++,j++)   
                ps.setString(j,(index[i])+"");
            ps.execute();
            con.close(); 
        }
        catch (SQLException | NumberFormatException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
}
    
private void arr()
{
    Connection con = null;
    Statement st = null;
    Statement st2 = null;
    Statement st3 = null;
    Statement st4=null;
    Statement st1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
      
    ResultSet rs3=null;
    ResultSet rs4=null;
    int cnt = 0,j=0,i,k=1,did;
    double mean1,mean2,mean3;
    float temptime2 = 0,tempacc=0,temptime = 0,accratio = 0,timeratio,arr1,arr2,arr3;
       
    try {
        con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
        st = con.createStatement();

        rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 0");
        if(fold==10)
        {
            rs = st.executeQuery("truncate sorted_best_accd1;");
            rs = st.executeQuery("truncate sorted_best_accd2;");
            rs = st.executeQuery("truncate sorted_best_accd3;");
        }
        if(fold==5)
            rs = st.executeQuery("truncate sorted_best5;");

        rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
        con.close();
    } 
    catch (SQLException ex) {
        Logger lgr = Logger.getLogger(DROCA.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
    }
        
    double gm1=0,sum1=0;
    double gm2=0,sum2=0;
    double gm3=0,sum3=0;

    try {
        con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
        st = con.createStatement();
        st1 = con.createStatement();
        st2 = con.createStatement();
        st3 = con.createStatement();
        st4 = con.createStatement();

        rs = st.executeQuery("SELECT * from dataset;");
        rs.last();
        noOfDset = rs.getInt(1);
        rs1 = st1.executeQuery("SELECT * from dataset_table;");
        rs3 = st3.executeQuery("SELECT * from dataset_table;");
        rs4=st4.executeQuery("SELECT * from dataset_table;");
         
        rs3.first();
        do//every record
        {
            sum1=sum2=sum3=0;
            i=1;
         
            did=Integer.parseInt(rs3.getString(1));
            if(fold==10)
            {
                tempacc=Float.parseFloat(rs3.getString(3));
                temptime=Float.parseFloat(rs3.getString(6))+Float.parseFloat(rs3.getString(8));
            }
            if(fold==5)
            {
                tempacc=Float.parseFloat(rs3.getString(9));
                temptime=Float.parseFloat(rs3.getString(6))+Float.parseFloat(rs3.getString(7));
            }
            rs4.absolute(rs3.getRow());
            rs1.beforeFirst();
            while(rs1.next())//classifiers
            {
                arr1=arr2=arr3=1;
                if(fold==10)
                {
                    tempacc=Float.parseFloat(rs4.getString(3));
                    temptime=Float.parseFloat(rs4.getString(6))+Float.parseFloat(rs4.getString(8));
                }
                if(fold==5)
                {
                    tempacc=Float.parseFloat(rs4.getString(9));
                    temptime = Float.parseFloat(rs1.getString(6))+Float.parseFloat(rs1.getString(7));
                }
            
                if(rs1.getInt(1)==rs3.getInt(1) && rs1.getInt(2)==rs3.getInt(2))
                {}
                else
                {
                    cnt=0;
                    while(rs1.absolute(i) && rs4.absolute(i) && cnt<noOfDset)//single algo on all dsets
                    {  
                        if(fold==10)
                            temptime2 = Float.parseFloat(rs1.getString(6))+Float.parseFloat(rs1.getString(8));
                        if(fold==5)
                            temptime2 = Float.parseFloat(rs1.getString(6))+Float.parseFloat(rs1.getString(7));
                        if(fold==10)
                            accratio=(tempacc/Float.parseFloat(rs1.getString(3)));
                        if(fold==5)
                            accratio=(tempacc/Float.parseFloat(rs1.getString(9)));
                        timeratio=(temptime/temptime2);
                        arr1*=accratio/(1+0.1*(Math.log(timeratio)));
                        arr2*=accratio/(1+1*(Math.log(timeratio)));
                        arr3*=accratio/(1+10*(Math.log(timeratio)));
                        i+=classifierCnt;
                        cnt++;
                    }
           
                    double temp1=(1/(double)noOfDset);
        
                    gm1=Math.pow(Math.abs(arr1),temp1);
                    gm2=Math.pow(Math.abs(arr2),temp1);
                    gm3=Math.pow(Math.abs(arr3),temp1);
                    sum1=sum1+gm1;
                    sum2=sum2+gm2;
                    sum3=sum3+gm3;
            }
         }
        
        mean1= sum1/classifierCnt;
        mean2= sum2/classifierCnt;
        mean3= sum3/classifierCnt;
        rank1[j]=mean1;
        rank2[j]=mean2;
        rank3[j]=mean3;
        j++;

        if(j%classifierCnt==0)
        {
            double temp1=0;
            int temp2=0;
            j=0;
            for( i=0;i<classifierCnt;i++)
                pr1[i]=pr2[i]=pr3[i]=i;
            
            for( i = 0; i < classifierCnt; i++)
            {   
                for(int q = 0; q < classifierCnt-1; q++)
                {
                    if(rank1[q] > rank1[q+1])
                    {
                        temp1 = rank1[q+1];
                        rank1[q+1]=rank1[q];
                        rank1[q]=temp1;
                    
                        temp2 = pr1[q+1];
                        pr1[q+1]=pr1[q];
                        pr1[q]= temp2;
                    }
                    
                    if(rank2[q] > rank2[q+1])
                    {
                        temp1 = rank2[q+1];
                        rank2[q+1]=rank2[q];
                        rank2[q]=temp1;
                    
                        temp2 = pr2[q+1];
                        pr2[q+1]=pr2[q];
                        pr2[q]= temp2;
                    }
                    if(rank3[q] > rank3[q+1])
                    {
                        temp1 = rank3[q+1];
                        rank3[q+1]=rank3[q];
                        rank3[q]=temp1;

                        temp2 = pr3[q+1];
                        pr3[q+1]=pr3[q];
                        pr3[q]= temp2;
                    }
                }
            }
            try {
            if(fold==10)
            {
                PreparedStatement ps1=con.prepareStatement("insert into sorted_best_accd1 values(?,?,?,?,?,?,?,?,?,?,?)");
                PreparedStatement ps2=con.prepareStatement("insert into sorted_best_accd2 values(?,?,?,?,?,?,?,?,?,?,?)");
                PreparedStatement ps3=con.prepareStatement("insert into sorted_best_accd3 values(?,?,?,?,?,?,?,?,?,?,?)");
           
                ps1.setString(1,k+"");
                ps2.setString(1,k+"");
                ps3.setString(1,k+"");
                for(i=0,j=2;i<classifierCnt;i++,j++)
                {
                    ps1.setString(j,pr1[i]+"");
                    ps2.setString(j,pr2[i]+"");
                    ps3.setString(j,pr3[i]+"");
                }
            
                ps1.execute();
                ps2.execute();
                ps3.execute();
                k++;
                j=0;
            }
          
            else if(fold==5)
            {
                PreparedStatement ps1=con.prepareStatement("insert into sorted_best5 values(?,?,?,?,?,?,?,?,?,?,?)");  
                ps1.setString(1,k+"");
                for(i=0,j=2;i<classifierCnt;i++,j++)
                ps1.setString(j,pr2[i]+"");
            
                ps1.execute();
                k++;
                j=0;
            }
        }
        catch (SQLException | NumberFormatException ex) {
        Logger lgr = Logger.getLogger(DROCA.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        }  
        }while (rs3.next());
        con.close();
        }
        catch (SQLException | NumberFormatException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
}
private void func_append()
{
    Runnable runner = new Runnable(){
    @Override
    public void run() {
    closeFlag=false;
    jProgressBar1.setVisible(true);
    int no=files.length;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    int flag=0,emptyflag=0,r=0,c1=0,c2=0;
    try {
        con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
        st = con.createStatement();
        rs = st.executeQuery("SELECT * from dataset;");
   
        for(int i=0;i<files.length;i++)
        {
            emptyflag=0;
            if(files[i].length() == 0)
            {
                c1++;
                c2=1;
                emptyflag=1;
            }
            if(emptyflag!=1)
            {
                c2=0;
                rs.beforeFirst();
                flag=0;
                while(rs.next())
                {
                    if(rs.getString(2).equals(files[i].getName().split(".arff")[0]))
                    {
                        flag=1;
                        r++;
                        break;
                    }
                }
                if(flag!=1)
                {
                    jProgressBar1.setValue(((int)(((i+1)*100)/no))-1);
                    rs.last();
                    PreparedStatement ps=con.prepareStatement("insert into dataset values(?,?)");
                    ps.setString(1, (rs.getRow()+1+i-r-c1)+"");
          
                    ps.setString(2,files[i].getName().split(".arff")[0]);
                    ps.execute();
                    addToDb(files[i]);
                    characteristics(files[i], true,false);
                }
            }
        }
        jProgressBar1.setValue(100);
        jProgressBar1.setVisible(false);
        normal();
        arr();
        accuracy();
        precision();
        recall();
        time();
        prec_rec_acc();
        rs.close();
        closeFlag=true;
    } 
    catch (SQLException ex) {
        Logger lgr = Logger.getLogger(DROCA.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
        closeFlag=true;   
    }
    }
    };
    Thread t = new Thread(runner, "Code Executer");
    t.start();
}
 
    private void appendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appendButtonActionPerformed
    if(closeFlag==false)
        JOptionPane.showMessageDialog(null, "Some Processes are still running\nPlease try again", "Cannot Close now", JOptionPane.INFORMATION_MESSAGE, null);
    else{
        closeFlag=false;
        try {        
            Class.forName("java.sql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }	
        
        int c2=0;
        
        JFileChooser fchooser = new JFileChooser();
        fchooser.setMultiSelectionEnabled(true);
        if (fchooser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION)
        {
            closeFlag=true;
            return;
        }
        
        files = fchooser.getSelectedFiles();
        
        if(fchooser.getSelectedFile().toString().endsWith(".arff"))
            func_append();
        else
        {
            int dialogResult=JOptionPane.showConfirmDialog(null, "Not an arff file..Do you want to try again?","Warning",1);
            if(dialogResult == JOptionPane.YES_OPTION)
            appendButtonActionPerformed(evt);
        }
        if(c2==1)
        {
            int dialogResult=JOptionPane.showConfirmDialog(null, "!!Empty file! Do you want to try again?","Warning",1);
            if(dialogResult == JOptionPane.YES_OPTION)
            appendButtonActionPerformed(evt);
        }
        closeFlag=true;
    }
    }//GEN-LAST:event_appendButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(idealFlag==true)
        JOptionPane.showMessageDialog(null, "Some Processes are still running\nPlease try again", "Cannot Close now", JOptionPane.INFORMATION_MESSAGE, null);
        else{
    
            closeFlag=false;
            if(flagUpload)
            {
                new Comparison().setVisible(true);
                jButton2.setEnabled(true);
                jButton4.setEnabled(true);
                jButton6.setEnabled(true);
            }
            else
            {
                try {
                Connection con1 = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
                Statement st2 = con1.createStatement();
                Statement st3 = con1.createStatement();
                Statement st4 = con1.createStatement();
                ResultSet rs2 = st2.executeQuery("select * from classifier;");
                ResultSet rs3=null;
                ResultSet rs4=null;
                int k=0,i=0,id;
                if(acctimeRBtn.isSelected())
                {     
                    arr();
                    if(accd==0.1f)
                    {
                        for(i=0;i<classifierCnt;i++)
                        {
                            rs2.beforeFirst();
                            while(rs2.next())
                            {       
                            if(rs2.getInt(1)==(pr1[i]+1))
                            {
                                Knn.ranking[k++][2]=rs2.getString(2);
                                break;
                            }
                        }   
                    }   
                }
            
                if(accd==1)
                {
                    for(i=0;i<classifierCnt;i++)
                    {
                        rs2.beforeFirst();
                        while(rs2.next())
                        {       
                            if(rs2.getInt(1)==(pr2[i]+1))
                            {
                                Knn.ranking[k++][2]=rs2.getString(2);
                                break;
                            }
                        }   
                    }
                }
            
                if(accd==10)
                {
                    for(i=0;i<classifierCnt;i++)
                    {
                        rs2.beforeFirst();
                        while(rs2.next())
                        { 
                            if(rs2.getInt(1)==(pr3[i]+1))
                            {
                                Knn.ranking[k++][2]=rs2.getString(2);
                                break;
                            }
                        }   
                    }
                }
            } 
            else if(accRBtn.isSelected())
            {
                rs3=  st3.executeQuery("SELECT * FROM classifier");
                rs4=  st4.executeQuery("SELECT * FROM sorted_best_acc");
                rs4.last();
                id=Integer.parseInt(rs4.getString(1));
          
                for(i=2;i<classifierCnt+2;i++)
                {
                    rs3.beforeFirst();
                    while(rs3.next())
                    {
                        if(rs3.getInt(1)==(rs4.getInt(i)+1))
                            Knn.ranking[k++][2]=rs3.getString(2);
                    }
                }
            }      
            else if(precRBtn.isSelected())
            {
                rs3=  st3.executeQuery("SELECT * FROM classifier");
                rs4=  st4.executeQuery("SELECT * FROM sorted_bestp");
                rs4.last();
                id=Integer.parseInt(rs4.getString(1));
          
                for(i=2;i<classifierCnt+2;i++)
                {
                    rs3.beforeFirst();
                    while(rs3.next())
                    {
                        if(rs3.getInt(1)==(rs4.getInt(i)+1))
                        Knn.ranking[k++][2]=rs3.getString(2);
                    }       
                }
            }
            //recall
            else if(recRBtn.isSelected())
            {
                rs3=  st3.executeQuery("SELECT * FROM classifier");
                rs4=  st4.executeQuery("SELECT * FROM sorted_bestr");
                rs4.last();
                id=Integer.parseInt(rs4.getString(1));
          
                for(i=2;i<classifierCnt+2;i++)
                {
                    rs3.beforeFirst();
                    while(rs3.next())
                    {
                        if(rs3.getInt(1)==(rs4.getInt(i)+1))
                        Knn.ranking[k++][2]=rs3.getString(2);
                    }
                }
            }
            //time
            else if(timeRBtn.isSelected())
            {
                rs3=  st3.executeQuery("SELECT * FROM classifier");
                rs4=  st4.executeQuery("SELECT * FROM sorted_best_time");
                rs4.last();
                id=Integer.parseInt(rs4.getString(1));
          
                for(i=2;i<classifierCnt+2;i++)
                {
                    rs3.beforeFirst();
                    while(rs3.next())
                    {
                        if(rs3.getInt(1)==(rs4.getInt(i)+1))
                        Knn.ranking[k++][2]=rs3.getString(2);
                    }
                }
            }
            
            //accuracy prec recall
            else if(precrecaccRBtn.isSelected())
            {
                rs3=  st3.executeQuery("SELECT * FROM classifier");
                rs4=  st4.executeQuery("SELECT * FROM sorted_bestpra");
                rs4.last();
                id=Integer.parseInt(rs4.getString(1));
                for(i=2;i<classifierCnt+2;i++)
                {
                    rs3.beforeFirst();
                    while(rs3.next())
                    {
                        if(rs3.getInt(1)==(rs4.getInt(i)+1))
                        Knn.ranking[k++][2]=rs3.getString(2);
                    }
                }
            }
            new Comparison().setVisible(true);
            jButton2.setEnabled(true);
            jButton4.setEnabled(true);
            jButton6.setEnabled(true);
        }
        catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        }closeFlag=true;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeFlag=false;
        LineChartDemo6 demo = new LineChartDemo6("10 Fold - Calculated vs Ideal Ranking",0,"Classifiers","Ranking");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        closeFlag=true;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    closeFlag=false; 
    try {
    NewJFrame.fold=5;
    arr();
    Knn k=new Knn();
    k.test(foundDid,true);
    fold=10;
    LineChartDemo6 demo = new LineChartDemo6("5 Fold - Calculated vs Ideal Ranking",1,"Classifiers","Ranking");
    demo.pack();
    RefineryUtilities.centerFrameOnScreen(demo);
    demo.setVisible(true);
    } 
    catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    closeFlag=true;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void acctimeRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acctimeRBtnActionPerformed
      
    }//GEN-LAST:event_acctimeRBtnActionPerformed

    private void anotherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anotherButtonActionPerformed
        closeFlag=false;

        uploadButton.setEnabled(true);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        anotherButton.setEnabled(false);
        jButton6.setEnabled(false);
        closeFlag=true;
    }//GEN-LAST:event_anotherButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        closeFlag=false;
        LineChartDemo6 demo = new LineChartDemo6("Accuracy - Calculated vs Ideal Ranking",2,"Classifiers","Ranking");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        demo = new LineChartDemo6("Accuracy & Time - Calculated vs Ideal Ranking",3,"Classifiers","Ranking");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        closeFlag=true;
    }//GEN-LAST:event_jButton6ActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
    if(closeFlag)
    {
        this.dispose();
        new LoginFrame().setVisible(true);
    }
    else
    JOptionPane.showMessageDialog(null, "Some Processes are still running\nPlease try again", "Cannot Logout now", JOptionPane.INFORMATION_MESSAGE, null);

    }//GEN-LAST:event_logoutButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
    if(closeFlag)
        System.exit(0); 
    else
        JOptionPane.showMessageDialog(null, "Some Processes are still running\nPlease try again", "Cannot Close now", JOptionPane.INFORMATION_MESSAGE, null);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void classifierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classifierButtonActionPerformed
      new ClassifiersFrame();
    }//GEN-LAST:event_classifierButtonActionPerformed

    private void datasetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datasetButtonActionPerformed
    if(closeFlag)
        new DatasetsFrame();
    else
        JOptionPane.showMessageDialog(null, "Database is being accessed by some other process\nPlease try again", "Cannot show datasets now", JOptionPane.INFORMATION_MESSAGE, null);

    }//GEN-LAST:event_datasetButtonActionPerformed

    private void recRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recRBtnActionPerformed

    }//GEN-LAST:event_recRBtnActionPerformed

    private void timeRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeRBtnActionPerformed

    }//GEN-LAST:event_timeRBtnActionPerformed

    private void precrecaccRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precrecaccRBtnActionPerformed

    }//GEN-LAST:event_precrecaccRBtnActionPerformed

    public void reset1()
    {
        System.gc();
        cnt=0;
        cntsym=0;cntnumeric=0;
        attr_name=new String[500];
        obj_str=new String[5000][300];
        maxprob=0;
        entropy=0;
        float bin_count[]= new float[20000];
        no_attr=0;
        missing_count=0;
        mean=0;
      
        elementArr.clear();
        colIndexArr.clear();			
    }

    private void characteristics(File file1,  boolean histflag,boolean foundFlag)
    {
        float sum=0,te=0,be=0,se=0,cntt,countt;
        float  []bin_count=new float [20000];
        int len=0,flg=0,p=0,i,j,y,h,h1;
        entropy=0;
        test2++;
        String strLine;
        boolean r;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Boolean didFoundFlag=false;
        String[] record = null;
        String did= new String();
        reset1();
        try {
        FileInputStream fstream=new FileInputStream(file1);
	DataInputStream in = new DataInputStream(fstream);
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
        if(!foundFlag)
        {
            while ((strLine = br.readLine()) != null)   
            {		
                if(strLine.equals("%"))
                {
                }
	//to find out attribute
                else if(strLine.startsWith("@attribute")||strLine.startsWith("@ATTRIBUTE"))
                {
                    String[] s=strLine.split(" "); //s[0]=@attrib s[1]=attrib name s[2]=attrib values
                    attr_name[p]=s[1];

                    p++;
                    no_attr=p;
                }
                else
                {
                    h = 0;

                    if(flg==1)
                    {
                        record = strLine.split(",");  //fields in each rec
                        len = record.length; 
                        if(len<=1)
                        {
                        }
                        else
                        {
                            for(j=0;j<len;j++)
                            {   
                                obj_str[(int) cnt][j]=record[j];
                                r=isNumeric(record[j]);
                                if(r==true)
                                    h++;
                                if(record[j].equals("?"))
                                    missing_count=missing_count+1;
                                else
                                {
                                    int newEleFlag=0;
                                    for(y=0;y<elementArr.size();y++)
                                    {
                                        if(elementArr.get(y).equals(record[j])&&colIndexArr.get(y).equals(""+j))
                                        {
                                            //if same element at same column found then increment count of that element
                                            newEleFlag=1;
                                            break;
                                        }
                                        else
                                        newEleFlag=0;
                                    }
                                //this if checks similar element of same column then incement count
                                    if(newEleFlag==1)
                                    {
                                  // sum the array
                                        for(i=0; i<elementArr.size(); i++)
                                        {
                                            if(record[j].equals(elementArr.get(i))&&colIndexArr.get(i).equals(""+j)) //check whether array of element and column no is same
                                            bin_count[i]=bin_count[i]+1;
                                            length=i+1;
                                        }
                                    }
                                    else
                                    {	
                                        colIndexArr.add(""+j);
                                        elementArr.add(record[j]);
                                    }
                                }
                                if(h>cntnumeric)
                                    cntnumeric=h;
                                cntsym=len-cntnumeric;
                            }
                            cnt++;
                        }			  		 
                    }
                    if(strLine.equalsIgnoreCase("@data"))
                        flg=1;
                }	
            }
            mean=0;    
            for (i = 0; i < no_attr; i++)  
            {
                for(h=0;h<cnt;h++)
                {  
                    r=isNumeric(obj_str[h][i]);
                    if(r==true)
                    {
                        float g=Float.parseFloat(obj_str[h][i]);
                        sum=sum+g;
                    }
                }
            }
            if(cntnumeric!=0)
                mean=sum/(cnt*cntnumeric);
            else 
                mean=0;

            for(i=0;i<cnt;i++)
            {
                for(j=0;j<len;j++)
                {   
                    r=isNumeric(obj_str[i][j]);
                    if(r==true)
                    {
                        float g=Float.parseFloat(obj_str[i][j]);
                        se=(float) (se+Math.pow(g-mean, 2));
                        te=(float) (te+Math.pow(g-mean, 3));					
                        be=(float) (be+Math.pow(g-mean, 4));
                    }
                }
            }

            h1 = 0;
            for(int u=0;u<colIndexArr.size();u++)
            {
                int m=Integer.parseInt((String) colIndexArr.get(u));
                if(m==(no_attr-1))
                {
                    if((bin_count[u]+1)>maxprob) //max no of occurences of same value for any attrib
                    maxprob=(bin_count[u]+1);
                    countt=(bin_count[u]+1);
                    float temp=countt/cnt;
                    entropy+=(temp*logarithm(temp,2));
                    h1++;
                }
            }
            entropy=-entropy;
            cntt=(float)cnt;
            std= se;
            kurt1=be;
            skew1=te;
            if(cntnumeric!=0)
            {
                std_dev= std/((cnt*cntnumeric)-1);
                std_dev = (float) Math.sqrt(std_dev);
                kurtosis=kurt1/((cnt*cntnumeric)-1);
                kurtosis=kurtosis/Math.pow(std_dev,4);
                skewness=skew1/((cnt*cntnumeric)-1);
                skewness=skewness/Math.pow(std_dev,3);
                snr=mean/std_dev;
            }
            else 
            {
                kurtosis=0;
                skewness=0;
                std_dev=0;
                snr=0;
            }
        data[0][0]="No. of attribute";data[0][1]=no_attr;
        data[1][0]="No of Instance";data[1][1]=cnt;
        data[2][0]="No of symbolic";data[2][1]=cntsym;
        data[3][0]="No of Numeric";data[3][1]=cntnumeric;
        data[4][0]="Missing Value";data[4][1]=missing_count;
        data[5][0]="No of distinct value";data[5][1]=elementArr.size();
        data[6][0]="% of missing value";data[6][1]=(missing_count*100)/((no_attr)*cnt);
        data[7][0]="Dimensionality";data[7][1]=(float)(no_attr)/cntt;
        data[8][0]="% of symbolic";data[8][1]=(float)(cntsym*100)/(no_attr);
        data[9][0]="% of Numeric";data[9][1]=(float)(cntnumeric*100)/(no_attr);
        data[10][0]="Kurtosis";data[10][1]=kurtosis;
        data[11][0]="Skewness";data[11][1]=skewness;
        data[12][0]="Max probability";data[12][1]=maxprob/cnt;
        data[13][0]="No of Class";data[13][1]=h1;
        data[14][0]="Std Dev";data[14][1]=std_dev;
        data[15][0]="Signal to Noise ratio";data[15][1]=snr;
        data[16][0]="Entropy";data[16][1]=entropy;
    }
    try {
    con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
    st = con.createStatement();
    rs = st.executeQuery("SELECT * from dataset;");
    String name=file1.getName().split(".arff")[0];
    while(rs.next())
    {
        if(rs.getString(2).equalsIgnoreCase(name))
        { 
            foundDid=rs.getInt(1);
            didFoundFlag=true;   
            break;
        }
    }
    if(didFoundFlag)
    {}
    else
    {
        System.err.println("NOT FOUND "+name);
        System.exit(0);
    }
       
    did=rs.getString(1);
    con.close();
    } 
    catch (SQLException e) {
    }
    if(!foundFlag)
    {
        try {
        int temp;
        con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
        st = con.createStatement();
        rs = st.executeQuery("select * from char_tab;");
        PreparedStatement ps=con.prepareStatement("insert into char_tab values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,did);
        rs.absolute(Integer.parseInt(did));
        for(i=2;i<19;i++)                   
            ps.setString(i," "+data[i-2][1]);
               
        temp=ps.executeUpdate();
        if(temp==0)
            System.out.println("Failed ps.execute for did:"+did);        
        con.close();
        }
            
        catch (SQLException e) {      
        System.err.println("error in character"+e);
        System.exit(1);    
        }
    }
    if(!histflag)
    {
        normal();
        Knn k=new Knn();
        k.test(foundDid,false);
    }
    } 
    catch (IOException ex) {
    }
    }
    private void normal()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Statement st1 = null;
        ResultSet rs1 = null;
        double min, max,k,val=0,val1=0;
        double data1[][]=new double[100][100];
        int cnt,i,j,temp;
        String did;
    
        try {
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st = con.createStatement();
            rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 0");
            rs = st.executeQuery("truncate norm_tab;"); 
            rs=st.executeQuery("SET FOREIGN_KEY_CHECKS = 1");    
        } 
        catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DROCA.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
 
        try {
        con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
        st = con.createStatement();

        rs=st.executeQuery("select * from char_tab");
        for(i=2;i<19;i++)
        {
            cnt=0;
            min=50000;
            max=-1;
            rs.beforeFirst();
            while(rs.next())
            {
                k= Double.parseDouble(rs.getString(i));
                if(k<min)
                    min=k; 
                if(k>=max)
                    max=k;
            }
            
            rs.beforeFirst();
            val1=max-min;   
            while(rs.next())
            {
                k=Double.parseDouble(rs.getString(i));
                if(val1==0)
                    val=k;
                else
                val=(k-min)/val1;
                data1[cnt][i-2]=val;
                cnt++;
            }
        }
        } 
        catch (SQLException ex) {
        Logger lgr = Logger.getLogger(DROCA.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    
        try {
            j=2;
            con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
            st1 = con.createStatement();
            rs1 = st.executeQuery("select * from norm_tab;");
            rs=st1.executeQuery("select * from dataset");
            rs.beforeFirst();
            while(rs.next())
            {
                cnt=0;
                did=rs.getString(1);
                PreparedStatement ps=con.prepareStatement("insert into norm_tab values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,did);
                rs1.absolute(Integer.parseInt(did));
                for(i=2;i<19;i++)                   
                    ps.setString(i," "+data1[j-2][cnt++]);
                j++;
                temp=ps.executeUpdate();
                if(temp==0)
                    System.out.println("Failed ps.execute for did:"+did);
            } 
        }
        catch (SQLException e) {       
        System.err.println(e);
        System.exit(1);
        } 
}
       
class LineChartDemo6 extends JFrame {
    LineChartDemo6(final String title,int flag, final String x, final String y) {

    super(title);

    XYDataset dataset = createDataset(flag);
    JFreeChart chart = createChart(title,dataset,x,y);
    ChartPanel chartPanel = new ChartPanel(chart);
    if(flag==0 || flag==1)
        chartPanel.setBounds(500, 500, 270, 500);
    else if(flag==2)
    {
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setAlignmentX(100);
        chartPanel.setAlignmentY(500);
    }  
    else if(flag==3)
    {
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setAlignmentX(800);
        chartPanel.setAlignmentY(500);
    }
    setContentPane(chartPanel);
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
}
    
    private XYDataset createDataset(int flag) {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    int grapharr[]=new int[classifierCnt];
    try{ 
        con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
        st = con.createStatement();
        if(flag==0)
        {
            if(accRBtn.isSelected())
            rs=st.executeQuery("select * from sorted_best_acc");
            else if(timeRBtn.isSelected())
            rs=st.executeQuery("select * from sorted_best_time");
            else if(precRBtn.isSelected())
                rs=st.executeQuery("select * from sorted_bestp");
            else if(recRBtn.isSelected())
                rs=st.executeQuery("select * from sorted_bestr");
            else if (acctimeRBtn.isSelected())
            {
                if(accd==0.1f)
                    rs=st.executeQuery("select * from sorted_best_accd1");
                   
                if(accd==1)
                    rs=st.executeQuery("select * from sorted_best_accd2");
               
                if(accd==10)
                    rs=st.executeQuery("select * from sorted_best_accd3");
            }
            else if(precrecaccRBtn.isSelected())
                rs=st.executeQuery("select * from sorted_bestpra");
        }
        else if(flag==1)
            rs=st.executeQuery("select * from sorted_best5");
       
        else if(flag==2)
            rs=st.executeQuery("select * from sorted_best_acc");
        else if(flag==3)
            rs=st.executeQuery("select * from sorted_best_accd2");
               
        rs.last();
        for(int i=0;i<classifierCnt;i++)
        {
            for(int j=2;j<classifierCnt+2;j++)
            {
                if(i == Integer.parseInt(rs.getString(j)))
                {
                    grapharr[i]=j-1;
                    break;
                }
            }   
        }
        XYSeries series2 = new XYSeries("ideal");
        if(!flagUpload)
            for(int i=0;i<classifierCnt;i++)
                series2.add(i+1, grapharr[i]);
        else
        {
            if(flag==1)
            {
                for(int i=0;i<classifierCnt;i++)
                {
                    for(int j=0;j<classifierCnt;j++)
                    {

                        if(i == Knn.graph_val5[j])
                        {
                            series2.add(i+1, j+1);
                            break;
                        }
                    }
                }
            }
            else
            {
                for(int i=0;i<classifierCnt;i++)
                {
                    for(int j=0;j<classifierCnt;j++)
                    {

                        if(i == Knn.graph_val[j])
                        {
                            series2.add(i+1, j+1);
                            break;
                        }
                    }
                }
            }
        }
        
        if(flag==1)
        {
            for(int i=0;i<classifierCnt;i++)
            {
                for(int j=0;j<classifierCnt;j++)
                {
                    if(i == Knn.graph_val5[j])
                    {
                        grapharr[i]=j+1;
                        break;
                    }
                }
            }
        }
        else
        {
            for(int i=0;i<classifierCnt;i++)
            {
                for(int j=0;j<classifierCnt;j++)
                {
                    if(i == Knn.graph_val[j])
                    {
                        grapharr[i]=j+1;
                        break;
                    }
                }
            }
        }
        XYSeries series1 = new XYSeries("calculated");
        
        for(int i=0;i<classifierCnt;i++)
            series1.add(i+1, grapharr[i]);
            
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        return dataset;
    }
    catch (SQLException e) {      
    System.err.println(e);
    System.exit(1);
    }
    return null;   
}
    private JFreeChart createChart(final String title, final XYDataset dataset,final String x,final String y ) 
    {
        JFreeChart chart = ChartFactory.createXYLineChart(
        title, // chart title
        x,                      // x axis label
        y,                      // y axis label
        dataset,                  // data
        PlotOrientation.VERTICAL,
        true,                     // include legend
        true,                     // tooltips
        false                     // urls
        );

        chart.setBackgroundPaint(Color.white);
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return chart;  
    }
    }
    private float logarithm(float f, int i) {
    return (float) (Math.log(f) / Math.log(i));
    }
    private boolean isNumeric(String string) 
    {
        try  
        {  
            double d = Double.parseDouble(string);  
        }  
        catch(NumberFormatException nfe)  
        {  
            return false;  
        }  
        return true;  
    }
    private final Object[][] data=new Object[50][50];
    double[] rank1=new double[classifierCnt];
    double[] rank2=new double[classifierCnt];
    double[] rank3=new double[classifierCnt];
    int cnt=0;
    int cntsym=0,cntnumeric=0;
    String [] attr_name=new String[500];
    String [][] obj_str=new String[5000][300];
    ArrayList<String> elementArr=new ArrayList<>();
    ArrayList<String> colIndexArr=new ArrayList<> ();
    int no_attr=0;
    int missing_count=0;
    float mean=0;
    float maxprob=0;
    double entropy = 0;
    float tesum=0;
    double besum=0;
    float std_dev=0;
    float snr=0;
    static int classifierCnt;
    static int noOfChar=17;
    static int noOfDset;
    static float accd=0;
    static int test2=0;
    static int fold=10;
    int accflag=0;
    boolean flagUpload=false,idealFlag=false;
    double acc[]=new double[classifierCnt];
    double pre[]=new double[classifierCnt];
    double rec[]=new double[classifierCnt];
    double precRecAcc[]=new double[classifierCnt];
    double time[]=new double[classifierCnt];
    int pr1[]=new int[classifierCnt];
    int pr2[]=new int[classifierCnt];
    int pr3[]=new int[classifierCnt];
    File[] files;
    File file_upload;
    boolean invalidFlag=false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JRadioButton accRBtn;
    static javax.swing.JRadioButton acctimeRBtn;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addLabel;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JButton anotherButton;
    private javax.swing.JButton appendButton;
    private javax.swing.JLabel appendLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel chooseLabel;
    private javax.swing.JButton classifierButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton datasetButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel mainPanel;
    static javax.swing.JRadioButton precRBtn;
    static javax.swing.JRadioButton precrecaccRBtn;
    static javax.swing.JRadioButton recRBtn;
    static javax.swing.JRadioButton timeRBtn;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton uploadButton;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
