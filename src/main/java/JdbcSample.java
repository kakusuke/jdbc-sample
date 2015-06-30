import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;

public class JdbcSample {

    private final DataSource ds;

    public JdbcSample(DataSource dataSource) {
        this.ds = dataSource;
    }

    public void run() throws SQLException {
        createSampleTable();
        insert();
    }

    public void createSampleTable() throws SQLException {
        try (Connection conn = ds.getConnection()) {
            try (PreparedStatement st = conn.prepareStatement("DROP TABLE IF EXISTS sample")) {
                st.execute();
            }
            try (PreparedStatement st = conn.prepareStatement("CREATE TABLE sample(range daterange, json json)")) {
                st.execute();
            }
        }
    }

    public void insert() throws SQLException {
        try (Connection conn = ds.getConnection()) {
            try (PreparedStatement st = conn.prepareStatement("INSERT INTO sample (range, json) VALUES(?, ?)")) {
                st.setObject(1, "[2012-12-12,2013-12-12)", Types.OTHER);
                st.setObject(2, "{\"hoge\":1}", Types.OTHER);
                st.execute();
            }
        }
    }
}
