package File;
import Type.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static List<ProcessJob> job_file_read(String filename) throws IOException {
        List<ProcessJob> jobList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String title;

        while ((title = br.readLine()) != null) {
            String burstLine = br.readLine();   // next line is burst time
            if (burstLine == null) break;

            int burstTime = Integer.parseInt(burstLine.trim());
            jobList.add(new ProcessJob(title.trim(), burstTime));
        }

        br.close();
        return jobList;
    }

    public static void saveResults(String filename, String data) {
        try (FileWriter writer = new FileWriter(filename, true)) { // Append mode
            writer.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
