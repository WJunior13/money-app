CREATE TABLE balances (
    id varchar not null primary key,
    last_transaction_id varchar not null,
    account_id varchar not null unique,
    value float8 not null
);

create index balances_account_id_index on balances (account_id);