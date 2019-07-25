package mayidemo.bird;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest {

    @Test
    public void s1(){
        BigDecimal a1 = new BigDecimal(1);
        BigDecimal a2 = new BigDecimal(3);

        BigDecimal result = a1.divide(a2, 2,BigDecimal.ROUND_HALF_UP);

        System.out.println("result  1 /3 = " + result.doubleValue());
    }

    @Test
    public void s2(){
        BigDecimal a1 = new BigDecimal(1.254);
        BigDecimal a2 = new BigDecimal(3.32);
        // 有效位数 4不好控制
        MathContext mc = new MathContext(4, RoundingMode.HALF_UP);
        BigDecimal result = a1.multiply(a2,mc);

        System.out.println("result  1.25 * 3.32 = " + result.doubleValue());
    }
    @Test
    public void s21(){
        BigDecimal a1 = new BigDecimal(1.256);
        BigDecimal a2 = new BigDecimal(3.32);
        BigDecimal result = a1.multiply(a2);
//        result.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("result  1.25 * 3.32 = " + result.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
    }


    @Test
    public void s3(){
        BigDecimal a1 = new BigDecimal(1.25);
        BigDecimal a2 = new BigDecimal(3.3);

        BigDecimal result = a1.add(a2);

        System.out.println("result  1.25 + 3.2 = " + result.doubleValue());
    }
}
