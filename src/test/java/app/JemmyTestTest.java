package app;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.netbeans.jemmy.JemmyProperties;
import org.netbeans.jemmy.QueueTool;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.*;

import static org.junit.Assert.*;

public class JemmyTestTest {
    JFrameOperator mainFrame;
    QueueTool mainQueue;

    @Before
    public void getFrame(){
        //Создаем приложение
        Dna.startApp();
        //Ищем фрейм
        mainFrame = new JFrameOperator();
        //Это приостановление очереди выполнения событий
        //просто для того, чтобы было удобнее смотреть
        mainQueue = new QueueTool();
        mainQueue.waitEmpty(200);
    }

    @BeforeClass
    public static void setTimeouts(){
        //Скорость набора символов
        JemmyProperties.setCurrentTimeout("JTextComponentOperator.PushKeyTimeout",   50);
        //Максимальное время ожидания JFrame
        JemmyProperties.setCurrentTimeout("FrameWaiter.WaitFrameTimeout", 2000);
        //Максимальное время ожидания всех компонентов
        JemmyProperties.setCurrentTimeout("ComponentOperator.WaitComponentTimeout", 1000);
    }

    @Test
    public void testTitleFrame(){
        //У найденного ранее фрейма берем параметр Имя окна
        String titleFrame = mainFrame.getTitle();
        //Сравниваем с ожидаемым значением
        assertEquals("DNA Check",titleFrame);
        mainQueue.waitEmpty(100);
    }

    @Test
    public void runIt() {
    }
}