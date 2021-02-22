//kc18182 - 1803189

package maze;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class ReadFromFile {
    //Class that returns an array of scores.
    ReadFromFile() {
        read();
    }

    StringBuilder read() {
        //ArrayList that will contain the scores.
        ArrayList<Integer> scores = new ArrayList<>();
        //StringBuilder for making the scores display neat.
        StringBuilder scoresText = new StringBuilder();

        //File name that stores the scores.
        String fileName = "scores.txt";

        String line;

        //Try to make a new buffered reader that uses file reader and the file scores.txt.
        try {
            //Create file if it does not exists.
            new FileOutputStream("scores.txt", true);
            //BufferedReader for reading the scores from the text file.
            BufferedReader br = new BufferedReader(new FileReader("scores.txt"));

            //while file has a line.
            while((line = br.readLine()) != null) {
                //Add the line (score) to the array list.
                scores.add(Integer.parseInt(line));
            }

            //Sort the ArrayList ascending order.
            Collections.sort(scores);

            //If the ArrayList is larger than 5, remove the values after the 5th index to the end.
            if (scores.size() > 5) {
                scores.subList(5, scores.size()).clear();
            }

            //Close BufferedReader.
            br.close();

        } catch(FileNotFoundException ex) { //Catch File not Found.
            System.out.println("Unable to open file '" + fileName + "'");
        } catch(IOException ex) { //Catch error reading the file.
            System.out.println("Error reading file '" + fileName + "'");
        }

        //Returning that score.
        for (int i = 0; i < scores.size(); i++) {
            scoresText.append("Top ").append(i + 1).append(": ").append(scores.get(i)).append(" seconds\n");
        }
        return scoresText;
    }
}
