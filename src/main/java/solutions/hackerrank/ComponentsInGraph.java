package solutions.hackerrank;

/**
 * Created by yael on 31/01/17.
 * Solution for https://www.hackerrank.com/challenges/components-in-graph
 */
import java.util.*;

public class ComponentsInGraph {

    private Map<Integer, Group> memberGroupMap;
    private List<Group> groups;

    public ComponentsInGraph() {
        this.memberGroupMap = new HashMap<>();
        this.groups = new ArrayList<>();
    }

    class Group{
        Set<Integer> members;

        Group(int v1, int v2){
            members = new HashSet<>();
            addMember(v1);
            addMember(v2);
        }

        void addMember(int newMember){
            members.add(newMember);
            memberGroupMap.put(newMember, this);
        }

        void addMembers(Group g){
            members.addAll(g.members);
            for(Integer i :g.members){
                memberGroupMap.put(i, this);
            }
        }

        int getSize(){
            return members.size();
        }

    }
    public static void main(String[] args) {
        ComponentsInGraph solution = new ComponentsInGraph();
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        for(int i = 0 ; i<n ; i++){
            String line = sc.nextLine();
            String[] numStrings = line.split(" ");
            int v1 = Integer.valueOf(numStrings[0]);
            int v2 = Integer.valueOf(numStrings[1]);
            solution.addEdge(v1, v2);
        }
        solution.printMinAndMaxGroup();

    }

    private void addEdge(int val1, int val2){
        Group g1 = getGroup(val1);
        Group g2 = getGroup(val2);
        if(g1 == null && g2 == null) {
            Group g = new Group(val1, val2);
            groups.add(g);
        } else if(g1 != null && g2 != null && !g1.equals(g2)){
            mergeTwoGroups(g1, g2);
        } else if(g1 != null) {
            g1.addMember(val2);
        } else {
            g2.addMember(val1);
        }
    }

    private Group mergeTwoGroups(Group g1, Group g2){
        Group smaller = g1.getSize() < g2.getSize() ? g1 : g2;
        Group larger = g1.getSize() < g2.getSize() ? g2 : g1;
        groups.remove(smaller);
        larger.addMembers(smaller);
        return larger;
    }

    private Group getGroup(int key){
        return memberGroupMap.get(key);
    }

    private void printMinAndMaxGroup(){
        Integer max = 0;
        Integer min = Integer.MAX_VALUE;

        for(Group g : groups){
            int s = g.getSize();
            if(s > max){
                max = s;
            }
            if(s < min) {
                min = s;
            }
        }
        if(!groups.isEmpty()){
            System.out.println(min  +" " + max);
        }
    }
}