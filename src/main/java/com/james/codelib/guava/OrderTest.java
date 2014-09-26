package com.james.codelib.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Function;

/**
 * Created by james on 9/26/14.
 */
public class OrderTest {
    public static final Logger LOG = LoggerFactory.getLogger(OrderTest.class);

    public static void main(String[] args) {
        List<String> strs = Lists.newArrayList("a", "abc", "adc", "bcd", "b", "", null);
        List<Integer> ints = Lists.newArrayList(1, 5, 6, 0, 11, 3, -1, null);
        LOG.info("before sort : {}", strs);
        LOG.info("before sort : {}", ints);

        /*
         * 自然排序，按照字典顺序或者int从小到大排序
         * 可以指定Null在前面还是后面
         */
        Ordering<String> naturalStrOrder = Ordering.natural();
        Ordering<Integer> naturalIntOrder = Ordering.natural();
        LOG.info("natural sort null first : {}", naturalStrOrder.nullsFirst().sortedCopy(strs));
        LOG.info("natural sort null first : {}", naturalIntOrder.nullsFirst().sortedCopy(ints));
        LOG.info("natural sort null last : {}", naturalStrOrder.nullsLast().sortedCopy(strs));
        LOG.info("natural sort null last : {}", naturalIntOrder.nullsLast().sortedCopy(ints));

        /*
         * 先执行toString，再按照字典顺序进行排列。
         */
        Ordering<Object> toStringOrdering = Ordering.usingToString();
        LOG.info("toString sort null first : {}", toStringOrdering.nullsFirst().sortedCopy(strs));

        /*
         * 还有一个arbitrary排序，返回一个对象的任意顺序，没发现具体作用。
         * 所以这里不提供例子。
         */

         /*
         * 反序
         */
        LOG.info("natural sort null last : {}", naturalStrOrder.nullsLast().reverse().nullsLast().sortedCopy(strs));

        /**
         * 按照字符串长度从小到大排序
         */
        Ordering<String> userOrdering = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };
        LOG.info("string length sort : {}", userOrdering.nullsLast().sortedCopy(strs));
    }
}
