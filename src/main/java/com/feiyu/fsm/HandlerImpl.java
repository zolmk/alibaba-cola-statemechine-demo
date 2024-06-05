package com.feiyu.fsm;

/**
 * 快递事件处理类
 * @author Zhuff
 */
public class HandlerImpl implements Handler<ExpStateEnum, ExpEventEnum, ExpContext> {

    @Override
    public void collected(ExpStateEnum beforeState, ExpStateEnum curState, ExpEventEnum event, ExpContext context) {
        context.addHistory(new ExpStateInfo(null, beforeState, curState));
        System.out.printf("开始揽收%s %n", context.getExpId());
    }

    @Override
    public void transfer(ExpStateEnum beforeState, ExpStateEnum curState, ExpEventEnum event, ExpContext context) {
        context.addHistory(new ExpStateInfo(null, beforeState, curState));
        System.out.printf("开始传输%s %n", context.getExpId());
    }

    @Override
    public void signed(ExpStateEnum beforeState, ExpStateEnum curState, ExpEventEnum event, ExpContext context) {
        context.addHistory(new ExpStateInfo(null, beforeState, curState));
        System.out.printf("已签收%s %n", context.getExpId());
    }
}
