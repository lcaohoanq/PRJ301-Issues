use student_1
CREATE TABLE [Student] (
    [StudentID] INTEGER NOT NULL IDENTITY(1, 1),
    [name] VARCHAR(255) NULL,
    [gender] bit NULL,
    [dob] date,
    PRIMARY KEY ([StudentID])
);
GO

INSERT INTO Student([name],[gender],[dob]) VALUES('Hadassah','1','2016-Mar-12');
INSERT INTO Student([name],[gender],[dob]) VALUES('Reuben','1','2013-Apr-01');
INSERT INTO Student([name],[gender],[dob]) VALUES('Janna','1','2016-Jan-14');
INSERT INTO Student([name],[gender],[dob]) VALUES('Harrison','1','2015-Dec-25');
INSERT INTO Student([name],[gender],[dob]) VALUES('Winter','0','2013-Oct-27');
INSERT INTO Student([name],[gender],[dob]) VALUES('Norman','1','2015-Mar-21');
INSERT INTO Student([name],[gender],[dob]) VALUES('Rigel','1','2007-Aug-31');
INSERT INTO Student([name],[gender],[dob]) VALUES('Gannon','0','2005-Jun-10');
INSERT INTO Student([name],[gender],[dob]) VALUES('Delilah','1','2011-Aug-01');
INSERT INTO Student([name],[gender],[dob]) VALUES('Faith','1','2015-Jan-13');
INSERT INTO Student([name],[gender],[dob]) VALUES('Geoffrey','0','2017-Sep-29');