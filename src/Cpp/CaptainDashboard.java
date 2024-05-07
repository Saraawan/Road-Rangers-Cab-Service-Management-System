/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class CaptainDashboard extends javax.swing.JFrame {

    String DataBasePath = "jdbc:oracle:thin:@localhost:1521:XE";

    /**
     * Creates new form CaptainDashboard
     */
    public CaptainDashboard() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Captain Dashboard");
        tableUpdate();
    }

    public CaptainDashboard(String username) {
        initComponents();
        setLocationRelativeTo(null);
        userfullname.setText(username);
        this.setTitle("Captain Dashboard");
        tableUpdate();
        try {
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            String status = "Reached";
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                    String url = "jdbc:oracle:thin:@localhost:1521:XE";
                    String usernamee = "system";
                    String passwordd = "awansara123";
                    con = DriverManager.getConnection(url, usernamee, passwordd);
            String query = "SELECT COUNT(*) FROM BOOKING WHERE CaptainUsername='" + username + "'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
                totalridestaken.setText("" + count);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;

              Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                    String url = "jdbc:oracle:thin:@localhost:1521:XE";
                    String usernamee = "system";
                    String passwordd = "awansara123";
                    con = DriverManager.getConnection(url, usernamee, passwordd);
            String query = "SELECT sum(Fare) FROM BOOKING WHERE CaptainUsername='" + username + "'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                double sum = rs.getDouble(1);
                double percent = 0.07;
                double taxamount = sum * percent;
                double aftertax = (sum - taxamount);
                totalearning.setText("" + aftertax);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            String totalRides = totalridestaken.getText();
            String Uname = userfullname.getText();
            String Tearning = totalearning.getText();
              Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                    String url = "jdbc:oracle:thin:@localhost:1521:XE";
                    String usernamee = "system";
                    String passwordd = "awansara123";
                    con = DriverManager.getConnection(url, usernamee, passwordd);
            String query = "UPDATE CAPTAINS SET TotalRidesTaken = ?, TotalEarning = ? WHERE Username = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, totalRides);
            pst.setString(2, Tearning);
            pst.setString(3, Uname);
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error in query: " + e);
        }

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
              Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                    String url = "jdbc:oracle:thin:@localhost:1521:XE";
                    String usernamee = "system";
                    String passwordd = "awansara123";
                    con = DriverManager.getConnection(url, usernamee, passwordd);
            String query = "select * from CAPTAINS where Username='" + username + "'";

            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                String phonenumber = rs.getString("PhoneNumber");
                userphonenumber.setText(phonenumber);
                String vcolor = rs.getString("VehicalColor");
                outputvehicalcolour.setText(vcolor);
                String userkaname = rs.getString("FullName");
                userkanaam.setText(userkaname);
                String vnumber = rs.getString("VehicalNumber");
                outputVehicalNmber.setText(vnumber);
                String vtype = rs.getString("VehicalType");
                outputvehicaltype.setText(vtype);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    public void tableUpdate() {

        int c;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String username = userfullname.getText();
        String Status = "Active";
        String ridetype = null;
        try {
              Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                    String url = "jdbc:oracle:thin:@localhost:1521:XE";
                    String usernamee = "system";
                    String passwordd = "awansara123";
                    con = DriverManager.getConnection(url, usernamee, passwordd);
            String query1 = "select VehicalType from CAPTAINS where Username='" + username + "'";

            pst = con.prepareStatement(query1);
            rs = pst.executeQuery();
            if (rs.next()) {
                String vtype = rs.getString("VehicalType");
                outputvehicaltype.setText(vtype);
                ridetype = vtype;
            }
              Class.forName("oracle.jdbc.driver.OracleDriver"); // Fixed driver class name
                   
                    con = DriverManager.getConnection(url, usernamee, passwordd);
            String query = "select * from BOOKING where PassengerRideType='" + ridetype + "' and Status='" + Status + "'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            DefaultTableModel dft = (DefaultTableModel) captaindashboardtable.getModel();
            dft.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getInt("BookingID"));
                    v2.add(rs.getString("PassengerUsername"));
                    v2.add(rs.getString("PassengerSource"));
                    v2.add(rs.getString("PassengerDestination"));
                    v2.add(rs.getString("PassengerPhone"));
                    v2.add(rs.getString("PassengerRideType"));
                    v2.add(rs.getString("Status"));
                    v2.add(rs.getString("commentsandwishes"));
                    v2.add(rs.getString("TotalDistance"));
                    v2.add(rs.getDouble("Fare"));
                }
                dft.addRow(v2);
            }
        } catch (ClassNotFoundException | SQLException ce) {
            System.out.println(ce);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        logoutbutton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userphoneeee = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        userfullname = new javax.swing.JLabel();
        userkanaam = new javax.swing.JLabel();
        userphonenumber = new javax.swing.JLabel();
        outputVehicalNmber = new javax.swing.JLabel();
        outputvehicaltype = new javax.swing.JLabel();
        outputvehicalcolour = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalridestaken = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        totalearning = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        captaindashboardtable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        acceptride = new javax.swing.JButton();
        completedRidesCaptain = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Captain Dashboard");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        logoutbutton.setForeground(new java.awt.Color(255, 255, 255));
        logoutbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CCP/logout.png"))); // NOI18N
        logoutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbuttonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Details:"));

        jLabel2.setText("Username:");

        jLabel3.setText("Name:");

        userphoneeee.setText("Phone:");

        jLabel5.setText("Vehical Number:");

        jLabel6.setText("Vehical Type:");

        jLabel7.setText("Vehical Colour:");

        userfullname.setText("userfullname");

        userkanaam.setText("name");

        userphonenumber.setText("Userphonenumber");

        outputVehicalNmber.setText("vehicalnumber");

        outputvehicaltype.setText("vehicaltype");

        outputvehicalcolour.setText("vehicalcolour");

        jLabel8.setText("Total Rides Taken:");

        totalridestaken.setText("totalridestaken");

        jLabel10.setText("Total Earning:");

        totalearning.setText("totalearning");

        jLabel9.setText("excluding 7% tax");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userphoneeee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(totalearning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(outputvehicaltype, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userphonenumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userfullname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userkanaam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(outputvehicalcolour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(outputVehicalNmber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(70, 70, 70))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(totalridestaken)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userfullname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userkanaam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userphoneeee)
                    .addComponent(userphonenumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(outputVehicalNmber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(outputvehicaltype))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outputvehicalcolour))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(totalridestaken))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(totalearning)
                    .addComponent(jLabel9)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        captaindashboardtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "BookingID", "PassengerUsername", "PassengerSource", "PassengerDestination", "PassengerPhone", "PassengerRideType", "Status", "commentsandwishes", "TotalDistance", "Fare"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(captaindashboardtable);

        acceptride.setText("Accept Ride");
        acceptride.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptrideActionPerformed(evt);
            }
        });

        completedRidesCaptain.setText("Completed Rides");
        completedRidesCaptain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedRidesCaptainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(acceptride, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(completedRidesCaptain)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptride, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(completedRidesCaptain, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223)
                        .addComponent(logoutbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoutbutton)
                    .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbuttonActionPerformed
        // TODO add your handling code here:
        login_form lgf = new login_form();
        lgf.show();
        dispose();
    }//GEN-LAST:event_logoutbuttonActionPerformed

    private void acceptrideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptrideActionPerformed
        // TODO add your handling code here:
        int selectedIndex = captaindashboardtable.getSelectedRow();
        String captainusername = userfullname.getText();
        int id = Integer.parseInt(captaindashboardtable.getValueAt(selectedIndex, 0).toString());
        String vnumber = outputVehicalNmber.getText();
        String vcolor = outputvehicalcolour.getText();
        String sstatus = captaindashboardtable.getValueAt(selectedIndex, 6).toString();

        if (captaindashboardtable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row from the table first.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if ("Reached".equals(sstatus) || "cancelled".equals(sstatus)) {
                JOptionPane.showMessageDialog(this, "This Ride is Completed. kindly select active rides.");
            } else {
                AcceptedRideForm arf = new AcceptedRideForm(captainusername, id, vnumber, vcolor);
                arf.show();
                dispose();
            }

        }
    }//GEN-LAST:event_acceptrideActionPerformed

    private void completedRidesCaptainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completedRidesCaptainActionPerformed
        // TODO add your handling code here:
        String username = userfullname.getText();

        captainRidesHistory crh = new captainRidesHistory(username);
        crh.show();
        dispose();
    }//GEN-LAST:event_completedRidesCaptainActionPerformed

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
            java.util.logging.Logger.getLogger(CaptainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaptainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaptainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaptainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaptainDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptride;
    private javax.swing.JTable captaindashboardtable;
    private javax.swing.JButton completedRidesCaptain;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JButton logoutbutton;
    private javax.swing.JLabel outputVehicalNmber;
    private javax.swing.JLabel outputvehicalcolour;
    private javax.swing.JLabel outputvehicaltype;
    private javax.swing.JLabel totalearning;
    private javax.swing.JLabel totalridestaken;
    private javax.swing.JLabel userfullname;
    public javax.swing.JLabel userkanaam;
    private javax.swing.JLabel userphoneeee;
    private javax.swing.JLabel userphonenumber;
    // End of variables declaration//GEN-END:variables
}
