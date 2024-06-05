package com.feiyu.fsm;

import com.alibaba.cola.statemachine.Condition;
import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;

/**
 * 快递状态机构建器
 * @author Zhuff
 */
public class ExpStateMachineBuilder {
    public static StateMachine<ExpStateEnum, ExpEventEnum, ExpContext> build(String machineId, Handler<ExpStateEnum, ExpEventEnum, ExpContext> handler) {
        StateMachineBuilder<ExpStateEnum, ExpEventEnum, ExpContext> machineBuilder = StateMachineBuilderFactory.create();
        machineBuilder.externalTransition()
                .from(ExpStateEnum.TO_BE_COLLECTED)
                .to(ExpStateEnum.COLLECTED)
                .on(ExpEventEnum.COLLECTED)
                .when(NULL_CONDITION)
                .perform((expStateEnum, s1, eventEnum, expContext) -> {
                    handler.collected(expStateEnum, ExpStateEnum.COLLECTED, eventEnum, expContext);
                });

        machineBuilder.externalTransition()
                .from(ExpStateEnum.COLLECTED)
                .to(ExpStateEnum.IN_TRANSIT)
                .on(ExpEventEnum.TRANSFER)
                .when(NULL_CONDITION)
                .perform(((expStateEnum, s1, eventEnum, expContext) -> {
                    handler.transfer(expStateEnum, ExpStateEnum.IN_TRANSIT, eventEnum, expContext);
                }));

        machineBuilder.externalTransition()
                .from(ExpStateEnum.IN_TRANSIT)
                .to(ExpStateEnum.SIGNED)
                .on(ExpEventEnum.SIGNED)
                .when(NULL_CONDITION)
                .perform(((expStateEnum, s1, eventEnum, expContext) -> {
                    handler.signed(expStateEnum, ExpStateEnum.SIGNED, eventEnum, expContext);
                }));



        return machineBuilder.build(machineId);
    }

    private static final Condition<ExpContext> NULL_CONDITION = expContext -> true;
}
