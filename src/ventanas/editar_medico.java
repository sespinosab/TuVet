package ventanas;

import tuvet.Conector_DB;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class editar_medico extends javax.swing.JFrame {

    Conector_DB conector =new Conector_DB();
    String nombre_db="veterinaria";
    
    public editar_medico() {
        initComponents();
        setLocationRelativeTo(null);
        
        conector.conectar(nombre_db);
        Connection reg =conector.getConnection();
        System.out.println(reg);
        formato_tabla();
        Auto_agrandado_columnas();
    }
    
    void Auto_agrandado_columnas() {
    final TableColumnModel columnModel = tabla_datos.getColumnModel();
    for (int column = 0; column < tabla_datos.getColumnCount(); column++) {
        int width = 15; // Min width
        for (int row = 0; row < tabla_datos.getRowCount(); row++) {
            TableCellRenderer renderer = tabla_datos.getCellRenderer(row, column);
            Component comp = tabla_datos.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width +1 , width);
        }
        if(width > 300)
            width=300;
        columnModel.getColumn(column).setPreferredWidth(width);
    }
    }
    
    void formato_tabla()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Estudios Medicos");
        modelo.addColumn("Consultario Medico");
        modelo.addColumn("ID Persona");
        tabla_datos.setModel(modelo);
        String sql= "SELECT * FROM medico";
        String data[]=new String [3];
        try {
            Statement st = conector.conectar(nombre_db).createStatement();
            ResultSet resultado=st.executeQuery(sql);
            while(resultado.next())
            {
                data[0]=resultado.getString(1);
                data[1]=resultado.getString(2);
                data[2]=resultado.getString(3);
                modelo.addRow(data);
            }
            tabla_datos.setModel(modelo);
        } catch (SQLException ex) {
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Eliminar = new javax.swing.JButton();
        Crear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Consultorio = new javax.swing.JTextField();
        Estudios = new javax.swing.JTextField();
        Medico = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_datos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Eliminar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Crear.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Crear.setText("Crear");
        Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Consultorio");

        Consultorio.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        Estudios.setEditable(false);
        Estudios.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        Medico.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Medico");

        Salir.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        tabla_datos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        tabla_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_datos);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Estudios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Estudios)
                    .addComponent(Consultorio)
                    .addComponent(Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Medico, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Estudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Consultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(Crear))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Salir)
                            .addComponent(Eliminar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        try {
            PreparedStatement eliminar_datos=conector.conectar(nombre_db).prepareStatement("DELETE * FROM medico WHERE Persona_id_Persona='"+Medico.getText()+"'");
            eliminar_datos.executeQuery();
            JOptionPane.showMessageDialog(null,"Datos eliminados");
            formato_tabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al Actualizar");
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearActionPerformed
        try {
            PreparedStatement crear_datos=conector.conectar(nombre_db).prepareStatement("INSERT INTO mascota VALUES('"+Estudios.getText()+"','"+Consultorio.getText()+"','"+Math.random()*(900-100)+"');");
            crear_datos.executeQuery();
            JOptionPane.showMessageDialog(null,"Datos actualizados");
            formato_tabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al Actualizar");
        }
    }//GEN-LAST:event_CrearActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        new menu_principal_admin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void tabla_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_datosMouseClicked
        int seleccion=tabla_datos.rowAtPoint(evt.getPoint());
        Estudios.setText(String.valueOf(tabla_datos.getValueAt(seleccion,0)));
        Consultorio.setText(String.valueOf(tabla_datos.getValueAt(seleccion,1)));
        Medico.setText(String.valueOf(tabla_datos.getValueAt(seleccion,2)));

    }//GEN-LAST:event_tabla_datosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            PreparedStatement actualizar_datos=conector.conectar(nombre_db).prepareStatement("UPDATE medico SET Estudios_Medico='"+Estudios.getText()+"', Consultorio_Medico='"+Consultorio.getText()+"' WHERE Persona_id_Persona='"+Medico.getText()+"'");
            actualizar_datos.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos actualizados");
            formato_tabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al Actualizar");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(editar_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editar_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editar_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editar_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editar_medico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Consultorio;
    private javax.swing.JButton Crear;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTextField Estudios;
    private javax.swing.JTextField Medico;
    private javax.swing.JButton Salir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_datos;
    // End of variables declaration//GEN-END:variables
}
