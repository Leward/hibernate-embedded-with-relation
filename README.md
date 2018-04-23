This repository shows how to map and use with Hibernate an `@Entity` containing an `@Embedded` value 
which itself defines a `@OneToMany` relation.

## Run

Run with: `./mvnw spring-boot:run`

Access the list of users: http://localhost:8080/users

## Generated schema

```sql
create table user (
  id bigint not null, 
  email varchar(255), 
  nickname varchar(255), 
  primary key (id)
);

create table user_roles (
  user_id bigint not null, 
  roles varchar(255)
);

alter table user_roles 
  add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user;
```