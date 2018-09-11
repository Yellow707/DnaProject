package app;

import java.util.ArrayList;

import static org.junit.Assert.*;

/*

Вариант 11 Молекула ДНК состоит из последовательностей нуклеотидов А, Г, Ц и У. Несколько
одинаковых молекул известной длины были нарезаны на фрагменты произвольной длины.
Функция восстанавливает исходную молекулу в том случае, если это возможно сделать
единственным образом

Пример: АГЦЦГГУААЦЦ нарезана на фрагменты АГЦЦ, ЦГГУ , ГГУАА и УААЦЦ.

Пример невосстанавливаемой последовательности: АГЦЦГГУААЦЦ нарезана на фрагменты
АГЦЦ, ГГУАА и УААЦЦ.

*/

public class DnaTest {

    ArrayList<Boolean> bl = new ArrayList<>();
    int fragmentsNumber;

    @org.junit.Before
    public void setUp() throws Exception {
//        Graph graph = new Graph();
//        ArrayList<String> fragmentsArray = new ArrayList();

    }

    @org.junit.Test
    public void rightFragments() {
        
        Dna dna = new Dna();

        ArrayList<String> fragmentsArray = new ArrayList();
        fragmentsArray.add("АГЦЦ");
        fragmentsArray.add("ЦГГУ");
        fragmentsArray.add("ГГУАА");
        fragmentsArray.add("УААЦЦ");
        fragmentsNumber = 4;

        int actual = dna.testFunc(fragmentsArray, fragmentsNumber);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void falseFragments() {

        Dna dna = new Dna();

        ArrayList<String> fragmentsArray = new ArrayList();
        fragmentsArray.add("АГЦЦ");
        fragmentsArray.add("ГГУАА");
        fragmentsArray.add("УААЦЦ");
        fragmentsNumber = 3;

        int actual = dna.testFunc(fragmentsArray, fragmentsNumber);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void errorFragments() {

        Dna dna = new Dna();
        ArrayList<String> fragmentsArray = new ArrayList();
        fragmentsArray.add("ASD$@#");
        fragmentsArray.add("GSA!&");
        fragmentsArray.add("FG1324");
        fragmentsNumber = 3;

        int actual = dna.testFunc(fragmentsArray, fragmentsNumber);
        int expected = -1;
        assertEquals(expected, actual);
    }
}