package tree;

/**
 * Created by linjun on 16/7/24.
 */
public class SelfBalanceBinaryTree {
    public static TreeNode prepareData(int[] values){
        TreeNode root = null;
        for(int i = 0; i < values.length; i ++){
            TreeNode newNode = new TreeNode(values[i]);
            if(null == root){
                root = new TreeNode(values[i]);
            }else{
                root.addNodeAsBST(new TreeNode(values[i]));
            }

        }
        return root;
    }
    public static void solution(TreeNode root) {
        if(null == root){
            return;
        }
        if(_compare2Tree(root.left, root.right)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
    private static boolean _compare2Tree(TreeNode left, TreeNode right) {
        if(null == left && null == right){
            return true;
        }
        if(null == left || null == right){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return _compare2Tree(left.left, right.right) && _compare2Tree(left.left, right.right);
    }

    public static void main(String[] args){
        int[] values = {1, 2, 3, 4, 5};
        solution(prepareData(values));
    }
}
