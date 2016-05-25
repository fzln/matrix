package matrix;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by f on 22.05.16.
 *
 */
public class TestInputStream {
    public static InputStream get() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            outputStream.write("3 7".getBytes());
            outputStream.write("\n".getBytes());
            outputStream.write("1 3 + 2 / 1 -;  2  3   +  ;3;b2 b1 + a3 -;5;a7;a5 c7 +".getBytes());
            outputStream.write("\n".getBytes());
            outputStream.write("8 2 +;9;0;1.01234567; 2; c1 b5 b7 + +;4.5 5.5 +".getBytes());
            outputStream.write("\n".getBytes());
            outputStream.write("c3 c2 +;c4;2;8 2 /;9;0;c1".getBytes());
            outputStream.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
