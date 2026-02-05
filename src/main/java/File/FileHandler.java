package File;
import Type.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

}
