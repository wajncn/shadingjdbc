CREATE TABLE
    sharding_table_1
    (
        id bigint NOT NULL COMMENT '主键',
        name VARCHAR(50) COMMENT '用户名',
        mobile_phone VARCHAR(30) COMMENT '手机号码',
        create_date DATETIME COMMENT '更新人',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分表测试 ';