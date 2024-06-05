package com.feiyu;

import com.alibaba.cola.statemachine.StateMachine;
import com.feiyu.fsm.*;

public class Main {
    public static void main(String[] args) {
        StateMachine<ExpStateEnum, ExpEventEnum, ExpContext> node1 = ExpStateMachineBuilder.build("node1", new HandlerImpl());
        ExpContext context = new ExpContext();
        context.setExpId("24234342");
        node1.fireEvent(context.getLastState(), ExpEventEnum.COLLECTED, context);

        node1.fireEvent(context.getLastState(), ExpEventEnum.TRANSFER, context);

        node1.fireEvent(context.getLastState(), ExpEventEnum.SIGNED, context);
    }
}

