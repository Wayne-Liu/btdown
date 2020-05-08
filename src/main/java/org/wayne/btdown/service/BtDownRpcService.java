package org.wayne.btdown.service;

public interface BtDownRpcService {

    String btdownUrl(String torrNum);

    void runDownLoadTask();
}
