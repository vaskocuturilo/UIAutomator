package utils;

import androidx.test.platform.app.InstrumentationRegistry;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import static java.lang.String.format;
import static utils.PropertiesReader.getJsonFromAssets;

public final class JsonData {

    public static <T> T getJsonData(final String jsonFileName, final Class<T> tClass, final String folderName) {
        final String pathToFolder = getJsonFromAssets(InstrumentationRegistry.getInstrumentation().getTargetContext(), format(folderName + "/%s.json", jsonFileName));

        return new Gson().fromJson(pathToFolder, tClass);
    }

    public static <T> T getJsonDataExternal(String filename, final Class<T> tClass) {
        final String pathToFolder = readFile(filename);

        return new Gson().fromJson(pathToFolder, tClass);
    }

    public static String readFile(String filename) {
        String jString = null;
        try {
            File yourFile = new File("/data/data/" + InstrumentationRegistry.getInstrumentation().getTargetContext().getPackageName() + "/" + filename);
            FileInputStream stream = new FileInputStream(yourFile);
            jString = null;
            try {
                FileChannel fc = stream.getChannel();
                MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
                jString = Charset.defaultCharset().decode(bb).toString();
            } finally {
                stream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jString;
    }
}
