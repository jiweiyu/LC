package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem_1166 {

    Map<String, Integer> file = new HashMap<>();

    public DesignFileSystem_1166() {
        file.put("", -1);
    }

    public boolean create(String path, int value) {
        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        if (!file.containsKey(parent)) { return false; }
        return file.putIfAbsent(path, value) == null;
    }

    public int get(String path) {
        return file.getOrDefault(path, -1);
    }
}
