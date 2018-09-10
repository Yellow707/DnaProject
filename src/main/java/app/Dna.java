package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.ArrayList;

import java.awt.FlowLayout;
import javax.swing.*;


/*

Вариант 11 Молекула ДНК состоит из последовательностей нуклеотидов А, Г, Ц и У. Несколько
одинаковых молекул известной длины были нарезаны на фрагменты произвольной длины.
Функция восстанавливает исходную молекулу в том случае, если это возможно сделать
единственным образом

Пример: АГЦЦГГУААЦЦ нарезана на фрагменты АГЦЦ, ЦГГУ , ГГУАА и УААЦЦ.

Пример невосстанавливаемой последовательности: АГЦЦГГУААЦЦ нарезана на фрагменты
АГЦЦ, ГГУАА и УААЦЦ.

*/

public class Dna extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JTextField fragmentsNumberTextField;
    private JButton button;
    private JList<JTextField> arrayTextFields;

    private static int fragmentsNumber;

    public static void main(String[] args) {
        Dna dna = new Dna();
    }

    public Dna() {
        frame = new JFrame("DNA Check");
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        label = new JLabel("Введите кол-во фрагментов!");
        fragmentsNumberTextField = new JTextField("", 10);
//        fragmentsNumberTextField.setSize(100, 30);

        button = new JButton();
        button.setText("Go");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fragmentsNumber = Integer.parseInt(fragmentsNumberTextField.getText());
                System.out.println(fragmentsNumber);

                ArrayList<JTextField> fragmentsTextFieldArray = new ArrayList<>();
                for (int i = 0; i < fragmentsNumber; i++) {
                    JTextField fragmentsTextField = new JTextField("", 10);
                    fragmentsTextFieldArray.add(fragmentsTextField);
//                    arrayTextFields.add(fragmentsTextField);
                    panel.add(fragmentsTextField);
                }
                frame.setSize(301, 301);
            }
        });
//        panel.add(arrayTextFields);

        panel.add(label);
        panel.add(fragmentsNumberTextField);
        panel.add(button);


        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

////        System.out.print("Введите ДНК: ");
//        Scanner scanner = new Scanner(System.in);
//        //String str = scanner.nextLine();
//        System.out.print("Введите кол-во фрагментов: ");
//
//        fragmentsNumber = scanner.nextInt();
//
//        ArrayList<String> fragmentsArray = new ArrayList();
//        System.out.println("Введите фрагменты ДНК:");
//            for(int i = 0; i < fragmentsNumber; i++){
//                System.out.print("Фрагмент №" + (i+1) + ": ");
//                String fragment = scanner.next();
//                fragmentsArray.add(fragment);
//            }
//        Graph fragmentsGraph = new Graph(fragmentsNumber,fragmentsArray);
//        System.out.print("\nОриентированный граф построенный из фрагментов:\n");
//        fragmentsGraph.printList(); //печать списков смежности
//        System.out.print("\n");
//
//        ArrayList<Boolean> bl = new ArrayList<>();
//            for(int i = 0; i < fragmentsNumber; i++) {
//                bl.add(Boolean.FALSE);
//            }
//        fragmentsGraph.searchPath(0, 0); //поиск в глубины
//
//        System.out.print("Кол-во путей в графе -> " + fragmentsGraph.count());
//        System.out.print("\n");
    }

    public int testFunc(ArrayList<String> fragmentsArray, int fragmentsNumber) {
        for (int i = 0; i < fragmentsNumber; i++ ){
            String fragment = fragmentsArray.get(i);
            for (int j = 0; j < fragment.length(); j++) {
                if (Character.isLetter(fragment.charAt(j)) == false) {
                    return -1;
                }
            }
        }
        Graph graph = new Graph(fragmentsNumber, fragmentsArray);
        graph.searchPath(0, 0);
        int count = graph.count();
        return count;
    }
}

