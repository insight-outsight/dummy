package com.selffun.clover.algorithm;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class TreeTraversal {
	
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int val) {
	        this.val = val;
	    }
	    
	    TreeNode(TreeNode left, TreeNode right, int val) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	
	public void preOrderTraverseRecursively(TreeNode root) {  
        if (root != null) {  
            System.out.print(root.val+" ");  
            preOrderTraverseRecursively(root.left);  
            preOrderTraverseRecursively(root.right);  
        }  
	}
	
	/**
	 * 二叉树的按层打印(广度优先遍历)
	 * 
	 * 		         1
                    / \
                   2   3
                 /     /\
                4     5  6
                     / \       
                    7   8                  
              打印结果为：
              1
              23
              456
              78
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	Queue <TreeNode> queue=new ArrayBlockingQueue<>(100);
    	TreeNode last=root;     //当前行的最后节点
    	TreeNode nLast=root;    //下一行的最右节点
    	queue.add(root);
    	
    	while (!queue.isEmpty()) {
			TreeNode out=queue.poll();
			System.out.print(out.val+" "); 
			list.add(out.val);
			if (out.left!=null) {
				queue.add(out.left);
				nLast=out.left;
			}
			if (out.right!=null) {
				queue.add(out.right);
				nLast=out.right;
			}
			if (out==last) {
				System.out.println("");
				last=nLast;
			}
			
		}
    	return list;
    }

	
	public static void main(String[] args) {
		
		/**
		 *   	     1
                    / \
                   2   3
                 /     /\
                4     5  6
               / \        \
              7   8        9

		 */
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		TreeNode t8=new TreeNode(8);
		TreeNode t9=new TreeNode(9);


		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t4.left = t7;
		t4.right = t8;
		t3.left = t5;
		t3.right = t6;
		t6.right = t9;
		
		TreeNode root = t1;
		TreeTraversal treeTraversal = new TreeTraversal();
		treeTraversal.preOrderTraverseRecursively(root);
		System.out.println("----");
		treeTraversal.printFromTopToBottom(root);
	}
}
