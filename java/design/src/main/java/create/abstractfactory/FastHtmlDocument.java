package create.abstractfactory;

import java.io.IOException;
import java.nio.file.Path;

public class FastHtmlDocument implements HtmlDocument {
    public FastHtmlDocument(String md) {
    }

    @Override
    public void save(Path path) throws IOException {

    }
}
