import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cart extends JFrame {
    static JTable table = new JTable();

    public Cart() {
        setTitle("Data Produk");
        setSize(700, 380);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        Database db = new Database();
        db.cart();

        add(new txtJudul());
        add(new PanelData());
        add(new PanelButton());

        setVisible(true);

        JLabel label = new JLabel("Klik disini untuk input!");
        label.setFont(new Font("times", Font.BOLD, 12));
        label.setForeground(new Color(101, 64, 98));
        label.setBounds(255,390,300,50);
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new inputcart();
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
        add(label);
    }

    static class txtJudul extends JPanel {
        public txtJudul() {
            setBackground(new Color(230, 230, 250));
            JLabel txtJudul = new JLabel("SEMBAKOKU");
            txtJudul.setFont(new Font("Tw Cent MT", Font.BOLD, 25));
            txtJudul.setBounds(108, 31, 300, 50);
            txtJudul.setForeground(Color.DARK_GRAY);
            add(txtJudul);
        }
    }

    static class PanelData extends JPanel {
        public PanelData() {
            setBackground(new Color(230, 230, 250));
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);
            table.setEnabled(false);
            setLayout(new GridLayout(1, 1));
            setBorder(new EmptyBorder(0, 10, 0, 10));

            add(scrollPane);
        }
    }

    class PanelButton extends JPanel {
        JButton btnInput;

        public PanelButton() {
            setBackground(new Color(230, 230, 250));
            btnInput = new JButton("INPUT");
            btnInput.setFont(new Font("Tw Cent MT", Font.BOLD, 14));
            btnInput.setBackground(Color.LIGHT_GRAY);
            btnInput.setForeground(Color.white);
            btnInput.setBounds(150, 360, 140, 30);
            add(btnInput);

            btnInput.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new inputcart();
                    ProdukPanel.cleanTable();
                    dispose();
                }
            });
        }
    }
}