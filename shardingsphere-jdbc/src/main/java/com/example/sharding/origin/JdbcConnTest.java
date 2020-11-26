package com.example.sharding.origin;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.core.strategy.keygen.UUIDShardingKeyGenerator;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

public class JdbcConnTest {

    public static DataSource getDateSource() throws SQLException {
        //配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        //配置第一个数据源
        BasicDataSource dataSource1 = new BasicDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://47.95.140.142:3306/ds0");
        dataSource1.setUsername("root");
        dataSource1.setPassword("wayne");
        dataSourceMap.put("ds0", dataSource1);

        // 配置第二个数据源
        BasicDataSource dataSource2 = new BasicDataSource();
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setUrl("jdbc:mysql://47.95.140.142:3306/ds1");
        dataSource2.setUsername("root");
        dataSource2.setPassword("wayne");
        dataSourceMap.put("ds1", dataSource2);

        //配置order表规则
        TableRuleConfiguration orderTableRuleConfig = new
                TableRuleConfiguration("t_order","ds${0..1}.t_order${0..1}");
        TableRuleConfiguration orderItemTableRuleConfig = new
                TableRuleConfiguration("t_order_item","ds${0..1}.t_order_item${0..1}");

        // 配置分库 + 分表策略
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds${user_id % 2}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "t_order${user_id % 2}"));
        //配置order_item表规则
        orderItemTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id","ds${user_id % 2}"));
        orderItemTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id","t_order_item${user_id % 2}"));

        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
        shardingRuleConfig.getTableRuleConfigs().add(orderItemTableRuleConfig);


        // 获取数据源对象
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new Properties());

        return dataSource;
    }

    public static void main(String[] args) throws SQLException {
        String order_id = UUID.randomUUID().toString();
        int user_id = 2003;

        String sql1 = "insert into t_order (order_id,user_id,order_name) values (?,?,?)";
        String sql2 = "insert into t_order_item (order_id,user_id,total_fee,actual_fee) values(?,?,?,?)";

        Connection conn = getDateSource().getConnection();

        //手动提交
        conn.setAutoCommit(false);

        PreparedStatement preparedStatement = conn.prepareStatement(sql1);

        preparedStatement.setString(1,order_id);
        preparedStatement.setInt(2,user_id);
        preparedStatement.setString(3,"奈菲");

        int affectRows = preparedStatement.executeUpdate();
        System.out.println("order表插入记录："+affectRows);

        if (affectRows == 0) {
            throw new SQLException("Insert fail,no row affected");
        }

//        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
//            if (generatedKeys.next()) {
//                order_id = generatedKeys.getLong(1);
//            } else {
//                throw new SQLException("Insert fail, no id return");
//            }
//        }

        if (order_id !=null) {
            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);

            preparedStatement2.setString(1,order_id);
            preparedStatement2.setInt(2,user_id);
            preparedStatement2.setDouble(3,10.5);
            preparedStatement2.setDouble(4,8.3);

            int affectRows2 = preparedStatement2.executeUpdate();
            System.out.println("item插入记录："+affectRows2);
        }

        conn.commit();



    }


}
