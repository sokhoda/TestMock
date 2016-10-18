import matchers.AbcMatcher;
import matchers.AsaMatcherString;
import matchers.LengthString;
import mock.domain.Human;
import mock.domain.Record;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalMatchers.geq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;

public class Task1 {

    @Mock
    private List<String> mockedList;

    @Spy
    private List<Integer> spyList = new LinkedList<>();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        //    mockedList.clear();

        verify(mockedList).add("one");
        //   verify(mockedList).clear();
    }

    @Test
    public void defVal() throws Exception {
        Human human = mock(Human.class);
        given(human.gettAgeOfMe(anyInt())).willReturn(2);

        //when
        int resultTen = human.gettAgeOfMe(10);
        int resultTwenty = human.gettAgeOfMe(20);

        assertThat(resultTen, is(2));
        assertThat(resultTwenty, is(2));

    }

    @Test
    public void testSpy() throws Exception {
        spyList.add(10);
        spyList.addAll(Arrays.asList(11, -23, 44));
        System.out.println(spyList);
        doReturn(12).when(spyList).get(0);
        doCallRealMethod().when(spyList).get(0);
        System.out.println(spyList.get(0));
    }

    @Test
    public void argumentCaptor() throws Exception {
        Human human = new Human();
        Human spyHuman = spy(human);

        spyHuman.setName("Ivan");
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        verify(spyHuman).setName(argumentCaptor.capture());
        String expected = "Ivan";
        assertThat(expected, is(argumentCaptor.getValue()));
    }

    @Test
    public void argumentCaptorVarArg() throws Exception {
        Human human = new Human();
        Human spyHuman = spy(human);
        spyHuman.setPersonalData("Ivan","Hrytsyshyn");

        ArgumentCaptor<String> varArgs = ArgumentCaptor.forClass(String.class);

        verify(spyHuman).setPersonalData(varArgs.capture());
        List expected = Arrays.asList("Ivan", "Hrytsyshyn");
        assertEquals(expected, varArgs.getAllValues());
    }

    @Test
    public void isOrder() throws Exception {
        spyList.add(-1);
        spyList.get(0);
        spyList.addAll(Arrays.asList(1,2));

        InOrder inOrder = inOrder(spyList);
        inOrder.verify(spyList).add(geq(-1));
        inOrder.verify(spyList).get(0);
        inOrder.verify(spyList).addAll(anyList());
    }

    @Test
    public void name() throws Exception {
        List<Integer> ilist = mock(ArrayList.class);
        ilist.add(11);
        verify(ilist).add(intThat(is(greaterThan(10))));

        mockedList.add("afrfasafr ff34 ");
        verify(mockedList).add(anyString());
        verify(mockedList).add(argThat(new AsaMatcherString()));
    }

    @Test
    public void multipleParamsMatch() throws Exception {
        Human human = mock(Human.class);
        human.surnameContainsName("12asa ", " abc2");
////        human.surnameContainsName(eq("f"),eq("34"));
//
        verify(human).surnameContainsName(
                argThat(both(new AsaMatcherString()).and(new LengthString())),
                argThat(new AbcMatcher()));

        human.surnameContainsName("as1a 1", " abc2");
        verify(human, atLeast(1)).surnameContainsName(
                argThat(either(new AsaMatcherString()).or(new LengthString())),
                argThat(new AbcMatcher()));

        human.surnameContainsName("12a@s1a ", " ab@c2");
        human.surnameContainsName("12a@s1a ", " ab@c2");
        human.surnameContainsName("12a@s1a ", " ab@c2");
        verify(human, atLeast(2)).surnameContainsName(matches(".*@.*"), matches
                (".*@.*"));
        verify(human, never()).getWater();

    }

    @Test
    public void spyHuman() throws Exception {
        Human spy = spy(new Human());
        List<Record<Double>> hours = spy.getHours();
        List<Record<Double>> hours2 = spy.getHours();

        Record<Double> record = new Record<>(LocalDate.now(), 1.5);
        hours.add(record);
        verify(spy, times(2)).getHours();

//        doReturn(true).when(spy).dayZeroCalories(any(LocalDate.class));
        doCallRealMethod().when(spy).dayZeroCalories(any(LocalDate.class));
//        doThrow( new RuntimeException()).when(spy).dayZeroCalories(any(LocalDate.class));

        boolean result = spy.dayZeroCalories(LocalDate.MAX);

        assertThat(result, is(true));
        assertThat(hours.size(), is(2));
    }

    @Test
    public void mockPayment() throws Exception {
        //given
        Human human = mock(Human.class);
        List<Record<Integer>> calories = myInit();
        Record<Integer> record2 = new Record<>(LocalDate.of(2016, 11, 21), 200);
        given(human.getCalories()).willReturn(calories);

        //when
        Record<Integer> record = human.getCalories().get(1);
        System.out.println(record);
        System.out.println(record2);
        //then
        assertThat(record, is(record2));
    }

    @Test
    public void test2() throws Exception {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);
        // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenReturn("seconde");
//        when(mockedList.get(0)).thenThrow(new EmptyStackException());

        // the following prints "first"
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));
        // the following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));
    }

    @Test
    public void myTest() {
        // mock creation
        List mockedList = spy(LinkedList.class);
        when(mockedList.size()).thenReturn(1);
//        when(mockedList.add(1)).thenReturn(1);
        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.add("two");
//
//        // selective, explicit, highly readable verification

        verify(mockedList).add("one");
        verify(mockedList).add("two");
        assertThat(mockedList.size(), is(1));
    }


    public List<Record<Integer>> myInit() {
        List<Record<Integer>> calories = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate[] ld = new LocalDate[]{
                LocalDate.of(2016, 11, 20),
                LocalDate.of(2016, 11, 21),
                LocalDate.of(2016, 11, 22)
        };

        Record<Integer> record1 = new Record<>(ld[0], 100);
        Record<Integer> record2 = new Record<>(ld[1], 200);
        Record<Integer> record3 = new Record<>(ld[2], 3300);
        calories = Arrays.asList(record1, record2,
                record3);
        return calories;
    }
}
