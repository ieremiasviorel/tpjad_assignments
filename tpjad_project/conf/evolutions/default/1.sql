# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table directory_item (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  path                          varchar(255),
  parent_id                     bigint,
  constraint pk_directory_item primary key (id)
);

create table file_item (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  path                          varchar(255),
  parent_id                     bigint,
  data_id                       varchar(255),
  extension                     varchar(255),
  constraint pk_file_item primary key (id)
);

create table linked_accounts (
  id                            bigint auto_increment not null,
  user_id                       bigint,
  provider_user_id              varchar(255),
  provider_key                  varchar(255),
  root_directory_id             bigint,
  constraint uq_linked_accounts_provider_user_id unique (provider_user_id),
  constraint uq_linked_accounts_root_directory_id unique (root_directory_id),
  constraint pk_linked_accounts primary key (id)
);

create table users (
  id                            bigint auto_increment not null,
  email                         varchar(255),
  name                          varchar(255),
  active                        tinyint(1) default 0 not null,
  email_validated               tinyint(1) default 0 not null,
  constraint uq_users_email unique (email),
  constraint pk_users primary key (id)
);

alter table directory_item add constraint fk_directory_item_parent_id foreign key (parent_id) references directory_item (id) on delete restrict on update restrict;
create index ix_directory_item_parent_id on directory_item (parent_id);

alter table file_item add constraint fk_file_item_parent_id foreign key (parent_id) references directory_item (id) on delete restrict on update restrict;
create index ix_file_item_parent_id on file_item (parent_id);

alter table linked_accounts add constraint fk_linked_accounts_user_id foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_linked_accounts_user_id on linked_accounts (user_id);

alter table linked_accounts add constraint fk_linked_accounts_root_directory_id foreign key (root_directory_id) references directory_item (id) on delete restrict on update restrict;


# --- !Downs

alter table directory_item drop foreign key fk_directory_item_parent_id;
drop index ix_directory_item_parent_id on directory_item;

alter table file_item drop foreign key fk_file_item_parent_id;
drop index ix_file_item_parent_id on file_item;

alter table linked_accounts drop foreign key fk_linked_accounts_user_id;
drop index ix_linked_accounts_user_id on linked_accounts;

alter table linked_accounts drop foreign key fk_linked_accounts_root_directory_id;

drop table if exists directory_item;

drop table if exists file_item;

drop table if exists linked_accounts;

drop table if exists users;

