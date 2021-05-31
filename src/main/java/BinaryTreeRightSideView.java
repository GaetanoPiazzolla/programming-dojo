import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    /**
     * Input: [1,2,3,null,5,null,4]
     * Output: [1, 3, 4]
     * Explanation:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     *
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, 0, list);
        return list;
    }

    private void traverse(TreeNode root, int depth, List<Integer> list) {
        if(root == null){
            return;
        }
        if(list.size() <= depth)
        {
            list.add(root.val);
        }
        depth++;
        traverse(root.right,depth,list);
        traverse(root.left,depth,list);

    }

}
