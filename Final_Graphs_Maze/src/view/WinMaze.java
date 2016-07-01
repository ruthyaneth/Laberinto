package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import logic.Busqueda;


public class WinMaze extends javax.swing.JFrame {

    /**
     * Creates new form WinMain
     *
     * @param archivo
     * @param tipo
     */
    public WinMaze(File archivo, String tipo) {
        initComponents();
        myInit(archivo, tipo);
    }

    public WinMaze(String archivo, String tipo) {
        this(new File(archivo), tipo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        b_solucion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MazeResolve");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        b_solucion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        b_solucion.setText("Solucionar");
        b_solucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_solucionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_solucion)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_solucion)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_solucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_solucionActionPerformed
        if (inicio == false) {
            b_solucion.setText("Detener");
            inicio = true;
            new Thread(new Runnable() {

                @Override
                public void run() {
                    Busqueda b;
                    try {
                    	Thread.sleep(5);
                        panelImg.imagen = ImageIO.read(file);
                        b = new Busqueda(panelImg);
                        b.solucionar();                                           
                        inicio = false;
                        b_solucion.setText("Solucionar");
                        panelImg.updateUI();
                        JOptionPane.showMessageDialog(yo(), "Terminado :D", "Fin", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        Logger.getLogger(WinMaze.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(yo(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }).start();
        } else {
            //Detener
            inicio = false;
            panelImg.detener = true;
            b_solucion.setText("Solucionar");
        }
    }//GEN-LAST:event_b_solucionActionPerformed

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        panelImg.setBounds(1, 1, jPanel1.getWidth() - 2, jPanel1.getHeight() - 2);
        panelImg.updateUI();
        panelImg.setPuntos = 0;
    }//GEN-LAST:event_jPanel1ComponentResized

    private JFrame yo() {
        return this;
    }

    private void myInit(File f, String tipo) {
        file = f;
        inicio = false;

        //Crenado panel de imagen
        panelImg = new PanelImg();
        panelImg.setBounds(1, 1, jPanel1.getWidth() - 2, jPanel1.getHeight() - 2);
        panelImg.setOpaque(false);
        try {
            panelImg.imagen = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(WinMaze.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanel1.add(panelImg);

        //Filtro jfilechooser
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "png", "gif", "jpeg"));
    }

    private PanelImg panelImg;
    private File file;
    private boolean inicio;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_solucion;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
