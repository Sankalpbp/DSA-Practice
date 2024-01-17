public class BTtoDoubly {

    public static void print () {
        TreeNode root = new TreeNode ( 3 );
        root.left = new TreeNode ( 5 );
        root.right = new TreeNode ( 2 );
        root.right.left = new TreeNode ( 1 );
        root.right.left.left = new TreeNode ( 4 );
        root.right.left.right = new TreeNode ( 6 );

        System.out.println ();
        inorder ( root );
        System.out.println ();

        root = convertInorder ( root );
        printList ( root );
    }

    public static TreeNode convertInorder ( TreeNode root ) {
        if ( root == null ) {
            return null;
        }

        TreeNode head = convertInorder ( root.left );
        root.right = convertInorder ( root.right );

        if ( root.right != null ) {
            root.right.left = root;
        }

        if ( head == null ) {
            return root;
        }

        TreeNode ptr = head;
        while ( ptr.right != null ) {
            ptr = ptr.right;
        }

        ptr.right = root;
        root.left = ptr;

        return head;
    }

    public static void inorder ( TreeNode root ) {
        if ( root != null ) {
            inorder ( root.left );
            System.out.print ( root.data + " " );
            inorder ( root.right );
        }
    }

    public static void printList ( TreeNode head ) {
        TreeNode ptr = head;

        while ( ptr != null ) {
            System.out.print ( ptr.data + " " );
            ptr = ptr.right;
        }
        System.out.println ();
    }

}
