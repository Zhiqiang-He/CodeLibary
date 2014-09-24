package com.james.codelib.guava;

import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by james on 9/24/14.
 */
public class ThrowablesTest {
    public static final Logger LOG = LoggerFactory.getLogger(ThrowablesTest.class);

    public static void main(String[] args) {
        String s = "a";
        try {
            Integer.valueOf(s);
            //NumberFormatException
        } catch (Exception e) {
            //将异常堆栈转为字符串并打印出来
            LOG.error(Throwables.getStackTraceAsString(e));
            //获取根异常
            LOG.error("exp",Throwables.getRootCause(e));
            //获取异常链
            LOG.error("exp2",Throwables.getCausalChain(e));
            //如果类型是参数错误的异常，则异常从这里抛出
            Throwables.propagateIfInstanceOf(e, IllegalArgumentException.class);
            //如果是Error类型，则抛出原始类型
            //如果不是Error类型，则抛出RunTimeException
            Throwables.propagateIfPossible(e);
        }
    }
}
