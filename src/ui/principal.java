/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author Javier_Andres Herrera Manjarrez
 */
public class principal extends javax.swing.JFrame {

    public principal() {
        initComponents();

        Random azar = new Random();
        int num = azar.nextInt(3) + 1;

        try {
            //Mirar y sentir información           obtener instalado Look And Feels
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                //UIManager = Administrador de interfaz de usuario
               if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIManager.put("nimbusBlueGrey", Color.black);
                    UIManager.put("control", Color.white); 
                    break;
               }

//                if ("Windows".equals(info.getName()) && num== 2) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    UIManager.put("nimbusBlueGrey", Color.black);
//                    UIManager.put("control", Color.white); 
//                    break;
//                }
//                if ("Metal".equals(info.getName()) && num== 3) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    UIManager.put("nimbusBlueGrey", Color.black);
//                    UIManager.put("control", Color.white); 
//                    break;
//                }
//

            }
        } catch (InstantiationException tte) {
            // Si Nimbus no está disponible, puede configurar la interfaz gráfica de usuario con otro aspecto.
        } catch (ClassNotFoundException ex) {

        } catch (IllegalAccessException ex) {

        } catch (UnsupportedLookAndFeelException ex) {

        }
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 251, 119));
        Image imagen = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/guarderia24px.png"));
        setIconImage(imagen);

        menu me = new menu();
        me.setSize(1000, 525);
        add(me.intconponente());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1000, 525));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
