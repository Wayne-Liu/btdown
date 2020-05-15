package com.example.demo.tbschedule.scheduler;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.tbschedule.demain.BillRule;
import com.taobao.pamirs.schedule.strategy.ScheduleStrategy;
import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import com.taobao.pamirs.schedule.taskmanager.ScheduleTaskType;
import org.springframework.stereotype.Component;

//@Component
public class UsagePullSchedulerManager {

    private TBScheduleManagerFactory scheduleManagerFactory;

    public void init(TBScheduleManagerFactory tbScheduleManagerFactory) throws Exception {
        this.scheduleManagerFactory = tbScheduleManagerFactory;
        initScheduleByRule();
    }

    private void initScheduleByRule() throws Exception {
        initScheduleTaskType();
        initScheduleStrategy();
    }

    private void initScheduleTaskType() throws Exception {
        ScheduleTaskType taskType = new ScheduleTaskType();
        taskType.setBaseTaskType("usagePullType");
        taskType.setDealBeanName("usagePullTask");
        taskType.setHeartBeatRate(20000);
        taskType.setJudgeDeadInterval(120000);
        taskType.setTaskParameter(JSONArray.toJSONString(new BillRule(1,"zhangsan","0")));
        taskType.setTaskItems(ScheduleTaskType.splitTaskItem(
                "0:{\"mod\":100,\"rangeLeft\":0,\"rangeRight\":9},"
                        + "1:{\"mod\":100,\"rangeLeft\":10,\"rangeRight\":19},"
                        + "2:{\"mod\":100,\"rangeLeft\":20,\"rangeRight\":29},"
                        + "3:{\"mod\":100,\"rangeLeft\":30,\"rangeRight\":39},"
                        + "4:{\"mod\":100,\"rangeLeft\":40,\"rangeRight\":49},"
                        + "5:{\"mod\":100,\"rangeLeft\":50,\"rangeRight\":59},"
                        + "6:{\"mod\":100,\"rangeLeft\":60,\"rangeRight\":69},"
                        + "7:{\"mod\":100,\"rangeLeft\":70,\"rangeRight\":79},"
                        + "8:{\"mod\":100,\"rangeLeft\":80,\"rangeRight\":89},"
                        + "9:{\"mod\":100,\"rangeLeft\":90,\"rangeRight\":99}"
        ));
        taskType.setFetchDataNumber(5000);
        taskType.setThreadNumber(5);
        taskType.setPermitRunStartTime("0/10 * * * * ?");

        scheduleManagerFactory.getScheduleDataManager().deleteTaskType(taskType.getBaseTaskType());

        scheduleManagerFactory.getScheduleDataManager().createBaseTaskType(taskType);
    }

    private void initScheduleStrategy() {

        ScheduleStrategy scheduleStrategy = new ScheduleStrategy();
        scheduleStrategy.setTaskName("usagePullType-Strategy");
    }

}
