/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.master;

import entity.master.Fakultas;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import tools.Koneksi;

/**
 *
 * @author Rosidin
 */
public class FakultasServiceServer extends UnicastRemoteObject implements FakultasService {
    
    private JdbcTemplate jdbcTemplate = Koneksi.getJdbcTemplate();
    
    // untuk transaction
//    private ApplicationContext context = Koneksi.getContext();
//    private DataSource dataSource = (DataSource)context.getBean("dataSource");
//    private PlatformTransactionManager transactionManager = (PlatformTransactionManager)context.getBean("transactionManager");
//    private TransactionDefinition transactionDefinition;
//    private TransactionStatus status;

    public FakultasServiceServer() throws RemoteException {
    }

//    public DataSource getDataSource() {
//        return dataSource;
//    }
//
//    public PlatformTransactionManager getTransactionManager() {
//        return transactionManager;
//    }
    
    @Override
    public Fakultas create(Fakultas f) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Fakultas> read() throws RemoteException {
        String sql = "SELECT * FROM tbl_fakultas ORDER BY NamaFakultas";
        RowMapper mapper = new RowMapper() {

            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Fakultas f = new Fakultas();
                f.setIdFakultas(rs.getInt("IdFakultas"));
                f.setKodeFakultas(rs.getString("KodeFakultas"));
                f.setNamaFakultas(rs.getString("NamaFakultas"));
                f.setKeterangan(rs.getString("Keterangan"));
                return f;
            }
        };
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Fakultas update(Fakultas f) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Fakultas f) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
