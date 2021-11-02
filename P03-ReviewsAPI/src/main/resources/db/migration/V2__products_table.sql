create table review_api.product
(
    id          int auto_increment not null primary key,
    price       float        not null,
    name        varchar(255) not null,
    description varchar(150) not null
);

