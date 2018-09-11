package app;

//import javax.swing.*;
import org.netbeans.jemmy.*;
import org.netbeans.jemmy.operators.*;

public class JemmyTest implements Scenario{

    public static void main(String[] args) {
        String[] params = {"app.JemmyTest"};
        org.netbeans.jemmy.Test.main(params);
    }

    public int runIt(Object param) {
        try {
            //Запуск Swing приложения
            new ClassReference("app.Dna").startApplication();
            //Поиск JFrame
            JFrameOperator mainFrame = new JFrameOperator("DNA Check");
            //Делаем небольшую задержку
            new QueueTool().waitEmpty(200);
            //Ищем JTextField по имени после нажатия кнопки должно стать "First pressed"
            JTextFieldOperator textField = new JTextFieldOperator(mainFrame, 0);
            //Очищаем поле ввода
            textField.clearText();
            textField.enterText("3");
            //Ищем кнопку по имени
            JButtonOperator firstButton = new JButtonOperator(mainFrame, "Go");
            firstButton.push();

            //После ввода текста на JFrame должен появиться JLabel
            //Метка должна быть "Hello"
//            new JLabelOperator(mainFrame,"Hello");
            //Поиск второго компонента JTextField по индексу
            JTextFieldOperator textField2 = new JTextFieldOperator(mainFrame,1);
            JTextFieldOperator textField3 = new JTextFieldOperator(mainFrame,2);
            JTextFieldOperator textField4 = new JTextFieldOperator(mainFrame,3);
            textField2.enterText("ABC");
            textField3.enterText("CDE");
            textField4.enterText("EFG");

            JButtonOperator secondButton = new JButtonOperator(mainFrame, "Go2");
            secondButton.push();
            //Опять ищем JLabel по тексту
//            new JLabelOperator(mainFrame,"Field2");
//            JButtonOperator secondButton = new JButtonOperator(mainFrame, "Second");
//            secondButton.push();
            mainFrame.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            return(1);
        }
        return(0);
    }
}
