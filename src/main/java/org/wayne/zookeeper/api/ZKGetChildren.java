package org.wayne.zookeeper.api;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class ZKGetChildren {

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
                List<String> children = zk.getChildren(path, false);
                for (int i=0; i < children.size(); i++)
                    System.out.println(children.get(i));

                //删除子节点
                String child = path+"/myfirstsubnode";
                if (znode_exists(child) != null) {
                    zk.delete(child, zk.exists(child, true).getVersion());
                }

                List<String> children2 = zk.getChildren(path, false);
                for (int i=0; i < children2.size(); i++)
                    System.out.println(children2.get(i));
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
