package com.javaee;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.Before;
import org.junit.Test;

public class ZookeeperTest {
    CuratorFramework client = null;

    @Before
    public void before() {
        RetryPolicy policy = new ExponentialBackoffRetry(3000, 3);
        client = CuratorFrameworkFactory.newClient("192.168.0.38:2181", 1000, 1000, policy);
    }

    @Test
    public void testFindNode() throws Exception {
        client.start();
        byte[] bytes = client.getData().forPath("/app1");
        System.out.println("节点数据：" + new String(bytes));

        client.close();
    }

    @Test
    public void testCreateNode() throws Exception {
        client.start();

        client.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath("/app3/a", "aNode".getBytes());

        client.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT_SEQUENTIAL)
                .forPath("/app3/b", "bNode".getBytes());

        client.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath("/app3/c", "cNode".getBytes());

        client.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .forPath("/app3/d", "dNode".getBytes());

        Thread.sleep(9000);
        client.close();
    }

    @Test
    public void testUpdateNode() throws Exception {
        client.start();

        client.setData().forPath("/app1", "app1Node".getBytes());

        client.close();
    }

    @Test
    public void testDeleteNode() throws Exception {
        client.start();

        client.delete().deletingChildrenIfNeeded().forPath("/app3");

        client.close();
    }

    @Test
    public void testNodeCache() throws Exception {
        client.start();
        NodeCache nodeCache = new NodeCache(client, "/hello");
        nodeCache.start(true);
        System.out.println(nodeCache.getCurrentData());

        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                ChildData currentData = nodeCache.getCurrentData();
                String data = new String(currentData.getData());
                String path = currentData.getPath();
                System.out.println("path: " + path + " data: " + data);
            }
        });

        System.in.read();
        client.close();
    }

    @Test
    public void testPathChildrenCache() throws Exception {
        client.start();
        PathChildrenCache childrenCache = new PathChildrenCache(client, "/hello", true);
        childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);

        childrenCache.getListenable().addListener((client, event) -> {
            if (event.getType() == PathChildrenCacheEvent.Type.CONNECTION_RECONNECTED) {
                System.out.println("reconnected");
            } else if (event.getType() == PathChildrenCacheEvent.Type.CONNECTION_SUSPENDED) {
                System.out.println("suspended");
            } else if (event.getType() == PathChildrenCacheEvent.Type.CONNECTION_LOST) {
                System.out.println("connection lost");
            } else if (event.getType() == PathChildrenCacheEvent.Type.INITIALIZED) {
                System.out.println("initialized");
            } else if (event.getType() == PathChildrenCacheEvent.Type.CHILD_ADDED) {
                System.out.println("children added, path: " + event.getData().getPath() + ", data: " + new String(event.getData().getData()));
            } else if (event.getType() == PathChildrenCacheEvent.Type.CHILD_UPDATED) {
                System.out.println("children updated, path: " + event.getData().getPath() + ", data: " + new String(event.getData().getData()));
            } else if (event.getType() == PathChildrenCacheEvent.Type.CHILD_REMOVED) {
                System.out.println("children removed, path: " + event.getData().getPath() + ", data: " + new String(event.getData().getData()));
            }
        });
        System.in.read();
    }

    @Test
    public void testTreeCache() throws Exception {
        client.start();
        TreeCache treeCache = new TreeCache(client, "/hello");
        treeCache.start();
        treeCache.getListenable().addListener((client, event) -> {
            if (event.getType() == TreeCacheEvent.Type.CONNECTION_RECONNECTED) {
                System.out.println("reconnected");
            } else if (event.getType() == TreeCacheEvent.Type.CONNECTION_SUSPENDED) {
                System.out.println("suspended");
            } else if (event.getType() == TreeCacheEvent.Type.CONNECTION_LOST) {
                System.out.println("connection lost");
            } else if (event.getType() == TreeCacheEvent.Type.INITIALIZED) {
                System.out.println("initialized");
            } else if (event.getType() == TreeCacheEvent.Type.NODE_ADDED) {
                System.out.println("sub node added, path: " + event.getData().getPath() + ", data: " + new String(event.getData().getData()));
            } else if (event.getType() == TreeCacheEvent.Type.NODE_UPDATED) {
                System.out.println("sub node updated, path: " + event.getData().getPath() + ", data: " + new String(event.getData().getData()));
            } else if (event.getType() == TreeCacheEvent.Type.NODE_REMOVED) {
                System.out.println("sub node removed, path: " + event.getData().getPath() + ", data: " + new String(event.getData().getData()));
            }
        });
        System.in.read();
    }
}
