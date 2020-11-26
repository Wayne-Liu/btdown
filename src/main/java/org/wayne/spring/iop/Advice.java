package org.wayne.spring.iop;

import java.lang.reflect.Method;

public interface Advice {

    void before(Method method, Object[] args,Object target);


}
