/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CCP;

import java.awt.HeadlessException;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class ForgotPassword extends javax.swing.JFrame {

    String DataBasePath = "jdbc:oracle:thin:@localhost:1521:XE";

    /**
     * Creates new form ForgotPassowrd
     */
    public ForgotPassword() {
        initComponents();
        this.setTitle("Forgot Password");
        usernotfound.setText("");
        wronganswer.setText("");
        setLocationRelativeTo(null);
        useraccountname.setText(SessionManager.getInstance().getUsername());

        newpassword.setText("");
        confirmpassword.setText("");

        username.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                usernotfound.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                usernotfound.setText("");
            }
        });

        answer.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                wronganswer.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                wronganswer.setText("");
            }
        });

        inputnewpassword.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                newpassword.setText("");
                passwordnotmatch.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                newpassword.setText("");
                passwordnotmatch.setText("");
            }
        });
        inputconfirmpassword.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                confirmpassword.setText("");
                passwordnotmatch.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                confirmpassword.setText("");
                passwordnotmatch.setText("");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        forgotpassword = new javax.swing.JTabbedPane();
        searchaccount = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        usernotfound = new javax.swing.JLabel();
        mainpanel = new javax.swing.JPanel();
        selectrole = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        useraccountname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        securityquestion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        wronganswer = new javax.swing.JLabel();
        answer = new javax.swing.JTextField();
        submitquestion = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        newpassword = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        confirmpassword = new javax.swing.JLabel();
        passwordnotmatch = new javax.swing.JLabel();
        useraccountname1 = new javax.swing.JLabel();
        updatepasswordbtn = new javax.swing.JButton();
        inputnewpassword = new javax.swing.JPasswordField();
        inputconfirmpassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Forgot Password");

        jLabel4.setText("Enter your username:");

        searchbtn.setText("search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        usernotfound.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usernotfound.setForeground(new java.awt.Color(255, 0, 0));
        usernotfound.setText("usernotfound");

        mainpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose your Role:"));

        selectrole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Captain", "User" }));

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectrole, 0, 237, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(selectrole, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\OneDrive\\Documents\\NetBeansProjects\\CAB_SERVICE_CCP final\\CAB_SERVICE final\\image_2024-01-07_212723027-removebg-preview.png")); // NOI18N

        javax.swing.GroupLayout searchaccountLayout = new javax.swing.GroupLayout(searchaccount);
        searchaccount.setLayout(searchaccountLayout);
        searchaccountLayout.setHorizontalGroup(
            searchaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchaccountLayout.createSequentialGroup()
                .addGroup(searchaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchaccountLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1))
                    .addGroup(searchaccountLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(searchaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(searchaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(mainpanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(searchaccountLayout.createSequentialGroup()
                                    .addGap(187, 187, 187)
                                    .addComponent(searchbtn)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchaccountLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(usernotfound)
                                .addGap(13, 13, 13))
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        searchaccountLayout.setVerticalGroup(
            searchaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchaccountLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(searchaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernotfound)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchbtn)
                .addGap(27, 27, 27))
        );

        forgotpassword.addTab("tab1", searchaccount);

        useraccountname.setText("username");

        jLabel3.setText("Account found");

        securityquestion.setBackground(new java.awt.Color(196, 181, 129));
        securityquestion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        securityquestion.setText("Securityquestion");

        jLabel2.setBackground(new java.awt.Color(196, 181, 129));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Answer:");

        wronganswer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        wronganswer.setForeground(new java.awt.Color(255, 0, 0));
        wronganswer.setText("wrong answer");

        submitquestion.setText("submit");
        submitquestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitquestionActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\OneDrive\\Documents\\NetBeansProjects\\CAB_SERVICE_CCP final\\CAB_SERVICE final\\accountfound.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(useraccountname)
                            .addComponent(jLabel2)
                            .addComponent(wronganswer)
                            .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitquestion)
                            .addComponent(securityquestion)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(useraccountname)
                .addGap(18, 18, 18)
                .addComponent(securityquestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(wronganswer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submitquestion)
                .addGap(29, 29, 29))
        );

        forgotpassword.addTab("tab2", jPanel1);

        jLabel5.setText("New Password");

        jLabel6.setBackground(new java.awt.Color(196, 181, 129));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("New Password:");

        newpassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        newpassword.setForeground(new java.awt.Color(255, 51, 0));
        newpassword.setText("password");

        jLabel7.setBackground(new java.awt.Color(196, 181, 129));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Confirm Password:");

        confirmpassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        confirmpassword.setForeground(new java.awt.Color(255, 51, 0));
        confirmpassword.setText("password");

        passwordnotmatch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordnotmatch.setForeground(new java.awt.Color(255, 0, 0));
        passwordnotmatch.setText("Password does not match");

        useraccountname1.setText("username");

        updatepasswordbtn.setText("update password");
        updatepasswordbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatepasswordbtnActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\OneDrive\\Documents\\NetBeansProjects\\CAB_SERVICE_CCP final\\CAB_SERVICE final\\forgotpassword.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(confirmpassword))
                            .addComponent(passwordnotmatch, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputconfirmpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(inputnewpassword)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(newpassword))
                            .addComponent(useraccountname1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(updatepasswordbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(16, 16, 16)
                .addComponent(useraccountname1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newpassword)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputnewpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(confirmpassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputconfirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordnotmatch)
                .addGap(18, 18, 18)
                .addComponent(updatepasswordbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        forgotpassword.addTab("tab3", jPanel2);

        getContentPane().add(forgotpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 380, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        // TODO add your handling code here:
        String searchusername = username.getText();
        usernotfound.setText("");
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int userrole = selectrole.getSelectedIndex();
        if (userrole == 1) {

            try {

                Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                String usernamee = "system";
                String passwordd = "awansara123";
                con = DriverManager.getConnection(url, usernamee, passwordd);
                String query = "select * from USERS where username='" + searchusername + "'";
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();

                if (rs.next()) {
                    String secQuestion = rs.getString("SecurityQuestion");
                    forgotpassword.setSelectedIndex(1);
                    securityquestion.setText(secQuestion);
                    SessionManager.getInstance().setUsername(searchusername);

                } else {
                    usernotfound.setText("Account not found.");
                    username.setText("");

                }

            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            }

        } else if (userrole == 0) {

            try {

                Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                String usernamee = "system";
                String passwordd = "awansara123";
                con = DriverManager.getConnection(url, usernamee, passwordd);
                String query = "select * from CAPTAINS where username='" + searchusername + "'";
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();

                if (rs.next()) {
                    String secQuestion = rs.getString("SecurityQuestion");
                    forgotpassword.setSelectedIndex(1);
                    securityquestion.setText(secQuestion);
                    SessionManager.getInstance().setUsername(searchusername);

                } else {
                    usernotfound.setText("Account not found.");
                    username.setText("");

                }

            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            }

        }

        useraccountname.setText(searchusername);

    }//GEN-LAST:event_searchbtnActionPerformed

    private void submitquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitquestionActionPerformed
        // TODO add your handling code here:
        String username = SessionManager.getInstance().getUsername();
        String sanswer = answer.getText().toLowerCase();
        int userrole = selectrole.getSelectedIndex();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        if (userrole == 1) {
            try {

                Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                String usernamee = "system";
                String passwordd = "awansara123";
                con = DriverManager.getConnection(url, usernamee, passwordd);
                String query = "select * from USERS where username='" + username + "'";
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();

                if (rs.next()) {

                    String securityans = rs.getString("SecurityAnswer");
                    if (sanswer.equals(securityans)) {
                        forgotpassword.setSelectedIndex(2);
                    } else {

                        wronganswer.setText("your answer is wrong.");
                    }
                }

            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            }
        } else if (userrole == 0) {
            try {

                Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                String usernamee = "system";
                String passwordd = "awansara123";
                con = DriverManager.getConnection(url, usernamee, passwordd);
                String query = "select * from CAPTAINS where username='" + username + "'";
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();

                if (rs.next()) {

                    String securityans = rs.getString("SecurityAnswer");
                    if (sanswer.equals(securityans)) {
                        forgotpassword.setSelectedIndex(2);
                    } else {

                        wronganswer.setText("your answer is wrong.");
                    }
                }

            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            }
        }

    }//GEN-LAST:event_submitquestionActionPerformed

    private void updatepasswordbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatepasswordbtnActionPerformed
        // TODO add your handling code here:

        String firstpassword = new String(inputnewpassword.getPassword());
        String secondpassword = new String(inputconfirmpassword.getPassword());
        int passlength = firstpassword.length();
        String username = SessionManager.getInstance().getUsername();
        int userrole = selectrole.getSelectedIndex();

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        if (firstpassword.isEmpty() && secondpassword.isEmpty()) {
            newpassword.setText("Required field!");
            confirmpassword.setText("Required field!");
        } else if (firstpassword.isEmpty()) {
            newpassword.setText("Required field!");
        } else if (secondpassword.isEmpty()) {
            confirmpassword.setText("Required field!");
        } else if (passlength < 8) {
            JOptionPane.showMessageDialog(this, "password should be more than 8 chracters");
        } else if (passlength > 16) {
            JOptionPane.showMessageDialog(this, "password should be less than 16 chracters");
        } else if (!firstpassword.equals(secondpassword)) {
            passwordnotmatch.setText("Password does not match");
            inputnewpassword.setText("");
            inputconfirmpassword.setText("");
        } else if (firstpassword.equals(secondpassword)) {

            String encryptedPassword = encryptPassword(firstpassword);

            if (userrole == 1) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                    String url = "jdbc:oracle:thin:@localhost:1521:XE";
                    String usernamee = "system";
                    String passwordd = "awansara123";
                    con = DriverManager.getConnection(url, usernamee, passwordd);
                    String query = "UPDATE USERS SET Password = ? WHERE username = ?";
                    pst = con.prepareStatement(query);
                    pst.setString(1, encryptedPassword);
                    pst.setString(2, username);

                    int rowsAffected = pst.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showConfirmDialog(this, "Password Updated Successfully", "Success", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        login_form lf = new login_form();
                        lf.show();
                        dispose();
                    } else {
                        JOptionPane.showConfirmDialog(this, "something went wrong");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }else if (userrole == 0) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                    String url = "jdbc:oracle:thin:@localhost:1521:XE";
                    String usernamee = "system";
                    String passwordd = "awansara123";
                    con = DriverManager.getConnection(url, usernamee, passwordd);
                    String query = "UPDATE CAPTAINS SET Password = ? WHERE username = ?";
                    pst = con.prepareStatement(query);
                    pst.setString(1, encryptedPassword);
                    pst.setString(2, username);

                    int rowsAffected = pst.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showConfirmDialog(this, "Password Updated Successfully", "Success", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        login_form lf = new login_form();
                        lf.show();
                        dispose();
                    } else {
                        JOptionPane.showConfirmDialog(this, "something went wrong");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }//GEN-LAST:event_updatepasswordbtnActionPerformed

    public String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answer;
    private javax.swing.JLabel confirmpassword;
    private javax.swing.JTabbedPane forgotpassword;
    private javax.swing.JPasswordField inputconfirmpassword;
    private javax.swing.JPasswordField inputnewpassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JLabel newpassword;
    private javax.swing.JLabel passwordnotmatch;
    private javax.swing.JPanel searchaccount;
    private javax.swing.JButton searchbtn;
    private javax.swing.JLabel securityquestion;
    private javax.swing.JComboBox selectrole;
    private javax.swing.JButton submitquestion;
    private javax.swing.JButton updatepasswordbtn;
    private javax.swing.JLabel useraccountname;
    private javax.swing.JLabel useraccountname1;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernotfound;
    private javax.swing.JLabel wronganswer;
    // End of variables declaration//GEN-END:variables
}
