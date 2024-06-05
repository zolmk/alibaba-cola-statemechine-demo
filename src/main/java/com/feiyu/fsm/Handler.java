package com.feiyu.fsm;

/**
 * 快递事件处理函数
 * @author Zhuff
 */
public interface Handler<S, E, C> {
    /**
     * 处理揽收事件
     * @param beforeState 之前的状态
     * @param curState 当前的状态
     * @param event 事件
     * @param context 上下文对象
     */
    void collected(S beforeState, S curState, E event, C context);

    /**
     * 运输快递
     * @param beforeState 之前的状态
     * @param curState 当前的状态
     * @param event 事件
     * @param context 上下文对象
     */
    void transfer(S beforeState, S curState, E event, C context);

    /**
     * 签收
     * @param beforeState 之前的状态
     * @param curState 当前的状态
     * @param event 事件
     * @param context 上下文对象
     */
    void signed(S beforeState, S curState, E event, C context);
}
