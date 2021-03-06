/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexionBD.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lupita
 */
public class RegistroPacientes extends javax.swing.JFrame {
    
    private Object[][] datos;
    private TablaPaciente pacientes;
    DefaultTableModel modelo;

    /**
     * Creates new form VerPaciente
     */
    public RegistroPacientes() {
        initComponents();
        pacientes = new TablaPaciente();       
        setLocationRelativeTo(null);
        actualizarTabla();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
    
    public void ingresoMedico(){
        eliminar.setVisible(false);
    }
  
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPopupMenu();
        ver = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();

        ver.setText("Ver Paciente");
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        menu.add(ver);
        menu.add(jSeparator1);

        eliminar.setText("Eliminar Paciente");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        menu.add(eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jLabel4.setText("Registro de Pacientes");

        tablaPacientes = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        };
        tablaPacientes.setBorder(new javax.swing.border.MatteBorder(null));
        tablaPacientes.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaPacientes.setComponentPopupMenu(menu);
        tablaPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaPacientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaPacientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void actualizarTabla(){
        String[] nombreColumnas = {"CodigoPaciente", "Nombres", "Apellidos","Sexo","Edad"};
        datos = pacientes.getDatos();
        modelo = new DefaultTableModel(datos, nombreColumnas);
        tablaPacientes.setModel(modelo);    // :s no entiendo bien xx
    }
    
    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        // TODO add your handling code here:
        int fila = tablaPacientes.getSelectedRow();
        if(fila>-1){
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String codigo = (String) tablaPacientes.getValueAt(fila, 0);
                VerPaciente pacientes = new VerPaciente(codigo);
                pacientes.setVisible(true); 
            }
        });
       }
        
    }//GEN-LAST:event_verActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        int fila = tablaPacientes.getSelectedRow();
        if(fila>-1){
            String codigo = (String) tablaPacientes.getValueAt(fila, 0);
            pacientes.BorrarPaciente(codigo);
            JOptionPane.showMessageDialog(rootPane,"Se ha borrado al paciente con exito","Borrado exitoso",JOptionPane.INFORMATION_MESSAGE);
            actualizarTabla();
        }
        
    }//GEN-LAST:event_eliminarActionPerformed

     
     
        
    /**
     * @param args the command line arguments
     */
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JTable tablaPacientes;
    private javax.swing.JMenuItem ver;
    // End of variables declaration//GEN-END:variables
}
