package com.james.codelib.guava;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by james on 9/24/14.
 */
public class PreConditionsMain {
    public static final Logger LOG = LoggerFactory.getLogger(PreConditionsMain.class);

    public static void main(String[] args) {
        String s = "name";
        String ns = "";
        LOG.info(Preconditions.checkNotNull(s));
        LOG.info(Preconditions.checkNotNull(ns));
        //如果是null，就按照后面的描述内容抛出空指针异常
        LOG.info(Preconditions.checkNotNull(ns,"name is null"));

        int age = 20;
        //如果不符合条件，就抛出参数错误异常
        Preconditions.checkArgument(age >= 18 && age < 99, "age must in range (18,99)");
        Preconditions.checkArgument(s !=null && s.length() < 10, "desc too long, max length is ", 10);
    }
}
