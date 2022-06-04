/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesYAtributos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author USUARIO
 */
public class MenuEmergente {

    private final JPopupMenu emergente;
    private JMenuItem reporteDeUnInfate, reporteConsumos, reporteInfantes;
    private JSeparator n1, n2;
    private Connection conexion;

    public MenuEmergente() {
        emergente = new JPopupMenu();
        reporteDeUnInfate = new JMenuItem("Reporte de un Infante");
        reporteConsumos = new JMenuItem("Reporte de Consumos");
        reporteInfantes = new JMenuItem("Reporte de Infantes");
        n1 = new JSeparator();
        n2 = new JSeparator();

        try {
            String DSN = "jdbc:mariadb://localhost:3306/guarderia?";
            String user = "user=root&";
            String password = "password=root";
            conexion = DriverManager.getConnection(DSN + user + password);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (SQLException ded) {
            JOptionPane.showMessageDialog(null, "Error al realizar la conexión", "error", JOptionPane.ERROR_MESSAGE);
        }

        reporteDeUnInfate.setForeground(Color.BLACK);
        reporteDeUnInfate.setFont(new Font("Arial", 1, 14));
        reporteDeUnInfate.addActionListener((ActionEvent eve) -> {
            evetReporteDeUnInfate(eve);
        });

        reporteConsumos.setForeground(Color.BLACK);
        reporteConsumos.setFont(new Font("Arial", 1, 14));
        reporteConsumos.addActionListener((ActionEvent eve) -> {
            evetReporteConsumos();
        });

        reporteInfantes.setForeground(Color.BLACK);
        reporteInfantes.setFont(new Font("Arial", 1, 14));
        reporteInfantes.addActionListener((ActionEvent eve) -> {
            evetReporteInfantes(eve);
        });

        emergente.add(reporteDeUnInfate);
        emergente.add(n1);
        emergente.add(reporteConsumos);
        emergente.add(n2);
        emergente.add(reporteInfantes);

    }

    private void evetReporteInfantes(ActionEvent evt) {
        Icon icono = new ImageIcon(getClass().getResource("/imgjpanel/escoger.png"));
        int confir = JOptionPane.showConfirmDialog(null, "Confirme su decición",
                "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icono);
        if (confir == JOptionPane.YES_OPTION) {
            try {
                JasperReport reporte = null;
                String path = "src" + File.separator + File.separator + "plantillas" +
                        File.separator + File.separator + "reporteInfantes.jasper";
                String consulta = null;
                HashMap parametro = new HashMap();

                // para que pueda cargar el archivo .jasper
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

                // llenado del reporte
                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conexion);

                // vista del reporte
                JasperViewer view = new JasperViewer(jprint, false);
                view.setTitle("Reporte Infantes");
                // Para que pueda cerrar este reporte
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                // hacer visible el reporte
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(MenuEmergente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void evetReporteConsumos() {
        Icon icono = new ImageIcon(getClass().getResource("/imgjpanel/escoger.png"));
        int confir = JOptionPane.showConfirmDialog(null, "Confirme su decición",
                "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icono);
        if (confir == JOptionPane.YES_OPTION) {
            try {
                JasperReport reporte = null;
                String path = "src" + File.separator + File.separator + "plantillas" + 
                        File.separator + File.separator + "reporteConsumos.jasper";
                String consulta = null;
                HashMap parametro = new HashMap();
                parametro.put("hh", 2);
                // para que pueda cargar el archivo .jasper
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

                // llenado del reporte
                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conexion);

                // vista del reporte
                JasperViewer view = new JasperViewer(jprint, false);
                view.setTitle("Reporte de los consumos");
                // Para que pueda cerrar este reporte
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                // hacer visible el reporte
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(MenuEmergente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void evetReporteDeUnInfate(ActionEvent eve) {
        Icon icono = new ImageIcon(getClass().getResource("/imgjpanel/escoger.png"));
        int confir = JOptionPane.showConfirmDialog(null, "Confirme su decición",
                "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icono);
        if (confir == JOptionPane.YES_OPTION) {
            try {
                JasperReport reporte = null;
                String path = "src" + File.separator + File.separator + "plantillas" +
                        File.separator + File.separator + "consumosDeUnInfante.jasper";
                String consulta = null;
                boolean very;
                //Consulta
                do {
                    very = true;
                    try {
                        consulta = JOptionPane.showInputDialog(null,
                                "Numereo de matricula del Infante");
                        consulta = String.valueOf(Integer.parseInt(consulta));
                    } catch (NumberFormatException ee) {
                        very = false;
                        JOptionPane.showMessageDialog(null, "Porfavor digite solo numeros",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } while (very == false);

                HashMap parametro = new HashMap();
                parametro.put("numero", Integer.parseInt(consulta));

                // para que pueda cargar el archivo .jasper
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

                // llenado del reporte
                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conexion);

                // vista del reporte
                JasperViewer view = new JasperViewer(jprint, false);
                view.setTitle("Reporte de un Infante");
                // Para que pueda cerrar este reporte
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                // hacer visible el reporte
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(MenuEmergente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public JPopupMenu getMenuEmergente() {
        return emergente;
    }
}
