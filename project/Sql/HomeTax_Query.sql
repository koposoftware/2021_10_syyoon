create table credit_info
(
    user_seq            bigint                   not null,
    user_id             varchar(100)             not null,
    pay_tax_yn          varchar(100)             not null comment '���� ���� ���� ���� { ��ȣ / ���� / �ҷ� }',
    national_pension     tinyint    default 0     not null comment '���� ����',
    health_insurance     tinyint    default 0     not null comment '�ǰ� ����',
    employment_insurance tinyint    default 0     not null comment '��� ����',
    work_insurance       tinyint    default 0     not null comment '���� ����',
    job                   varchar(100)             not null comment '����',
    work_year            tinyint                    comment  '�ټ� ���',
    company_name         varchar(100)               comment '�����',
    ipo_yn               tinyint    default 0       comment '���忩��',
    PRIMARY KEY (user_id)
);

select * from credit_info;
# TRUNCATE TABLE credit_user_info;
INSERT INTO credit_info  VALUES
        (1,'onehana', '��ȣ', 1, 1,1,1,'ȸ���', 2,'�ϳ�����IT',0),
        (2,'goo95', '�ҷ�', 1, 1,1,1,'ȸ���', 2,'�ϳ�����',0);