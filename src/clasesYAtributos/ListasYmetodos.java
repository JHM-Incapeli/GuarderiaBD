/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesYAtributos;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Javier_Andres Herrera Manjarrez
 */
public class ListasYmetodos {

    private Matricula infante = new Matricula();
    private PersonaCosteaMensualidad costea = new PersonaCosteaMensualidad();
    private Acudiente acudiente = new Acudiente();
    private Menu menu = new Menu();

    private consumoDeInfante consumoInfante = new consumoDeInfante();
    private ArrayList<String> todasLasLineas = new ArrayList<>();
    private Connection conexion;
    private Statement sentencia;

    public ListasYmetodos() {
        PrepararBasedatos();
    }

    /*
    public void ejem() {

        for (int i = 0; i < 3; i++) {
            PersonaCosteaMensualidad per = new PersonaCosteaMensualidad();
            //per.acudiente.Nombre = "Javier"+"    ("+i+")";
            per.acudiente = new Acudiente("Javier" + "    (" + i + ")");

            listaPersonaCosteaMensualidad.add(per);

        }

        PersonaCosteaMensualidad perdos = new PersonaCosteaMensualidad();
        perdos.acudiente = new Acudiente("la morgue");
        listaPersonaCosteaMensualidad.add(perdos);

        for (int i = 0; i < listaPersonaCosteaMensualidad.size(); i++) {
            perdos = listaPersonaCosteaMensualidad.get(i);
            System.out.println(listaPersonaCosteaMensualidad.get(i));
            System.out.println("nombre: " + perdos.acudiente.Nombre);

        }
    
    
        ---cuando balla aeliminar primero voy a borrar todo el contenido del txt

    }
     */
//**************************************************************************************************************
    // fi metodo llenar un array list
//**************************************************************************************************************
    private void PrepararBasedatos() {
        try {
            String DSN = "jdbc:mariadb://localhost:3306/guarderia?";
            String user = "user=root&";
            String password = "password=root";
            conexion = DriverManager.getConnection(DSN + user + password);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (SQLException ded) {
            JOptionPane.showMessageDialog(null, "Error al realizar la conexión", "error", JOptionPane.ERROR_MESSAGE);
        }

        
        try {
            sentencia = conexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar sentencia en la BD", "error", JOptionPane.ERROR_MESSAGE);
        }

    }
//**************************************************************************************************************

    public JTable getMatricula_Acudiente_PCMensualidad() {

        JTable tabla = new JTable();
        DefaultTableModel modelo = new DefaultTableModel() {
            //  para que no se pueda editar la tabla
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }

        };

        modelo.addColumn("Numero de matricula");
        modelo.addColumn("Nombre Infante");
        modelo.addColumn("Fecha de Nacimiento Infate");
        modelo.addColumn("Fecha de Ingreso Infante");
        modelo.addColumn("Fecha de baja infante");
        modelo.addColumn("Alergias");
        modelo.addColumn("DNI Acudiente");
        modelo.addColumn("Nombre Acudiente");
        modelo.addColumn("Dirección Acudiente");
        modelo.addColumn("Telefono Acudiente");
        modelo.addColumn("Relación del infante y Acudiente");
        modelo.addColumn("Costea Mensualidad DNI");
        modelo.addColumn("Costea Mensualidad Nombre");
        modelo.addColumn("Costea Mensualidad Direccion");
        modelo.addColumn("Costea Mensualidad Telefono");
        modelo.addColumn("Costea Mensualidad N° De Cuenta Bancaria");

        String[] datos = new String[16];
        try {
            ResultSet r = sentencia.executeQuery("select * from infantes order by numeromatricula");
            while (r.next()) {
                datos[0] = r.getString("numeromatricula");
                datos[1] = r.getString("nombreinfante");
                datos[2] = r.getString("infante_fecha_nacimineto");
                datos[3] = r.getString("fecha_ingreso_guarderia");
                datos[4] = r.getString("fecha_de_baja");
                datos[5] = r.getString("alergias_infante");
                datos[6] = r.getString("acudiente_dni");
                datos[7] = r.getString("acudiente_nombre");
                datos[8] = r.getString("acudiente_direccion");
                datos[9] = r.getString("acudiente_telefono");
                datos[10] = r.getString("relacion_infanteacu");
                datos[11] = r.getString("coste_dni");
                datos[12] = r.getString("costea_nombre");
                datos[13] = r.getString("coste_direccion");
                datos[14] = r.getString("costea_telefono");
                datos[15] = r.getString("costea_numero_cueta");

                modelo.addRow(datos);

            }

        } catch (SQLException e) {

        }

        int val[] = {200, 300, 200, 200, 200, 200, 200, 300, 200, 200, 250, 200,
            300, 250, 250, 300};

        //tabla.setGridColor(new Color(0,0,255));
        tabla.setForeground(new Color(0, 0, 0));
        tabla.setFont(new Font("calibri", 2, 16));

        tabla.setModel(modelo);

        tabla.setRowHeight(25);

        tabla.getTableHeader().setFont(new Font("Calibri", 2, 16));
        tabla.getTableHeader().setForeground(new Color(255, 255, 255));

        // apagar el auto redimencionaminto en JTable
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // colocar un escroll al momento que las filas pasen el  tamaño del JTable
        tabla.setAutoscrolls(true);

        //   establese el ancho de las columnas
        for (int p = 0; p < 16; p++) {
            tabla.getColumnModel().getColumn(p).setPreferredWidth(val[p]);
        }
        return tabla;
    }
//**************************************************************************************************************

    public JTable getTablaConsumosDeInfantes() {
        JTable tabla = new JTable();
        DefaultTableModel model = new DefaultTableModel() {//  para que no se pueda editar la tabla
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("Numero de Matricula");
        model.addColumn("Fecha del Consumo");
        model.addColumn("Numero del Menú");
        model.addColumn("Precio del Menú");

        String[] datos = new String[5];
        try {
            ResultSet r = sentencia.executeQuery("select * from consumos  order by numeromatricula");
            while (r.next()) {
                datos[0] = r.getString("id");
                datos[1] = r.getString("numeromatricula");
                datos[2] = r.getString("fecha");
                datos[3] = r.getString("numero_menu");
                datos[4] = r.getString("costo_menu");

                model.addRow(datos);

            }

        } catch (SQLException e) {

        }

        int whit[] = {60, 245, 245, 245, 245};

        tabla.setForeground(new Color(0, 0, 0));
        tabla.setFont(new Font("calibri", 2, 16));

        tabla.setModel(model);

        tabla.getTableHeader().setOpaque(true);
        tabla.getTableHeader().setFont(new Font("Calibri", 2, 16));
        tabla.getTableHeader().setForeground(new Color(255, 255, 255));
        tabla.setRowHeight(25);

        // apagar el auto redimencionaminto en JTable
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // colocar un escroll al momento que las filas pasen el  tamaño del JTable
        tabla.setAutoscrolls(false);

        //   establese el ancho de las columnas
        for (int p = 0; p <= 4; p++) {
            tabla.getColumnModel().getColumn(p).setPreferredWidth(whit[p]);
        }

        return tabla;
    }
//**************************************************************************************************************

    public void eliminarFila(int cualTabla, int num) {
        if (cualTabla == 1) {
            try {
                String sql = "DELETE FROM infantes WHERE numeromatricula='" + num + "';";
                sentencia.execute(sql);
            } catch (SQLException ee) {
                JOptionPane.showMessageDialog(null, "Error al intentar borrar\n"
                        + "un infante con matricula" + num,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cualTabla == 2) {
            try {
                String sql = "DELETE FROM consumos WHERE id=" + num + ";";
                sentencia.execute(sql);
            } catch (SQLException ee) {
                JOptionPane.showMessageDialog(null, "Error al intentar borrar\n"
                        + " Consumo con ID = " + num,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cualTabla == 3) {
            try {
                String sql = "DELETE FROM menus WHERE numero_menu=" + num + ";";
                sentencia.execute(sql);
            } catch (SQLException ee) {
                JOptionPane.showMessageDialog(null, " Error al intentar borrar \n"
                        + "el menú numero = " + num,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
//**************************************************************************************************************

    public boolean addInfate(Matricula man, Acudiente acudiente, PersonaCosteaMensualidad per, int n) {
        boolean confir = true;
        if (n == 1) {
            String sql = "UPDATE infantes "
                    + "SET nombreinfante='" + man.getNombreDeInfante() + "', infante_fecha_nacimineto='" + man.getFechaNacimiento() + "',"
                    + " fecha_ingreso_guarderia='" + man.getFechaIngresoGuarderia() + "', fecha_de_baja='" + man.getSiSeDioBajaAlNinoFecha() + "',"
                    + " alergias_infante='" + man.getAlergiaDelInfante() + "', acudiente_dni='" + acudiente.getDNI() + "',"
                    + " acudiente_nombre='" + acudiente.getNombre() + "', acudiente_direccion='" + acudiente.direccion + "',"
                    + " acudiente_telefono='" + acudiente.getNumeroTelefono() + "', relacion_infanteacu='" + acudiente.getRelacionConInfante() + "',"
                    + " coste_dni='" + per.getDNICotea() + "', costea_nombre='" + per.getNombreCostea() + "',"
                    + " coste_direccion='" + per.getDireccionCostea() + "', costea_telefono='" + per.getNumeroTelefono() + "',"
                    + " costea_numero_cueta='" + per.getNumeroDeCuenta() + "' WHERE numeromatricula='" + man.numeroMatricula + "';";
            try {
                sentencia.executeUpdate(sql);
            } catch (SQLException ee) {
                confir = false;
                JOptionPane.showMessageDialog(null, "Ocurrio un error"+
                                              "inesperado con"+ 
                                              "la base de datos"   
                                              );
            }

        } else {
            try {
                String sql = "insert into infantes value('" + man.numeroMatricula + "','" + man.nombreDeInfante
                        + "','" + man.fechaNacimiento + "','" + man.fechaIngresoGuarderia + "','" + man.siSeDioBajaAlNinoFecha
                        + "','" + man.alergiaDelInfante + "','" + acudiente.DNI + "','" + acudiente.Nombre + "','" + acudiente.direccion
                        + "','" + acudiente.numeroTelefono + "','" + acudiente.relacionConInfante + "','" + per.getDNICotea()
                        + "','" + per.getNombreCostea() + "','" + per.getDireccionCostea() + "','" + per.getNumeroTelefono()
                        + "','" + per.numeroDeCuenta + "');";
                sentencia.executeUpdate(sql);
                Icon ico = new ImageIcon(getClass().getResource("/imgjpanel" + File.separator + "cuenta.png"));
                JOptionPane.showMessageDialog(null, "El proceso ha sido exitoso", "Aviso", JOptionPane.INFORMATION_MESSAGE, ico);

            } catch (SQLException ee) {
                confir = false;
                Icon icon = new ImageIcon(getClass().getResource("/imgjpanel" + File.separator + "advertencia.png"));
                String men = "";
                if (ee.getErrorCode() == 1062) {
                    men = "Numero de matricula\n"
                            + " esta ya se encutra enbase de datos";
                } else {
                    men = " acurrido un error en\n"+
                 "la base de datos";
                }
                JOptionPane.showMessageDialog(null, men, "Advertencia",
                        JOptionPane.DEFAULT_OPTION, icon);
            }
        }
        return confir;
    }
//**************************************************************************************************************

    public boolean addMenu(Menu menu) {
        boolean confir = true;
        try {
            String sql = "insert into menus value('" + menu.numeroMenu
                    + "','" + menu.nombrePlatos
                    + "','" + menu.costoMenu
                    + "','" + menu.costoDelosPlato
                    + "','" + menu.ingredientes + "');";
            sentencia.executeUpdate(sql);
            Icon ico = new ImageIcon(getClass().getResource("/imgjpanel" + File.separator + "cuenta.png"));
            JOptionPane.showMessageDialog(null, "El proceso ha sido exitoso", "Aviso", JOptionPane.INFORMATION_MESSAGE, ico);
        } catch (SQLException ee) {
            confir = false;
            Icon icon = new ImageIcon(getClass().getResource("/imgjpanel" + File.separator + "advertencia.png"));
            String men = "";

            if (ee.getErrorCode() == 1062) {
                men = "El numero de menú\n"+
                "ya existe cambielo"
                ;
            } else {
                men = "acurrido un error en\n"+
                 "la base de datos";
            }
            JOptionPane.showMessageDialog(null, men, "Advertencia",
                    JOptionPane.DEFAULT_OPTION, icon);
        }
        return confir;
    }
//**************************************************************************************************************

    public boolean addConsumoDeUnInfante(consumoDeInfante consumo) {
        boolean confir = true;
        try {
            String sql = "insert into consumos value(" + null
                    + ",'" + consumo.numeroMatriculaInfate
                    + "','" + consumo.fecha
                    + "','" + consumo.numeroMenu
                    + "','" + consumo.costoMenu + "');";
            sentencia.executeUpdate(sql);
            Icon ico = new ImageIcon(getClass().getResource("/imgjpanel" + File.separator + "cuenta.png"));
            JOptionPane.showMessageDialog(null, "El proceso ha sido exitoso", "Aviso", JOptionPane.INFORMATION_MESSAGE, ico);
        } catch (SQLException ee) {
            confir = false;
            Icon icon = new ImageIcon(getClass().getResource("/imgjpanel" + File.separator + "advertencia.png"));
            String men = " Error inesperado"+
                "al realizar el proceso"
            ;

            JOptionPane.showMessageDialog(null, men + ee.getErrorCode(), "Advertencia",
                    JOptionPane.DEFAULT_OPTION, icon);
        }
        return confir;

    }
//**************************************************************************************************************

    public Matricula getInfante(String num) {
        String[] datos = new String[6];
        try {
            ResultSet r = sentencia.executeQuery("select numeromatricula,"
                    + "nombreinfante,infante_fecha_nacimineto,fecha_ingreso_guarderia,"
                    + "fecha_de_baja,alergias_infante from infantes where numeromatricula ='" + num + "';");
            r.next();
            datos[0] = r.getString("numeromatricula");
            datos[1] = r.getString("nombreinfante");
            datos[2] = r.getString("infante_fecha_nacimineto");
            datos[3] = r.getString("fecha_ingreso_guarderia");
            datos[4] = r.getString("fecha_de_baja");
            datos[5] = r.getString("alergias_infante");

        } catch (SQLException e) {
            Icon ico = new ImageIcon(getClass().getResource("/imgjpanel" + File.separator + "advertencia.png"));
            JOptionPane.showMessageDialog(null, "Lamentamos informarleque\n"
                    + "que el numero de matricula " + num
                    + "\n ¡No esxite!", "Aviso", JOptionPane.INFORMATION_MESSAGE, ico);
            infante.numeroMatricula = null;
        }
        if (datos[0] != null) {
            infante.numeroMatricula = datos[0];
            infante.nombreDeInfante = datos[1];
            infante.fechaNacimiento = datos[2];
            infante.fechaIngresoGuarderia = datos[3];
            infante.siSeDioBajaAlNinoFecha = datos[4];
            infante.alergiaDelInfante = datos[5];
        }
        return this.infante;
    }
//**************************************************************************************************************

    public Acudiente getAcudiente(String num) {
        String[] datos = new String[5];
        try {
            ResultSet r = sentencia.executeQuery("select acudiente_dni,"
                    + "acudiente_nombre,acudiente_direccion,acudiente_telefono,"
                    + "relacion_infanteacu from infantes where numeromatricula ='" + num + "';");
            r.next();
            datos[0] = r.getString("acudiente_dni");
            datos[1] = r.getString("acudiente_nombre");
            datos[2] = r.getString("acudiente_direccion");
            datos[3] = r.getString("acudiente_telefono");
            datos[4] = r.getString("relacion_infanteacu");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado al\n"+
                                                "consultar la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        acudiente.DNI = datos[0];
        acudiente.Nombre = datos[1];
        acudiente.direccion = datos[2];
        acudiente.numeroTelefono = datos[3];
        acudiente.relacionConInfante = datos[4];

        return this.acudiente;
    }
//**************************************************************************************************************

    public PersonaCosteaMensualidad getperCostea(String num) {
        String[] datos = new String[5];
        try {
            ResultSet r = sentencia.executeQuery("select coste_dni,"
                    + "costea_nombre,coste_direccion,costea_telefono,"
                    + "costea_numero_cueta from infantes where numeromatricula ='" + num + "';");
            r.next();
            datos[0] = r.getString("coste_dni");
            datos[1] = r.getString("costea_nombre");
            datos[2] = r.getString("coste_direccion");
            datos[3] = r.getString("costea_telefono");
            datos[4] = r.getString("costea_numero_cueta");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error inesperado al\n"+
                                                "consultar la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        costea.acudiente.DNI = datos[0];
        costea.acudiente.Nombre = datos[1];
        costea.acudiente.direccion = datos[2];
        costea.acudiente.numeroTelefono = datos[3];
        costea.numeroDeCuenta = datos[4];

        return this.costea;
    }
//**************************************************************************************************************

    public Menu getMenu(String num) {
        String[] datos = new String[5];
        try {
            ResultSet r = sentencia.executeQuery("select * from menus where numero_menu ='" + num + "';");
            r.next();
            datos[0] = r.getString("numero_menu");
            datos[1] = r.getString("nombre_platos");
            datos[2] = r.getString("costo_menu");
            datos[3] = r.getString("costo_de_platos");
            datos[4] = r.getString("ingredientes");

        } catch (SQLException e) {
            Icon ico = new ImageIcon(getClass().getResource("/imgjpanel" + File.separator + "advertencia.png"));
            JOptionPane.showMessageDialog(null, "Lamentamos informarleque\n"
                    + "que el numero de Menu " + num
                    + "\n ¡No esxite!", "Aviso", JOptionPane.INFORMATION_MESSAGE, ico);
            menu.numeroMenu = null;
        }
        if (datos[0] != null) {
            menu.numeroMenu = datos[0];
            menu.nombrePlatos = datos[1];
            menu.costoMenu = datos[2];
            menu.costoDelosPlato = datos[3];
            menu.ingredientes = datos[4];
        }
        return this.menu;
    }
//**************************************************************************************************************

    public void vaciarUnarrayList(int num) {
        if (num == 1) {
            infante = null;
        } else if (num == 2) {
            acudiente = null;
        } else if (num == 3) {
            costea = null;
        } else if (num == 4) {
            menu = null;
        } else if (num == 5) {
            consumoInfante = null;
        } else if (num == 6) {
            todasLasLineas.clear();
        }
    }
//**************************************************************************************************************

    public void finalizarConexion() {
        try {
            conexion.close();

        } catch (SQLException eee) {
            JOptionPane.showMessageDialog(null, "Error al finalizar la conexión", "error", JOptionPane.ERROR_MESSAGE);
        }
    }
//**************************************************************************************************************

    public String getConsumoDeUnInfate(String nom) {
        String datos = "";
        float auxi = 0;

        String dato;
        boolean verificacion;
        float num = 0;

        do {
            verificacion = true;
            dato = JOptionPane.showInputDialog(null, "Digite el coste fijo mensual\n"+
                                                    "-No se aceptan letras\n"+
                                                    "-Digite solo numeros \n"+
                                                    "-si hay decimales \n"+
                                                    "coloque un punto(.) como \n"+
                                                    "metodo de separaci\u00f3n", "Requeriodo", JOptionPane.WARNING_MESSAGE);
            try {
                num = Float.parseFloat(dato);

            } catch (NumberFormatException ee) {
                verificacion = false;

            }

        } while (verificacion == false);

        Matricula matricula = getInfante(nom);
        datos = "Numero de Matricula: " + matricula.getNumeroMatricula()
                + "\nNombre: " + matricula.getNombreDeInfante()
                + "\nFecha de Ingreso: " + matricula.getFechaIngresoGuarderia()
                + "\nFecha de Nacimiento: " + matricula.getFechaNacimiento()
                + "\nFecha de Baja del Ifante: " + matricula.getSiSeDioBajaAlNinoFecha()
                + "\nAlergia(s) del Infante: " + matricula.getAlergiaDelInfante()
                + "\nCuota fija mensual: " + num;

        datos += "\n---------------------------------------------\n";
        int i = 0;

        ArrayList<consumoDeInfante> listaConsumoInfante = new ArrayList<>();
        String[] da = new String[4];
        try {
            ResultSet r = sentencia.executeQuery("select * from consumos");
            while (r.next()) {
                da[0] = r.getString("numeromatricula");
                da[1] = r.getString("fecha");
                da[2] = r.getString("numero_menu");
                da[3] = r.getString("costo_menu");
                consumoDeInfante con = new consumoDeInfante(da[0], da[1], da[2], da[3]);
                listaConsumoInfante.add(con);
            }

        } catch (SQLException e) {

        }

        for (consumoDeInfante consu : listaConsumoInfante) {
            if (nom.equals(consu.numeroMatriculaInfate)) {
                datos += "\n" + (i + 1) + ")  Fecha del consumo: " + consu.getFecha()
                        + "    Numero del Menú: " + consu.getNumeroMenu()
                        + "    Costo del Menú: " + consu.getCostoMenu() + " $";
                auxi += Float.parseFloat(consu.getCostoMenu());
                datos += "\n---------------------------------------------";
                i++;
            }
        }

        datos += "\n\nTotal Consumo: " + auxi + " $";
        datos += "\nTotal a pagar: " + (auxi + num) + " $";
        datos += "\nDias que asistio el infante: " + i;
        listaConsumoInfante.clear();
        return datos;
    }
//**************************************************************************************************************

    public JTable getTablaMenus() {
        JTable tabla = new JTable();
        DefaultTableModel modelo = new DefaultTableModel() {
            //  para que no se pueda editar la tabla
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }

        };

        modelo.addColumn("Numero del Menú");
        modelo.addColumn("Costo Total del Menú");

        String[] datos = new String[2];
        try {
            ResultSet r = sentencia.executeQuery("select * from menus order by numero_menu");
            while (r.next()) {
                datos[0] = r.getString("numero_menu");
                datos[1] = r.getString("costo_menu");

                modelo.addRow(datos);
            }

        } catch (SQLException e) {

        }

        int val[] = {470, 470};

        //tabla.setGridColor(new Color(0,0,255));
        tabla.setForeground(new Color(0, 0, 0));
        tabla.setFont(new Font("calibri", 2, 16));

        tabla.setModel(modelo);

        tabla.setRowHeight(25);

        tabla.getTableHeader().setFont(new Font("Calibri", 2, 16));
        tabla.getTableHeader().setForeground(new Color(255, 255, 255));

        // apagar el auto redimencionaminto en JTable
        //tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // colocar un escroll al momento que las filas pasen el  tamaño del JTable
        tabla.setAutoscrolls(true);

        //   establese el ancho de las columnas
        /*for (int p = 0; p < 2; p++) {
            tabla.getColumnModel().getColumn(p).setPreferredWidth(val[p]);
        }
         */
        return tabla;
    }
}
