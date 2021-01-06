CREATE TABLE public.client_corp (
    client_id character varying PRIMARY KEY,
    name character varying NOT NULL,
    org_form character varying NOT NULL,
    abbreviated_name character varying NOT NULL,
    INN character varying NOT NULL,
    KPP character varying NOT NULL,
    OGRN character varying NOT NULL,
    OKPO character varying NOT NULL,
    OKVED character varying NOT NULL,
    address_u character varying NOT NULL,
    address_f character varying NOT NULL,
    email character varying NOT NULL
);

CREATE TABLE public.client_individual(
    client_id character varying PRIMARY KEY,
    last_name character varying NOT NULL,
    first_name character varying NOT NULL,
    middle_name character varying NOT NULL,
    citizenship character varying NOT NULL,
    birthday date not null,
    passport character varying NOT NULL
);