package com.james.codelib.guava.patterns.singleton;

import com.google.common.base.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by james on 9/27/14.
 */
public class EnumSingleton {

    public static final Logger LOG = LoggerFactory.getLogger(EnumSingleton.class);

    public static void main(String[] args) {
        LOG.info(ToStringFunction.INSTANCE.apply(123));
        LOG.info(ToStringFunction.INSTANCE.apply(true));
    }

    /**
     * 以下代码完全粘贴自Functions类。
     */
    private enum ToStringFunction implements Function<Object, String> {
        INSTANCE;

        @Override
        public String apply(Object o) {
            checkNotNull(o);  // eager for GWT.
            return o.toString();
        }

        @Override
        public String toString() {
            return "toString";
        }
    }
}
