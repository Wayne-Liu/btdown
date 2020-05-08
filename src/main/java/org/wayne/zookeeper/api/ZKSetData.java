package org.wayne.zookeeper.api;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;

public class ZKSetData {

    private static ZooKeeper zk;

    private static ZookeeperConnection conn;

    public static void update(String path, byte[] data) throws KeeperException, InterruptedException {
        zk.setData(path, data, zk.exists(path,true).getVersion());
    }

    public static void main(String[] args) {
        String path = "/MyFirstZnode";
        byte[] data = "你哈,哈皮".getBytes();

        conn = new ZookeeperConnection();
        try {
            zk = conn.connect("47.95.140.142:2181");
            update(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
