
package vista;

/**
 *
 * @author XoanOuteiro
 */
public class AcademiaMasUI extends javax.swing.JFrame {

    /**
     * Creates new form AcademiaMasUI
     */
    public AcademiaMasUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdlgAltaAlumnos = new javax.swing.JDialog();
        lblAltaAlumnos = new javax.swing.JLabel();
        pnlAltaAlumno = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblLocalidad = new javax.swing.JLabel();
        txtfNombre = new javax.swing.JTextField();
        txtfLocalidad = new javax.swing.JTextField();
        lblModulos = new javax.swing.JLabel();
        cbbModulos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaModulos = new javax.swing.JTextArea();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        pnlButtonHold = new javax.swing.JPanel();
        btnAddAlumno = new javax.swing.JButton();
        btnAddModulo = new javax.swing.JButton();
        btnSeeAlumno = new javax.swing.JButton();
        menuMainWindow = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        lblAltaAlumnos.setText("ALTA ALUMNOS");

        pnlAltaAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder("Añadir Alumno"));

        lblNombre.setText("Nombre:");

        lblLocalidad.setText("Localidad:");

        javax.swing.GroupLayout pnlAltaAlumnoLayout = new javax.swing.GroupLayout(pnlAltaAlumno);
        pnlAltaAlumno.setLayout(pnlAltaAlumnoLayout);
        pnlAltaAlumnoLayout.setHorizontalGroup(
            pnlAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAltaAlumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAltaAlumnoLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(txtfNombre))
                    .addGroup(pnlAltaAlumnoLayout.createSequentialGroup()
                        .addComponent(lblLocalidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfLocalidad)))
                .addContainerGap())
        );
        pnlAltaAlumnoLayout.setVerticalGroup(
            pnlAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAltaAlumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtfLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocalidad))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblModulos.setText("Módulos:");

        txtaModulos.setColumns(20);
        txtaModulos.setRows(5);
        jScrollPane1.setViewportView(txtaModulos);

        btnGrabar.setText("Grabar");

        btnLimpiar.setText("Limpiar");

        btnQuitar.setText("Quitar");

        javax.swing.GroupLayout jdlgAltaAlumnosLayout = new javax.swing.GroupLayout(jdlgAltaAlumnos.getContentPane());
        jdlgAltaAlumnos.getContentPane().setLayout(jdlgAltaAlumnosLayout);
        jdlgAltaAlumnosLayout.setHorizontalGroup(
            jdlgAltaAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlgAltaAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdlgAltaAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(lblAltaAlumnos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAltaAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jdlgAltaAlumnosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jdlgAltaAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdlgAltaAlumnosLayout.createSequentialGroup()
                                .addComponent(lblModulos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbModulos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jdlgAltaAlumnosLayout.createSequentialGroup()
                                .addComponent(btnGrabar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar)
                                .addGap(10, 10, 10)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuitar)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jdlgAltaAlumnosLayout.setVerticalGroup(
            jdlgAltaAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlgAltaAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAltaAlumnos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAltaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdlgAltaAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModulos)
                    .addComponent(cbbModulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdlgAltaAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdlgAltaAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnLimpiar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAddAlumno.setText("Añadir Alumno");

        btnAddModulo.setText("Añadir Módulo");

        btnSeeAlumno.setText("Ver Alumno");

        javax.swing.GroupLayout pnlButtonHoldLayout = new javax.swing.GroupLayout(pnlButtonHold);
        pnlButtonHold.setLayout(pnlButtonHoldLayout);
        pnlButtonHoldLayout.setHorizontalGroup(
            pnlButtonHoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonHoldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonHoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeeAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddAlumno)
                    .addComponent(btnAddModulo))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        pnlButtonHoldLayout.setVerticalGroup(
            pnlButtonHoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonHoldLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddModulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeeAlumno)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jMenu1.setText("Alumnos");
        menuMainWindow.add(jMenu1);

        jMenu2.setText("Módulos");
        menuMainWindow.add(jMenu2);

        setJMenuBar(menuMainWindow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtonHold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtonHold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AcademiaMasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcademiaMasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcademiaMasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcademiaMasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcademiaMasUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAlumno;
    private javax.swing.JButton btnAddModulo;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSeeAlumno;
    private javax.swing.JComboBox<String> cbbModulos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog jdlgAltaAlumnos;
    private javax.swing.JLabel lblAltaAlumnos;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblModulos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JMenuBar menuMainWindow;
    private javax.swing.JPanel pnlAltaAlumno;
    private javax.swing.JPanel pnlButtonHold;
    private javax.swing.JTextArea txtaModulos;
    private javax.swing.JTextField txtfLocalidad;
    private javax.swing.JTextField txtfNombre;
    // End of variables declaration//GEN-END:variables
}