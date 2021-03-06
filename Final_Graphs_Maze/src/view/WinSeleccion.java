package view;



import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class WinSeleccion extends javax.swing.JFrame {

    /**
     * Creates new form WinSeleccion
     */
    public WinSeleccion() {
        initComponents();
        myInit();
    }

  
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        li3 = new javax.swing.JLabel();
        li1 = new javax.swing.JLabel();
        li2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lf3 = new javax.swing.JLabel();
        lf1 = new javax.swing.JLabel();
        lf2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        ld3 = new javax.swing.JLabel();
        ld1 = new javax.swing.JLabel();
        ld2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccion de Laberinto");
        setBackground(new java.awt.Color(204, 255, 255));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Snap ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Personalizado");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Intermedio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14))); // NOI18N

        li3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        li3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                li3MouseClicked(evt);
            }
        });

        li1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        li1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                li1MouseClicked(evt);
            }
        });

        li2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        li2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                li2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(li1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(li3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(212, 212, 212)
                    .addComponent(li2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(219, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(li1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(li3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(li2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Facil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14))); // NOI18N

        lf3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lf3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lf3MouseClicked(evt);
            }
        });

        lf1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lf1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lf1MouseClicked(evt);
            }
        });

        lf2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lf2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lf2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lf1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(lf3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(212, 212, 212)
                    .addComponent(lf2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(219, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lf1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(lf3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lf2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Dificil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14))); // NOI18N

        ld3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ld3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ld3MouseClicked(evt);
            }
        });

        ld1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ld1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ld1MouseClicked(evt);
            }
        });

        ld2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ld2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ld2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(ld1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(ld3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(212, 212, 212)
                    .addComponent(ld2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(219, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ld1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(ld3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ld2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLabel2.setFont(new java.awt.Font("Snap ITC", 1, 18)); 
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Niveles");

        jButton1.setFont(new java.awt.Font("Tahoma", 2, 18)); 
        jButton1.setText("Abrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(43, 43, 43))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(248, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel2)
                    .addContainerGap(735, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(325, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel2)
                    .addContainerGap(484, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File f = jFileChooser1.getSelectedFile();
            this.dispose();
            new WinMaze(f, "Personalizado").setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lf1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lf1MouseClicked
        this.dispose();
        new WinMaze(getClass().getResource("/img/facil1.png").getFile(), "Facil").setVisible(true);
    }//GEN-LAST:event_lf1MouseClicked

    private void lf2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lf2MouseClicked
        this.dispose();
        new WinMaze(getClass().getResource("/img/facil2.png").getFile(), "Facil").setVisible(true);
    }//GEN-LAST:event_lf2MouseClicked

    private void lf3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lf3MouseClicked
        this.dispose();
        new WinMaze(getClass().getResource("/img/facil3.png").getFile(), "Facil").setVisible(true);
    }//GEN-LAST:event_lf3MouseClicked

    private void li1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_li1MouseClicked
        this.dispose();
        new WinMaze(getClass().getResource("/img/inter1.png").getFile(), "Intermedio").setVisible(true);
    }//GEN-LAST:event_li1MouseClicked

    private void li2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_li2MouseClicked
        this.dispose();
        new WinMaze(getClass().getResource("/img/inter2.png").getFile(), "Intermedio").setVisible(true);
    }//GEN-LAST:event_li2MouseClicked

    private void li3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_li3MouseClicked
        this.dispose();
        new WinMaze(getClass().getResource("/img/inter4.png").getFile(), "Intermedio").setVisible(true);
    }//GEN-LAST:event_li3MouseClicked

    private void ld1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ld1MouseClicked
        this.dispose();
        new WinMaze(getClass().getResource("/img/dificil1.png").getFile(), "Dificil").setVisible(true);
    }//GEN-LAST:event_ld1MouseClicked

    private void ld2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ld2MouseClicked
        this.dispose();
        new WinMaze(getClass().getResource("/img/dificil2.png").getFile(), "Dificil").setVisible(true);
    }//GEN-LAST:event_ld2MouseClicked

    private void ld3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ld3MouseClicked
        this.dispose();
        new WinMaze(getClass().getResource("/img/dificil3.png").getFile(), "Dificil").setVisible(true);
    }//GEN-LAST:event_ld3MouseClicked

    private void myInit(){
        //Filtro jfilechooser
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "png", "gif", "jpeg"));
        
        //Colocar imagenes
        lf1.setIcon(new ImageIcon(F1.getImage().getScaledInstance(lf1.getWidth(), lf1.getHeight(), Image.SCALE_DEFAULT)));
        lf2.setIcon(new ImageIcon(F2.getImage().getScaledInstance(lf2.getWidth(), lf2.getHeight(), Image.SCALE_DEFAULT)));
        lf3.setIcon(new ImageIcon(F3.getImage().getScaledInstance(lf3.getWidth(), lf3.getHeight(), Image.SCALE_DEFAULT)));
        li1.setIcon(new ImageIcon(I1.getImage().getScaledInstance(li1.getWidth(), li1.getHeight(), Image.SCALE_DEFAULT)));
        li2.setIcon(new ImageIcon(I2.getImage().getScaledInstance(li2.getWidth(), li2.getHeight(), Image.SCALE_DEFAULT)));
        li3.setIcon(new ImageIcon(I4.getImage().getScaledInstance(li3.getWidth(), li3.getHeight(), Image.SCALE_DEFAULT)));
        ld1.setIcon(new ImageIcon(D1.getImage().getScaledInstance(ld1.getWidth(), ld1.getHeight(), Image.SCALE_DEFAULT)));
        ld2.setIcon(new ImageIcon(D2.getImage().getScaledInstance(ld2.getWidth(), ld2.getHeight(), Image.SCALE_DEFAULT)));
        ld3.setIcon(new ImageIcon(D3.getImage().getScaledInstance(ld3.getWidth(), ld3.getHeight(), Image.SCALE_DEFAULT)));
    }
    
    private final ImageIcon F1 = new ImageIcon(getClass().getResource("/img/facil1.png"));
    private final ImageIcon F2 = new ImageIcon(getClass().getResource("/img/facil2.png"));
    private final ImageIcon F3 = new ImageIcon(getClass().getResource("/img/facil3.png"));
    private final ImageIcon I1 = new ImageIcon(getClass().getResource("/img/inter1.png"));
    private final ImageIcon I2 = new ImageIcon(getClass().getResource("/img/inter2.png"));
    private final ImageIcon I3 = new ImageIcon(getClass().getResource("/img/inter3.png"));
    private final ImageIcon I4 = new ImageIcon(getClass().getResource("/img/inter4.png"));
    private final ImageIcon D1 = new ImageIcon(getClass().getResource("/img/dificil1.png"));
    private final ImageIcon D2 = new ImageIcon(getClass().getResource("/img/dificil2.png"));
    private final ImageIcon D3 = new ImageIcon(getClass().getResource("/img/dificil3.png"));
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel ld1;
    private javax.swing.JLabel ld2;
    private javax.swing.JLabel ld3;
    private javax.swing.JLabel lf1;
    private javax.swing.JLabel lf2;
    private javax.swing.JLabel lf3;
    private javax.swing.JLabel li1;
    private javax.swing.JLabel li2;
    private javax.swing.JLabel li3;
    // End of variables declaration//GEN-END:variables
}
