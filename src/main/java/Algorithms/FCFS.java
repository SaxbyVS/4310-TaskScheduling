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
}
