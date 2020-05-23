import java.util.*;
public class ReorderDatainLogs {
    // Using Custom sort from the main leet code solution.

    /**
     * Time Complexity: O(\mathcal{A}\log \mathcal{A})O(AlogA), where \mathcal{A}A is the total content of logs.
     *
     * Space Complexity: O(\mathcal{A})O(A).
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    //Solution Two

    /**
     * TODO:: Corner case -- fails.
     * @param logs
     * @return
     */
    public String[] reorderLogFilesTwo(String[] logs) {
        if (logs == null || logs.length == 0) return logs;
        int len = logs.length;
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();
        for (String log : logs) {
            if (log.split(" ")[1].charAt(0) < 'a') {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }
        Collections.sort(letterList, (o1, o2) -> {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            int len1 = s1.length;
            int len2 = s2.length;
            for (int i = 1; i < Math.min(len1, len2); i++) {
                if (!s1[i].equals(s2[i])) {
                    return s1[i].compareTo(s2[i]);
                }
            }
            return 0;
        });

        for (int i = 0; i < len; i++) {
            if (i < letterList.size())
                logs[i] = letterList.get(i);
            else logs[i] = digitList.get(i - letterList.size());
        }
        return logs;
    }

    // solution fixes with corner case.
    public String[] reorderLogFilesThree(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String[] elements = log.split(" ");
            if (Character.isLetter(elements[1].charAt(0))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        letterLogs.sort((o1, o2) -> {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            String id1 = s1[0];
            String id2 = s2[0];
            int len1 = s1.length;
            int len2 = s2.length;

            for (int i = 1; i < Math.min(len1, len2); i++) {
                if (!s1[i].equals(s2[i])) {
                    return s1[i].compareTo(s2[i]);
                } else if (i == Math.min(len1, len2) - 1 && s1[i].equals(s2[i])) {
                    return id1.compareTo(id2);
                }
            }
            return 0;
        });

        for (int i = 0; i < logs.length; i++) {
            if (i < letterLogs.size()) {
                logs[i] = letterLogs.get(i);
            } else {
                logs[i] = digitLogs.get(i - letterLogs.size());
            }
        }

        return logs;
    }

    // Using Priority Queues and works FINE.
    // This is one solution we could use.
    public String[] reorderLogFilesFour(String[] logs) {
        PriorityQueue<String> pq = new PriorityQueue<String>((a,b)->{
            String[] awords = a.split(" ",2);
            String[] bwords = b.split(" ",2);
            if (awords[1].equals(bwords[1]))
                return awords[0].compareTo(bwords[0]);
            return awords[1].compareTo(bwords[1]);
        }) ;

        List<String> q = new LinkedList();
        List<String> result = new LinkedList();
        for (String log : logs)
        {
            String temp = log.split(" ",2)[1];
            if (temp.charAt(0) - 'a' >= 0)
                pq.offer(log);
            else
                q.add(log);
        }
        while (!pq.isEmpty())
            result.add(pq.poll());
        result.addAll(q);
        return result.toArray(new String[logs.length]);
    }

}
