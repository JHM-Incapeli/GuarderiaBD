/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import clasesYAtributos.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier_Andres Herrera Manjarrez
 */
public class Archivos extends javax.swing.JPanel {

    /**
     * Creates new form Archivos
     */
    private ListasYmetodos base = new ListasYmetodos();
    private JPopupMenu meEmergente;
    JSeparator nu1, nu2, nu3;
    private JMenuItem elimiFila,Regargar, editar, buscarConsumo;
    private JScrollPane scull2;
    public Archivos() {
        initComponents();
        //scull2 = new JScrollPane();
        jScrollPane1.setBounds(0, 120, 985, 368);
        tablaDeContenido = (JTable) base.getMatricula_Acudiente_PCMensualidad();
        
        jScrollPane1.setViewportView(tablaDeContenido);
   
        jScrollPane1.getViewport().setBackground(new Color(237, 252, 243));
        
        
        
        meEmergente = new JPopupMenu();
        //scull2.setPreferredSize(new Dimension(150,150));
        //scull2.setViewportView((JTable) base.getMatricula_Acudiente_PCMensualidad());
        //meEmergente.add(scull2);
        nu1 = new JSeparator();
        nu2 = new JSeparator();
        nu3 = new JSeparator();
        
        elimiFila = new JMenuItem("Eliminar fila seleccionada");
        elimiFila.setForeground(Color.red);
        elimiFila.setFont(new Font("Arial",1,14));
        elimiFila.addActionListener((ActionEvent eve) ->{
            Icon icono = new ImageIcon(getClass().getResource("/imgjpanel/advertencia.png"));
            int confir = JOptionPane.showConfirmDialog(null, "Si seborra el infante se borra\n"+
                                                             "el registro de consumo que posee esté",
                    "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icono);
            if (confir == JOptionPane.YES_OPTION) {
                int filas = tablaDeContenido.getSelectedRow();
                if (filas == -1) {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar la fila a borrar");
                } else {
                    DefaultTableModel m = (DefaultTableModel) tablaDeContenido.getModel();
                    base.eliminarFila(1, Integer.parseInt((String)m.getValueAt(filas, 0)));
                    tablaDeContenido = (JTable) base.getMatricula_Acudiente_PCMensualidad();

                    jScrollPane1.setViewportView(tablaDeContenido);
                    tablaDeContenido.setComponentPopupMenu(meEmergente);
                }
            }
        }); 
        
        Regargar = new JMenuItem("Actualizar");
        Regargar.setForeground(Color.black);
        Regargar.setFont(new Font("Arial",1,14));
        Regargar.addActionListener((ActionEvent eve) ->{
            
            tablaDeContenido = (JTable) base.getMatricula_Acudiente_PCMensualidad();
            meEmergente.add(elimiFila);
            meEmergente.add(nu1);
            meEmergente.add(editar);
            meEmergente.add(nu2);
            meEmergente.add(Regargar);
            meEmergente.add(nu3);
            meEmergente.add(buscarConsumo);
            
            jScrollPane1.setViewportView(tablaDeContenido);
            tablaDeContenido.setComponentPopupMenu(meEmergente); 
        });
        
        editar = new JMenuItem("Editar fila seleccionada");
        editar.setForeground(new Color(6, 212, 30));
        editar.setFont(new Font("Arial",1,14));
        editar.addActionListener((ActionEvent eve) ->{
            
            String numMAtricula;
            int filas= tablaDeContenido.getSelectedRow();
            
            if(filas==-1){
                JOptionPane.showMessageDialog(null,"Debes seleccionar la fila a editar");
            }else{
                DefaultTableModel m = (DefaultTableModel) tablaDeContenido.getModel();
                numMAtricula = (String) m.getValueAt(filas,0);
                
                /**
                 * primero llamo registro infante que tambien va a servir para editar
                 */
                meEmergente.removeAll();
                meEmergente.add(Regargar);
                tablaDeContenido.setComponentPopupMenu(meEmergente);
                
                System.out.println(numMAtricula);
                
                registroInfante registro = new registroInfante(null, true); 
                registro.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                registro.setSize(1080, 700);
                registro.setResizable(false);
                registro.setTitle("Registro Infante");
                registro.setLocationRelativeTo(null);
                registro.getContentPane().setBackground(new Color(255, 233, 108));
                registro.datosDelaparaLaestraccion(numMAtricula);
                registro.tipoDeJDialog(1);
                registro.setVisible(true);
            }
        });
        
        buscarConsumo= new JMenuItem("Buscar los consumos realizados");
        buscarConsumo.setForeground(new Color(6, 212, 30));
        buscarConsumo.setFont(new Font("Arial",1,14));
        buscarConsumo.addActionListener((ActionEvent eve) ->{
            String numMAtricula;
            int filas= tablaDeContenido.getSelectedRow();
            
            if(filas==-1){
                JOptionPane.showMessageDialog(null,"Debes seleccionar la fila a editar");
            }else{
                DefaultTableModel m = (DefaultTableModel) tablaDeContenido.getModel();
                numMAtricula = (String) m.getValueAt(filas, 0);
                
                JDDatos = new JDialog();
                
                areaDatos = new JTextArea();
                areaDatos.setBackground(new Color(204,255,204));
                areaDatos.setForeground(Color.black);
                areaDatos.setFont(new java.awt.Font("Arial", 0, 18));
                areaDatos.setEditable(false);
                areaDatos.setText(base.getConsumoDeUnInfate(numMAtricula));

                scull = new JScrollPane();
                scull.setViewportView(areaDatos);
                scull.setBounds(10,10,450,450);
                JDDatos.getContentPane().add(scull);
                
                JDDatos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                JDDatos.setResizable(false);
                JDDatos.setSize(402,463);
                JDDatos.setTitle("Datos");
                JDDatos.setLocationRelativeTo(null);
                JDDatos.getContentPane().setBackground(new Color(34, 255, 248));
                JDDatos.setModal(true);
                JDDatos.setVisible(true);
            }
        });
        
        
        
        
        meEmergente.add(elimiFila);
        meEmergente.add(nu1);
        meEmergente.add(editar);
        meEmergente.add(nu2);
        meEmergente.add(Regargar);
        meEmergente.add(nu3);
        meEmergente.add(buscarConsumo);
        

        
        tablaDeContenido.setComponentPopupMenu(meEmergente);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDDatos = new javax.swing.JDialog();
        scull = new javax.swing.JScrollPane();
        areaDatos = new javax.swing.JTextArea();
        inicio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDeContenido = new javax.swing.JTable();

        JDDatos.getContentPane().setLayout(null);

        areaDatos.setBackground(new java.awt.Color(204, 255, 204));
        areaDatos.setColumns(20);
        areaDatos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        areaDatos.setForeground(new java.awt.Color(0, 0, 0));
        areaDatos.setRows(5);
        scull.setViewportView(areaDatos);

        JDDatos.getContentPane().add(scull);
        scull.setBounds(10, 10, 450, 450);

        setBackground(new java.awt.Color(255, 211, 70));
        setLayout(null);

        inicio.setBackground(new java.awt.Color(154, 0, 4));
        inicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inicio.setForeground(new java.awt.Color(0, 0, 0));
        inicio.setText("Inicio");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        add(inicio);
        inicio.setBounds(50, 30, 140, 30);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tablaDeContenido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaDeContenido);

        add(jScrollPane1);
        jScrollPane1.setBounds(2, 120, 1000, 402);
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        removeAll();
        updateUI();
        base.finalizarConexion();
        menu m = new menu();
        m.setBounds(0,0,1000,525);
        add(m.intconponente());
    }//GEN-LAST:event_inicioActionPerformed
    
    public JPanel iten (){
        return this;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JDDatos;
    private javax.swing.JTextArea areaDatos;
    private javax.swing.JButton inicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scull;
    private javax.swing.JTable tablaDeContenido;
    // End of variables declaration//GEN-END:variables
}
