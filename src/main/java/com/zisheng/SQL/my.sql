select * from tb_user;
insert into tb_user(id,name,gender,age) values (111,'张三',0,21);
drop table if exists tb_eBook;
create table tb_eBook(
    id bigint primary key  comment '主键id',
    name varchar(50) comment '名称',
    category1_id bigint comment '分类1Id',
    category2_id bigint comment '分类2Id',
    description varchar(200) comment '描述',
    cover varchar(200) comment '封面',
    doc_count int comment '文档数',
    view_count int comment '阅读数',
    vote_count int comment '点赞数'
) engine=innodb default charset=utf8mb4 comment '电子书表';