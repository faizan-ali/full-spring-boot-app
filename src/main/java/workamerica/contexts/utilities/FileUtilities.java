package workamerica.contexts.utilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Faizan on 8/9/2016.
 */
public class FileUtilities {

    // Takes an InputStream and returns a file (the stream is closed)
    public static File inputStreamToFile(InputStream stream) {
        if (stream != null) {
            File tmp = new File("tmp");
            tmp.deleteOnExit();
            try {
                FileUtils.copyInputStreamToFile(stream, tmp);
                return tmp;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
