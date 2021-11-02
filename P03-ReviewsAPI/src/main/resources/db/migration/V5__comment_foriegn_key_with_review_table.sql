alter table review_api.comment
    add constraint comment_review_id_fk
        foreign key (review_id) references review (id)
            on delete cascade;
