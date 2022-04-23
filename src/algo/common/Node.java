package common;

/**
 * @author Moosphon
 * @date 2020/4/1 下午11:45
 * @desc Base Node for linked list.
 */
public class Node<T> {
    T val;
    Node<T> next;
    protected Node(T value) {
        this.val = value;
    }
}
