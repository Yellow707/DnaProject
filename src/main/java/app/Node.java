package app;

//вершина ор графа
public class Node {
    private String fragment;
    private int number;

    public Node(String fragment, int number){
        this.fragment = fragment;
        this.number = number;
    }

    public int Num() {
        return number;
    }


    public String Fragment() {
        return fragment;
    }

}
