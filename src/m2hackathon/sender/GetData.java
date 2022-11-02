package m2hackathon.sender;

import java.io.*;

public class GetData
{

    private static void getFilePath()
    {
        String filePath = "";
        File file = new File(filePath);

        if(!file.exists())
            return;

        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedInputStream bi = new BufferedInputStream(is);


    }


}

