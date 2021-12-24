package com.example.systemcouse.AOP;

import lombok.extern.java.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Entered
@Interceptor
@Log
public class ScoreBefore implements Serializable {

    @AroundInvoke
    protected Object protocolInvocation(final InvocationContext invocationContext) throws Exception {
        if(invocationContext.getMethod().getName().equals("selectScores")) {
            log.info ("Selecting all from score");
        }
        if(invocationContext.getMethod().getName().equals("insertScore")) {
            log.info ("Adding score");
        }
        if(invocationContext.getMethod().getName().equals("deleteScore")) {
            log.info ("Deleting score");
        }
        return invocationContext.proceed();
    }
}
