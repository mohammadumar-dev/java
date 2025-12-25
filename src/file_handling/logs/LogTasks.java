package file_handling.logs;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LogTasks {

    // Date format for cleaner timestamps
    private static final DateTimeFormatter dtf =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Task (1-4): ");
        int task = sc.nextInt();
        sc.nextLine(); // clear enter key

        switch (task) {
            case 1: task1_simpleFileWriter(); break;
            case 2: task2_bufferedWriterTimestamp(); break;
            case 3: task3_generate50Logs(); break;
            case 4: task4_logAnalyzer(); break;
            default: System.out.println("Invalid choice!");
        }
    }

    // ---------------------------------------------------------------
    // TASK 1: Simple FileWriter Log
    // ---------------------------------------------------------------
    /*
       This task:
       ✔ Takes a message from user
       ✔ Writes it into log.txt
       ✔ Adds (appends) new message on every program run

       FileWriter(true) → true means append mode
    */
    public static void task1_simpleFileWriter() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your log message: ");
        String msg = sc.nextLine();

        // FileWriter opens the file. "true" means: don't erase old content.
        FileWriter fw = new FileWriter("log.txt", true);

        fw.write(msg + "\n"); // write message + new line
        fw.close();

        System.out.println("Message written to log.txt");
    }

    // ---------------------------------------------------------------
    // TASK 2: BufferedWriter Log with Timestamp
    // ---------------------------------------------------------------
    /*
       This task:
       ✔ Uses BufferedWriter → faster than FileWriter
       ✔ Automatically writes timestamp
       ✔ Format: 2025-01-22 10:35:25 INFO Message

       LocalDateTime.now() → returns current date + time
    */
    public static void task2_bufferedWriterTimestamp() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your log message: ");
        String msg = sc.nextLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));

        String logLine = dtf.format(LocalDateTime.now()) + " INFO " + msg;

        bw.write(logLine);  // write log line
        bw.newLine();       // move to next line
        bw.close();

        System.out.println("Timestamped log written to log.txt");
    }

    // ---------------------------------------------------------------
    // TASK 3: Generate 50 Logs Automatically
    // ---------------------------------------------------------------
    /*
       This task:
       ✔ Automatically generates 50 logs
       ✔ 25 INFO, 15 WARN, 10 ERROR
       ✔ Writes them with timestamps

       We use loops to generate the log messages.
    */
    public static void task3_generate50Logs() throws Exception {

        BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));

        // Write 25 INFO logs
        for (int i = 1; i <= 25; i++) {
            bw.write(dtf.format(LocalDateTime.now()) + " INFO Auto-generated info log " + i);
            bw.newLine();
        }

        // Write 15 WARN logs
        for (int i = 1; i <= 15; i++) {
            bw.write(dtf.format(LocalDateTime.now()) + " WARN Auto-generated warning " + i);
            bw.newLine();
        }

        // Write 10 ERROR logs
        for (int i = 1; i <= 10; i++) {
            bw.write(dtf.format(LocalDateTime.now()) + " ERROR Auto-generated error " + i);
            bw.newLine();
        }

        bw.close();
        System.out.println("50 Logs generated successfully!");
    }

    // ---------------------------------------------------------------
    // TASK 4: Log Analyzer
    // ---------------------------------------------------------------
    /*
       This task reads log.txt and prints:
       ✔ Total log lines
       ✔ How many INFO
       ✔ How many WARN
       ✔ How many ERROR
       ✔ Longest log line
       ✔ First & last timestamp

       We use BufferedReader to read file line by line.
    */
    public static void task4_logAnalyzer() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("log.txt"));

        String line;
        int total = 0;
        int info = 0;
        int warn = 0;
        int error = 0;

        String longestLine = "";
        String firstTimestamp = null;
        String lastTimestamp = null;

        while ((line = br.readLine()) != null) {

            total++; // count each line

            // Capture first timestamp
            if (firstTimestamp == null) {
                firstTimestamp = line.substring(0, 19); // first 19 chars are date+time
            }

            // Update last timestamp every time
            lastTimestamp = line.substring(0, 19);

            // Check log type (INFO/WARN/ERROR)
            if (line.contains("INFO")) info++;
            if (line.contains("WARN")) warn++;
            if (line.contains("ERROR")) error++;

            // Check longest log line
            if (line.length() > longestLine.length()) {
                longestLine = line;
            }
        }

        br.close();

        // Printing results
        System.out.println("====== LOG ANALYSIS ======");
        System.out.println("Total log lines: " + total);
        System.out.println("INFO count: " + info);
        System.out.println("WARN count: " + warn);
        System.out.println("ERROR count: " + error);
        System.out.println("Longest log line: " + longestLine);
        System.out.println("First log timestamp: " + firstTimestamp);
        System.out.println("Last log timestamp: " + lastTimestamp);
    }
}
