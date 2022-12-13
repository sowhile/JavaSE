import java.util.Arrays;
import java.util.Comparator;

/**
 * @author WangDa
 * @version 1.0
 * <p>
 * 2022/11/6 14:48
 */
public class SortTime {
    public static void main(String[] args) {
        new Quick().runTime();
        new Bubble().runTime();
    }
}

abstract class Sta {
    static final int num = 10000;
    static Integer[] integers = Rand.randInt(num);

    abstract void run(Integer[] p);

    void runTime() {
        Integer[] p = Arrays.copyOf(integers, num);
        System.out.print("\n");
        System.out.println(this.getClass() + " default:" + Arrays.toString(p));
        long start = 0, end = 0;
        start = System.currentTimeMillis();
        run(p);
        end = System.currentTimeMillis();
        System.out.println(this.getClass() + " time:" + (end - start));
        System.out.println(this.getClass() + " finish:" + Arrays.toString(p));
    }
}

class Quick extends Sta {

    @Override
    void run(Integer[] p) {
        Arrays.sort(p, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i1 - i2;
            }
        });
    }
}

class Bubble extends Sta {

    @Override
    void run(Integer[] p) {
        bubble(p, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i1 - i2;
            }
        });
    }

    static void bubble(Integer[] integers, Comparator comparator) {
        int temp;
        for (int i = 0; i < integers.length - 1; i++) {
            for (int j = 0; j < integers.length - i - 1; j++) {
                if (comparator.compare(integers[j], integers[j + 1]) > 0) {
                    temp = integers[j];
                    integers[j] = integers[j + 1];
                    integers[j + 1] = temp;
                }
            }
        }
    }
}

class Rand {
    static Integer[] randInt(int n) {
        Integer[] integers = new Integer[n];
        for (int i = 0; i < integers.length; i++)
            integers[i] = (int) (Math.random() * n) + 1;
        return integers;
    }
}