import java.lang.reflect.Method;

public class SampleAnnotation {

    @Benchmark(on = true, value = 10)
    public Integer tripleValue() {
        Integer result = null;
        try {
            Class clazz = this.getClass();
            Method method = clazz.getMethod("tripleValue");
            Benchmark ann = method.getAnnotation(Benchmark.class);
            if (ann.on()) {
                result  = ann.value() * 3;
            }
            else {
                result = null;
            }
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return result;
    }
}
