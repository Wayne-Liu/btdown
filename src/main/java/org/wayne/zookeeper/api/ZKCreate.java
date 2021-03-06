package org.wayne.zookeeper.api;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZKCreate {

    private static ZooKeeper zk;

    private static ZookeeperConnection conn;

    public static void create(String path, byte[] data) throws KeeperException, InterruptedException {
        zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public static void main(String[] args) {
        String path = "/MyFirstZnode";
        byte[] data = "My First zookeeper app".getBytes();


        try {
            conn = new ZookeeperConnection();
            zk = conn.connect("47.95.140.142:2181");
            create(path, data);
            conn.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }
}
