import java.util.*;

class Solution {
    public int countDays(int n, int[][] meetings) {
        List<int[]> events = new ArrayList<>();

        // Convert meetings into events
        for (int[] meeting : meetings) {
            events.add(new int[]{meeting[0], 1});  // Meeting starts
            events.add(new int[]{meeting[1] + 1, -1});  // Meeting ends
        }

        // Sort events by day, prioritize end (-1) over start (+1) if same day
        Collections.sort(events, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int freeDays = 0;
        int activeMeetings = 0;
        int prevDay = 1;

        // Sweep through the events
        for (int[] event : events) {
            int day = event[0], type = event[1];

            // Count free days before the next event starts
            if (activeMeetings == 0) {
                freeDays += day - prevDay;
            }

            // Update active meeting count
            activeMeetings += type;
            prevDay = day;
        }

        // Count remaining free days after last event
        if (prevDay <= n) {
            freeDays += n - prevDay + 1;
        }

        return freeDays;
    }

    
}
