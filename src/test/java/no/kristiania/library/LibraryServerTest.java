package no.kristiania.library;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

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
