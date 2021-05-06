package utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PropertiesReader {

    public static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }


    private void copyFileOrDir(String path) throws IOException {
        AssetManager assetManager = InstrumentationRegistry.getInstrumentation().getTargetContext().getAssets();
        String assets[] = null;
        try {
            assets = assetManager.list(path);
            if (assets.length == 0) {
                copyFile(path);
            } else {
                String fullPath = "/data/data/" + InstrumentationRegistry.getInstrumentation().getTargetContext().getPackageName() + "/" + path;
                File dir = new File(fullPath);
                if (!dir.exists())
                    dir.mkdir();
                for (int i = 0; i < assets.length; ++i) {
                    copyFileOrDir(path + "/" + assets[i]);
                }
            }
        } catch (IOException ex) {
            Log.e("tag", "I/O Exception", ex);
            throw ex;
        }
    }

    private void copyFile(String filename) {
        AssetManager assetManager = InstrumentationRegistry.getInstrumentation().getTargetContext().getAssets();
        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(filename);
            String newFileName = "/data/data/" + InstrumentationRegistry.getInstrumentation().getTargetContext().getPackageName() + "/" + filename;
            out = new FileOutputStream(newFileName);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }
    }
}
