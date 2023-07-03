/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

public class HeightOfBinaryTree {
    int height(Node node) {

        if ( node == null ) {
            return 0;
        }

        int leftHeight = height ( node.left );
        int rightHeight = height ( node.right );

        return 1 + Math.max ( leftHeight, rightHeight );
    }
}
