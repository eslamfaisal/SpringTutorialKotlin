create table review_api.review
(
    id          int auto_increment
        primary key,
    title       varchar(255)                        not null,
    review_text varchar(10000)                      null,
    created_ts  timestamp default CURRENT_TIMESTAMP null,
    recommended tinyint(1)                          null,
    product_id  int                                 not null
);

