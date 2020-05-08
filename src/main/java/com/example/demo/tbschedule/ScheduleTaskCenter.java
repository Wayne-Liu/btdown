package com.example.demo.tbschedule;

import com.example.demo.tbschedule.scheduler.UsagePullSchedulerManager;
import com.taobao.pamirs.schedule.strategy.ScheduleStrategy;
import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import com.taobao.pamirs.schedule.zk.ScheduleStrategyDataManager4ZK;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Component
public class ScheduleTaskCenter {

    @Resource
    private TBScheduleManagerFactory scheduleManagerFactory;

    @Resource
    private UsagePullSchedulerManager usagePullSchedulerManager;

    @PostConstruct
    public void init() {
        ScheduleStrategyDataManager4ZK strategyManager = scheduleManagerFactory.getScheduleStrategyManager();

        try {
            List<ScheduleStrategy> t = strategyManager.loadAllScheduleStrategy();
            for (ScheduleStrategy item : t) {
                if (scheduleManagerFactory.getScheduleStrategyManager().loadStrategy(item.getStrategyName()) != null) {
                    scheduleManagerFactory.getScheduleStrategyManager().pause(item.getStrategyName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            usagePullSchedulerManager.init(scheduleManagerFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<ScheduleStrategy> t = scheduleManagerFactory.getScheduleStrategyManager().loadAllScheduleStrategy();
            for (ScheduleStrategy item : t) {
                if (item.getSts().equals(ScheduleStrategy.STS_PAUSE)) {
                    scheduleManagerFactory.getScheduleStrategyManager().resume(item.getStrategyName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
