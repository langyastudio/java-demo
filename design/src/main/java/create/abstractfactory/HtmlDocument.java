package create.abstractfactory;

import java.io.IOException;
import java.nio.file.Path;

public interface HtmlDocument {
    void save(Path path) throws IOException;
}
