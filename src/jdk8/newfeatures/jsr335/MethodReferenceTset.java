package jdk8.newfeatures.jsr335;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * 
 * @author benhail
 * 
 * http://my.oschina.net/benhaile/blog/175012
 *
 *其实是lambda表达式的一个简化写法，所引用的方法其实是lambda表达式的方法体实现，语法也很简单，左边是容器（可以是类名，实例名），中间是"::"，右边是相应的方法名。如下所示：
ObjectReference::methodName
一般方法的引用格式是

如果是静态方法，则是ClassName::methodName。如 Object ::equals

如果是实例方法，则是Instance::methodName。如Object obj=new Object();obj::equals;

构造函数.则是ClassName::new
 */
public class MethodReferenceTset {

	public static void main(String[] args) {
		 
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
         
        JButton button1 = new JButton("点我!");
        JButton button2 = new JButton("也点我!");
         
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        //这里addActionListener方法的参数是ActionListener，是一个函数式接口
        //使用lambda表达式方式
        button1.addActionListener(e -> { System.out.println("这里是Lambda实现方式"+e.getID()); });
        //使用方法引用方式
        button2.addActionListener(MethodReferenceTset::doSomething);
         
    }
    /**
     * 这里是函数式接口ActionListener的实现方法
     * @param e 
     */
    public static void doSomething(ActionEvent e) {
         
        System.out.println("这里是方法引用实现方式"+e.getActionCommand());
    }
}
