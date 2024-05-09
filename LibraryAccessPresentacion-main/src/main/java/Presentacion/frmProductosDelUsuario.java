/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import DTO.ProductoDTO;
import DTO.UsuarioDTO;
import IProductosDelUsuario.IProductosUsuario;
import Negocio.ProductoSeleccionado;
import Negocio.UsuarioSesion;
import ProductosDelUsuario.ProductosUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author INEGI
 */
public class frmProductosDelUsuario extends javax.swing.JFrame {
    IProductosUsuario productosUsuario;
    
    
    public frmProductosDelUsuario() {
        productosUsuario= new ProductosUsuario();
        initComponents();
        tabla();
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.SystemColor.activeCaptionBorder);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PRODUCTOS A RESEÑAR");

        jScrollPane4.setBackground(new java.awt.Color(227, 227, 227));
        jScrollPane4.setFocusable(false);

        tblConsultas = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblConsultas.getTableHeader().setReorderingAllowed(false);
        tblConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblConsultas);

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.jpg"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuUsuario ve = new MenuUsuario();
        ve.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tblConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultasMouseClicked
 int filaSeleccionada = tblConsultas.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tblConsultas.getModel();
            ProductoDTO productoSeleccionado = new ProductoDTO();
            productoSeleccionado.setIsbn((int) model.getValueAt(filaSeleccionada, 0));
            productoSeleccionado.setTitulo((String) model.getValueAt(filaSeleccionada, 1));
            productoSeleccionado.setAutor((String) model.getValueAt(filaSeleccionada, 2));
            productoSeleccionado.setTipo((String) model.getValueAt(filaSeleccionada, 3));
            productoSeleccionado.setEditorial((String) model.getValueAt(filaSeleccionada, 4));
            productoSeleccionado.setPrecio((double) model.getValueAt(filaSeleccionada, 5));
            productoSeleccionado.setCategoria((String) model.getValueAt(filaSeleccionada, 6));

            ProductoSeleccionado.setPersonaSeleccionada(productoSeleccionado);

            FrmGenerarReseña ventana = new FrmGenerarReseña();
            ventana.setVisible(true);
        }

    }//GEN-LAST:event_tblConsultasMouseClicked

    
    public void tabla() {
        tblConsultas.setDefaultRenderer(Object.class, new RenderTabla());

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tblConsultas.setModel(modeloTabla);

        tblConsultas.setRowHeight(40);

        // Definición de las columnas y sus encabezados
        String[] encabezados = {"ISBN", "Titulo", "Autor", "Tipo", "Editorial", "Precio",  "Categoria"};
        modeloTabla.setColumnIdentifiers(encabezados);

        int[] anchos = {100, 100, 100, 100, 100, 100, 100}; // Ajusta el ancho de la última columna
        for (int i = 0; i < anchos.length; i++) {
            tblConsultas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }
    
    public void llenarTabla() {
    UsuarioDTO usuarioDTO = UsuarioSesion.usuarioSesion();
        List<ProductoDTO> productosEncontrados = productosUsuario.consultarProductosCompradosPorUsuario(usuarioDTO.getNombreUsuario());

        DefaultTableModel modeloTabla = (DefaultTableModel) tblConsultas.getModel();
        modeloTabla.setRowCount(0);

        for (ProductoDTO producto : productosEncontrados) {
            Object[] fila = {
                producto.getIsbn(),
                producto.getTitulo(),
                producto.getAutor(),
                producto.getTipo(),
                producto.getEditorial(),
                producto.getPrecio(),
                producto.getCategoria(),
            };
            modeloTabla.addRow(fila);
        }
    }


  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblConsultas;
    // End of variables declaration//GEN-END:variables
}
