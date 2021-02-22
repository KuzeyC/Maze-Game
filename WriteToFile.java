//kc18182 - 1803189

package maze;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class WriteToFile {
    //Class that writes the current score to the file.
    WriteToFile(long score) {
        //File name that stores the scores.
        String fileName = "scores.txt";

        //Try to make a new buffered writer that uses file writer and the file scores.txt with append so the text in scores doesnt get deleted.
        try {
            //Create file if it does not exists.
            new FileOutputStream("scores.txt", true);
            //BufferedWriter for adding the scores to the text file.
            BufferedWriter bw = new BufferedWriter(new FileWriter("scores.txt", true));

            //Write the score to the file with a new line after it.
            bw.write(score + "\n");

            //Close buffered writer.
            bw.close();

        } catch(FileNotFoundException ex) { //Catch File not Found.
            System.out.println("Unable to open file '" + fileName + "'");
        } catch(IOException ex) { //Catch error reading the file.
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }
}
