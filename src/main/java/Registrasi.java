import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Registrasi extends JFrame implements ActionListener {
        JPanel panel = new JPanel();
        static JTextField firstName = new JTextField(20);
        static JTextField lastName = new JTextField(20);
        static JComboBox<String> gender = new JComboBox<>(new String[]{"Male", "Female"});
        static JTextField username = new JTextField(20);
        static JTextField email = new JTextField(20);
        static JPasswordField pass = new JPasswordField(20);
        static JTextField id = new JTextField(20);

        JButton regis;
        JButton login;

    public Registrasi() {
        new Database();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("REGISTRATION");
        setSize(450, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setSize(450,650);
        panel.setLayout(null);
        panel.setBackground(new Color(230,230,250));
        panel.setOpaque(true);

        JLabel judul = new JLabel("REGISTER");
        judul.setFont(new Font("Tw Cent MT", Font.BOLD, 36));
        judul.setBounds(125, 10, 300, 50);
        judul.setForeground(Color.gray);
        panel.add(judul);

        JLabel first = new JLabel("First Name");
        first.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        first.setBounds(35, 60, 175, 50);
        panel.add(first);

        firstName.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        firstName.setBounds(35, 100, 170, 30);
        panel.add(firstName);

        JLabel last = new JLabel("Last Name");
        last.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        last.setBounds(230, 60, 150, 50);
        panel.add(last);

        lastName.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        lastName.setBounds(230, 100, 170, 30);
        panel.add(lastName);

        JLabel gend = new JLabel("Gender");
        gend.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        gend.setBounds(35, 130, 200, 50);
        panel.add(gend);

        gender.setBounds(35, 170, 365, 30);
        gender.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        gender.setEditable(true);
        gender.getEditor().getEditorComponent().setBackground(Color.white);
        panel.add(gender);
        setLayout(null);

        JLabel uname = new JLabel("Username");
        uname.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        uname.setBounds(35, 200, 175, 50);
        panel.add(uname);

        username.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        username.setBounds(35, 240, 365, 30);
        panel.add(username);

        JLabel emails = new JLabel("Email Address");
        emails.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        emails.setBounds(35, 270, 175, 50);
        panel.add(emails);

        email.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        email.setBounds(35, 310, 365, 30);
        panel.add(email);

        JLabel passwords = new JLabel("Password");
        passwords.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        passwords.setBounds(35, 340, 175, 50);
        panel.add(passwords);

        pass.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        pass.setBounds(35, 380, 365, 30);
        panel.add(pass);

        JLabel ids = new JLabel("ID");
        ids.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        ids.setBounds(35, 410, 175, 50);
        panel.add(ids);

        id.setFont(new Font("Tw Cent MT", Font.PLAIN, 14));
        id.setBounds(35, 450, 365, 30);
        panel.add(id);

        regis = new JButton("REGISTER NOW");
        regis.setFont(new Font("Tw Cent MT", Font.BOLD, 14));
        regis.setBounds(220, 505, 160, 30);
        regis.setBackground(Color.lightGray);
        regis.setForeground(Color.white);
        panel.add(regis);
        regis.addActionListener(this);

        login = new JButton("BACK");
        login.setFont(new Font("Tw Cent MT", Font.BOLD, 14));
        login.setBounds(55, 505, 140, 30);
        login.setBackground(Color.lightGray);
        login.setForeground(Color.white);
        login.addActionListener(this);
        panel.add(login);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                dispose();
                panel.setVisible(true);
                setLocationRelativeTo(null);
            }
        });

        regis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Cart();
                dispose();
                panel.setVisible(true);
                setLocationRelativeTo(null);
            }
        });
        add(panel);
        setVisible(true);
    }
    private void setBorder(CompoundBorder compoundBorder) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regis) {
            Database db = new Database();
            try {
                db.Insert(firstName.getText(), lastName.getText(), gender.getSelectedItem().toString(), username.getText(), email.getText(), pass.getText(), id.getText());
//                System.out.println("tesMasuk");
                JOptionPane.showMessageDialog(null, "Your Account Has Been Registered !");
            }catch (Exception e1){
                System.out.println(e1);
                JOptionPane.showMessageDialog(null, "Your Account Has Not Been Registered !");
            }

        }
        if(e.getSource()==login){}
}
}
