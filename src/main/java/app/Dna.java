package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JButton fragmentsNumberButton;
    private JButton fragmentsListButton;
    private JList<JTextField> arrayTextFields;
    private JLabel resultLabel;

    private static int fragmentsNumber;

    public static void main(String[] args) {
        Dna dna = new Dna();
    }

    public Dna() {
        frame = new JFrame("DNA Check");
        panel = new JPanel();
        resultLabel = new JLabel();
        panel.setLayout(new FlowLayout());
        label = new JLabel("Введите кол-во фрагментов!");
        fragmentsNumberTextField = new JTextField("", 10);

        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

        fragmentsNumberButton = new JButton();
        fragmentsNumberButton.setText("Go");

        fragmentsListButton = new JButton();
        fragmentsListButton.setText("Go2");


        fragmentsNumberButton.addActionListener(new ActionListener() {
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
                panel.add(fragmentsListButton);
                frame.setSize(301, 301);
            }
        });

        fragmentsListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> fragmentsArray = new ArrayList<>();
                for (Component component : panel.getComponents()) {
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        fragmentsArray.add(textField.getText());
                    }
                }
                fragmentsArray.remove(0);
                System.out.println(fragmentsArray);
                int result = testFunc(fragmentsArray, fragmentsArray.size());
                if (result == 1) {
                    resultLabel.setText("Успех!");
                    resultLabel.setForeground(Color.green);
                    panel.add(resultLabel);
                } else if (result == 0) {
                    resultLabel.setText("Фрагменты не совместимы!");
                    resultLabel.setForeground(Color.yellow);
                    panel.add(resultLabel);
                } else {
                    resultLabel.setText("Ошибка!");
                    resultLabel.setForeground(Color.red);
                    panel.add(resultLabel);
                }
                frame.setSize(300, 300);
            }
        });
//        panel.add(arrayTextFields);

        panel.add(label);
        panel.add(fragmentsNumberTextField);
        panel.add(fragmentsNumberButton);

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

    public static void startApp(){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Dna();
            }
        });
    }

    public int testFunc(ArrayList<String> fragmentsArray, int fragmentsNumber) {
        for (int i = 0; i < fragmentsNumber; i++ ){
            String fragment = fragmentsArray.get(i);
            for (int j = 0; j < fragment.length(); j++) {
                if (!Character.isLetter(fragment.charAt(j))) {
                    return -1;
                }
            }
        }
        Graph graph = new Graph(fragmentsNumber, fragmentsArray);
        graph.searchPath(0, 0);
        int count = graph.count();
        graph.printList();
        return count;
    }
}

