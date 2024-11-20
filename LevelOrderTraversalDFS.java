import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalDFS {


    public List<List<Integer>> levelOrderUSingDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;

    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> result) {

        if (root == null) return;  // if node is null return to the same place

        // Ensure the list is large enough for the current depth
        if (result.size() <= depth) {
            result.add(new ArrayList<>());
        }

        // add the current node'S value to the correponding level
        result.get(depth).add(root.val);

        // recursively traverse left and right tree
        dfs(root.left, depth + 1, result);
        dfs(root.right, depth + 1, result);

    }

    public static void main (String [] args){
        // Create a sample tree:
        //         3
        //       /   \
        //      9     20
        //           /  \
        //          15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal solution = new LevelOrderTraversal();
        List<List<Integer>> result = solution.levelOrderTraversal(root);

        // print the tree
        System.out.println("Level OrderTraversal");
        for(List<Integer> level : result) {
            System.out.println(level);
        }
    }


}
