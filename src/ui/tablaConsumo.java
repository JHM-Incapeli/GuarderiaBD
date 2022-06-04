/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import clasesYAtributos.*;
import java.awt.*;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier_Andres Herrera Manjarrez
 */
public class tablaConsumo extends javax.swing.JPanel {

    /**
     * Creates new form tablaConsumo
     */
    private ListasYmetodos base = new ListasYmetodos();
    private JPopupMenu meEmergente;
    private JMenuItem eliminarFilaconsumo, tablaMenus, eliminarMenu, tablaconsumos, buscarmenu;
    private JDialog JDDatos;
    private JTextArea areaDatos;
    private JScrollPane scull;
    private clasesYAtributos.Menu menu;
    public tablaConsumo() {
        initComponents();
        meEmergente = new JPopupMenu();
        JSeparator s1 = new JSeparator();
        
        jScrollPane1.setBounds(0, 120, 985, 368);
        tablaDeConsumo = (JTable) base.getTablaConsumosDeInfantes();
        jScrollPane1.setViewportView(tablaDeConsumo);
        jScrollPane1.getViewport().setBackground(new Color(237, 252, 243));
        
        eliminarFilaconsumo = new JMenuItem("Eliminar Fila");
        eliminarFilaconsumo.setForeground(Color.RED);
        eliminarFilaconsumo.setFont(new Font("Arial",1,14));
        eliminarFilaconsumo.addActionListener((ActionEvent eve) ->{
            Icon icono = new ImageIcon(getClass().getResource("/imgjpanel/escoger.png"));
            int confir = JOptionPane.showConfirmDialog(null, "Confirme su decición",
                    "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icono);
            if (confir == JOptionPane.YES_OPTION) {

                int fila = tablaDeConsumo.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar la fila a borrar");
                } else {
                    DefaultTableModel m = (DefaultTableModel) tablaDeConsumo.getModel();
                    base.eliminarFila(2, Integer.parseInt((String) m.getValueAt(fila, 0)));
                    tablaDeConsumo = (JTable) base.getTablaConsumosDeInfantes();

                    jScrollPane1.setViewportView(tablaDeConsumo);
                    tablaDeConsumo.setComponentPopupMenu(meEmergente);
                }

            }
        });
        tablaMenus = new JMenuItem("Tabla Menús");
        tablaMenus.setForeground(Color.black);
        tablaMenus.setFont(new Font("Arial",1,14));
        tablaMenus.addActionListener((ActionEvent eve) ->{
            Icon icono = new ImageIcon(getClass().getResource("/imgjpanel/escoger.png"));
            int confir = JOptionPane.showConfirmDialog(null, "Confirme su decición",
                    "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icono);
            if (confir == JOptionPane.YES_OPTION) {
                meEmergente.removeAll();
                meEmergente.add(buscarmenu);
                meEmergente.add(s1);
                meEmergente.add(tablaconsumos);
                
                
                tablaDeConsumo.removeAll();
                
                tablaDeConsumo =(JTable) base.getTablaMenus();
                jScrollPane1.setViewportView(tablaDeConsumo);
                tablaDeConsumo.setComponentPopupMenu(meEmergente);
            }
        });
        
        tablaconsumos = new JMenuItem("Tabla Consumos");
        tablaconsumos.setForeground(Color.black);
        tablaconsumos.setFont(new Font("Arial",1,14));
        tablaconsumos.addActionListener((ActionEvent eve) ->{
            Icon icono = new ImageIcon(getClass().getResource("/imgjpanel/escoger.png"));
            int confir = JOptionPane.showConfirmDialog(null, "Confirme su decición",
                    "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icono);
            if (confir == JOptionPane.YES_OPTION) {
                meEmergente.removeAll();
                meEmergente.add(eliminarFilaconsumo);
                meEmergente.add(s1);
                meEmergente.add(tablaMenus);
                
                tablaDeConsumo.removeAll();
                
                tablaDeConsumo =(JTable) base.getTablaConsumosDeInfantes();
                jScrollPane1.setViewportView(tablaDeConsumo);
                tablaDeConsumo.setComponentPopupMenu(meEmergente);
            }
        });
        /*
        eliminarMenu = new JMenuItem("Eliminar Menú");
        eliminarMenu.setForeground(Color.red);
        eliminarMenu.setFont(new Font("Arial",1,14));
        eliminarMenu.addActionListener((ActionEvent eve) ->{
            Icon icono = new ImageIcon(getClass().getResource("/imgjpanel/advertencia.png"));
            int confir = JOptionPane.showConfirmDialog(null, """
                                                             Si borra un menú se
                                                             se borraran todos los 
                                                             consumos con este menú
                                                             """,
                    "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icono);
            if (confir == JOptionPane.YES_OPTION) {
                int fila = tablaDeConsumo.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar la fila a borrar");
                } else {
                    DefaultTableModel m = (DefaultTableModel) tablaDeConsumo.getModel();
                    base.eliminarFila(3, Integer.parseInt((String) m.getValueAt(fila, 0)));
                    tablaDeConsumo = (JTable) base.getTablaConsumosDeInfantes();

                    jScrollPane1.setViewportView(tablaDeConsumo);
                    tablaDeConsumo.setComponentPopupMenu(meEmergente);
                }
            }
        });
        */
        buscarmenu = new JMenuItem("Buscar datos del Menú");
        buscarmenu.setForeground(Color.black);
        buscarmenu.setFont(new Font("Arial",1,14));
        buscarmenu.addActionListener((ActionEvent eve) ->{
            Icon icono = new ImageIcon(getClass().getResource("/imgjpanel/escoger.png"));
            int confir = JOptionPane.showConfirmDialog(null, "Confirme su decisión ",
                    "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icono);
            if (confir == JOptionPane.YES_OPTION) {
                
                int fila = tablaDeConsumo.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "1. selecciona el menú");
                } else {
                    DefaultTableModel m = (DefaultTableModel) tablaDeConsumo.getModel();
                    menu = base.getMenu((String) m.getValueAt(fila, 0));
                    String datos = "**********************************************************\n"
                            + "Numero del Menu:  " + menu.getNumeroMenu()
                            + "\nCosto del Menu:  " + menu.getCostoMenu() + "$\n"
                            + "-------------------------------------------------------------------\n";
                    String[] auxi1 = new String[5];
                    String[] auxi2 = new String[5];
                    String[] auxi5 = new String[5];
                    if (menu.getNombrePlatos().contains("¡")) {
                        auxi1 = (menu.getNombrePlatos()).split("¡");
                        auxi2 = (menu.getIngredientes()).split("¡");
                        auxi5 = (menu.getCostoDelosPlato()).split("¡");
                    } else {
                        auxi1[0] = menu.getNombrePlatos();
                        auxi2[0] = menu.getIngredientes();
                        auxi5[0] = menu.getCostoDelosPlato();
                    }

                    for (int i = 0; i < auxi1.length; i++) {
                        if (auxi1[i] != null) {
                            datos += ("\nPlato N° " + (i + 1) + " : " + auxi1[i])
                                    + "\nCosto del plato:  " + auxi5[i]
                                    + "\nIgredientes:\n";
                            String[] auxi3 = (auxi2[i]).split(" ");
                            int p = 1;
                            for (String auxi4 : auxi3) {
                                if (p % 4 == 0) {
                                    datos += " " + auxi4 + "\n";
                                } else {
                                    datos += " " + auxi4;
                                }
                                p++;
                            }
                            datos += "\n-------------------------------------------------------------------";
                        }
                    }
                    JDDatos = new JDialog();

                    areaDatos = new JTextArea();
                    areaDatos.setBackground(new Color(204, 255, 204));
                    areaDatos.setForeground(Color.black);
                    areaDatos.setFont(new java.awt.Font("Arial", 0, 18));
                    areaDatos.setEditable(false);
                    areaDatos.setText(datos);

                    scull = new JScrollPane();
                    scull.setViewportView(areaDatos);
                    scull.setBounds(10, 10, 450, 450);
                    JDDatos.getContentPane().add(scull);

                    JDDatos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    JDDatos.setResizable(false);
                    JDDatos.setSize(402, 463);
                    JDDatos.setTitle("Datos");
                    JDDatos.setLocationRelativeTo(null);
                    JDDatos.getContentPane().setBackground(new Color(34, 255, 248));
                    JDDatos.setModal(true);
                    JDDatos.setVisible(true);
                }
            }
        });

        meEmergente.add(eliminarFilaconsumo);
        meEmergente.add(s1);
        meEmergente.add(tablaMenus);
        tablaDeConsumo.setComponentPopupMenu(meEmergente);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDeConsumo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 211, 70));
        setPreferredSize(new java.awt.Dimension(1000, 525));
        setLayout(null);

        tablaDeConsumo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaDeConsumo);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 120, 980, 370);

        jButton1.setBackground(new java.awt.Color(154, 0, 4));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Inicio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(50, 30, 140, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        removeAll();
        updateUI();
        base.finalizarConexion();
        menu m = new menu();
        m.setBounds(0,0,1000,525);
        add(m.intconponente());
    }//GEN-LAST:event_jButton1ActionPerformed
     
    public JPanel iten(){
        return this;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDeConsumo;
    // End of variables declaration//GEN-END:variables
}
