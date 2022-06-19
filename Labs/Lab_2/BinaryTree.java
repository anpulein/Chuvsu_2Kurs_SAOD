package Lab_2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class BinaryTree implements Tree {

    private Node root; // начальный узел
    private int countNode = 0;
    private Set<Integer> setTreeValue = new HashSet<>();
    private String indent = "";

    @Override
    public void add(int value) {
        setTreeValue.add(value);
        addTree(value);
    }

    @Override
    public void delete(int value) {

    }

    @Override
    public void print() {
        Node side = null;
        printTree(root);
    }

    private void printTree(Node root) {
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(root);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); // выводим его значение в консоли
                    localStack.push(temp.getLeft()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null ||
                            temp.getRight() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }

    public int countValue(int value) {
        Node temp = root;
        int k = 0;

        while (temp != null) {
            if (temp.getValue() == value) {
                k++;
            }
            if (value < temp.getValue()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }

        return k;
    }

    private void addTree (int value) {
        if(root == null) {
            root = new Node(value);
            return;
        }

        Node newNode = new Node(value);

        Node temp = root;
        Node parentTemp;

        while (true) {
            parentTemp = temp;
            if (value < temp.getValue()) {
                temp = temp.getLeft();
                if(temp == null) {
                    parentTemp.setLeft(newNode);
                    return;
                }
            } else {
                temp = temp.getRight();
                if(temp == null) {
                    parentTemp.setRight(newNode);
                    return;
                }
            }
        }
    }




    private static class Node{
        private int value;
        private Node right;
        private Node left;

        public Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(final int value) {
            this.value = value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(final Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(final Node left) {
            this.left = left;
        }
    }
}
