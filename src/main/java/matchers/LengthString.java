package matchers;

import org.mockito.ArgumentMatcher;

public class LengthString extends ArgumentMatcher<String> {
    @Override
    public boolean matches(Object o) {
        String str = (String)o;
        return str.length() > 5 ;
    }
}
