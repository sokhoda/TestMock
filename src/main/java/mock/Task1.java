package mock;

import mock.domain.Human;
import mock.domain.Record;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class Task1 {
    @Test
    public void test() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        //    mockedList.clear();

        verify(mockedList).add("one");
        //   verify(mockedList).clear();
    }

    @Test
    public void mockPayment() throws Exception {
        //given
        Human human = mock(Human.class);
        List<Record<Integer>> calories = init();
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
        mockedList.add(10);
        // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(0)).thenThrow(new EmptyStackException());

        // the following prints "first"
        System.out.println(mockedList.get(0));
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
//        mockedList.add("one");
//        mockedList.add("two");
//
//        // selective, explicit, highly readable verification

//        verify(mockedList).add("one");
//        verify(mockedList).add("two");
        assertThat(mockedList.size(), is(1));
    }


    public List<Record<Integer>> init() {
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
