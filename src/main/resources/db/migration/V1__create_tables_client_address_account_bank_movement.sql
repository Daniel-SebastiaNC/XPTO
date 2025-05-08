CREATE TABLE tb_address (
    id NUMBER PRIMARY KEY,
    street VARCHAR2(255) NOT NULL,
    number_house NUMBER NOT NULL,
    complement VARCHAR2(255),
    district VARCHAR2(100) NOT NULL,
    city VARCHAR2(100) NOT NULL,
    state VARCHAR2(2) NOT NULL,
    cep VARCHAR2(8) NOT NULL
);

CREATE TABLE tb_client (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(255) NOT NULL,
    cpf_cnpj VARCHAR2(14) NOT NULL UNIQUE,
    address_id NUMBER NOT NULL,
    tax_identifier VARCHAR2(2) NOT NULL,
    telephone VARCHAR2(17) NOT NULL,
    created_at DATE DEFAULT TRUNC(SYSDATE) NOT NULL,
    balance_total NUMBER(19, 2) NOT NULL,
    CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES tb_address(id)
);

CREATE TABLE tb_account (
    id NUMBER PRIMARY KEY,
    balance NUMBER(19, 2),
    client_id NUMBER,
    CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES tb_client(id)
);

CREATE TABLE tb_bank_movement (
    id NUMBER PRIMARY KEY,
    value NUMBER(19, 2) NOT NULL,
    created_at DATE DEFAULT TRUNC(SYSDATE) NOT NULL,
    credit_debit_indicator VARCHAR2(6) NOT NULL,
    account_id NUMBER NOT NULL,
    CONSTRAINT fk_account_id FOREIGN KEY (account_id) REFERENCES tb_account(id)
);
