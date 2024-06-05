package com.feiyu.fsm;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhuff
 */
@Data
public class ExpContext {
    private String expId;
    /** 快递的历史状态信息 */
    private List<ExpStateInfo> infos;



    public ExpContext() {
        this.infos = new ArrayList<>();
    }

    public String getId() {
        return this.expId;
    }

    public ExpStateEnum getLastState() {
        if (infos.isEmpty()) {
            return ExpStateEnum.TO_BE_COLLECTED;
        }
        return infos.get(infos.size() - 1).getTargetState();
    }

    public void addHistory(ExpStateInfo info) {
        this.infos.add(info);
    }
}
