package common.java;

/**
 * @author Moosphon
 * @date 2020/5/7 上午11:05
 * @desc 搞懂"="的意义：
 *       1.Java的引用传递和值传递？
 *       2.Java基本类型和引用类型区别？
 *       3.Java赋值运算符的作用？
 * 定义：
 *      1.值传递：即pass by value，是指在调用函数时将实际的参数复制一份传递到函数中，这样在函数中如果对参数进行修改，将不会影响到实际参数。
 *        引用传递：即pass by reference，是指在调用函数时将实际参数的地址传递到函数中，那么在函数中对参数进行修改将直接影响到实际参数。
 *      2.基本类型，值直接保存在变量中，引用类型保存了是对象的地址，所有基本类型赋值是按值传递 (拷贝赋值)，引用类型赋值是按引用传递。
 *      2.对于基本类型，赋值运算符会直接改变变量的值，原来的值被覆盖掉。
          对于引用类型，赋值运算符会改变引用中所保存的地址，原来的地址被覆盖掉，但是原来的对象不会被改变。
 */
public class AssignmentAffiliation {

    private static void testParamAssignment() {
        // 此处证明了：Java对象赋值是引用传递而不是值传递，基本数据类型才是值传递。
        TestNode p = new TestNode();
        TestNode q = p;
        q.data = 32;
        q.type = 1;
        System.out.println("p="+p.toString());

        int p2 = 0;
        int q2 = p2;
        q2 = q2+1;
        System.out.println("p2="+p2 + ", q2="+q2);
    }
}

class TestNode {
    int data = 0;
    int type = -1;

    @Override
    public String toString() {
        String string = "{ data: " + data + ", type: " + type + "}";
        return string;
    }
}