package no.kristiania.library;
import  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LibraryServerTest {

    @Override
    void shouldShowFrontPage() throws IOException {
        LibraryServer server = new LibraryServer(0);

        URL url = server.getURL();

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        assertThat(connection.getResponseCode().as(connection.getResponseMessage().isEqualTo(200)));
        assertThat(connection.getInputStream().asString().contains("<h1>Kristiania Library</h1>"));
    }
}
