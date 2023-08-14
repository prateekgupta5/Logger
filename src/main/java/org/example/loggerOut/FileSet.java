package org.example.loggerOut;

import java.io.*;

import static org.example.util.DefaultFile.DEFAULT_DIR;

public class FileSet {
    public FileSet (String name) throws IOException {
        this.name = name;

        dir = new File(DEFAULT_DIR + name);

        if (dir.mkdir()) { //if it doesn't exist, numFiles = 0
            File setData = new File(dir.getPath() + ".SetData.txt");
            numFiles = 0;
        } else { //otherwise numFiles = the number of files
            File setData = new File(dir.getPath() + ".SetData.txt");
            BufferedReader reader = new BufferedReader(new FileReader(setData));
            numFiles = Integer.parseInt(reader.readLine());
        }
    }

    public File getEntry (int i) throws IOException {
        if( i >= numFiles ) {
            return getNewEntry();
        }
        return new File(dir.getPath() + "entry_" + i + ".txt");
    }

    public File getNewEntry () throws IOException {
        ++numFiles;
        updateSetData();
        return new File(dir.getPath() + "entry_" + (numFiles-1) + ".txt");
    }

    public void updateSetData () throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(dir.getPath() + ".SetData.txt"));
        writer.write(String.valueOf(numFiles) + "\n");
    }

    public int getNumFiles () {
        return numFiles;
    }

    public String getName () {
        return name;
    }

    String name;
    File dir;
    int numFiles;
}