package Algorithms;

import Type.*;

import java.util.*;

/*
Class SJF:
    - Shortest Job First algo
    - has schedule function which takes list of jobs and returns ScheduleResult obj
 */

public class SJF {

    public static ScheduleResult schedule(List<ProcessJob> processes){
        int time = 0;

        //queue up all processes into prio queue (sorts by burst time)
        PriorityQueue<ProcessJob> jobQ = new PriorityQueue<>(Comparator.comparingInt(ProcessJob -> ProcessJob.burstTime));
        jobQ.addAll(processes);

        //complete jobs
        while (!jobQ.isEmpty()) {
            ProcessJob pj = jobQ.poll();
            time += pj.burstTime;
            pj.completionTime = time;
        }

        return new ScheduleResult(processes);
    }

    //SCHEDULE PRINTING VERSION - used for testing
    public static ScheduleResult schedule(List<ProcessJob> processes, boolean debug){
        int time = 0;

        //queue up all processes into prio queue (sorts by burst time)
        PriorityQueue<ProcessJob> jobQ = new PriorityQueue<>(Comparator.comparingInt(ProcessJob -> ProcessJob.burstTime));
        jobQ.addAll(processes);

        System.out.println("<Shortest Job First Schedule Table>");
        System.out.println("___________________________________________________");
        System.out.printf("%10s|%12s|%12s|%12s%n", "Job", "Start Time", "End Time", "Completion");

        //complete jobs
        while (!jobQ.isEmpty()) {
            ProcessJob pj = jobQ.poll();
            String rowString = String.format("%10s", pj.title);
            rowString += String.format("|%12d| ", time);
            time += pj.burstTime;
            rowString += String.format("%11d| ", time);
            pj.completionTime = time;
            rowString += pj.title + " completed @"+time;
            System.out.println(rowString);
        }
        System.out.println("___________________________________________________");

        return new ScheduleResult(processes);
    }
}
