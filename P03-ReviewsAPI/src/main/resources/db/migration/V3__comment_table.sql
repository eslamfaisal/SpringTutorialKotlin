-- auto-generated definition
create table review_api.comment
(
    id           int auto_increment primary key,
    title        varchar(255)                        not null,
    comment_text varchar(10000)                      null,
    created_ts   timestamp default CURRENT_TIMESTAMP null,
    review_id    int                                 not null
);