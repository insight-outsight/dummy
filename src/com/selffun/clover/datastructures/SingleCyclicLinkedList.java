package com.selffun.clover.datastructures;

import java.util.Objects;

/**
 * 单向循环链表,非线程安全
 * @author zcx
 *
 * @param <T> 链表节点值的类型，比如Integer
 */
public class SingleCyclicLinkedList<T> {

	private CLLNode<T> head,rear;
	int count = 0;
	
	public SingleCyclicLinkedList(){

	}
	
	public SingleCyclicLinkedList(T[] data){
		Objects.requireNonNull(data, "data array is null");
		CLLNode<T> currentNode = null;
		for(int i=0;i<data.length;i++){			
			if(head == null){
				currentNode = new CLLNode<T>(data[i]);
				rear = head = currentNode;
			}	
			if(i+1<data.length){
				currentNode = new CLLNode<T>(data[i+1]);
				rear.setNext(currentNode);
				rear = currentNode;
			}
			else{
				rear.setNext(head);
			}
		}
		count = data.length;
	}
	
	/**
	 * 
	 * @param item 要添加的节点值
	 * @return 添加过的新节点
	 */
	public CLLNode<T> add(T item){
		
		/*空链表*/
		if(head == null){
			rear = head =  new CLLNode<T>(item);
			head.setNext(rear);
		}
		else{
			CLLNode<T> node = new CLLNode<T>(item);
			node.setNext(head);
			rear.setNext(node);
			rear = node;		
		}
		count++;
		return rear;
		
	}
	
	/**
	 * 如果链表中存在大于1个要删除的节点值，那么只有第一个匹配项会被删除。
	 * @param item 要删除节点值
	 * @return 删除过的节点数组。如果要删除节点值不存在或者链表为空，则返回null。
	 */
	public CLLNode<T> remove(T item){
		
		/*空链表*/
		if(head == null){
			return null;
		}
		
		/*只有一个节点的链表*/
		if(head == rear){
			if(head.getData().equals(item)){
				head = null;
				count--;
				return head;
			}
			else{
				return null;
			}
		}
		
		/*大于等于两个节点的链表*/
		CLLNode<T> currentNode = head;
		CLLNode<T> previousNode = null;
		
		do{				
			if(currentNode.getData().equals(item)){
				if(currentNode == head){
					head = currentNode.getNext();
					rear.setNext(head);
				}
				else if(currentNode == rear){					
					previousNode.setNext(head);
					rear = previousNode;
				}
				else{
					previousNode.setNext(currentNode.getNext());
				}
				count--;
				return currentNode;
			}
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		while(currentNode != head);
		
		return null;
		
	}
	
	public void print(){
		if(head!=null){
			CLLNode<T> currentNode = head;
			System.out.println("打印开始。");
			do{
				System.out.print(currentNode.getData()+"~~~");
				currentNode = currentNode.getNext();
			}while(currentNode != head);
			System.out.println("\r\n打印完毕。");
		}
		else{
			System.out.println("单循环列表为空。");
		}
	}
	
	public int size(){
		return count;
	}
	
	public CLLNode<T> getHead(){
		return this.head;
	}
	
	public CLLNode<T> getRear(){
		return this.rear;
	}
	
	public CLLNode<T> next(){
		return head.getNext();
	}
	
	public static void main(String[] args) {
		SingleCyclicLinkedList<Integer> scll0 = new SingleCyclicLinkedList<Integer>(new Integer[]{25000});
		scll0.print();

		SingleCyclicLinkedList<Integer> scll = new SingleCyclicLinkedList<Integer>(new Integer[]{25,-37,16,8,9,45,999});
		scll.print();
		System.out.println("###################");
		scll.add(111);
		scll.print();
		System.out.println("###################");
		CLLNode<Integer> removed = scll.remove(-37);
		if(removed!=null){
			System.out.println("删除了节点值为"+removed.getData());
		}
		scll.print();
		System.out.println("###################");
		SingleCyclicLinkedList<Integer> scll2 = new SingleCyclicLinkedList<Integer>();
		scll2.print();
		System.out.println("###################");
		scll2.add(27);
		scll2.print();
	}
	
	public static class CLLNode<N> {
		
	    private N data;
	    private CLLNode<N> next;
	    
	    public CLLNode(N k) {
	        data = k;
	        next = null;
	    }
	    
	    public void setNext(CLLNode<N> nxt){
	    	this.next = nxt;
	    }
	    
	    public N getData(){
	    	return this.data;
	    }
	    
	    public CLLNode<N> getNext(){
	    	return this.next;
	    }
	    
	}
	
}
