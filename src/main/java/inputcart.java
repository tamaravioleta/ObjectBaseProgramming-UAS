import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class inputcart extends JFrame {
    JFrame inputcart = new JFrame();
    public inputcart (){
        Database db = new Database();
        setTitle("Data Produk");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new ProdukEditPanel());
        add(new ProdukPanel());
        add(new Button());

        setVisible(true);
    }
}

class ProdukPanel extends JPanel{
    static String[] column = {"ID","NAMA","JUMLAH","HARGA"};
    static DefaultTableModel dtm = new DefaultTableModel(null,column);
    static JTable table = new JTable(dtm);

    ProdukPanel(){
        setBackground(new Color(230, 230, 250));
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        setLayout(new GridLayout(1, 1));
        setBorder(new EmptyBorder(10, 10, 0, 10));

        add(scrollPane);

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProdukEditPanel.txtID.setText(dtm.getValueAt(table.getSelectedRow(),0)+"");
                ProdukEditPanel.txtNama.setSelectedItem(dtm.getValueAt(table.getSelectedRow(),1)+"");
                ProdukEditPanel.txtJumlah.setText(dtm.getValueAt(table.getSelectedRow(),2)+"");
                ProdukEditPanel.txtHarga.setText(dtm.getValueAt(table.getSelectedRow(),3)+"");
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
    }
    public static void cleanTable(){
        new Database();
        int baris = dtm.getRowCount();
        for(int a=0;a<baris;a++);
        {
            dtm.removeRow(0);
        }
    }
}

class ProdukEditPanel extends JPanel implements ItemListener {
    static JTextField txtID = new JTextField();
    static JComboBox<String> txtNama = new JComboBox<>(new String[]{"Gula", "Beras", "Susu Kental Manis", "Minyak Goreng", "Indomie Kuah", "Indomie Goreng", "Kecap Manis", "Kecap Asin", "Telur Bebek", "Telur Ayam", "Tepung Tapioka", "Tepung Segitiga", "Teh Sari Murni", "Kopi Kapal", "Garam", "Sirup Marjan"});
    static JTextField txtJumlah = new JTextField();
    static JTextField txtHarga = new JTextField();

    public ProdukEditPanel(){
        setBackground(new Color(230, 230, 250));
        setLayout(new GridLayout(4, 2));

        add(new JLabel("ID Produk"));
        add(txtID);
        txtID.setEditable(false);

        add(new JLabel("Nama"));
        add(txtNama);
        txtNama.addItemListener(this);
        txtNama.setEditable(true);
        txtNama.getEditor().getEditorComponent().setBackground(Color.white);

        add(new JLabel("Jumlah"));
        add(txtJumlah);

        add(new JLabel("Harga"));
        add(txtHarga);

        // border
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Produk");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));

        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10,10), titledBorder));
    }
    public void itemStateChanged(ItemEvent e)
    {
        // if the state combobox is changed
        if (e.getSource() == txtNama) {
            if(txtNama.getSelectedItem().equals("Gula")){
                txtID.setText("001");
                txtHarga.setText("20000");
            }
            if(txtNama.getSelectedItem().equals("Beras")){
                txtID.setText("002");
                txtHarga.setText("80000");
            }
            if(txtNama.getSelectedItem().equals("Susu Kental Manis")){
                txtID.setText("003");
                txtHarga.setText("17000");
            }
            if(txtNama.getSelectedItem().equals("Minyak Goreng")){
                txtID.setText("004");
                txtHarga.setText("25000");
            }
            if(txtNama.getSelectedItem().equals("Indomie Kuah")){
                txtID.setText("005");
                txtHarga.setText("26000");
            }
            if(txtNama.getSelectedItem().equals("Indomie Goreng")){
                txtID.setText("006");
                txtHarga.setText("26000");
            }
            if(txtNama.getSelectedItem().equals("Kecap Manis")){
                txtID.setText("007");
                txtHarga.setText("15000");
            }
            if(txtNama.getSelectedItem().equals("Kecap Asin")){
                txtID.setText("008");
                txtHarga.setText("15000");
            }
            if(txtNama.getSelectedItem().equals("Telur Bebek")){
                txtID.setText("009");
                txtHarga.setText("15000");
            }
            if(txtNama.getSelectedItem().equals("Telur Ayam")){
                txtID.setText("0010");
                txtHarga.setText("12000");
            }
            if(txtNama.getSelectedItem().equals("Tepung Tapioka")){
                txtID.setText("011");
                txtHarga.setText("12000");
            }
            if(txtNama.getSelectedItem().equals("Tepung Segitiga")){
                txtID.setText("012");
                txtHarga.setText("12000");
            }
            if(txtNama.getSelectedItem().equals("Teh Sari Murni")){
                txtID.setText("013");
                txtHarga.setText("75000");
            }
            if(txtNama.getSelectedItem().equals("Kopi Kapal")){
                txtID.setText("014");
                txtHarga.setText("15000");
            }
            if(txtNama.getSelectedItem().equals("Garam")){
                txtID.setText("015");
                txtHarga.setText("12000");
            }
            if(txtNama.getSelectedItem().equals("Sirup Marjan")) {
                txtID.setText("016");
                txtHarga.setText("21000");
            }
        }
    }
}


class Button extends  JPanel {
    JButton btnAdd = new JButton("Add new");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnOrder = new JButton("Order");
    JButton btnReset = new JButton("Reset");

    int subharga = 0;
    static int harga = 0;
    public Button() {
        new Database();
        setBackground(new Color(230, 230, 250));
        btnAdd.setBackground(Color.LIGHT_GRAY);
        btnAdd.setForeground(Color.white);
        btnUpdate.setBackground(Color.LIGHT_GRAY);
        btnUpdate.setForeground(Color.white);
        btnDelete.setBackground(Color.LIGHT_GRAY);
        btnDelete.setForeground(Color.white);
        btnOrder.setBackground(Color.LIGHT_GRAY);
        btnOrder.setForeground(Color.white);
        btnReset.setBackground(Color.LIGHT_GRAY);
        btnReset.setForeground(Color.white);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertCart();
                subharga = Integer.parseInt(
                        ProdukEditPanel.txtHarga.getText()) *
                        Integer.parseInt(ProdukEditPanel.txtJumlah.getText()
                        );
                harga += subharga;
                DataPembelian.txtTotal.setText(String.valueOf(harga));
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCart();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCart();
            }
        });

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pembayaran();
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProdukPanel.cleanTable();
            }
        });


        add(btnAdd);
        add(btnUpdate);
        add(btnDelete);
        add(btnOrder);
        add(btnReset);
        showDataCart();
    }

    public void showDataCart(){
        try{
            String sql = "SELECT * FROM keranjang";
            Statement st = Database.db.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ProdukPanel.dtm.setRowCount(0);
            while(rs.next()){
                Object[] row = {
                        rs.getString("idcart"),
                        rs.getString("namaproduk"),
                        rs.getInt("jumlah"),
                        rs.getInt("harga")
                };
                ProdukPanel.dtm.addRow(row);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertCart() {
        String kode = ProdukEditPanel.txtID.getText();
        String nama = (String) ProdukEditPanel.txtNama.getSelectedItem();
        int jumlah = Integer.parseInt(ProdukEditPanel.txtJumlah.getText());
        int total = Integer.parseInt(ProdukEditPanel.txtHarga.getText());
        try {
            String sql = "INSERT INTO keranjang VALUES(?, ?, ?, ?)";
            PreparedStatement ps = Database.db.prepareStatement(sql);
            ps.setString(1, kode);
            ps.setString(2, nama);
            ps.setInt(3, jumlah);
            ps.setInt(4, total);
            ps.execute();
            showDataCart();
            JOptionPane.showMessageDialog(null, "Insert Success");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Insert Failed");
        }
    }

    public void updateCart(){
        try{
            String sql = "UPDATE keranjang SET namaproduk=?, jumlah=?, harga=? WHERE idcart=?";
            PreparedStatement st = Database.db.prepareStatement(sql);
            ProdukPanel.dtm.setRowCount(0);
            try{
                st.setString(1, (String) ProdukEditPanel.txtNama.getSelectedItem());
                st.setInt(2, Integer.parseInt(ProdukEditPanel.txtJumlah.getText()));
                st.setInt(3, Integer.parseInt(ProdukEditPanel.txtHarga.getText()));
                st.setString(4,ProdukEditPanel.txtID.getText());
                st.execute();
                showDataCart();
                JOptionPane.showMessageDialog(null,"Update Success");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Update Fail");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteCart(){
        try{
            String sql = "DELETE FROM keranjang WHERE idcart = '"+ ProdukEditPanel.txtID.getText()+"'";
            PreparedStatement stmt = Database.db.prepareStatement(sql);
            stmt.execute();
            showDataCart();
            JOptionPane.showMessageDialog(null,"Delete Success");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Delete Fail");
        }
    }

}