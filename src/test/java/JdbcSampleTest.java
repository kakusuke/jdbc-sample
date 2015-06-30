import org.junit.Test;
import org.postgresql.jdbc2.optional.SimpleDataSource;

/**
 * Created by kakusuke on 15/06/30.
 */
public class JdbcSampleTest {

    @Test
    public void run() throws Exception {
        SimpleDataSource ds = new SimpleDataSource();
        ds.setUrl("jdbc:postgresql:test");
        ds.setUser("test");

        new JdbcSample(ds).run();
    }
}