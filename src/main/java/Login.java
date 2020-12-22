import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

public class Login extends JFrame {

    static JTextField usernameTextField = new JTextField(20);
    static JPasswordField passwordField = new JPasswordField(20);

    private Connection db;

    JPanel panel = new JPanel();
    JButton signInButton;
    JButton registerButton;

    public Login() {

        new Database();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("LOGIN");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setSize(450, 500);
        panel.setLayout(null);
        panel.setBackground(new Color(230, 230, 250));
        panel.setOpaque(true);

        JLabel account = new JLabel("Tidak memiliki akun?");
        account.setFont(new Font("times", Font.PLAIN, 12));
        account.setForeground(new Color(101, 64, 98));
        account.setBounds(120,380,300,50);
        panel.add(account);

        JLabel regist = new JLabel("Klik disini!");
        regist.setFont(new Font("times", Font.BOLD, 12));
        regist.setForeground(new Color(101, 64, 98));
        regist.setBounds(235,380,300,50);
        panel.add(regist);

        JLabel gambar1 = new JLabel();
        setBackground(Color.white);
        System.out.println("berhasil");
        ImageIcon gambarr = new ImageIcon(new ImageIcon("images/logo.jpg").getImage().getScaledInstance(200, 110, Image.SCALE_DEFAULT));
        gambar1.setIcon(gambarr);
        gambar1.setBounds(120, 20, 250, 100);
        panel.add(gambar1);

        JLabel labelJudul = new JLabel("PENJUALAN SEMBAKO ONLINE");
        labelJudul.setFont(new Font("times", Font.BOLD, 15));
        labelJudul.setForeground(Color.white);
        labelJudul.setBounds(98, 111, 300, 50);
        add(labelJudul);

        final JLabel labelUsername = new JLabel("Username");
        labelUsername.setFont(new Font("Tw Cent MT", Font.PLAIN, 15));
        labelUsername.setBounds(20, 185, 175, 50);
        panel.add(labelUsername);

        usernameTextField.setFont(new Font("Tw Cent MT", Font.PLAIN, 16));
        usernameTextField.setBounds(160, 195, 250, 29);
        panel.add(usernameTextField);

        final JLabel labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Tw Cent MT", Font.PLAIN, 15));
        labelPassword.setBounds(20, 220, 165, 50);
        panel.add(labelPassword);

        passwordField.setFont(new Font("Tw Cent MT", Font.PLAIN, 16));
        passwordField.setBounds(160, 235, 250, 29);
        panel.add(passwordField);

        setLayout(null);
        Border border = BorderFactory.createLineBorder(Color.GRAY);

        signInButton = new JButton("LOGIN");
        signInButton.setFont(new Font("Tw Cent MT", Font.BOLD, 14));
        signInButton.setBackground(Color.LIGHT_GRAY);
        signInButton.setBorder(border);
        signInButton.setForeground(Color.white);
        signInButton.setBounds(70, 360, 140, 30);
        panel.add(signInButton);

        registerButton = new JButton("REGIST");
        registerButton.setFont(new Font("Tw Cent MT", Font.BOLD, 14));
        registerButton.setBackground(Color.LIGHT_GRAY);
        registerButton.setBorder(border);
        registerButton.setForeground(Color.white);
        registerButton.setBounds(220, 360, 140, 30);
        panel.add(registerButton);

        add(panel);
        setVisible(true);

        regist.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Registrasi();
                dispose();
                panel.setVisible(true);
                setLocationRelativeTo(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        signInButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String user = usernameTextField.getText();
                String pass = String.valueOf(passwordField.getText());
                Database db = new Database();
                try{
                    db.login(user,pass);
                    dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                }

                panel.setVisible(true);
                setLocationRelativeTo(null);

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registrasi();
                dispose();
                panel.setVisible(true);
                setLocationRelativeTo(null);
            }
        });
    }
}