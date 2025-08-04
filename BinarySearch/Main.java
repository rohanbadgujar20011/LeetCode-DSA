package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class to store a pair of timestamp and value
class Pair {
    int timestamp;
    String value;

    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

// TimeMap class that supports set and get operations
class TimeMap {

    // Map to store: key -> list of (timestamp, value) pairs
    Map<String, List<Pair>> listMap;

    public TimeMap() {
        // Initialize the map
        this.listMap = new HashMap<>();
    }

    // Store the key with the given value and timestamp
    public void set(String key, String value, int timestamp) {
        // If key is not present, create a new list for it
        listMap.putIfAbsent(key, new ArrayList<>());

        // Append the new (timestamp, value) pair to the list
        listMap.get(key).add(new Pair(timestamp, value));
    }

    // Return the value with the largest timestamp <= given timestamp
    public String get(String key, int timestamp) {
        // If the key does not exist, return empty string
        if (!listMap.containsKey(key)) return "";

        List<Pair> pairs = listMap.get(key);
        String result = "";
        int low = 0, high = pairs.size() - 1;

        // Binary search for the largest timestamp <= given timestamp
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (pairs.get(mid).timestamp <= timestamp) {
                // Candidate found, but look for a better (later) one
                result = pairs.get(mid).value;
                low = mid + 1;
            } else {
                // Too large, move left
                high = mid - 1;
            }
        }

        // Return the last valid result (or "" if none)
        return result;
    }
}

// Main class to test the TimeMap
public class Main {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();

        // Store value "bar" for key "foo" at timestamp 1
        timeMap.set("foo", "bar", 1);

        // Retrieve value for key "foo" at timestamp 1
        // Output: "bar"
        System.out.println(timeMap.get("foo", 1));

        // Retrieve value for key "foo" at timestamp 3
        // Output: "bar" (since it's the latest before or at 3)
        System.out.println(timeMap.get("foo", 3));

        // Set a new value for same key at a later timestamp
        timeMap.set("foo", "bar2", 4);

        // Retrieve value for timestamp 4 — should return "bar2"
        System.out.println(timeMap.get("foo", 4));

        // Retrieve value for timestamp 5 — still "bar2"
        System.out.println(timeMap.get("foo", 5));

        // Retrieve value before any data was set — should return ""
        System.out.println(timeMap.get("foo", 0));
    }
}
