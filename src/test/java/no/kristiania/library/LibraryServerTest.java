package no.kristiania.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryServerTest {


    private LibraryServer server;

    @BeforeEach
    void setUp() throws Exception {
        server = new LibraryServer(0);
        server.start();
    }

    @Test
    void shouldShowFrontPage() throws Exception {
        URL url = server.getURL();


        HttpURLConnection connection = (HttpURLConnection) new URL(server.getURL(),"/").openConnection();

        assertThat(connection.getResponseCode()).as(connection.getResponseMessage())
                .isEqualTo(200);
        assertThat(connection.getInputStream()).asString(StandardCharsets.UTF_8)
                .contains("<h1>Kristiania Library</h1>");
    }


    @Test
    void shouldReturnBookList() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(server.getURL(), "/api/books").openConnection();
        assertThat(connection.getResponseCode()).as(connection.getResponseMessage())
                .isEqualTo(200);
        assertThat(connection.getInputStream()).asString(StandardCharsets.UTF_8)
                .contains("{\"title\": \"Example Book\"");
    }
}
