import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


public class Database {
    static Connection db;
    static DefaultTableModel dtm;

    public Database() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String password = "";

            Class.forName(driver);
            db = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Insert(String firstname,String lastname, String gender, String username,String email,String password,String id) {
        try {
            String sql = "INSERT INTO dataregis (firstname, lastname, gender, username, email, password, id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = db.prepareStatement(sql);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, gender);
            ps.setString(4, username);
            ps.setString(5, email);
            ps.setString(6, password);
            ps.setString(7, id);

            ps.execute();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void login(String userName, String password){
        try{
            System.out.println(userName+" "+password);
            String sql = "SELECT username, password FROM dataregis WHERE username='" +userName+
                    "' and password='"+password+"'";
            Statement ps = db.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            String username="";
            String pw="";
            while (rs.next())
            {
                username = rs.getString("username");
                pw = rs.getString("password");
                System.out.println(username+" "+pw);
            }
            if(userName.equals(username)&&password.equals(pw)){
                JOptionPane.showMessageDialog(null,"Success Sign In");
                new Cart();
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Username And Password");
            }
        }catch (Exception ex){
            ex.printStackTrace();

        }

    }

    private void dispose() {
    }

    public void cart() {
        try {
            Object[] kolom = {"ID", "Nama Produk", "Banyak", "Harga"};

            dtm = new DefaultTableModel(null, kolom);
            Cart.table.setModel(dtm);


        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String sql = "SELECT*FROM cart";

            Statement statement = db.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Object[] row = {resultSet.getString("id"),
                        resultSet.getString("namaProduk"),
                        resultSet.getString("Jumlah"),
                        resultSet.getInt("Harga")};
                dtm.addRow(row);
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }


    }


}
