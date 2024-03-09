import java.util.*;

public class Floyd {
    public static void main(String[] args) {
        Node v1 = new Node("v1"),
                v2 = new Node("v2"), v3 = new Node("v3"),
                v4 = new Node("v4"),
                v5 = new Node("v5");
        //v1
        v1.next.put(v5, 5);
        v1.next.put(v4, 1);
        v1.next.put(v3, null);
        v1.next.put(v1, 0);
        v1.next.put(v2, 1);
        //v2
        v2.next.put(v5, null);
        v2.next.put(v4, 2);
        v2.next.put(v3, 3);
        v2.next.put(v1, 9);
        v2.next.put(v2, 0);
        //v3
        v3.next.put(v5, null);
        v3.next.put(v4, 4);
        v3.next.put(v3, 0);
        v3.next.put(v1, null);
        v3.next.put(v2, null);
        //v4
        v4.next.put(v5, 3);
        v4.next.put(v4, 0);
        v4.next.put(v3, 2);
        v4.next.put(v1, null);
        v4.next.put(v2, null);
        //v5
        v5.next.put(v5, 0);
        v5.next.put(v4, null);
        v5.next.put(v3, null);
        v5.next.put(v1, 3);
        v5.next.put(v2, null);
        ArrayList<ArrayList<Integer>> floyd = new ArrayList<>();
        floyd.add(new ArrayList<>(v1.next.values()));
        floyd.add(new ArrayList<>(v2.next.values()));
        floyd.add(new ArrayList<>(v3.next.values()));
        floyd.add(new ArrayList<>(v4.next.values()));
        floyd.add(new ArrayList<>(v5.next.values()));
        System.out.println("W: "+ floyd);
        shortest(floyd);
        System.out.println("D: "+ floyd);
    }

    public static void shortest(ArrayList<ArrayList<Integer>> floyd) {
        for (int k = 0; k < floyd.size(); k++) {
            for (int i = 0; i < floyd.size(); i++) {
                for (int j = 0; j < floyd.size(); j++) {
                    if (!(floyd.get(k).get(j) == null || floyd.get(i).get(k) == null)) {
                        if (floyd.get(i).get(j) == null) {
                            floyd.get(i).set(j, floyd.get(k).get(j) + floyd.get(i).get(k));
                        } else {
                            floyd.get(i).set(j, Math.min(floyd.get(k).get(j) +
                                            floyd.get(i).get(k), floyd.get(i).get(j)));
                        }
                    }
                }
            }
        }
    }
}

class Node {
    HashMap<Node, Integer> next = new HashMap<>();
    String name;

    Node(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}