create table credit_info
(
    user_seq            bigint                   not null,
    user_id             varchar(100)             not null,
    pay_tax_yn          varchar(100)             not null comment '세금 납세 이행 여부 { 양호 / 보통 / 불량 }',
    national_pension     tinyint    default 0     not null comment '국민 연금',
    health_insurance     tinyint    default 0     not null comment '건강 보험',
    employment_insurance tinyint    default 0     not null comment '고용 보험',
    work_insurance       tinyint    default 0     not null comment '산재 보험',
    job                   varchar(100)             not null comment '직업',
    work_year            tinyint                    comment  '근속 년수',
    company_name         varchar(100)               comment '기업명',
    ipo_yn               tinyint    default 0       comment '상장여부',
    PRIMARY KEY (user_id)
);

select * from credit_info;
# TRUNCATE TABLE credit_user_info;
INSERT INTO credit_info  VALUES
        (1,'onehana', '양호', 1, 1,1,1,'회사원', 2,'하나금융IT',0),
        (2,'goo95', '불량', 1, 1,1,1,'회사원', 2,'하나금융',0);