import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Pembayaran extends JFrame {
    JLabel txtInvoice = new JLabel("20");

    public Pembayaran() {
        setTitle("PEMBAYARAN");
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new Alamat());
        add(new DataPanel());
        add(new DataPembelian());
        add(new ButtonPanel());
        
        setVisible(true);
    }
}

class Alamat extends JPanel {
    static JTextField txtDate = new JTextField();
    static JTextField txtAlamat = new JTextField();

    static JComboBox<String> cmbKurir = new JComboBox<>(new String[]{
            "JNE",
            "TIKI",
            "Sicepat",
            "AnterAja",
            "GRAB",
            "Gojek",
            "Cargo"
    });

    public Alamat() {
        setBackground(new Color(230, 230, 250));
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Tanggal Pembelian"));
        add(txtDate);

        add(new JLabel("Alamat"));
        add(txtAlamat);

        add(new JLabel(" Kurir Pengiriman"));
        cmbKurir.setEditable(true);
        cmbKurir.getEditor().getEditorComponent().setBackground(Color.white);
        add(cmbKurir);

        // Border
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Pengiriman");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));

        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorder));
    }
}

class DataPanel extends JPanel {
    static JTable table = new JTable(ProdukPanel.dtm);

    public DataPanel() {
        setBackground(new Color(230, 230, 250));
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setEnabled(false);

        setLayout(new GridLayout(1, 1));
        setBorder(new EmptyBorder(10, 10, 0, 10));


        add(scrollPane);
    }
}

class DataPembelian extends JPanel {
    Random rand = new Random();
    static JTextField txtInvoice = new JTextField();
    static JTextField txtTotal = new JTextField();

    static JComboBox<String> cmbBayar = new JComboBox<String>(new String[] {
            "Transfer Bank",
            "Virtual Account",
            "SuperMarket",
            "COD"
    });

    public DataPembelian() {
        setBackground(new Color(230, 230, 250));
        int upperbound = 25;
        int int_random = rand.nextInt(upperbound);

        setLayout(new GridLayout(6, 2));

        add(new JLabel("NO. Invoice"));
        add(txtInvoice);
        txtInvoice.setText(String.valueOf(int_random));

        add(new JLabel("Total Harga"));
        add(txtTotal);

        add(new JLabel("Metode Pembayaran"));
        cmbBayar.setEditable(true);
        cmbBayar.getEditor().getEditorComponent().setBackground(Color.white);
        add(cmbBayar);

        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Data Pembelian");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));

        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorder));
    }
}

class ButtonPanel extends JPanel {
    JButton btnTambah = new JButton("Tambah");
    JButton btnOrder = new JButton("Bayar");
    JButton btnCancel = new JButton("Cancel");

    public ButtonPanel() {
        setBackground(new Color(230, 230, 250));
        final Database db = new Database();

        btnTambah.setBackground(Color.LIGHT_GRAY);
        btnTambah.setForeground(Color.white);
        btnOrder.setBackground(Color.LIGHT_GRAY);
        btnOrder.setForeground(Color.white);
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setForeground(Color.white);

        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new inputcart();
                dispose();
                setLocationRelativeTo(null);
            }
            private void dispose() {
            }
        });

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProdukPanel.cleanTable();
                System.exit(0);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setLayout(new GridLayout(1, 3));
        add(btnTambah);
        add(btnOrder);
        add(btnCancel);
    }

    private void setLocationRelativeTo(Object o) {
    }

}





