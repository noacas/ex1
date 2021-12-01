import java.util.Arrays;

public class MyTester {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < 1000; i++) {
            avlTree.insert(i, "num" + i);
        }
        AVLTree[] res = avlTree.split(786);
        System.out.println(res[0].size());
        System.out.println(res[1].max());
        System.out.println(res[1].min());
        System.out.println(res[1].size());
    }

    public static boolean testRemove() {
        AVLTree tree = new AVLTree();
        if (!tree.empty()) {
            return false;
        }
        int[] values = new int[]{16, 24, 36, 19, 44, 28, 61, 74, 83, 64, 52, 65, 86, 93, 88};
        for (int val : values) {
            tree.insert(val, "" + val);
        }
        if (!tree.min().equals("16")) {
            return false;
        }
        if (!tree.max().equals("93")) {
            return false;
        }
        if (!checkBalanceOfTree(tree.getRoot())) {
            return false;
        }
        if (!checkOrderingOfTree(tree.getRoot())) {
            return false;
        }
        tree.delete(88);
        if (!checkBalanceOfTree(tree.getRoot())) {
            return false;
        }
        if (!checkOrderingOfTree(tree.getRoot())) {
            return false;
        }
        if (tree.search(88) != null) {
            return false;
        }

        tree.delete(19);
        if (!checkBalanceOfTree(tree.getRoot())) {
            return false;
        }
        if (!checkOrderingOfTree(tree.getRoot())) {
            return false;
        }
        if (tree.search(19) != null) {
            return false;
        }

        tree.delete(16);
        if (!checkBalanceOfTree(tree.getRoot())) {
            return false;
        }
        if (!checkOrderingOfTree(tree.getRoot())) {
            return false;
        }
        if (tree.search(16) != null) {
            return false;
        }

        tree.delete(28);
        if (!checkBalanceOfTree(tree.getRoot())) {
            return false;
        }
        if (!checkOrderingOfTree(tree.getRoot())) {
            return false;
        }
        if (tree.search(16) != null) {
            return false;
        }
        tree.delete(24);
        if (!checkBalanceOfTree(tree.getRoot())) {
            return false;
        }
        if (!checkOrderingOfTree(tree.getRoot())) {
            return false;
        }
        if (tree.search(24) != null) {
            return false;
        }

        tree.delete(36);
        if (!checkBalanceOfTree(tree.getRoot())) {
            return false;
        }
        if (!checkOrderingOfTree(tree.getRoot())) {
            return false;
        }
        if (tree.search(36) != null) {
            return false;
        }

        tree.delete(52);
        if (!checkBalanceOfTree(tree.getRoot())) {
            return false;
        }
        if (!checkOrderingOfTree(tree.getRoot())) {
            return false;
        }
        if (tree.search(52) != null) {
            return false;
        }

        tree.delete(93);
        if (!checkBalanceOfTree(tree.getRoot())) {
            return false;
        }
        if (!checkOrderingOfTree(tree.getRoot())) {
            return false;
        }
        if (tree.search(93) != null) {
            return false;
        }

        tree.delete(86);
        if (!checkBalanceOfTree(tree.getRoot())) {
            return false;
        }
        if (!checkOrderingOfTree(tree.getRoot())) {
            return false;
        }
        if (tree.search(86) != null) {
            return false;
        }

        tree.delete(83);
        if (!checkBalanceOfTree(tree.getRoot())) {
            return false;
        }
        if (!checkOrderingOfTree(tree.getRoot())) {
            return false;
        }
        if (tree.search(83) != null) {
            return false;
        }
        return true;
    }

    public static boolean checkBalanceOfTree(AVLTree.IAVLNode current) {
        boolean balancedRight = true, balancedLeft = true;
        int leftHeight = 0, rightHeight = 0;
        if (current.getRight() != null) {
            balancedRight = checkBalanceOfTree(current.getRight());
            rightHeight = getDepth(current.getRight());
        }
        if (current.getLeft() != null) {
            balancedLeft = checkBalanceOfTree(current.getLeft());
            leftHeight = getDepth(current.getLeft());
        }

        return balancedLeft && balancedRight && Math.abs(leftHeight - rightHeight) < 2;
    }

    private static int getDepth(AVLTree.IAVLNode n) {
        int leftHeight = 0, rightHeight = 0;

        if (n.getRight() != null)
            rightHeight = getDepth(n.getRight());
        if (n.getLeft() != null)
            leftHeight = getDepth(n.getLeft());

        return Math.max(rightHeight, leftHeight) + 1;
    }

    private static boolean checkOrderingOfTree(AVLTree.IAVLNode current) {
        if (current.getLeft().isRealNode()) {
            if (Integer.parseInt(current.getLeft().getValue()) > Integer.parseInt(current.getValue()))
                return false;
            else
                return checkOrderingOfTree(current.getLeft());
        } else if (current.getRight().isRealNode()) {
            if (Integer.parseInt(current.getRight().getValue()) < Integer.parseInt(current.getValue()))
                return false;
            else
                return checkOrderingOfTree(current.getRight());
        } else if (!current.getLeft().isRealNode() && !current.getRight().isRealNode())
            return true;

        return true;
    }
}
