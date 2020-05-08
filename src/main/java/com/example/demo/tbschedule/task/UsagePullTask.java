package com.example.demo.tbschedule.task;

import com.example.demo.tbschedule.demain.BillRule;
import com.example.demo.tbschedule.service.BillRuleService;
import com.example.demo.tbschedule.task.vo.UsageTaskItem;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsagePullTask implements IScheduleTaskDealSingle<UsageTaskItem> {

    @Autowired
    private BillRuleService billRuleService;

    @Override
    public boolean execute(UsageTaskItem usageTaskItem, String s) throws Exception {
        BillRule billRule = usageTaskItem.getBillRule();
        System.out.println("task execution: getBillRule--"+billRule.toString());
        return true;
    }

    @Override
    public List<UsageTaskItem> selectTasks(String taskParameter, String ownSign, int taskItemNum,
                                           List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
        List<Integer> taskItemIds = taskItemList.stream()
                .map(TaskItemDefine::getTaskItemId)
                .map(Integer::valueOf)
                .collect(Collectors.toList());


        List<BillRule> itemList = billRuleService.getBillRules(taskItemNum,taskItemIds,eachFetchDataNum);
        List<UsageTaskItem> list = new ArrayList<>();
        for (BillRule billRule : itemList) {

        }
        System.out.println("获取到%s条记录"+itemList.size());
        return list;
    }

    @Override
    public Comparator<UsageTaskItem> getComparator() {
        return null;
    }
}
