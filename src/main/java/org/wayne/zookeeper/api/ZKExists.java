package org.wayne.zookeeper.api;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZKExists {

    private static ZooKeeper zk;

    private static ZookeeperConnection conn;

    public static Stat znode_exists(String path) throws KeeperException, InterruptedException {
        return zk.exists(path, true);
    }

    public static void main(String[] args) {
        String path = "/MyFirstZnode";


        try {
            conn = new ZookeeperConnection();
            zk = conn.connect("47.95.140.142:2181");
            Stat stat = znode_exists(path);

            if (stat != null) {
                System.out.println("Node exists and node version is " + stat.getVersion());
            } else {
                System.out.println("Node does not exists");
            }

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
