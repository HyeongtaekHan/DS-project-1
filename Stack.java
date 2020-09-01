public class Stack {

    private final char[] data;
    private final int size;
    private int top;

    public Stack(int n) {
        data = new char[n];
        size = n;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == (size - 1);
    }

    public void push(char x) {
        if(!isFull()) {
            data[++top] = x;
        }
    }

    public char pop() {
        if (isEmpty()) {
            return '?';
        }
        else {
            return data[top--];
        }
    }

    public char peek() {
        if (isEmpty()) {
            return '?';
        }
        else {
            return data[top];
        }
    }

}
