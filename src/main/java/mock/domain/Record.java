package mock.domain;

import java.time.LocalDate;

public class Record <T extends Number> {
    private LocalDate date;
    private T value;

    public Record(LocalDate date, T value) {
        this.date = date;
        this.value = value;
    }

    public Record<T> addValue(Record<T> rec1){
        T val1 = rec1.getValue();
        T val2 = (T) this.getValue();
        if(val1 instanceof Double || val2 instanceof Double) {
            Double res = (Double)val1 + (Double)val2;
            setValue((T) res);
        }
        if(val1 instanceof Integer || val2 instanceof Integer) {
            Integer res = (Integer)val1 + (Integer)val2;
            setValue((T) res);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Record{" +
                "date=" + date +
                ", value=" + value +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record<?> record = (Record<?>) o;

        if (!date.equals(record.date)) return false;
        return value.equals(record.value);

    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
