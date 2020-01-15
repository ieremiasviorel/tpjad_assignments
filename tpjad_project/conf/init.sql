INSERT INTO tpjad_term_project.directory_item
(name, parent_id)
VALUES('Documents', 1);

INSERT INTO tpjad_term_project.directory_item
(name, parent_id)
VALUES('Downloads', 1);

INSERT INTO tpjad_term_project.directory_item
(name, parent_id)
VALUES('Pictures', 1);

INSERT INTO tpjad_term_project.directory_item
(name, parent_id)
VALUES('School', 4);

INSERT INTO tpjad_term_project.directory_item
(name, parent_id)
VALUES('Fun', 4);

INSERT INTO tpjad_term_project.file_item
(name, parent_id, data_id, extension)
VALUES('sample_document', 1, 'abcdefg', 'docx');

INSERT INTO tpjad_term_project.file_item
(name, parent_id, data_id, extension)
VALUES('sample_image', 1, 'abcdefg', 'png');