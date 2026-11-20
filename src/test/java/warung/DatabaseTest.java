package warung;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.jupiter.api.Test;
import warung.util.Database;

class DatabaseTest {
    @Test void membuatTabelDanSeed() throws Exception {
        Database database = new Database("jdbc:sqlite:file:stage1?mode=memory&cache=shared");
        try (Connection keepAlive = database.connect()) {
            database.initialize();
            try (Connection connection = database.connect(); Statement statement = connection.createStatement()) {
            assertEquals(2, count(statement, "user"));
            assertEquals(3, count(statement, "menu"));
            assertEquals(1, count(statement, "biaya"));
            }
        }
    }
    private static int count(Statement statement, String table) throws Exception {
        try (ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM " + table)) { result.next(); return result.getInt(1); }
    }
}
