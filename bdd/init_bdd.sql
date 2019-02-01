CREATE TABLE res_resultat_t(
    res_resultat_id INT(4) AUTO_INCREMENT,
    res_date_rep DATE,
    rep_reponse_id INT(4),
    snd_sonde_id INT(4),
    PRIMARY KEY (res_resultat_id)
);

CREATE TABLE rep_reponse_t(
    rep_reponse_id INT(4) AUTO_INCREMENT,
    rep_intitule VARCHAR(250),
    que_quest_id INT(4),
    PRIMARY KEY (rep_reponse_id)
);

CREATE TABLE que_quest_t(
    que_quest_id INT(4) AUTO_INCREMENT,
    que_intitule VARCHAR(250),
    que_type TINYINT(1),
    que_ordre INT(4),
    sdg_sondage_id INT(4),
    PRIMARY KEY (que_quest_id)
);

CREATE TABLE snd_sonde_t(
    snd_sonde_id INT(4) AUTO_INCREMENT,
    snd_nom VARCHAR(100),
    snd_prenom VARCHAR(100),
    snd_pseudo VARCHAR(100),
    snd_age INTEGER(4),
    snd_password VARCHAR(100),
    snd_email VARCHAR(100),
    cat_categorie_id INT(4),
    adm_admin_id INT(4),
    PRIMARY KEY (snd_sonde_id)
);

CREATE TABLE sdg_sondage_t(
    sdg_sondage_id INT(4) AUTO_INCREMENT,
    sdg_intitule VARCHAR(250),
    sdg_actif BOOLEAN,
    sdg_description VARCHAR(750),
    sdg_dateDebut DATE,
    sdg_dateFin DATE,
    sdr_sondeur_id INT(4),
    cat_categorie_id INT(4),
    PRIMARY KEY (sdg_sondage_id)
);

CREATE TABLE par_participant_t(
    sdg_sondage_id INT(4) NOT NULL,
    snd_sonde_id INT(4) NOT NULL,
    CONSTRAINT PK_par_participant_t PRIMARY KEY (sdg_sondage_id,snd_sonde_id)
);

CREATE TABLE cat_categorie_t(
    cat_categorie_id INT(4) AUTO_INCREMENT,
    cat_intitule VARCHAR(250),
    cat_description VARCHAR(750),
    sdr_sondeur_id INT(4),
    PRIMARY KEY (cat_categorie_id)
);

CREATE TABLE sdr_sondeur_t(
    sdr_sondeur_id INT(4) AUTO_INCREMENT,
    sdr_nom VARCHAR(100),
    sdr_prenom VARCHAR(100),
    sdr_mail VARCHAR(100),
    sdr_mdp VARCHAR(100),
    adm_admin_id INT(4),
    PRIMARY KEY (sdr_sondeur_id)
);

CREATE TABLE adm_admin_t(
    adm_admin_id INT(4) AUTO_INCREMENT,
    adm_email VARCHAR(100),
    adm_mdp VARCHAR(100),
    PRIMARY KEY (adm_admin_id)
);



ALTER TABLE res_resultat_t ADD CONSTRAINT FK_res_rep FOREIGN KEY (rep_reponse_id) REFERENCES rep_reponse_t(rep_reponse_id);
ALTER TABLE res_resultat_t ADD CONSTRAINT FK_res_snd FOREIGN KEY (snd_sonde_id) REFERENCES snd_sonde_t(snd_sonde_id);
ALTER TABLE rep_reponse_t ADD CONSTRAINT FK_rep_que FOREIGN KEY (que_quest_id) REFERENCES que_quest_t(que_quest_id);
ALTER TABLE que_quest_t ADD CONSTRAINT FK_que_sdg FOREIGN KEY (sdg_sondage_id) REFERENCES sdg_sondage_t(sdg_sondage_id);
ALTER TABLE snd_sonde_t ADD CONSTRAINT FK_snd_cat FOREIGN KEY (cat_categorie_id) REFERENCES cat_categorie_t(cat_categorie_id);
ALTER TABLE snd_sonde_t ADD CONSTRAINT FK_snd_adm FOREIGN KEY (adm_admin_id) REFERENCES adm_admin_t(adm_admin_id);
ALTER TABLE sdg_sondage_t ADD CONSTRAINT FK_sdg_sdr FOREIGN KEY (sdr_sondeur_id) REFERENCES sdr_sondeur_t(sdr_sondeur_id);
ALTER TABLE par_participant_t ADD CONSTRAINT FK_par_sdg FOREIGN KEY (sdg_sondage_id) REFERENCES sdg_sondage_t(sdg_sondage_id);
ALTER TABLE sdg_sondage_t ADD CONSTRAINT FK_sdg_sdr FOREIGN KEY (sdr_sondeur_id) REFERENCES sdr_sondeur_t(sdr_sondeur_id);
ALTER TABLE sdg_sondage_t ADD CONSTRAINT FK_sdg_cat FOREIGN KEY (cat_categorie_id) REFERENCES cat_categorie_t(cat_categorie_id);
ALTER TABLE par_participant_t ADD CONSTRAINT FK_par_snd FOREIGN KEY (snd_sonde_id) REFERENCES snd_sonde_t(snd_sonde_id);
ALTER TABLE cat_categorie_t ADD CONSTRAINT FK_cat_sdr FOREIGN KEY (sdr_sondeur_id) REFERENCES sdr_sondeur_t(sdr_sondeur_id);
ALTER TABLE sdr_sondeur_t ADD CONSTRAINT FK_sdr_adm FOREIGN KEY (adm_admin_id) REFERENCES adm_admin_t(adm_admin_id);