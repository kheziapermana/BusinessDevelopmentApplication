
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Pasien {

    private int id;
    private String nama;
    private String nik;
    private Date tanggalLahir;
    private String alamat;

    public Pasien(int id, String nama, String nik, Date tanggalLahir, String alamat) {
        this.id = id;
        this.nama = nama;
        this.nik = nik;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNik() {
        return this.nik;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Date getTanggalLahir() {
        return this.tanggalLahir;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void insert(Connection conn) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO klinik_blackpink (NamaPasien, NIK, TanggalLahir, Alamat)"
                    + " VALUES ("
                    + "'" + this.nama + "', "
                    + "'" + this.nik + "', "
                    + "'" + sdf.format(this.tanggalLahir) + "', "
                    + "'" + this.alamat + "'"
                    + ");";
            stmt.execute(query);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void update(Connection conn) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Statement stmt = conn.createStatement();
            String query = "UPDATE klinik_blackpink "
                    + "SET NamaPasien = '" + this.nama + "', "
                    + "NIK = '" + this.nik + "', "
                    + "TanggalLahir = '" + sdf.format(this.tanggalLahir) + "', "
                    + "Alamat = '" + this.alamat + "'"
                    + "WHERE Id = " + this.id;
            stmt.execute(query);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void delete(Connection conn) throws Exception {
        try {
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM klinik_blackpink WHERE Id = " + this.id;
            stmt.execute(query);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static ArrayList<Pasien> getAll(Connection conn) throws Exception {
        try {
            ArrayList<Pasien> pasiens = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM klinik_blackpink");
            while (rs.next()) {
                Pasien pasien = new Pasien(rs.getInt("Id"), rs.getString("NamaPasien"), rs.getString("NIK"), rs.getDate("TanggalLahir"), rs.getString("Alamat"));
                pasiens.add(pasien);
            }
            return pasiens;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
