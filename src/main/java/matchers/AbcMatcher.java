package matchers;

import org.mockito.ArgumentMatcher;

public class AbcMatcher extends ArgumentMatcher<String>{
    @Override
    public boolean matches(Object argument) {
        String str = (String) argument;
        return str.contains("abc");
    }
}
