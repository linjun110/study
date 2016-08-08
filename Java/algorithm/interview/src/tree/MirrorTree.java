package tree;

/**
 * Created by linjun on 16/7/12.
 */
public class MirrorTree {
    public static TreeNode prepareData(){
        TreeNode root = new TreeNode(0)
                .appendLeft(new TreeNode(1).appendLeft(new TreeNode(3).appendRight(4)))
                .appendRight(new TreeNode(1).appendRight(new TreeNode(3).appendLeft(4)));
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
        solution(prepareData());
    }
}
