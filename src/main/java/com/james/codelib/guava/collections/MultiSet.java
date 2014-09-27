package com.james.codelib.guava.collections;

import com.google.common.collect.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by james on 9/27/14.
 */
public class MultiSet {
    public static final Logger LOG = LoggerFactory.getLogger(MultiSet.class);


    public static void main(String[] args) {
        /**
         * 统计单词数量
         */
        List<String> strs = Lists.newArrayList(
                "a",
                "b",
                "b",
                "",
                "c",
                "");
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(strs);
        LOG.info(String.valueOf(wordsMultiset.count("b")));//2
        LOG.info(String.valueOf(wordsMultiset.count("a")));//1
        LOG.info(String.valueOf(wordsMultiset.count("")));//2
       //返回所有的总和
        LOG.info(String.valueOf(wordsMultiset.size())); //6


        Multimap<String,Integer> words = LinkedListMultimap.create();
        words.put("a",1);
        words.put("b",1);
        words.put("a",2);
        LOG.info(words.get("a").toString());//[1,2]

    }
}
