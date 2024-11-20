import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
  }
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrderTraversal(TreeNode root){

        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>(); // create an empty array list for adding elements at each level
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll(); // Dequue elements from the queue
                temp.add(curr.val);

                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);;
                }
            }
            result.add(temp);
        }
         return result;

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
