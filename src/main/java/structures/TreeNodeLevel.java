package structures;

public class TreeNodeLevel extends TreeNode {
    public int level;
    public TreeNodeLevel left;
    public TreeNodeLevel right;

    public TreeNodeLevel(int val) {
        super(val);
    }
}