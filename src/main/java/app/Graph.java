package app;

import java.util.ArrayList;
import java.util.Objects;
import javafx.util.Pair;

//ориетированный граф в виде списков смежности
public final class Graph {
    private ArrayList<Pair<Node,ArrayList<Node>>> list; //список списков
    private ArrayList<Boolean> doneNodeList; //список посещенных вершин
    private int pathCount; //число путей (в иделе должен быть один единственный путь)
    private int fragmentsNumber;

    //формирование списка списков
    public Graph(int fragmentsNumber, ArrayList<String> values){
        pathCount = 0;
        this.fragmentsNumber = fragmentsNumber;
        list = new ArrayList<>();
        doneNodeList = new ArrayList<>();
        for(int i = 0; i < fragmentsNumber; i++){
            list.add(new Pair<>(new Node(values.get(i),i),new ArrayList<>())); //инициализация вершин (начальная)
            doneNodeList.add(false);
        }

        //установка связей в вершинах графа
        for(int i = 0; i < fragmentsNumber; i++){
            doneNodeList.set(i, Boolean.TRUE); //не проверяем уже посещенные вершины
            for(int j = 0; j < fragmentsNumber; j++){
                if(Objects.equals(doneNodeList.get(j), Boolean.FALSE)){ //проходим только новые вершины слева направо (если нужно в любом порядке то замена на i != j и все
                    if(checkNode(list.get(i).getKey(), list.get(j).getKey())){
                        list.get(i).getValue().add(new Node(list.get(j).getKey().Fragment(), list.get(j).getKey().Num())); //добавляем вершину в список
                    }
                }
            }
        }

        resetList();
    }

    //может быть слева?
    public boolean checkNode(Node a, Node b){
        String fragmentA = a.Fragment(); //получаем фрагменты
        String fragmentB = b.Fragment();
        if(fragmentA.charAt(fragmentA.length() - 1) == fragmentB.charAt(0)) {
            return true;
        } else {
            while (fragmentA.length() != 1){
                if(fragmentB.startsWith(fragmentA)) {
                    return true;
                } else {
                    fragmentA = fragmentA.substring(1);
                }
            }
            return false;
        }
    }

    //сброс списка посещенных вершин
    public void resetList(){
        for(int i = 0; i < doneNodeList.size(); i++) {
            doneNodeList.set(i, Boolean.FALSE);
        }
    }

    //поиск пути (поиск в глубину)
    public void searchPath(int start, int lvl/*, ArrayList<Boolean> bl*/) {
        ArrayList<Boolean> bl = new ArrayList<>();

        for(int i = 0; i < fragmentsNumber; i++) {
                bl.add(Boolean.FALSE);
        }
        bl.set(start, Boolean.TRUE);
        lvl++;
            if(lvl == list.size()) {
                pathCount++;
            }

            for(Node x : list.get(start).getValue()){
                if(Objects.equals(bl.get(x.Num()), Boolean.FALSE)) {
                    searchPath(x.Num(),lvl/*,bl*/);
                }
            }
        bl.set(start, Boolean.FALSE);
    }

    //печать списка
    public void printList() {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getKey().Fragment() + " -> ");
            for (Node value : list.get(i).getValue()) {
                System.out.print(value.Fragment() + " ");
            }
            System.out.print("\n");
        }
    }

    //кол-во путей в графе содержащих в себе все фрагменты ДНК
    public int count(){
        return pathCount;
    }


}
