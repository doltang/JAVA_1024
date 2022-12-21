create database IF NOT EXISTS collage;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
	`st_num`	int	NOT NULL,
	`st_de_num`	int	NOT NULL,
	`st_pr_num`	int	NOT NULL,
	`st_name`	varchar(20)	NULL,
	`st_social_num`	int	NULL
);

DROP TABLE IF EXISTS `professor`;

CREATE TABLE `professor` (
	`pr_num`	int	NOT NULL,
	`pr_name`	varchar(20)	NULL,
	`pr_de_num`	int	NOT NULL,
	`pr_social_num`	int	NULL
);

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
	`de_num`	int	NOT NULL,
	`de_location`	varchar(30)	NULL,
	`de_number`	varchar(13)	NULL,
	`de_name`	varchar(30)	NULL
);

DROP TABLE IF EXISTS `student_belong`;

CREATE TABLE `student_belong` (
	`sb_num`	int	NOT NULL,
	`sb_de_num`	int	NOT NULL,
	`sb_st_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `lecture`;

CREATE TABLE `lecture` (
	`le_num`	int	NOT NULL,
	`le_code`	varchar(10)	NULL,
	`le_name`	varchar(30)	NULL,
	`le_personnel`	int	NULL,
	`pr_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `take_class`;

CREATE TABLE `take_class` (
	`tc_num`	int	NOT NULL,
	`tc_score`	varchar(10)	NULL,
	`tc_st_num`	int	NOT NULL,
	`tc_le_num`	int	NOT NULL
);

ALTER TABLE `student` ADD CONSTRAINT `PK_STUDENT` PRIMARY KEY (
	`st_num`
);

ALTER TABLE `professor` ADD CONSTRAINT `PK_PROFESSOR` PRIMARY KEY (
	`pr_num`
);

ALTER TABLE `department` ADD CONSTRAINT `PK_DEPARTMENT` PRIMARY KEY (
	`de_num`
);

ALTER TABLE `student_belong` ADD CONSTRAINT `PK_STUDENT_BELONG` PRIMARY KEY (
	`sb_num`
);

ALTER TABLE `lecture` ADD CONSTRAINT `PK_LECTURE` PRIMARY KEY (
	`le_num`
);

ALTER TABLE `take_class` ADD CONSTRAINT `PK_TAKE_CLASS` PRIMARY KEY (
	`tc_num`
);

ALTER TABLE `student` ADD CONSTRAINT `FK_department_TO_student_1` FOREIGN KEY (
	`st_de_num`
)
REFERENCES `department` (
	`de_num`
);

ALTER TABLE `student` ADD CONSTRAINT `FK_professor_TO_student_1` FOREIGN KEY (
	`st_pr_num`
)
REFERENCES `professor` (
	`pr_num`
);

ALTER TABLE `professor` ADD CONSTRAINT `FK_department_TO_professor_1` FOREIGN KEY (
	`pr_de_num`
)
REFERENCES `department` (
	`de_num`
);

ALTER TABLE `student_belong` ADD CONSTRAINT `FK_department_TO_student_belong_1` FOREIGN KEY (
	`sb_de_num`
)
REFERENCES `department` (
	`de_num`
);

ALTER TABLE `student_belong` ADD CONSTRAINT `FK_student_TO_student_belong_1` FOREIGN KEY (
	`sb_st_num`
)
REFERENCES `student` (
	`st_num`
);

ALTER TABLE `lecture` ADD CONSTRAINT `FK_professor_TO_lecture_1` FOREIGN KEY (
	`pr_num`
)
REFERENCES `professor` (
	`pr_num`
);

ALTER TABLE `take_class` ADD CONSTRAINT `FK_student_TO_take_class_1` FOREIGN KEY (
	`tc_st_num`
)
REFERENCES `student` (
	`st_num`
);

ALTER TABLE `take_class` ADD CONSTRAINT `FK_lecture_TO_take_class_1` FOREIGN KEY (
	`tc_le_num`
)
REFERENCES `lecture` (
	`le_num`
);

