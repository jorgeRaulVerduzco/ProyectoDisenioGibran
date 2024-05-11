/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import DTO.PagoDTO;
import DTO.UsuarioDTO;
import DTO.ProductoDTO;
import HistorialUsuario.HistorialUsuario;
import IHistorialUsuario.IHistorialUsuario;
import IProductosDelUsuario.IProductosUsuario;
import Negocio.PagoBO;
import Negocio.ProductoSeleccionado;
import Negocio.UsuarioSesion;
import ProductosDelUsuario.ProductosUsuario;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;

/**
 *
 * @author Bell
 */
public final class HistorialDeCompras extends javax.swing.JFrame implements Printable {

    IHistorialUsuario historial;

    public HistorialDeCompras() {
        initComponents();
        historial = new HistorialUsuario();
        tabla();
        llenarTabla();
    }

    public void tabla() {
        Tabla.setDefaultRenderer(Object.class, new RenderTabla());
        DefaultTableModel modeloTabla = new DefaultTableModel();
        Tabla.setModel(modeloTabla);
        Tabla.setRowHeight(40);

        String[] encabezados = {"FechaDePago", "Titulo ", "Cantidad", "Costo"};
        modeloTabla.setColumnIdentifiers(encabezados);

        int[] anchos = {220, 80, 50, 50,};
        for (int i = 0; i < anchos.length; i++) {
            Tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    public void llenarTabla() {

        UsuarioDTO usuarioDTO = UsuarioSesion.usuarioSesion();
        String nombreUsuario = usuarioDTO.getNombreUsuario();
        List<Object> productosEncontrados = historial.consultarHistorialComprasPorUsuario(nombreUsuario);
        DefaultTableModel modeloTabla = (DefaultTableModel) Tabla.getModel();
        modeloTabla.setRowCount(0);

        if (productosEncontrados != null) {
            System.out.println("Número de productos encontrados: " + productosEncontrados.size());
            for (Object pago : productosEncontrados) {
                Map<String, Object> histoMap = (Map<String, Object>) pago;
                System.out.println("Mapa de historial: " + histoMap);

                Date fechaPago = (Date) histoMap.get("fechaDePago"); // <-- Aquí corregido
                String titulo = (String) histoMap.get("titulo");
                int cantidad = (int) histoMap.get("cantidad");
                double costoTotal = (double) histoMap.get("costoTotal");

                modeloTabla.addRow(new Object[]{fechaPago, titulo, cantidad, costoTotal});
            }
        } else {
            System.out.println("No se encontraron productos");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton4 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tus pedidos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(108, 108, 108))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 6, -1, -1));

        jToggleButton4.setBackground(new java.awt.Color(102, 102, 102));
        jToggleButton4.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton4.setText("<");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 6, -1, -1));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 172, 469, 340));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hace 7 dias", "Hace 2 meses", "Hace 6 meses", "Hace 12 mese" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 132, -1, -1));

        jToggleButton1.setBackground(new java.awt.Color(51, 255, 51));
        jToggleButton1.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setText("Sacar PDF");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        MenuUsuario MU = new MenuUsuario();
        MU.setVisible(true);
        dispose();
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked

    }//GEN-LAST:event_TablaMouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(this);
        if (pj.printDialog()) {

            try {
                pj.print();
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo imprimir");
        }

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton4;
    // End of variables declaration//GEN-END:variables

  public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
    
        if (pageIndex == 0) {
            
            Graphics2D graphics2d = (Graphics2D) graphics;
            graphics2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            printAll(graphics2d);
            
            return PAGE_EXISTS;
        } else {
            
            return NO_SUCH_PAGE;
        }
        
  
    }
}
