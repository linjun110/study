package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by linjun on 16/6/30.
 */
public class ZTree {
    public static TreeNode prepareData(){
        TreeNode root = new TreeNode(0)
                .appendLeft(new TreeNode(1).appendLeft(new TreeNode(3).appendRight(8)))
                .appendRight(new TreeNode(2).appendLeft(new TreeNode(5).appendRight(12)).appendRight(6));
        return root;
    }
    public static void solution(TreeNode root) {
        if(null == root){
            return;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()){
            TreeNode o = q.poll();
            System.out.print(o.val);
            if(null != o.left){
                q.offer(o.left);
            }

            if(null != o.right){
                q.offer(o.right);
            }
        }
    }

    // advanced
    public static void solution2(TreeNode root) {
        if(null == root){
            return;
        }

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);

        while (!(s1.isEmpty() && s2.isEmpty())){

            while (!s1.isEmpty()){
                TreeNode o = s1.pop();
                System.out.print(o.val);
                if(null != o.left){
                    s2.push(o.left);
                }

                if(null != o.right){
                    s2.push(o.right);
                }
            }

            while (!s2.isEmpty()){
                TreeNode o = s2.pop();
                System.out.print(o.val);
                if(null != o.right){
                    s1.push(o.right);
                }

                if(null != o.left){
                    s1.push(o.left);
                }

            }
        }
    }

    public static void main(String[] args){
        solution(prepareData());
        solution2(prepareData());
    }
}

