package mock.report;


import mock.domain.Record;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class ReportLogic {
    private int digits;
    private final static BigDecimal HUNDRED = BigDecimal.valueOf(100);

    public ReportLogic(int digits) {
        this.digits = digits;
    }

    public <T extends Number> BigDecimal  calcConsumpPercentage(T dose,
                                                                List<Record<T>> list, LocalDate[] date) {
        BigDecimal bd1 = null;
        BigDecimal bd2 = null;
        LocalDate endDate = date.length > 1 ? date[1] : date[0];
        if (list.get(0).getValue() instanceof Integer){
            bd1 = BigDecimal.valueOf((Integer)getSum(list, date));
            bd2 = BigDecimal.valueOf((Integer)dose * (date[0].until(endDate,
                    DAYS) + 1));
        }
        if (list.get(0).getValue() instanceof Double){
            bd1 = BigDecimal.valueOf((Double) getSum(list, date));
            bd2 = BigDecimal.valueOf((Double)dose * (date[0].until(endDate,
                    DAYS) + 1));
        }
        BigDecimal result = (bd1.multiply(HUNDRED)).divide(bd2, digits,
                RoundingMode.CEILING);
        return !dose.equals(0) ? result : BigDecimal.ZERO;
    }

    public <T extends Number> void sortByDate(List<Record<T>> list) {
        Collections.sort(list, new Comparator<Record<T>>() {
            @Override
            public int compare(Record<T> o1, Record<T> o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
    }

    public <T extends Number> void sortByValue(final List<Record<T>> list) {
        Collections.sort(list, new Comparator<Record<T>>() {
            @Override
            public int compare(Record<T> o1, Record<T> o2) {
                int result = 0;
                if (list.get(0).getValue() instanceof Double) {
                    result = ((Double) o1.getValue()).compareTo((Double)
                            o2.getValue());
                }
                if (list.get(0).getValue() instanceof Integer) {
                    result = ((Integer) o1.getValue()).compareTo((Integer)
                            o2.getValue());
                }
                return result;
            }
        });
    }

    public <T extends Number> BigDecimal getMedian(List<Record<T>> list,
                                                   LocalDate... date) {
        BigDecimal result = BigDecimal.ZERO;

        if (list != null) {
            sortByDate(list);
            int lsize = list.size();
            if (lsize > 0) {
                int startInx = getFirstInxOfDateMatch(list, date[0], lsize);
                LocalDate endDate = date.length > 1 ? date[1] : date[0];
                int endInx = getLastInxOfDateMatch(list, endDate, lsize);
                if (startInx > -1) {
                    endInx = endInx != -1 ? endInx : lsize - 1;
                    int rangeSize = endInx - startInx + 1;
                    List<Record<T>> partList = list.subList(startInx, endInx
                            + 1);
                    sortByValue(partList);
                    if (list.get(0).getValue() instanceof Double) {
                        result = doubleMedian(partList);
                    }
                    if (list.get(0).getValue() instanceof Integer) {
                        result = intMedian(partList);
                    }
                }
            }
        }
        return result;
    }

    private <T extends Number> BigDecimal intMedian(List<Record<T>> list) {
        Integer res = 0;
        if (list != null && list.size() > 0) {
            int lSize = list.size();
            if (lSize % 2 == 0) {
                res = (((Integer) list.get(lSize / 2 - 1).getValue()) +
                        ((Integer) list.get(lSize / 2).getValue())) / 2;
            }
            else {
                res = ((Integer) list.get((lSize - 1) / 2).getValue());
            }
        }
        return BigDecimal.valueOf(res);
    }

    private <T extends Number> BigDecimal doubleMedian(List<Record<T>> list) {
        Double res = 0.;
        if (list != null && list.size() > 0) {
            int lSize = list.size();
            if (lSize % 2 == 0) {
                res = (((Double) list.get(lSize / 2 - 1).getValue()) +
                        ((Double) list.get(lSize / 2).getValue())) / 2;
            }
            else {
                res = ((Double) list.get((lSize - 1) / 2).getValue());
            }
        }
        return BigDecimal.valueOf(res);
    }

    public <T extends Number> void printList(List<Record<T>> list,
                                             LocalDate... date) {
        if (list != null) {
            int lsize = list.size();
            if (lsize > 0) {
                sortByDate(list);
                if (date == null) {
                    printAllList(list);
                }
                else if (date.length == 1) {
                    printSingleDateList(list, date[0]);
                }
                else {
                    printRangeDateList(list, date);
                }
            }
        }
        else {
            System.out.println("<empty>");
        }
    }

    private <T extends Number> void printRangeDateList(
            List<Record<T>> list, LocalDate... date) {
        int lsize = list.size();
        LocalDate currDate = null;
        int i = getFirstInxOfDateMatch(list, date[0], lsize);
        if (i > -1) {
            if (list.get(0).getValue() instanceof Integer) {
                Record<Integer> sum = new Record<>(null, 0);
                if (i < lsize) {
                    do {
                        currDate = list.get(i).getDate();
                        System.out.println(list.get(i++));
                    } while (i < lsize && date[1].compareTo(currDate) >= 0);
                }
            }
            else if (list.get(0).getValue() instanceof Double) {
                Record<Double> sum = new Record<>(null, 0.);
                if (i < lsize) {
                    do {
                        currDate = list.get(i).getDate();
                        System.out.println(list.get(i++));
                    } while (i < lsize && date[1].compareTo(currDate) >= 0);
                }
            }
        }
        else {
            System.out.println("<empty>");
        }
    }

    private <T extends Number> void printSingleDateList(
            List<Record<T>> list, LocalDate date) {
        int lsize = list.size();
        int i = getFirstInxOfDateMatch(list, date, lsize);

        if (list.get(0).getValue() instanceof Integer) {
            while (i < lsize && list.get(i).getDate().equals(date)) {
                System.out.println(list.get(i++));
            }
        }
        else if (list.get(0).getValue() instanceof Double) {
            while (i < lsize && list.get(i).getDate().equals(date)) {
                System.out.println(list.get(i++));
            }
        }
    }

    private <T extends Number> void printAllList(List<Record<T>> list) {
        int lsize = list.size();
        int i = 0;
        if (list.get(0).getValue() instanceof Integer) {
            while (i < lsize) {
                System.out.println(list.get(i++));
            }
        }
        else if (list.get(0).getValue() instanceof Double) {
            while (i < lsize) {
                System.out.println(list.get(i++));
            }
        }
    }


    public <T extends Number> T getSum(List<Record<T>> list,
                                       LocalDate... date) {
        T result = null;
        if (list != null) {
            int lsize = list.size();
            if (lsize > 0) {
                sortByDate(list);
                if (date == null) {
                    result = getTotalSum(list);
                }
                else if (date.length == 1) {
                    result = getSingleDateSum(list, date[0]);
                }
                else {
                    result = getRangeDateSum(list, date);
                }
            }
        }
        return result;
    }

    private <T extends Number> T getRangeDateSum(
            List<Record<T>> list, LocalDate... date) {
        T result = null;
        int lsize = list.size();
        LocalDate currDate = null;
        int i = getFirstInxOfDateMatch(list, date[0], lsize);
        if (i > -1) {
            if (list.get(0).getValue() instanceof Integer) {
                Record<Integer> sum = new Record<>(null, 0);
                if (i < lsize) {
                    do {
                        currDate = list.get(i).getDate();
                        sum = sum.addValue((Record<Integer>) list.get(i++));
                    } while (i < lsize && date[1].compareTo(currDate) >= 0);
                }
                result = (T) sum.getValue();
            }
            else if (list.get(0).getValue() instanceof Double) {
                Record<Double> sum = new Record<>(null, 0.);
                if (i < lsize) {
                    do {
                        currDate = list.get(i).getDate();
                        sum = sum.addValue((Record<Double>) list.get(i++));
                    } while (i < lsize && date[1].compareTo(currDate) >= 0);
                }
                result = (T) sum.getValue();
            }
        }
        return result;
    }

    private <T extends Number> T getSingleDateSum(
            List<Record<T>> list, LocalDate date) {
        T result = null;
        int lsize = list.size();
        int i = getFirstInxOfDateMatch(list, date, lsize);

        if (list.get(0).getValue() instanceof Integer) {
            Record<Integer> sum = new Record<>(null, 0);
            while (i < lsize && list.get(i).getDate().equals(date)) {
                sum = sum.addValue((Record<Integer>) list.get(i++));
            }
            result = (T) sum.getValue();
        }
        else if (list.get(0).getValue() instanceof Double) {
            Record<Double> sum = new Record<>(null, 0.);
            while (i < lsize && list.get(i).getDate().equals(date)) {
                sum = sum.addValue((Record<Double>) list.get(i++));
            }
            result = (T) sum.getValue();
        }
        return result;
    }

    private <T extends Number> int getFirstInxOfDateMatch(
            List<Record<T>> list, LocalDate date, int lsize) {
        int result = -1;
        int i = 0;
        if (lsize > 0) {
            while (i < lsize && !list.get(i).getDate().equals(date)) {
                i++;
            }
            result = (i == lsize ? i - 1 : i);
        }
        return result;
    }

    private <T extends Number> int getLastInxOfDateMatch(
            List<Record<T>> list, LocalDate date, int lsize) {
        int result = -1;
        int i = lsize - 1;
        if (lsize > 0) {
            while (i > -1 && !list.get(i).getDate().equals(date)) {
                i--;
            }
            result = i;
        }
        return result;
    }


    private <T extends Number> T getTotalSum(List<Record<T>> list) {
        T result = null;
        int lsize = list.size();
        int i = 0;
        if (list.get(0).getValue() instanceof Integer) {
            Record<Integer> sum = new Record<>(null, 0);
            while (i < lsize) {
                sum = sum.addValue((Record<Integer>) list.get(i++));
            }
            result = (T) sum.getValue();
        }
        else if (list.get(0).getValue() instanceof Double) {
            Record<Double> sum = new Record<>(null, 0.);
            while (i < lsize) {
                sum = sum.addValue((Record<Double>) list.get(i++));
            }
            result = (T) sum.getValue();
        }
        return result;
    }
}
