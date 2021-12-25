/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.master;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import prodi.Prodi;
import prodi.ProdiService;
import tools.Koneksi;

/**
 *
 * @author Rosidin
 */
public class ProdiServiceServer extends UnicastRemoteObject implements ProdiService {
    
    private JdbcTemplate jdbcTemplate = Koneksi.getJdbcTemplate();

    public ProdiServiceServer() throws RemoteException {
    }

    @Override
    public Prodi create(Prodi p) throws RemoteException {
        String sql = "INSERT INTO tbl_prodi (IdFakultas, KodeProdi, NamaProdi, StatusProdi, Akreditasi, TglBerdiri, Keterangan) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, p.getIdFakultas(),p.getKodeProdi(),p.getNamaProdi(),p.getStatusProdi(),p.getAkreditasi(),p.getTglBerdiri(),p.getKeterangan());
        return p;
    }

    @Override
    public List<Prodi> read() throws RemoteException {
        String sql = "SELECT * FROM tbl_prodi p "
                    + "LEFT JOIN tbl_fakultas f ON f.IdFakultas=p.`IdFakultas`ORDER BY NamaProdi";
        RowMapper mapper = new RowMapper() {

            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Prodi p = new Prodi();
                p.setIdProdi(rs.getInt("IdProdi"));
                p.setIdFakultas(rs.getInt("IdFakultas"));
                p.setNamaFakultas(rs.getString("NamaFakultas"));
                p.setKodeProdi(rs.getString("KodeProdi"));
                p.setNamaProdi(rs.getString("NamaProdi"));
                p.setStatusProdi(rs.getString("StatusProdi"));
                p.setAkreditasi(rs.getString("Akreditasi"));
                p.setTglBerdiri(rs.getDate("TglBerdiri"));
                p.setKeterangan(rs.getString("Keterangan"));
                return p;
            }
        };
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Prodi update(Prodi p) throws RemoteException {
        String sql = "UPDATE tbl_prodi SET IdFakultas = ?, KodeProdi = ?, NamaProdi = ?, StatusProdi = ?, "
                + "Akreditasi = ?, TglBerdiri = ?, Keterangan = ? WHERE IdProdi = ?";
        jdbcTemplate.update(sql, p.getIdFakultas(),p.getKodeProdi(),p.getNamaProdi(),p.getStatusProdi(),
                p.getAkreditasi(),p.getTglBerdiri(),p.getKeterangan(),p.getIdProdi());
        return p;
    }

    @Override
    public void delete(Prodi p) throws RemoteException {
        String sql = "DELETE FROM tbl_prodi WHERE IdProdi = ?";
        jdbcTemplate.update(sql, p.getIdProdi());
    }

    @Override
    public Integer cekKodeProdi(String kodeProdi) throws RemoteException {
        String sql = "select count(*) from tbl_prodi where KodeProdi LIKE ?";
        return jdbcTemplate.queryForInt(sql, kodeProdi);
    }

    @Override
    public Integer getIdFakultas(String namaFakultas) throws RemoteException {
        String sql = "SELECT IdFakultas FROM tbl_fakultas WHERE NamaFakultas LIKE ?";
        return jdbcTemplate.queryForInt(sql, namaFakultas);
    }
    
}
