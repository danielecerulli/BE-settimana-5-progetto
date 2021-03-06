PGDMP                          z            multedb    14.1    14.1     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16969    multedb    DATABASE     c   CREATE DATABASE multedb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE multedb;
                postgres    false            ?            1259    17000    auto    TABLE     ?   CREATE TABLE public.auto (
    targa character(7) NOT NULL,
    marca character varying(50) NOT NULL,
    modello character varying(50) NOT NULL
);
    DROP TABLE public.auto;
       public         heap    postgres    false            ?            1259    17019 
   infrazioni    TABLE     ?   CREATE TABLE public.infrazioni (
    id integer NOT NULL,
    data character varying(20) NOT NULL,
    tipo character varying(50) NOT NULL,
    importo smallint NOT NULL,
    targaf character(7)
);
    DROP TABLE public.infrazioni;
       public         heap    postgres    false            ?            1259    17018    infrazioni_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.infrazioni_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.infrazioni_id_seq;
       public          postgres    false    211            ?           0    0    infrazioni_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.infrazioni_id_seq OWNED BY public.infrazioni.id;
          public          postgres    false    210            `           2604    17022    infrazioni id    DEFAULT     n   ALTER TABLE ONLY public.infrazioni ALTER COLUMN id SET DEFAULT nextval('public.infrazioni_id_seq'::regclass);
 <   ALTER TABLE public.infrazioni ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210    211            ?          0    17000    auto 
   TABLE DATA           5   COPY public.auto (targa, marca, modello) FROM stdin;
    public          postgres    false    209   ?       ?          0    17019 
   infrazioni 
   TABLE DATA           E   COPY public.infrazioni (id, data, tipo, importo, targaf) FROM stdin;
    public          postgres    false    211   ?       ?           0    0    infrazioni_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.infrazioni_id_seq', 13, true);
          public          postgres    false    210            b           2606    17004    auto auto_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.auto
    ADD CONSTRAINT auto_pkey PRIMARY KEY (targa);
 8   ALTER TABLE ONLY public.auto DROP CONSTRAINT auto_pkey;
       public            postgres    false    209            e           2606    17024    infrazioni infrazioni_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.infrazioni
    ADD CONSTRAINT infrazioni_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.infrazioni DROP CONSTRAINT infrazioni_pkey;
       public            postgres    false    211            c           1259    17030    fki_infrazioni_auto_targa_fkey    INDEX     W   CREATE INDEX fki_infrazioni_auto_targa_fkey ON public.infrazioni USING btree (targaf);
 2   DROP INDEX public.fki_infrazioni_auto_targa_fkey;
       public            postgres    false    211            f           2606    17025 %   infrazioni infrazioni_auto_targa_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.infrazioni
    ADD CONSTRAINT infrazioni_auto_targa_fkey FOREIGN KEY (targaf) REFERENCES public.auto(targa) NOT VALID;
 O   ALTER TABLE ONLY public.infrazioni DROP CONSTRAINT infrazioni_auto_targa_fkey;
       public          postgres    false    211    3170    209            ?   ?   x?%?ͮ?0???)|?k??ߒ?5??L???\?{ӨԔv??[?j????)D?e	'r??-? e?Xĉ7????V{J?ܓ?.??????????q???4?u????l?"?QO?L???f??I?ƛ#Hmz8????y$[(?S?'iX+?P??6M??*ɠU??l??e?-??yz&??\gy??}???
???pe?9c?AB?      ?   ?   x?e?A?  ??+x?첡?#4$??R5!??RO?g&??Q?S5B
!?Zd????????_Hs???X??ȹn???wYw?'-[j??ή+3?}?)???P?R{\?????????T?(??v?G?(C̯?΃Z?X??ɤ??\?_%t1N     