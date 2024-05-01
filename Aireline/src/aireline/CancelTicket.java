/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aireline;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class CancelTicket extends javax.swing.JFrame {

    public CancelTicket() {
        initComponents();
        GetTickets();
        DisplayCancel();
        FcodeTb.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TIdCb = new javax.swing.JComboBox<>();
        FcodeTb = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CancellationTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Cancelbtn = new java.awt.Button();
        Resetbtn = new java.awt.Button();
        Backbtn = new java.awt.Button();
        CDate = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText("Id de billet");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText("Code de billest");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("Date de cancelation");

        TIdCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIdCbActionPerformed(evt);
            }
        });

        CancellationTable.setBackground(new java.awt.Color(204, 204, 204));
        CancellationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id de cancelation", "Id de billet", "Code de billet", "Date de cancelation"
            }
        ));
        jScrollPane1.setViewportView(CancellationTable);

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel5.setText("Liste ");

        Cancelbtn.setBackground(new java.awt.Color(204, 204, 204));
        Cancelbtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Cancelbtn.setLabel("Cancel");
        Cancelbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelbtnMouseClicked(evt);
            }
        });
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });

        Resetbtn.setBackground(new java.awt.Color(204, 204, 204));
        Resetbtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Resetbtn.setLabel("Reset");
        Resetbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetbtnMouseClicked(evt);
            }
        });
        Resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetbtnActionPerformed(evt);
            }
        });

        Backbtn.setActionCommand("Retour");
        Backbtn.setBackground(new java.awt.Color(204, 204, 204));
        Backbtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Backbtn.setLabel("Retour");
        Backbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackbtnMouseClicked(evt);
            }
        });
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FLY HIGH Airline");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(362, 362, 362))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel6.setText("Annulation des billets");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(355, 355, 355))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TIdCb, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(FcodeTb, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(CDate, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(Resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(407, 407, 407))))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TIdCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FcodeTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Cancelbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Backbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Resetbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 Connection Con = null;
 PreparedStatement pst = null;
 ResultSet Rs = null,Rs1 = null;
 Statement St = null,St1 = null;
 
    private void GetTickets()
 {
     try {
          Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
          St = Con.createStatement();
          String Query = "select * from bookingtbl";
          Rs = St.executeQuery(Query);
          while(Rs.next())
          {
            String T = String.valueOf(Rs.getInt("TicketId"));
             TIdCb.addItem(T);
          }
     }
     catch ( Exception e ){
     }
 }
    private void DisplayCancel()
 {
     try {
          Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
          St = Con.createStatement();
          Rs = St.executeQuery("select * from CancellationTbl");
          CancellationTable.setModel(DbUtils.resultSetToTableModel(Rs));
          
     } catch ( Exception e ){
     }   
 }
    private void GetFCode()
{
    String Query = "select * from bookingtbl where TicketId = " +TIdCb.getSelectedItem().toString();
    Statement St;
    ResultSet Rs;
    try {
          Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
          St = Con.createStatement();
          Rs = St.executeQuery(Query);
          if(Rs.next())
          {
             FcodeTb.setText(Rs.getString("FlCode"));
          }
     }
     catch ( Exception e ){
     }  
} 
int CId = 0;
private void CountCancel()
{ 
   try {
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
        St1 = Con.createStatement();
        Rs1 = St1.executeQuery("select Max(Cancid) from cancellationtbl");
        Rs1.next();
        CId = Rs1.getInt(1)+1;
   } catch (Exception e){
   }
}
    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
       if(FcodeTb.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(this, "Missing Information");
           
        }else{
            try {
                 CountCancel();
                 Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
                 PreparedStatement Add = Con.prepareStatement("insert into cancellationtbl values(?,?,?,?)");
                 Add.setInt(1, CId);
                 Add.setInt(2, Integer.valueOf(TIdCb.getSelectedItem().toString()));
                 Add.setString(3, FcodeTb.getText());
                 Add.setString(4, CDate.getDate().toString());
               
                 int row = Add.executeUpdate();
                 JOptionPane.showMessageDialog(this, "Ticket booked");
                 Con.close();
                 Cancel();
                 DisplayCancel();
                 GetTickets();
                 //clear();
                 
            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_CancelbtnActionPerformed
private void Cancel(){
           try {
                  Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
                  String Query = "Delete from bookingtbl where TicketId =  "+TIdCb.getSelectedItem();
                  Statement Del = Con.createStatement();
                  Del.executeUpdate(Query);
           }catch(Exception e){
               JOptionPane.showMessageDialog(this, e);
           }
}
    private void ResetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetbtnActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        Menu me = new Menu();
        me.setVisible(true);
        CancelTicket.super.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    private void BackbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackbtnMouseClicked
      // new MainFrom().setVisible(true);
       //this.dispose();
       
    }//GEN-LAST:event_BackbtnMouseClicked

    private void ResetbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetbtnMouseClicked
       FcodeTb.setText("");

       
    }//GEN-LAST:event_ResetbtnMouseClicked

    private void TIdCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIdCbActionPerformed
        GetFCode();
    }//GEN-LAST:event_TIdCbActionPerformed

    private void CancelbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelbtnMouseClicked
         
    }//GEN-LAST:event_CancelbtnMouseClicked

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
            java.util.logging.Logger.getLogger(CancelTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CancelTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CancelTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancelTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CancelTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Backbtn;
    private com.toedter.calendar.JDateChooser CDate;
    private java.awt.Button Cancelbtn;
    private javax.swing.JTable CancellationTable;
    private javax.swing.JTextField FcodeTb;
    private java.awt.Button Resetbtn;
    private javax.swing.JComboBox<String> TIdCb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
