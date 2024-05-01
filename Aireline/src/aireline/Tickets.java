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




public class Tickets extends javax.swing.JFrame {

  
    public Tickets() {
        initComponents();
        GetPassenger();
        PNat.setEditable(false);
        PassName.setEditable(false);
        NumPass.setEditable(false);
        PGen.setEditable(false);
        GetFlights();
        DisplayTicket();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        Pid = new javax.swing.JLabel();
        Pname = new javax.swing.JLabel();
        Passid = new javax.swing.JComboBox<>();
        PassName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Bookingtbl = new javax.swing.JTable();
        booking = new javax.swing.JLabel();
        Book = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        FlCode = new javax.swing.JComboBox<>();
        FlightCode = new javax.swing.JLabel();
        Gen = new javax.swing.JLabel();
        PGen = new javax.swing.JTextField();
        Numpasslabel = new javax.swing.JLabel();
        NumPass = new javax.swing.JTextField();
        Amount = new javax.swing.JLabel();
        AmountTb = new javax.swing.JTextField();
        Ntionalite = new javax.swing.JLabel();
        PNat = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        Pid.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Pid.setText("Id passenger");

        Pname.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Pname.setText("Nom de Passenger");

        Passid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PassidMouseClicked(evt);
            }
        });
        Passid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassidActionPerformed(evt);
            }
        });

        PassName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassNameActionPerformed(evt);
            }
        });

        Bookingtbl.setBackground(new java.awt.Color(204, 204, 204));
        Bookingtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "billets id", "Pnom", "FlCode", "PGender", "PPass", "Amount", "Nationalité"
            }
        ));
        jScrollPane1.setViewportView(Bookingtbl);

        booking.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        booking.setText("Liste ");

        Book.setBackground(new java.awt.Color(204, 204, 204));
        Book.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Book.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Book.setLabel("Enregistrer");
        Book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookMouseClicked(evt);
            }
        });
        Book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(204, 204, 204));
        button2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        button2.setLabel("Reset");
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button2MouseClicked(evt);
            }
        });
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setActionCommand("Back");
        button3.setBackground(new java.awt.Color(204, 204, 204));
        button3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        button3.setLabel("Retour");
        button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button3MouseClicked(evt);
            }
        });
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        FlCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlCodeMouseClicked(evt);
            }
        });
        FlCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlCodeActionPerformed(evt);
            }
        });

        FlightCode.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        FlightCode.setText("Code de vol");

        Gen.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Gen.setText("Genre");

        PGen.setEditable(false);
        PGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PGenActionPerformed(evt);
            }
        });

        Numpasslabel.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Numpasslabel.setText("Numero de passport");

        Amount.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Amount.setText("Montante");

        Ntionalite.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Ntionalite.setText("Nationalité");

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FLY HIGH Airline");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(395, 395, 395))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel2.setText("Réservation des billets");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(387, 387, 387))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Passid, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pid, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(Pname)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(PassName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FlCode, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FlightCode))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PGen, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Gen, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Numpasslabel)
                            .addComponent(NumPass, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Ntionalite)
                                    .addComponent(PNat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Amount)
                                    .addComponent(AmountTb, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(145, 145, 145)))))
                .addContainerGap())
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(Book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(booking)
                        .addGap(446, 446, 446))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(Pname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PassName))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Amount)
                            .addComponent(Ntionalite))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PNat))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(AmountTb))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(Numpasslabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NumPass, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(Gen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PGen))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(FlightCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FlCode))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(Pid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Passid)))
                .addGap(43, 43, 43)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Book, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(booking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Book.getAccessibleContext().setAccessibleName("Book");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 Connection Con = null;
 PreparedStatement pst = null;
 ResultSet Rs = null,Rs1 = null;
 Statement St = null,St1 = null;
 
 private void DisplayTicket()
 {
     try {
          Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
          St = Con.createStatement();
          Rs = St.executeQuery("select * from bookingtbl");
          Bookingtbl.setModel(DbUtils.resultSetToTableModel(Rs));
          
     } catch ( Exception e ){
     }   
 }
int TId = 0;
private void CountFlights()
{ 
   try {
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
        St1 = Con.createStatement();
        Rs1 = St1.executeQuery("select Max(TicketId) from bookingtbl");
        Rs1.next();
        TId = Rs1.getInt(1)+1;
   } catch (Exception e){
   }
}
 private void GetPassenger()
 {
     try {
          Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
          St = Con.createStatement();
          String Query = "select * from passengerstbl";
          Rs = St.executeQuery(Query);
          while(Rs.next())
          {
             String PI = String.valueOf(Rs.getInt("PI"));
             Passid.addItem(PI);
          }
     }
     catch ( Exception e ){
     }
 }
 private void GetFlights()
 {
     try {
          Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
          St = Con.createStatement();
          String Query = "select * from flights";
          Rs = St.executeQuery(Query);
          while(Rs.next())
          {
             String FiCode = String.valueOf(Rs.getString("flightcode"));
             FlCode.addItem(FiCode);
          }
          
     }
     catch ( Exception e ){
     }
 }
 
private void GetPassengersData()
{
    String Query = "select * from PassengersTbl where PI = " +Passid.getSelectedItem().toString();
    Statement St;
    ResultSet Rs;
    try {
          Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
          St = Con.createStatement();
          Rs = St.executeQuery(Query);
          if(Rs.next())
          {
             PassName.setText(Rs.getString("PName"));
             PGen.setText(Rs.getString("PGen"));
             NumPass.setText(Rs.getString("PPass"));
             PNat.setText(Rs.getString("PNat"));

          }
     }
     catch ( Exception e ){
     }  
}
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
       
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        Menu me = new Menu();
        me.setVisible(true);
        Tickets.super.dispose();
    }//GEN-LAST:event_button3ActionPerformed

    private void PassidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassidMouseClicked
        
    }//GEN-LAST:event_PassidMouseClicked

    private void PassidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassidActionPerformed
         GetPassengersData();
    }//GEN-LAST:event_PassidActionPerformed

    private void FlCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlCodeMouseClicked
     GetFlights();
    }//GEN-LAST:event_FlCodeMouseClicked

    private void FlCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlCodeActionPerformed
      
    }//GEN-LAST:event_FlCodeActionPerformed

    private void button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button3MouseClicked
     
    }//GEN-LAST:event_button3MouseClicked
    private void clear()
    {
        FlCode.setSelectedIndex(-1);
        // Passid.setSelectedIndex(-1);
        PassName.setText("");
        NumPass.setText("");
        PGen.setText("");
        PNat.setText("");
        AmountTb.setText("");
    }
    private void button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseClicked
     clear();
       
    }//GEN-LAST:event_button2MouseClicked

    private void PGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PGenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PGenActionPerformed

    private void PassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassNameActionPerformed

    private void BookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookActionPerformed

    private void BookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookMouseClicked
        if(Passid.getSelectedIndex()== -1 || FlCode.getSelectedIndex() == -1 ||AmountTb.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");

        }else{
            try {
                CountFlights();
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
                PreparedStatement Add = Con.prepareStatement("insert into bookingtbl values(?,?,?,?,?,?,?)");
                Add.setInt(1, TId);
                Add.setString(2, PassName.getText());
                Add.setString(3, FlCode.getSelectedItem().toString());
                Add.setString(4, PGen.getText());
                Add.setString(5, NumPass.getText());
                Add.setInt(6, Integer.valueOf(AmountTb.getText()));
                Add.setString(7, PNat.getText());
                int row = Add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Ticket booked");
                Con.close();
                DisplayTicket();
                clear();

            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_BookMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tickets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Amount;
    private javax.swing.JTextField AmountTb;
    private java.awt.Button Book;
    private javax.swing.JTable Bookingtbl;
    private javax.swing.JComboBox<String> FlCode;
    private javax.swing.JLabel FlightCode;
    private javax.swing.JLabel Gen;
    private javax.swing.JLabel Ntionalite;
    private javax.swing.JTextField NumPass;
    private javax.swing.JLabel Numpasslabel;
    private javax.swing.JTextField PGen;
    private javax.swing.JTextField PNat;
    private javax.swing.JTextField PassName;
    private javax.swing.JComboBox<String> Passid;
    private javax.swing.JLabel Pid;
    private javax.swing.JLabel Pname;
    private javax.swing.JLabel booking;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
