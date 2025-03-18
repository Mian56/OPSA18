package OPSA18;

import java.util.Arrays;

public class Scheduling {

    static class Process {
        int id, burstTime, waitingTime, turnaroundTime;

        Process(int id, int burstTime) {
            this.id = id;
            this.burstTime = burstTime;
        }
    }

    // FCFS Scheduling
    static void FCFS(Process[] processes) {
        int totalWaitingTime = 0, totalTurnaroundTime = 0;

        processes[0].waitingTime = 0; // First process has 0 waiting time
        processes[0].turnaroundTime = processes[0].burstTime;

        for (int i = 1; i < processes.length; i++) {
            processes[i].waitingTime = processes[i - 1].waitingTime + processes[i - 1].burstTime;
            processes[i].turnaroundTime = processes[i].waitingTime + processes[i].burstTime;
            totalWaitingTime += processes[i].waitingTime;
            totalTurnaroundTime += processes[i].turnaroundTime;
        }

        // Display FCFS
        System.out.println("----------------- FCFS -----------------");
        System.out.println("Process ID | Waiting Time | Turnaround Time");
        for (Process process : processes) {
            System.out.printf("%8d    | %12d    | %15d\n", process.id, process.waitingTime, process.turnaroundTime);
        }
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / processes.length);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processes.length);
    }

    // SJF Scheduling
    static void SJF(Process[] processes) {
        int totalWaitingTime = 0, totalTurnaroundTime = 0;

        Arrays.sort(processes, (a, b) -> a.burstTime - b.burstTime);

        processes[0].waitingTime = 0;
        processes[0].turnaroundTime = processes[0].burstTime;

        for (int i = 1; i < processes.length; i++) {
            processes[i].waitingTime = processes[i - 1].waitingTime + processes[i - 1].burstTime;
            processes[i].turnaroundTime = processes[i].waitingTime + processes[i].burstTime;
            totalWaitingTime += processes[i].waitingTime;
            totalTurnaroundTime += processes[i].turnaroundTime;
        }

        // Display SJF
        System.out.println("----------------- SJF -----------------");
        System.out.println("Process ID | Waiting Time | Turnaround Time");
        for (Process process : processes) {
            System.out.printf("%8d    | %12d    | %15d\n", process.id, process.waitingTime, process.turnaroundTime);
        }
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / processes.length);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processes.length);
    }

    public static void main(String[] args) {
        Process[] processesFCFS = new Process[] {
                new Process(1, 2),
                new Process(2, 1),
                new Process(3, 8),
                new Process(4, 4),
                new Process(5, 5)
        };

        Process[] processesSJF = Arrays.copyOf(processesFCFS, processesFCFS.length);

        // FCFS Scheduling
        FCFS(processesFCFS);

        // SJF Scheduling
        SJF(processesSJF);
    }
}
