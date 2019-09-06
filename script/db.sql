# sec kill database
create database `sec_kill`; 

use `sec_kill`;

# 类目表
create table catalogs(
	`catalog_id` int auto_increment comment '主键',
	`catalog_name` varchar(30) not null comment '类目名称',
	`catalog_code` varchar(20) not null comment '类目编码',
	primary key(`catalog_id`),
	unique key `uq_catalog_code`(`catalog_code`)
) comment '类目表';

# 商品表
create table products(
	`product_id` int auto_increment comment '主键',
	`product_name` varchar(30) not null comment '产品名称',
	`price` decimal(10,2) not null comment '商品价格',
	`catalog_code` varchar(20) not null comment '商品类目代码',
	primary key(`product_id`)
) comment '商品表';

# 订单表
create table orders(
	`order_id` int auto_increment comment '主键',
	`order_code` varchar(36) not null comment '订单号',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '修改时间',
	primary key(`order_id`),
	unique key `uq_order_code`(`order_code`)
) comment '订单表';

# 库存表
create table storage(
	`storage_id` int auto_increment comment '主键',
	`product_id` int not null comment '商品id',
	`total_count` int not null comment '库存总量',
	`saled_count` int not null comment '已收总量',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '修改时间',
	`version` int not null comment '版本乐观锁',
	primary key(`storage_id`),
	unique key `uq_product_id`(`product_id`)
) comment '库存表';