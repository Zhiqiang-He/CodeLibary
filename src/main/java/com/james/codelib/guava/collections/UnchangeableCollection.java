package com.james.codelib.guava.collections;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by james on 9/27/14.
 */
public class UnchangeableCollection {
    public static final Logger LOG = LoggerFactory.getLogger(UnchangeableCollection.class);


    public static void main(String[] args) {

        /*
         * 创建一个不可变集合，但是这个集合不允许出现Null。
         *
         * 当对象被不可信的库调用时，不可变形式是安全的；
         * 不可变对象被多个线程调用时，不存在竞态条件问题
         * 不可变集合不需要考虑变化，因此可以节省时间和空间。
         * 所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）；
         * 不可变对象因为有固定不变，可以作为常量来安全使用。
         */
        ImmutableSet<String> strs = ImmutableSet.of(
                "a",
                "b",
                "c",
                "",
                "d",
                "e");
        //会抛出UnsupportedOperationException异常
        //strs.add("f");

        List<String> lists = Lists.newArrayList("a", "c");
        strs = ImmutableSet.copyOf(lists);
        LOG.info(strs.toString());
        strs = ImmutableSet.<String>builder().addAll(lists).add("b").build();
        LOG.info(strs.toString());

        //只有通过aslist,toarray才能读取不可变集合中的内容
        LOG.info(strs.asList().get(0));
    }


}
