create table article(
    id INTEGER auto_increment primary key,
    title VARCHAR(256),
    description VARCHAR(4096),
    created DATETIME, -- 작성 시간
    updated DATETIME, -- 수정 시간
    member_id INTEGER
);
