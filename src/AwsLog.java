import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AwsLog {
    public static List<List<String>> filterAndSortLogs(List<List<String>> logs) {
        // Step 1: Filter logs with status ERROR or CRITICAL
        List<List<String>> filteredLogs = new ArrayList<>();
        for (List<String> log : logs) {
            String status = log.get(2).toUpperCase();
            if (status.equals("ERROR") || status.equals("CRITICAL")) {
                filteredLogs.add(log);
            }
        }

        // Step 2: Sort based on date (DD-MM-YYYY) and time (HH:MM)
        filteredLogs.sort((log1, log2) -> {
            String key1 = getSortableKey(log1.get(0), log1.get(1));
            String key2 = getSortableKey(log2.get(0), log2.get(1));
            return key1.compareTo(key2);
        });

        return filteredLogs;
    }

    // Helper to convert DD-MM-YYYY + HH:MM into sortable string YYYYMMDDHHMM
    private static String getSortableKey(String date, String time) {
        String[] dateParts = date.split("-");
        String dd = dateParts[0];
        String mm = dateParts[1];
        String yyyy = dateParts[2];

        String sortableDate = yyyy + mm + dd;
        String sortableTime = time.replace(":", "");

        return sortableDate + sortableTime;
    }

    // Main method to test
    public static void main(String[] args) {
        List<List<String>> logs = Arrays.asList(
                Arrays.asList("31-01-2022", "23:45", "INFO", "This is an informational log"),
                Arrays.asList("01-02-2022", "10:05", "ERROR", "An error occurred"),
                Arrays.asList("01-02-2022", "09:30", "DEBUG", "This is a debug log"),
                Arrays.asList("01-02-2022", "12:15", "CRITICAL", "A critical error occurred"),
                Arrays.asList("01-02-2023", "11:00", "ERROR", "Another error occurred")
        );

        List<List<String>> result = filterAndSortLogs(logs);

        // Print result
        for (List<String> log : result) {
            System.out.println(log);
        }
    }
}
