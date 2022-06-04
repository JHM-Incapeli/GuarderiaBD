
package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import clasesYAtributos.MenuEmergente;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


/**
 *
 * @author Javier_Andres Herrera Manjarrez
 */
public class menu extends JPanel {

    private JLabel etiArrivaCentral;
    private JLabel imagenCentral;
    private JButton btnRegistrar;
    private Icon ico;
    private JButton btnArchivos;
    private JButton btnAnadirMenu,btnconsumo;
    private JButton btnConsumon;
    private JLabel etiUno;
    private JLabel etDos;
    private JLabel etitre;
    private JLabel etiCuatro, eticonsumo;
    private JDialog ventanaFormularioRegistro;
    private JPanel panelDatosInfante, fechaNcimiento;
    private JButton btnOFF;
    private MenuEmergente menu;

    public menu() {
        setLayout(null);
        setBackground(new java.awt.Color(255, 251, 119));
        menu = new MenuEmergente();
        setComponentPopupMenu(menu.getMenuEmergente());

    }

    public JPanel intconponente() {
        etiArrivaCentral = new javax.swing.JLabel();
        imagenCentral = new javax.swing.JLabel();
        btnRegistrar = new JButton();
        btnArchivos = new JButton();
        btnOFF = new JButton();
        btnAnadirMenu = new JButton();
        btnConsumon = new JButton();
        etiUno = new JLabel("Registrar", SwingConstants.CENTER);
        etDos = new JLabel("Archivos", SwingConstants.CENTER);
        etitre = new JLabel("Añadir menu", SwingConstants.CENTER);
        etiCuatro = new JLabel("Tabla de Consumo", SwingConstants.CENTER);
        btnconsumo = new JButton();

        etiArrivaCentral.setBackground(new java.awt.Color(255, 199, 8));
        etiArrivaCentral.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        etiArrivaCentral.setForeground(new java.awt.Color(0, 0, 0));
        etiArrivaCentral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiArrivaCentral.setText("Jardin de infantes");
        etiArrivaCentral.setOpaque(true);
        etiArrivaCentral.setBounds(250, 71, 500, 31);
        add(etiArrivaCentral);

        imagenCentral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img"+File.separator+"guarderia.png"))); // NOI18N
        imagenCentral.setBounds(436, 128, 130, 110);
        add(imagenCentral);

        btnRegistrar.setBackground(new Color(251, 236, 24));
        btnRegistrar.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 119)));
        ico = new ImageIcon(getClass().getResource("/img"+File.separator+"curriculum.png"));
        btnRegistrar.setIcon(ico);
        btnRegistrar.setBounds(192, 300, 128, 128);
        btnRegistrar.setOpaque(false);
        add(btnRegistrar);
        etiUno.setBounds(208, 428, 82, 28);
        etiUno.setFont(new Font("Arial", 3, 18));
        add(etiUno);

        btnArchivos.setBackground(new Color(251, 236, 24));
        btnArchivos.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 119)));
        ico = new ImageIcon(getClass().getResource("/img"+File.separator+"archivos.png"));
        btnArchivos.setIcon(ico);
        btnArchivos.setBounds(362, 300, 128, 128);
        btnArchivos.setOpaque(false);
        add(btnArchivos);
        etDos.setBounds(385, 428, 82, 28);
        etDos.setFont(new Font("Arial", 3, 18));
        add(etDos);

        btnAnadirMenu.setBackground(new Color(251, 236, 24));
        btnAnadirMenu.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 119)));
        ico = new ImageIcon(getClass().getResource("/img"+File.separator+"menu.png"));
        btnAnadirMenu.setIcon(ico);
        btnAnadirMenu.setBounds(517, 300, 128, 128);
        btnAnadirMenu.setOpaque(false);
        add(btnAnadirMenu);
        etitre.setBounds(517, 428, 128, 28);
        etitre.setFont(new Font("Arial", 3, 18));
        add(etitre);

        btnConsumon.setBackground(new Color(251, 236, 24));
        btnConsumon.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 119)));
        ico = new ImageIcon(getClass().getResource("/img"+File.separator+"agregar_consumo.png"));
        btnConsumon.setIcon(ico);
        btnConsumon.setBounds(690, 300, 128, 128);
        btnConsumon.setOpaque(false);
        add(btnConsumon);
        etiCuatro.setBounds(668, 428, 171, 28);
        etiCuatro.setFont(new Font("Arial", 3, 18));
        add(etiCuatro);
        
        
        btnOFF.setBounds(0,0,32,32);
        Icon ico = new ImageIcon(getClass().getResource("/img"+File.separator+"btnApagar.png"));
        btnOFF.setIcon(ico);
        btnOFF.setBackground(new Color(255, 251, 119));
        btnOFF.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 119)));
        add(btnOFF);
        
        Icon i = new ImageIcon(getClass().getResource("/img"+File.separator+"comiendo.png"));
        btnconsumo.setBounds(68, 223, 64, 64);
        btnconsumo.setBackground(new Color(251, 236, 24));
        btnconsumo.setIcon(i);
        add(btnconsumo);
        eticonsumo = new JLabel("Generar consumo",SwingConstants.CENTER);
        eticonsumo.setBounds(15,289,171,27);
        eticonsumo.setFont(new Font("Arial",3,17));
        add(eticonsumo);

        btnRegistrar.addActionListener((ActionEvent even) -> {
            registroInfante registro = new registroInfante(null, true);
            registro.tipoDeJDialog(0);
            registro.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            registro.setSize(1080, 700);
            registro.setResizable(false);
            registro.setTitle("Registro Infante");
            registro.setLocationRelativeTo(null);
            registro.getContentPane().setBackground(new Color(255, 233, 108));
            registro.setVisible(true);
        });
        
        

        btnOFF.addActionListener((ActionEvent e)->{
            System.exit(0);
        });
        
        
        btnAnadirMenu.addActionListener((ActionEvent even) -> {
            Icon icono = new ImageIcon(getClass().getResource("/imgjpanel/advertencia.png"));
            int confir = JOptionPane.showConfirmDialog(null,"<html><h2 style='color: blue;'>Primero establezca</h2><h2 style='color: red;'>la cantidad de platos</h2></html>",
                "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icono);
            if(confir == JOptionPane.YES_OPTION){
                removeAll();
                updateUI();

                AñadirMenu me = new AñadirMenu();
                me.setLayout(null);
                add(me.iten());
            }
        });
        
        btnConsumon.addActionListener((ActionEvent even) -> {
            removeAll();
            updateUI();
            tablaConsumo t = new tablaConsumo();
            t.setBounds(0,0,1000,525);
            add(t.iten());
        });
        
         btnArchivos.addActionListener((ActionEvent e)->{
             removeAll();
             updateUI();
            Archivos a = new Archivos();
            a.setBounds(0,0,1000,525);
            add(a.iten());
        });
         btnconsumo.addActionListener((ActionEvent e)->{
             removeAll();
             updateUI();
            CrearConsumo a = new CrearConsumo();
            a.setBounds(0,0,1000,525);
            add(a.iten());
        });
        return this;
    }

}
