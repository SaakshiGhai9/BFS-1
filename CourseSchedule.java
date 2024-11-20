import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int [][] prerequisites, int numCourses) {
        // Step: 1 Build the Graph
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i =0; i< numCourses; i++){
            adjList.add(new ArrayList<>());

        }

        for (int [] preReq : prerequisites){
            int course = preReq[0];
            int pre = preReq[1];
            adjList.get(pre).add(course);
            inDegree[course]++;
        }
        // add all nodes with in- degree zero to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i < numCourses; i++){
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Proces nodes in a queue
        int processedCourses = 0;
        while( ! queue.isEmpty()){
            int current = queue.poll();
            processedCourses ++;

            for (int neighbour : adjList.get(current)) {
                inDegree[neighbour]--;
                if(inDegree [neighbour] == 0 ) {
                    queue.offer(neighbour);
                }
            }
        }
        return processedCourses == numCourses;

    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();

        // Test case 1
        int numCourses1 = 4;
        int[][] prerequisites1 = new int[][]{{1, 0}, {2, 1}, {3, 2}};
        System.out.println("Can finish all courses (Test 1): " + solution.canFinish(prerequisites1,numCourses1));
        // Expected output: true

        // Test case 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Can finish all courses (Test 2): " + solution.canFinish( prerequisites2, numCourses2));
        // Expected output: false

        // Test case 3
        int numCourses3 = 5;
        int[][] prerequisites3 = {{1, 0}, {2, 1}, {3, 1}, {4, 3}};
        System.out.println("Can finish all courses (Test 3): " + solution.canFinish(prerequisites3, numCourses3));
        // Expected output: true
    }

}
