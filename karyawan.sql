BEGIN;


CREATE TABLE IF NOT EXISTS public.karyawan
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999 CACHE 1 ),
    kode_karyawan character(50) COLLATE pg_catalog."default" NOT NULL GENERATED ALWAYS AS (('K-'::text || lpad((id)::text, 3, '0'::text))) STORED,
    nama_karyawan character(50) COLLATE pg_catalog."default" NOT NULL,
    tanggal_masuk_kerja date NOT NULL,
    no_hp character(15) COLLATE pg_catalog."default",
    limit_reimbursement numeric,
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL DEFAULT now(),
    CONSTRAINT karyawan_pkey PRIMARY KEY (id),
    CONSTRAINT unique_name UNIQUE (kode_karyawan),
    CONSTRAINT unique_phone UNIQUE (no_hp)
);
END;