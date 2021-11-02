alter table review_api.review
    add constraint review_product_id_fk
        foreign key (product_id) references product (id)
            on delete cascade;

