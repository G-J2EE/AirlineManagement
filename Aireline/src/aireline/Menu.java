package aireline;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        vols = new javax.swing.JButton();
        manfli = new javax.swing.JButton();
        Billets = new javax.swing.JButton();
        CancelB = new javax.swing.JButton();
        passengers = new javax.swing.JButton();
        dec = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));

        vols.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        vols.setForeground(new java.awt.Color(0, 102, 102));
        vols.setText("Vols");
        vols.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volsActionPerformed(evt);
            }
        });

        manfli.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        manfli.setForeground(new java.awt.Color(0, 102, 102));
        manfli.setText("Gerer les Vols");
        manfli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manfliActionPerformed(evt);
            }
        });

        Billets.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Billets.setForeground(new java.awt.Color(0, 102, 102));
        Billets.setText("Billets ");
        Billets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BilletsActionPerformed(evt);
            }
        });

        CancelB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CancelB.setForeground(new java.awt.Color(0, 102, 102));
        CancelB.setText("Annulation des billets");
        CancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBActionPerformed(evt);
            }
        });

        passengers.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        passengers.setForeground(new java.awt.Color(0, 102, 102));
        passengers.setText("Pssengers");
        passengers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passengersActionPerformed(evt);
            }
        });

        dec.setBackground(new java.awt.Color(255, 51, 51));
        dec.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        dec.setForeground(new java.awt.Color(255, 255, 255));
        dec.setText("DECONNECTER");
        dec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passengers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CancelB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Billets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vols, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manfli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(dec, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(manfli, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vols, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Billets, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CancelB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passengers, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(dec, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Downloads\\pngwing.com.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void decActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decActionPerformed
        Login log = new Login();
        log.setVisible(true);
        Menu.super.dispose();
    }//GEN-LAST:event_decActionPerformed

    private void manfliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manfliActionPerformed
        Menu.super.dispose();
        ManageFlights mf = new ManageFlights();
        mf.setVisible(true);
    }//GEN-LAST:event_manfliActionPerformed

    private void volsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volsActionPerformed
        // TODO add your handling code here:
        Menu.super.dispose();
        Vols fl = new Vols();
        fl.setVisible(true);
    }//GEN-LAST:event_volsActionPerformed

    private void BilletsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BilletsActionPerformed
      Menu.super.dispose();
        Tickets tk = new Tickets();
        tk.setVisible(true);
    }//GEN-LAST:event_BilletsActionPerformed

    private void CancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBActionPerformed
        Menu.super.dispose();
        CancelTicket Ctk = new CancelTicket();
        Ctk.setVisible(true);
    }//GEN-LAST:event_CancelBActionPerformed

    private void passengersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passengersActionPerformed
        Menu.super.dispose();
        Passengers pas = new Passengers();
        pas.setVisible(true);
    }//GEN-LAST:event_passengersActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Billets;
    private javax.swing.JButton CancelB;
    private javax.swing.JButton dec;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton manfli;
    private javax.swing.JButton passengers;
    private javax.swing.JButton vols;
    // End of variables declaration//GEN-END:variables
}
