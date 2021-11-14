public class Tests {

    //0
    public boolean empty() {
        AVLTree avlTree = new AVLTree();
        if (!avlTree.empty()) {
            return false;
        }
        avlTree.insert(1, "hello");
        return (!avlTree.empty());
    }

    //1
    public boolean search() {
        AVLTree avlTree = new AVLTree();
        if (avlTree.search(1) != null) {
            return false;
        }
        avlTree.insert(1, "hello");
        if (avlTree.search(1).equals("hello")) {
            return true;
        }
        return false;
    }

    //2
    public boolean insert_and_size() {
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < 1000; i++) {
            avlTree.insert(i, "num" + i);
        }
        return (avlTree.size() == 1000);
    }

    //3
    public boolean delete() {
        AVLTree avlTree = new AVLTree();
        if (avlTree.delete(1) != -1) {
            return false;
        }
        for (int i = 0; i < 100; i++) {
            avlTree.insert(i, "num" + i);
        }
        return true;
    }

    //4
    public boolean min() {
        AVLTree avlTree = new AVLTree();
        if (avlTree.min() != null) {
            return false;
        }
        for (int i = 0; i < 100; i++) {
            avlTree.insert(i, "num" + i);
        }
        return (avlTree.min().equals("num0"));
    }

    //5
    public boolean max() {
        AVLTree avlTree = new AVLTree();
        if (avlTree.max() != null) {
            return false;
        }
        for (int i = 0; i < 100; i++) {
            avlTree.insert(i, "num" + i);
        }
        return (avlTree.max().equals("num99"));
    }

    //6
    public boolean min_equals_max() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(1, "1");
        return (avlTree.min().equals(avlTree.max()));
    }

    //7
    public boolean keysToArray() {
        AVLTree avlTree = new AVLTree();
        String infoarray[];
        int[] keysarray;
        for (int i = 0; i < 100; i++) {
            avlTree.insert(i, "num" + i);
        }
        keysarray = avlTree.keysToArray();
        infoarray = avlTree.infoToArray();
        for (int i = 0; i < 100; i++) {
            if (!(infoarray[i].equals("num" + i) && keysarray[i] == i)) {
                return false;
            }
        }
        return true;

    }

    //8
    public boolean size() {
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < 100; i++) {
            avlTree.insert(i, "num" + i);
        }
        for (int i = 0; i < 50; i++) {
            avlTree.delete(i);
        }
        for (int i = 0; i < 25; i++) {
            avlTree.insert(i, "num" + i);
        }
        return (avlTree.size() == 75);
    }

    //9
    public boolean split() {
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < 1000; i++) {
            avlTree.insert(i, "num" + i);
        }
        avlTree.split(786);
        return true;
    }

    //10
    public boolean select() {
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < 1000; i++) {
			avlTree.insert(i, "num" + i);
        }
        return (avlTree.search(500).equals("num" + 500));
    }

    //11
    public boolean avlNodeFuncsImplemented() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(1, "1");
        AVLTree.IAVLNode avlNode = (AVLTree.IAVLNode) avlTree.getRoot();
        return true;
    }

    //12
    public boolean checkBalanceOfTree(AVLTree.IAVLNode current) {
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

    //13
    private int getDepth(AVLTree.IAVLNode n) {
        int leftHeight = 0, rightHeight = 0;

        if (n.getRight() != null)
            rightHeight = getDepth(n.getRight());
        if (n.getLeft() != null)
            leftHeight = getDepth(n.getLeft());

        return Math.max(rightHeight, leftHeight) + 1;
    }


    //14
    private boolean checkOrderingOfTree(AVLTree.IAVLNode current) {
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

    //15
    public boolean testRemove() {
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

}
