package Algorithms;

import Type.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Class RR:
    - Round Robin algo
    - schedule function takes list of jobs and specific quantum; returns ScheduleResult obj
 */

public class RR {

    public static ScheduleResult schedule(List<ProcessJob> processes, int quantum){
        int time = 0;
        Queue<ProcessJob> jobQ = new LinkedList<ProcessJob>(processes);

        while(!jobQ.isEmpty()){
            ProcessJob job = jobQ.poll();

            int runTime = Math.min(job.remainingTime, quantum);
            time += runTime;
            job.remainingTime -= runTime;

            if (job.remainingTime > 0){
                jobQ.offer(job);
            }else{
                job.completionTime = time;
            }
        }

        return new ScheduleResult(processes);
    }

    //SCHEDULE PRINTING VERSION - used for testing
    public static ScheduleResult schedule(List<ProcessJob> processes, int quantum, boolean debug){
        int time = 0;
        Queue<ProcessJob> jobQ = new LinkedList<ProcessJob>(processes);

        System.out.println("<Round Robin "+quantum+ " Schedule Table>");
        System.out.println("___________________________________________________");
        System.out.printf("%10s|%12s|%12s|%12s%n", "Job", "Start Time", "End Time", "Completion");

        while(!jobQ.isEmpty()){
            ProcessJob job = jobQ.poll();
            String rowString = String.format("%10s", job.title);

            rowString += String.format("|%12d| ", time);
            int runTime = Math.min(job.remainingTime, quantum);
            time += runTime;
            rowString += String.format("%11d| ", time);
            job.remainingTime -= runTime;

            if (job.remainingTime > 0){
                jobQ.offer(job);
            }else{
                job.completionTime = time;
                rowString += job.title + " completed @"+time;
            }
            System.out.println(rowString);
        }
        System.out.println("___________________________________________________");

        return new ScheduleResult(processes);
    }
}
