/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import modelos.ActividadDeportiva;
import modelos.Asistente;
import operaciones.Escritura;
import operaciones.Lectura;
import operaciones.ValidarFormulario;

/**
 *
 * @author giova
 */
public class Administrar extends javax.swing.JFrame {

    DefaultListModel<String> modeloLista = new DefaultListModel<>();
    ArrayList<ActividadDeportiva> actividades = new ArrayList();
    private Asistente asistente = new Asistente();
    private float precioTotal = 0f;
    Lectura llenado = new Lectura();
    LinkedList<Asistente> listaAsistente = llenado.leerAsistente("asistentes.txt");
    LinkedList<ActividadDeportiva> listaDeportiva = llenado.leerActividades("actividad.txt");
    Escritura escribir = new Escritura();

    /**
     * Creates new form Administrar
     */
    public Administrar(Asistente asistente) {
        initComponents();

        cbHorario.removeAllItems();
        cbInstructor.removeAllItems();
        cbActividad.removeAllItems();
        cbListaAsistentes.removeAllItems();

        this.asistente = asistente;
        datosAsistente(this.asistente);

        inicializar();

    }

    public Administrar() {
        initComponents();

        cbHorario.removeAllItems();
        cbInstructor.removeAllItems();
        cbActividad.removeAllItems();
        cbListaAsistentes.removeAllItems();

        if (listaAsistente.size() > 0) {
            asistente = listaAsistente.get(0);
            datosAsistente(this.asistente);
            inicializar();

        }
    }

    public void inicializar() {
        llenarListaAsistentes();
        datosNoDisponible();
        actividadNoDisponible();
        llenarListaActividades();
        llenarListaInstructor();
        llenarListaHorario();
        agruparBtnGoupEquipo();
        agruparBtnGoupGenero();
        mostarActividades();
        modificarDatos();
        modificarActividad();
        selecionarAsistente();
    }

    public void llenarListaAsistentes() {
        for (int i = 0; i < listaAsistente.size(); i++) {
            cbListaAsistentes.addItem(listaAsistente.get(i).getNombre());
        }
    }

    public void selecionarAsistente() {
        cbListaAsistentes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                int indice = cbListaAsistentes.getSelectedIndex();
                String opcionSeleccionado = (String) cbListaAsistentes.getSelectedItem();
                asistente = listaAsistente.get(indice);
                datosAsistente(asistente);
                modeloLista.clear();
                mostarActividades();
            }
        });
    }

    public void datosAsistente(Asistente asistente) {
        lblNombreAsistente.setText(asistente.getNombre());
        txtNombre.setText(asistente.getNombre());
        txtApellidoPaterno.setText(asistente.getApellidoPaterno());
        txtApellidoMaterno.setText(asistente.getApellidoMaterno());
        txtEdad.setText(asistente.getEdad());
        txtDireccion.setText(asistente.getDireccion());
        txtContacto.setText(asistente.getContacto());
        txtEmergencia.setText(asistente.getEmergencia());
        precioTotal = asistente.getPrecioTotal();
        lblPrecio.setText(precioTotal + "");

        if (asistente.getGenero().compareTo("Hombre") == 0) {
            rbHombre.setSelected(true);
        } else {
            rbMujer.setSelected(true);
        }
    }

    public void datosNoDisponible() {

        txtNombre.setEditable(false);
        txtNombre.setBackground(Color.LIGHT_GRAY);
        txtNombre.setEnabled(false);

        txtApellidoPaterno.setEditable(false);
        txtApellidoPaterno.setBackground(Color.LIGHT_GRAY);
        txtApellidoPaterno.setEnabled(false);

        txtApellidoMaterno.setEditable(false);
        txtApellidoMaterno.setBackground(Color.LIGHT_GRAY);
        txtApellidoMaterno.setEnabled(false);

        txtEdad.setEditable(false);
        txtEdad.setBackground(Color.LIGHT_GRAY);
        txtEdad.setEnabled(false);

        txtDireccion.setEditable(false);
        txtDireccion.setBackground(Color.LIGHT_GRAY);
        txtDireccion.setEnabled(false);

        txtContacto.setEditable(false);
        txtContacto.setBackground(Color.LIGHT_GRAY);
        txtContacto.setEnabled(false);

        txtEmergencia.setEditable(false);
        txtEmergencia.setBackground(Color.LIGHT_GRAY);
        txtEmergencia.setEnabled(false);

        rbHombre.setBackground(Color.LIGHT_GRAY);
        rbHombre.setEnabled(false);

        rbMujer.setBackground(Color.LIGHT_GRAY);
        rbMujer.setEnabled(false);

        btnBajaAsistente.setEnabled(false);
    }

    public void datosDisponible() {

        txtNombre.setEditable(true);
        txtNombre.setBackground(Color.WHITE);
        txtNombre.setEnabled(true);

        txtApellidoPaterno.setEditable(true);
        txtApellidoPaterno.setBackground(Color.WHITE);
        txtApellidoPaterno.setEnabled(true);

        txtApellidoMaterno.setEditable(true);
        txtApellidoMaterno.setBackground(Color.WHITE);
        txtApellidoMaterno.setEnabled(true);

        txtEdad.setEditable(true);
        txtEdad.setBackground(Color.WHITE);
        txtEdad.setEnabled(true);

        txtDireccion.setEditable(true);
        txtDireccion.setBackground(Color.WHITE);
        txtDireccion.setEnabled(true);

        txtContacto.setEditable(true);
        txtContacto.setBackground(Color.WHITE);
        txtContacto.setEnabled(true);

        txtEmergencia.setEditable(true);
        txtEmergencia.setBackground(Color.WHITE);
        txtEmergencia.setEnabled(true);

        rbHombre.setBackground(Color.WHITE);
        rbHombre.setEnabled(true);

        rbMujer.setBackground(Color.WHITE);
        rbMujer.setEnabled(true);

        btnBajaAsistente.setEnabled(true);
    }

    public void actividadNoDisponible() {
        cbHorario.setEnabled(false);
        cbInstructor.setEnabled(false);
        cbActividad.setEnabled(false);
        rbAgregarEquipo.setEnabled(false);
        rbQuitarEquipo.setEnabled(false);
        listActividades.setEnabled(false);
        btnBajaActividad.setEnabled(false);
        btnAgregarActividad.setEnabled(false);
    }

    public void actividadDisponible() {
        cbHorario.setEnabled(true);
        cbInstructor.setEnabled(true);
        cbActividad.setEnabled(true);
        rbAgregarEquipo.setEnabled(true);
        rbQuitarEquipo.setEnabled(true);
        listActividades.setEnabled(true);
        btnBajaActividad.setEnabled(true);
        btnAgregarActividad.setEnabled(true);
    }

    void mostarActividades() {
        actividades.clear();
        if (asistente.getActividades().size() > 0) {
            for (int i = 0; i < asistente.getActividades().size(); i++) {
                modeloLista.addElement(asistente.getActividad(i).toString());
                listActividades.setModel(modeloLista);
                actividades.add(asistente.getActividad(i));
            }
            precioTotal = asistente.getPrecioTotal();
            lblPrecio.setText(precioTotal + "");
        }
    }

    public void modificarDatos() {
        chbModificarDatos.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent event) {
                // Verificar el estado del checkbox
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    datosDisponible();
                } else {
                    datosNoDisponible();
                }
            }

        });

    }

    public void modificarActividad() {
        chbModificarActividad.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent event) {
                // Verificar el estado del checkbox
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    actividadDisponible();
                } else {
                    actividadNoDisponible();
                }
            }

        });

    }

    public void agruparBtnGoupEquipo() {
        rbGroupEquipo.add(rbAgregarEquipo);
        rbGroupEquipo.add(rbQuitarEquipo);
    }

    public void agruparBtnGoupGenero() {
        rbGroupGenero.add(rbMujer);
        rbGroupGenero.add(rbHombre);
    }

    void llenarListaActividades() {

        for (int i = 0; i < listaDeportiva.size(); i++) {
            cbActividad.addItem(listaDeportiva.get(i).getActividad());
        }
    }

    void llenarListaInstructor() {

        listaDeportiva = llenado.leerActividades("actividad.txt");

        for (int i = 0; i < listaDeportiva.size(); i++) {
            cbInstructor.addItem(listaDeportiva.get(i).getInstructor());
        }
    }

    void llenarListaHorario() {

        for (int i = 6; i < 20; i++) {
            cbHorario.addItem(i + ":00");
        }
    }

    public String seleccionarGenero() {
        //regresa enumeracion
        Enumeration<AbstractButton> btnGrp = rbGroupGenero.getElements();
        String resultado = "";
        while (btnGrp.hasMoreElements()) {
            JRadioButton btnAux = (JRadioButton) btnGrp.nextElement();
            if (btnAux.isSelected()) {
                resultado = btnAux.getText();
            }
        }
        return resultado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGroupEquipo = new javax.swing.ButtonGroup();
        rbGroupGenero = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblAsistenteSeleccionado = new javax.swing.JLabel();
        chbModificarDatos = new javax.swing.JCheckBox();
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        rbHombre = new javax.swing.JRadioButton();
        rbMujer = new javax.swing.JRadioButton();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblContacto = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        lblEmergencia = new javax.swing.JLabel();
        txtEmergencia = new javax.swing.JTextField();
        btnBajaAsistente = new javax.swing.JButton();
        lblNombreAsistente = new javax.swing.JLabel();
        lblSeleccionarAsistente = new javax.swing.JLabel();
        cbListaAsistentes = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblSeleccionarActividad = new javax.swing.JLabel();
        lblCostoTotal = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        btnBajaActividad = new javax.swing.JButton();
        lblHorarios = new javax.swing.JLabel();
        rbAgregarEquipo = new javax.swing.JRadioButton();
        rbQuitarEquipo = new javax.swing.JRadioButton();
        cbHorario = new javax.swing.JComboBox<>();
        btnAgregarActividad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listActividades = new javax.swing.JList<>();
        cbInstructor = new javax.swing.JComboBox<>();
        lblDisponible = new javax.swing.JLabel();
        lblActividad = new javax.swing.JLabel();
        cbActividad = new javax.swing.JComboBox<>();
        chbModificarActividad = new javax.swing.JCheckBox();
        btnRegresar = new javax.swing.JButton();
        btnActualizarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("Administración de la información de los asistentes");

        lblAsistenteSeleccionado.setText("Asistente Seleccionado");

        chbModificarDatos.setText("Modificar Datos");

        lblNombre.setText("Nombres");

        lblApellidoPaterno.setText("Apellido Paterno");

        lblApellidoMaterno.setText("Apellido Materno");

        lblEdad.setText("Edad");

        lblGenero.setText("Género");

        rbHombre.setSelected(true);
        rbHombre.setText("Hombre");

        rbMujer.setText("Mujer");

        lblDireccion.setText("Dirección");

        lblContacto.setText("Teléfono de contacto");

        lblEmergencia.setText("Télefono de emergencia");

        btnBajaAsistente.setText("Dar de baja Asistente");
        btnBajaAsistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaAsistenteActionPerformed(evt);
            }
        });

        lblNombreAsistente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombreAsistente.setText("Nombre Aistente");

        lblSeleccionarAsistente.setText("Seleccionar Asistente");

        cbListaAsistentes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblApellidoPaterno)
                                        .addComponent(lblApellidoMaterno))
                                    .addGap(23, 23, 23)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblGenero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblAsistenteSeleccionado)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblSeleccionarAsistente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(cbListaAsistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblNombreAsistente))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbMujer, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbHombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnBajaAsistente)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblEmergencia)
                                        .addGap(49, 49, 49)
                                        .addComponent(txtEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(53, 53, 53))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbModificarDatos))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAsistenteSeleccionado)
                    .addComponent(lblNombreAsistente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSeleccionarAsistente)
                    .addComponent(cbListaAsistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(chbModificarDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoPaterno)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoMaterno)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdad)
                    .addComponent(lblGenero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbHombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbMujer)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContacto)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmergencia)
                    .addComponent(txtEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBajaAsistente))
        );

        lblSeleccionarActividad.setText("Seleccionar Actividad");

        lblCostoTotal.setText("Precio Total:");

        lblPrecio.setText("0");

        btnBajaActividad.setText("Dar de baja Actividad");
        btnBajaActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActividadActionPerformed(evt);
            }
        });

        lblHorarios.setText("Horario disponibles:");

        rbAgregarEquipo.setSelected(true);
        rbAgregarEquipo.setText("Agregar equipo");

        rbQuitarEquipo.setText("Quitar Equipo");

        cbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregarActividad.setText("Agregar actividad");
        btnAgregarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActividadActionPerformed(evt);
            }
        });

        listActividades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listActividades);

        cbInstructor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblDisponible.setText("Instructor disponible:");

        lblActividad.setText("Agregar Actividad");

        cbActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        chbModificarActividad.setText("Modificar Actividad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblSeleccionarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(chbModificarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lblDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHorarios))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbAgregarEquipo)
                                    .addComponent(rbQuitarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblCostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnBajaActividad))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblActividad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnAgregarActividad)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSeleccionarActividad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chbModificarActividad)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHorarios)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbAgregarEquipo)
                        .addComponent(lblDisponible)))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbQuitarEquipo)
                    .addComponent(cbInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblActividad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregarActividad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCostoTotal)
                    .addComponent(lblPrecio)
                    .addComponent(btnBajaActividad))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnActualizarDatos.setText("Actualizar Datos");
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(lblTitulo)
                .addContainerGap(247, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarDatos)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresar))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarDatos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActividadActionPerformed
        // TODO add your handling code here:
        try {
            ActividadDeportiva actividad = new ActividadDeportiva();
            actividad.setActividad((String) cbActividad.getSelectedItem());
            actividad.setInstructor((String) cbInstructor.getSelectedItem());
            actividad.setHorario((String) cbHorario.getSelectedItem());
            boolean equipo = false;
            float precioEquipo = 0f;
            float precioActividad = 0f;

            for (int i = 0; i < listaDeportiva.size(); i++) {
                ActividadDeportiva act = new ActividadDeportiva();
                act = listaDeportiva.get(i);
                if (actividad.getActividad().compareTo(act.getActividad()) == 0) {
                    if (rbAgregarEquipo.isSelected()) {
                        equipo = true;
                        precioEquipo = act.getPrecioEquipo();
                    } else if (!rbAgregarEquipo.isSelected()) {
                        equipo = false;
                        precioEquipo = 0f;
                    }
                    precioActividad = act.getPrecioActividad();
                }
            }

            actividad.setEquipo(equipo);
            actividad.setPrecioEquipo(precioEquipo);
            actividad.setPrecio(precioActividad);
            precioTotal += precioActividad + precioEquipo;
            lblPrecio.setText(precioTotal + "");
            asistente.setPrecioTotal(precioTotal);
            modeloLista.addElement(actividad.toString());
            listActividades.setModel(modeloLista);
            actividades.add(actividad);

        } catch (Exception e) {
            // Manejo de la excepción
            JOptionPane.showMessageDialog(null, "No hay asistnetes para agregar actividad", "No hay asistente", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarActividadActionPerformed

    private void btnBajaActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActividadActionPerformed
        // TODO add your handling code here:

        try {
            int selectedIndex = listActividades.getSelectedIndex();
            if (selectedIndex != -1) {
                ActividadDeportiva actividad = new ActividadDeportiva();
                actividad = actividades.get(selectedIndex);
                precioTotal -= actividad.getPrecioActividad() + actividad.getPrecioEquipo();
                lblPrecio.setText(precioTotal + "");
                modeloLista.remove(selectedIndex);
                actividades.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona una actividad para borrar", "Sin actividad", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            // Manejo de la excepción
            JOptionPane.showMessageDialog(null, "No hay asistente para dar de baja actividad", "No hay asistente para modificar", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnBajaActividadActionPerformed

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed
        // TODO add your handling code here:

        try {
            int indice = cbListaAsistentes.getSelectedIndex() + 1;
            String nombre = txtNombre.getText();
            String apellidoPaterno = txtApellidoPaterno.getText();
            String apellidoMaterno = txtApellidoMaterno.getText();
            String edad = txtEdad.getText();
            String genero = seleccionarGenero();
            String direccion = txtDireccion.getText();
            String contacto = txtContacto.getText();
            String emergencia = txtEmergencia.getText();
            asistente.setIdAsistente((indice) + "");
            asistente.setNombre(nombre);
            asistente.setApellidoPaterno(apellidoPaterno);
            asistente.setApellidoMaterno(apellidoMaterno);
            asistente.setEdad(edad);
            asistente.setGenero(genero);
            asistente.setDireccion(direccion);
            asistente.setContacto(contacto);
            asistente.setEmergencia(emergencia);
            asistente.setActividades(actividades);
            asistente.setPrecioTotal(precioTotal);

            if (asistente.validarAsistente()) {
                listaAsistente = escribir.borrarAsistente(listaAsistente, indice - 1);
                escribir.limpiar("asistentes.txt");
                listaAsistente.add(asistente);

                for (int i = 0; i < listaAsistente.size(); i++) {
                    escribir.escribir("asistentes.txt", listaAsistente.get(i));
                }

                JOptionPane.showMessageDialog(null, "Asistente guardado y Actualizado con exito", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
                Menu menu = new Menu();
                menu.setVisible(true);
                this.dispose();
            }

        } catch (Exception e) {
            // Manejo de la excepción
            JOptionPane.showMessageDialog(null, "No hay asistente para actualizar datos", "No hay asistente", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarDatosActionPerformed

    private void btnBajaAsistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaAsistenteActionPerformed
        // TODO add your handling code here:

        try {

            int indice = cbListaAsistentes.getSelectedIndex() + 1;
            listaAsistente = escribir.borrarAsistente(listaAsistente, indice - 1);
            escribir.limpiar("asistentes.txt");

            for (int i = 0; i < listaAsistente.size(); i++) {
                escribir.escribir("asistentes.txt", listaAsistente.get(i));
            }

            JOptionPane.showMessageDialog(null, "Asistente borrado", "Borrado exitosa", JOptionPane.INFORMATION_MESSAGE);
            Administrar administrar = new Administrar();
            administrar.setVisible(true);
            this.dispose();

        } catch (Exception e) {
            // Manejo de la excepción
            JOptionPane.showMessageDialog(null, "No hay asistentes para dar de baja", "No hay asistente", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnBajaAsistenteActionPerformed

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
            java.util.logging.Logger.getLogger(Administrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarDatos;
    private javax.swing.JButton btnAgregarActividad;
    private javax.swing.JButton btnBajaActividad;
    private javax.swing.JButton btnBajaAsistente;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbActividad;
    private javax.swing.JComboBox<String> cbHorario;
    private javax.swing.JComboBox<String> cbInstructor;
    private javax.swing.JComboBox<String> cbListaAsistentes;
    private javax.swing.JCheckBox chbModificarActividad;
    private javax.swing.JCheckBox chbModificarDatos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblActividad;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblAsistenteSeleccionado;
    private javax.swing.JLabel lblContacto;
    private javax.swing.JLabel lblCostoTotal;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDisponible;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEmergencia;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblHorarios;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreAsistente;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSeleccionarActividad;
    private javax.swing.JLabel lblSeleccionarAsistente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> listActividades;
    private javax.swing.JRadioButton rbAgregarEquipo;
    private javax.swing.ButtonGroup rbGroupEquipo;
    private javax.swing.ButtonGroup rbGroupGenero;
    private javax.swing.JRadioButton rbHombre;
    private javax.swing.JRadioButton rbMujer;
    private javax.swing.JRadioButton rbQuitarEquipo;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEmergencia;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
