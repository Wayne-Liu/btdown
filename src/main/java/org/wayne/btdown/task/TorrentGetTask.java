package org.wayne.btdown.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TorrentGetTask {



    @Scheduled(cron = "0/5 * * * * ?")
    public void downLoad() {

    }
}
