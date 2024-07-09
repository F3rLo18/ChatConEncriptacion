package paquete;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame{
    private static String fuente="Congenial Black";
    private JPanel panel;
    public Login(){
    ListaUsuarios.crearAdmin();    
    iniciarComponentes();
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //Metodo para inicializar todos los componentes
    private void iniciarComponentes(){
    
    iniciarVentana();
    iniciarPanel();
    iniciarEtiquetas();
    iniciarCajasDeTexto();
    
    }

    //Metodo para inicializar la ventana
    private void iniciarVentana(){
    this.setSize(800,600);
    this.setTitle("Login");
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    }
    //Metodo para inicializar el JPanel:
    private void iniciarPanel(){
        panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setBackground(new Color(15, 188, 223));
        panel.setLayout(null);
    }
    //Metodo para inicializar las etiqeutas 
    private void iniciarEtiquetas(){
    //Etiqueta imagen 
    ImageIcon imagenlogoPng= new ImageIcon("logoLogin2.png");
    JLabel etiquetaImagenLogo= new JLabel();
    etiquetaImagenLogo.setBounds(300,50,215,225);
    etiquetaImagenLogo.setIcon(new ImageIcon(imagenlogoPng.getImage().getScaledInstance(etiquetaImagenLogo.getWidth(),etiquetaImagenLogo.getHeight(), Image.SCALE_SMOOTH)));
    //Etiqueta Codigo usuario:
    JLabel etiquetaCodigo= new JLabel("Codigo",SwingConstants.RIGHT);
    etiquetaCodigo.setBounds(120,300,130,45);
    
    etiquetaCodigo.setFont(new Font(fuente,0, 35));
    //Etiqueta contraseña: 
    JLabel etiquetaContrasegna= new JLabel("Contraseña",SwingConstants.RIGHT);
    etiquetaContrasegna.setBounds(70,350,180,45);
    
    etiquetaContrasegna.setFont(new Font(fuente,0, 35));
    //Etiqueta registrate
    JLabel etiquetaRegistro= new JLabel();
    etiquetaRegistro.setBounds(230,425,150,40);
    etiquetaRegistro.setText("<HTML>¿No tienes cuenta?,<p>Registrate!<HTML>");
    etiquetaRegistro.setFont(new Font(fuente,0, 15));
    listenerMouseRegistro(etiquetaRegistro);

    panel.add(etiquetaCodigo);
    panel.add(etiquetaImagenLogo);
    panel.add(etiquetaContrasegna);
    panel.add(etiquetaRegistro);
    }
    //Metodo para inicializar las cajas de texto: 
    private void iniciarCajasDeTexto(){
    //Inicializando la caja para el código del usuario: 
    JTextField cajaCodigo= new JTextField();
    cajaCodigo.setFont(new Font(fuente,0, 30));
    cajaCodigo.setBounds(275,300,300,40);
    //Inicializando la caja para la contraseña:
    JPasswordField cajaContrasegna= new JPasswordField();
    cajaContrasegna.setFont(new Font(fuente,0, 30));
    cajaContrasegna.setBounds(275,350,300,40);

    //Creando el botón para el inicio de sesión 
    JButton botonIniciarSesion = new JButton();
        botonIniciarSesion.setBounds(425,400,150,50);
        botonIniciarSesion.setText("Ingresar");
    listenerLogin(botonIniciarSesion, cajaCodigo, cajaContrasegna);
    panel.add(cajaCodigo);
    panel.add(cajaContrasegna);
    panel.add(botonIniciarSesion);
    }

    //Listener para la etiqueta de registro: 
    private void listenerMouseRegistro(JLabel etiqueta){
    MouseListener oyente= new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Register ventanaRegistro= new Register();
            ventanaRegistro.setVisible(true);
            Main.cerrarLogin();
        }
        @Override
        public void mousePressed(MouseEvent e) {   } 
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {
            etiqueta.setForeground(Color.blue);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            etiqueta.setForeground(Color.black);
        }
        
    };
    etiqueta.addMouseListener(oyente);
    }
    //Listener para el login 
    private void listenerLogin(JButton boton,JTextField codigo,JPasswordField contrasegna){
        


        ActionListener oyenteBoton = new ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent e) {
                 char [] contra= contrasegna.getPassword();
                 String contras= new String(contra);

              if( ListaUsuarios.buscarUsuario(codigo.getText())){
                JOptionPane.showMessageDialog(null,"Usuario encontrado!");
                    

              }else{
                JOptionPane.showMessageDialog(null,"Usuario no encontrado");
              }
            }
        };
        boton.addActionListener(oyenteBoton);
    }
}
