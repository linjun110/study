package tree;

/**
 * Created by linjun on 16/7/12.
 */
public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode sibling;
    int bf;

    TreeNode(int val){
        this.val = val;
    }

    public void addNodeAsBST(TreeNode node){
        if(node.val == val){
            return;
        }
        if(node.val > val){
            if(null == right) {
                right = node;
                return;
            }else{
                right.addNodeAsBST(node);
            }
        }else if(node.val < val){
            if(null == left) {
                left = node;
                return;
            }else{
                left.addNodeAsBST(node);
            }
        }
    }

    public TreeNode appendLeft(int val){
        this.left = new TreeNode(val);
        return this;
    }

    public TreeNode appendLeft(TreeNode node){
        this.left = node;
        return this;
    }

    public TreeNode appendRight(int val){
        this.right = new TreeNode(val);
        return this;
    }

    public TreeNode appendRight(TreeNode node){
        this.right = node;
        return this;
    }
}
