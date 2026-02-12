package Algorithms;

import Type.*;

import java.util.List;

/*
class FCFS:
    - First Come First Serve algorithm
    - has schedule function which takes list of jobs and returns ScheduleResult obj
 */

public class FCFS {

    public static ScheduleResult schedule(List<ProcessJob> processes){
        int time = 0;

        for (ProcessJob p: processes){
            time += p.burstTime;
            p.completionTime = time;
        }

        return new ScheduleResult(processes);
    }


    //SCHEDULE PRINTING VERSION - used for testing
    public static ScheduleResult schedule(List<ProcessJob> processes, boolean debug){
        int time = 0;
        System.out.println("<First Come First Serve Schedule Table>");
        System.out.println("___________________________________________________");
        System.out.printf("%10s|%12s|%12s|%12s%n", "Job", "Start Time", "End Time", "Completion");
        for (ProcessJob p: processes){
            String rowString = String.format("%10s", p.title);
            rowString += String.format("|%12d| ", time);
            time += p.burstTime;
            rowString += String.format("%11d| ", time);
            p.completionTime = time;
            rowString += p.title + " completed @"+time;
            System.out.println(rowString);

        }
        System.out.println("___________________________________________________");

        return new ScheduleResult(processes);
    }
}
