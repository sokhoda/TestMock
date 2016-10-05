package mock;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class Task1 {
    @Test
    public void test() {
        List mockedList = mock(List.class);
        mockedList.add("one");
//        mockedList.clear();

        verify(mockedList).add("one");
//        verify(mockedList).clear();
    }

    @Test
    public void test2() throws Exception {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");

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
}
