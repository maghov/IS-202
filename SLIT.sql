DROP DATABASE slitdb; 
CREATE DATABASE slitdb;
USE slitdb;

##########################################################

	CREATE TABLE Users ( #Lager en bruker som kan bli student, lærer eller hjelpelærer.
		user_ID INTEGER(4) AUTO_INCREMENT,
		user_UserName VARCHAR(64) NOT NULL,
		user_Password VARCHAR(64) NOT NULL,
		user_FirstName VARCHAR(64) NOT NULL,
		user_LastName VARCHAR(64) NOT NULL,
		user_Email VARCHAR(64) NOT NULL,
		user_Phone VARCHAR(11),
        user_tutor BOOLEAN,
		PRIMARY KEY(user_ID)
		);

	CREATE TABLE ApprovalQueue ( #Køsystem der innleveringer(Delivery) blir plassert.
		approvalQueue_ID INTEGER(10) AUTO_INCREMENT,
		PRIMARY KEY(approvalQueue_ID)
		);

	CREATE TABLE Student ( #Inneholder alle studenter
		student_user_ID INTEGER (4) AUTO_INCREMENT,
        PRIMARY KEY (student_user_ID),
        CONSTRAINT fk_UserStudent FOREIGN KEY (student_user_ID) REFERENCES Users (user_ID)
		);
        
	CREATE TABLE Teacher ( #Inneholder alle lærere
		teacher_user_ID INTEGER (4) AUTO_INCREMENT,
		teacher_Office VARCHAR(10) NOT NULL,
        FK_approvalQueue_ID INTEGER(10),
        PRIMARY KEY (teacher_user_ID),
        CONSTRAINT fk_UserTeacher FOREIGN KEY (teacher_user_ID) REFERENCES Users (user_ID),
		CONSTRAINT fk_ApprovalTeacher FOREIGN KEY(FK_approvalQueue_ID) REFERENCES ApprovalQueue(approvalQueue_ID)
		);
		
	CREATE TABLE Tutor ( #Inneholder alle hjelpelærere
		tutor_user_ID INTEGER (4) AUTO_INCREMENT,
        FK_approvalQueue_ID INTEGER(10),
        PRIMARY KEY (tutor_user_ID),
        CONSTRAINT fk_UserTutor FOREIGN KEY (tutor_user_ID) REFERENCES Users (user_ID),
		CONSTRAINT fk_ApprovalTutor FOREIGN KEY(FK_approvalQueue_ID) REFERENCES ApprovalQueue(approvalQueue_ID)
		);

	CREATE TABLE Module ( #Inneholder alle modulene som blir laget av lærere/forelesere
		module_ID INTEGER(10) AUTO_INCREMENT,
		module_Name VARCHAR(128) NOT NULL,
		module_Task VARCHAR(1000) NOT NULL,
		module_Resources VARCHAR(1000) NOT NULL,
		module_Aim VARCHAR(1000) NOT NULL,
		module_Deadline DATE NOT NULL,
		module_Obligatory BOOLEAN NOT NULL,
        teacher_user_ID INTEGER(4) NOT NULL,
		PRIMARY KEY(module_ID),
        CONSTRAINT fk_TeacherModule FOREIGN KEY(teacher_user_ID) REFERENCES Teacher(teacher_user_ID)
		);
        
	CREATE TABLE Delivery ( #Inneholder alle innleveringer som blir opprettet av studenter
		delivery_ID INTEGER(10) AUTO_INCREMENT,
		delivery_Name VARCHAR(64) NOT NULL,
		delivery_Comment VARCHAR(256) NOT NULL,
        student_user_ID INTEGER(4),
        teacher_user_ID INTEGER (4),
        tutor_user_ID INTEGER (4),
        FK_approvalQueue_ID INTEGER(10),
		PRIMARY KEY(delivery_ID),
        CONSTRAINT fk_TeacherDelivery FOREIGN KEY(teacher_user_ID) REFERENCES Teacher (teacher_user_ID),
        CONSTRAINT fk_TutorDelivery FOREIGN KEY(tutor_user_ID) REFERENCES Tutor (tutor_user_ID),
        CONSTRAINT fk_StudentDelivery FOREIGN KEY(student_user_ID) REFERENCES Student (student_user_ID),
        CONSTRAINT fk_ApprovalDelivery FOREIGN KEY(FK_approvalQueue_ID) REFERENCES ApprovalQueue(approvalQueue_ID)
		);
		
		
	#CREATE TABLE ModuleOverview ( #lage view for alle godkjente moduler
		

	#   );
		#En-til-mange eller en-til-en??
        
        
	CREATE TABLE Feedback (#Feedback blir knyttet til en innlevering(delivery)
		feedback_ID INTEGER(10) AUTO_INCREMENT,
		feedback_Comment VARCHAR(64) NOT NULL,
		feedback_HiddenComment VARCHAR(64) NOT NULL,
		feedback_Date DATE NOT NULL,
		feedback_Approved BOOLEAN NOT NULL,
		student_user_ID INTEGER(4),
        teacher_user_ID INTEGER (4),
        tutor_user_ID INTEGER (4),
        FK_delivery_ID INTEGER(10),
        PRIMARY KEY (feedback_ID),
        CONSTRAINT fk_DeliveryFeedback FOREIGN KEY(FK_delivery_ID) REFERENCES Delivery (delivery_ID),
		CONSTRAINT fk_TeacherFeedback FOREIGN KEY(teacher_user_ID) REFERENCES Teacher (teacher_user_ID),
        CONSTRAINT fk_TutorFeedback FOREIGN KEY(tutor_user_ID) REFERENCES Tutor (tutor_user_ID),
        CONSTRAINT fk_StudentFeedback FOREIGN KEY(student_user_ID) REFERENCES Student (student_user_ID)
		);

	CREATE TABLE CoursePlan ( #Skal inneholde semesterplan.docx. Fortsatt under arbeid
		coursePlan_ID INTEGER(10) AUTO_INCREMENT,
		coursePlan_Name VARCHAR(64) NOT NULL,
        coursePlan_Forelesning DATE NOT NULL,
        coursePlan_Plan VARCHAR(64) NOT NULL,
		PRIMARY KEY (coursePlan_ID)
		);

	CREATE TABLE Notification ( #Inneholder varsler som 
		notification_ID INTEGER(10) AUTO_INCREMENT,
		notification_Title VARCHAR(64) NOT NULL,
		notification_Text VARCHAR(256) NOT NULL,
		notification_Date DATE NOT NULL,
        FK_feedback_ID INTEGER(10),
		PRIMARY KEY(notification_ID),
        CONSTRAINT fk_FeedbackNotification FOREIGN KEY(FK_feedback_ID) REFERENCES Feedback(feedback_ID)
		);


###################################################################################################################
	
    INSERT INTO Users (user_UserName, user_Password, user_FirstName, user_LastName, user_Email, user_Phone, user_Tutor) 
		VALUES 	('Maghov', 'root', 'Magnus', 'Høvik', 'magnus@gmail.com', '12345678', FALSE),
				('Eiol', 'root', 'Eirik', 'Oliversen', 'eirik@gmail.com', '1234321', FALSE),
				('Evby', 'root', 'Even', 'Larsen', 'even@gmail.com', '87654321', FALSE),
                ('Rob', 'root', 'Robin', 'Hjelp', 'robin@gmail.com', '12435687', TRUE),
                ('Joakik', 'root', 'Joakim', 'Kilen', 'joakim@gmail.com', '21346578', FALSE),
                ('ErB', 'root', 'Erik', 'Berg', 'erik@gmail.com', '12365478', FALSE),
                ('Johnj', 'root', 'John', 'Jensen', 'john@gmail.com', '32145687', FALSE),
                ('Moh', 'root', 'Mohammad', 'Hussain', 'mohammad@gmail.com', '65487253', FALSE);
                
	INSERT INTO ApprovalQueue (approvalQueue_ID)
		VALUES 	(1);
		
	INSERT INTO Student (student_user_ID)
		VALUES 	(1),
				(2),
                (5),
                (6),
                (7),
                (8);
        
	INSERT INTO Teacher (teacher_user_ID, teacher_Office, FK_approvalQueue_ID)
		VALUES (3, 'H1337',1);
        
    INSERT INTO Tutor (tutor_user_ID, FK_approvalQueue_ID)
		VALUES (4, 1);
    
	INSERT INTO Module (module_Name, module_Task, module_Resources, module_Aim, module_Deadline, module_Obligatory, teacher_user_ID)
		VALUES 	('Modul 1 - Easy Start', 'Lag en video der du forklarer læringsmålene i modulen. Bruk Camtasia Relay eller annet egnet verktøy for skjermopptak. Link skal inn på bloggen. (PS: Max 5 min)', 'Objects first with BlueJ', 'Lære å bruke BlueJ', "2016-09-30", TRUE, 3), 
				('Modul 2 - Settere og getter', 'Lag et program der du bruker bruker noen settere og noen gettere','Objects first with BlueJ', 'Lære å bruke BlueJ',"2016.10,30", TRUE, 3),
				('Modul 3 - Litt mer avansert', 'Lage et litt mer avansert system', 'Objects first with BlueJ', 'Lære å bruke BlueJ', "2016.11.30", TRUE, 3),
				('Modul 4 - Enda mer avansert', 'Lage et enda mer avansert system', 'Objects first with BlueJ', 'Lære å bruke BlueJ', "2016.12.15", TRUE, 3),
				('Modul 5 - Testing med BlueJ', 'Lag testklasser og før opp noen forskjellige tester', 'Objects first with BlueJ', 'Lære å bruke BlueJ', "2016.12.30", FALSE, 3);
        
	
	INSERT INTO Delivery (delivery_Name, delivery_Comment, student_user_ID, FK_approvalQueue_ID)
		VALUES 	('Modul 1', 'Her er modul 1', 1, 1),
				('Modul 2', 'Her er modul 2', 1, 1),
                ('Modul 3', 'Her er modul 3', 1, 1),
                ('Modul 4', 'Her er modul 4', 1, 1),
                ('Modul 5', 'Her er modul 5', 1, 1),
				('Modul 1', 'Her er modul 1', 2, 1),
				('Modul 2', 'Her er modul 2', 2, 1),
                ('Modul 1', 'Her er modul 1', 5, 1),
                ('Modul 2', 'Her er modul 2', 5, 1),
                ('Modul 3', 'Her er modul 3', 5, 1),
                ('Modul 1', 'Her er modul 1', 6, 1),
                ('Modul 2', 'Her er modul 2', 6, 1),
                ('Modul 1', 'Her er modul 1', 7, 1),
                ('Modul 2', 'Her er modul 2', 7, 1),
				('Modul 1', 'Her er modul 1', 8, 1),
				('Modul 2', 'Her er modul 2', 8, 1);
        
	INSERT INTO Feedback (feedback_Comment, feedback_HiddenComment, feedback_Date, feedback_Approved, student_user_ID, teacher_user_ID, FK_delivery_ID)
		VALUES 
        #Delivery Student 1
        ('Godt jobbet', 'Han har full kontroll', "2016-09-15", TRUE, 1, 3, 1),
        ('Interessant, godt jobbet', 'Han har løst oppgaven på en interessant måte', "2016-09-29", TRUE, 1, 3, 2),
        ('Godt jobbet, fortsett slik', 'Han har full kontroll', "2016-10-07", TRUE, 1, 3, 3),
        ('Godt jobbet, kan forbedres, men er godt nok', 'Han har full kontroll', "2016-10-15", TRUE, 1, 3, 4),
        ('Nesten, men du må nok jobbe litt mer', 'Bra start, men mangler litt forståelse', "2016-11-05", FALSE, 1, 3, 5),
        #Delivery Student 2
        ('Godt jobbet', 'Han har full kontroll', "2016-09-29", TRUE, 2, 3, 6),
        ('Helt feil', 'Misforstått alt', "2016-10-29", FALSE, 2, 3, 7),
        #Delivery Student 3
        ('Godt jobbet', 'Han har full kontroll', "2016-09-29", TRUE, 5, 3, 8),
        ('Godt jobbet', 'Han har full kontroll', "2016-10-29", TRUE, 5, 3, 9),
        ('Helt feil', 'Misforstått alt', "2016-11-29", FALSE, 5, 3, 10),
        #Delivery Student 4
        ('Godt jobbet', 'Han har full kontroll', "2016-09-29",TRUE, 6, 3, 11),
		('Nesten, men du må nok jobbe litt mer', 'Bra start, men mangler litt forståelse', "2016-10-29", FALSE, 6, 3, 12),
        #Delivery Student 5
        ('Godt jobbet', 'Han har full kontroll', "2016-09-29", TRUE, 7, 3, 13),
		('Nesten, men du må nok jobbe litt mer', 'Bra start, men mangler litt forståelse', "2016-10-29", FALSE, 7, 3, 14),
		#Delivery Student 6
		('Godt jobbet', 'Han har full kontroll', "2016-09-29", TRUE, 8, 3, 15),
        ('Nesten, men du må nok jobbe litt mer', 'Bra start, men mangler litt forståelse', "2016-10-29", FALSE, 8, 3, 16);
        
	INSERT INTO Notification (notification_Title, notification_Text, notification_Date, FK_feedback_ID)
		VALUES 	
				#Varsel Student 1
				('Modul 1 Godkjent', 'Modul 1 har blitt godkjent', "2016-09-15", 1),
				('Modul 2 Godkjent', 'Modul 2 har blitt godkjent', "2016-09-29", 2),
                ('Modul 3 Godkjent', 'Modul 3 har blitt godkjent', "2016-10-07", 3),
                ('Modul 4 Godkjent', 'Modul 4 har blitt godkjent', "2016-10-15", 4),
                ('Modul 5 Ikke Godkjent', 'Modul 5 har Ikke blitt godkjent', "2016-11-05", 5),
                #Varsel Student 2
                ('Modul 1 Godkjent', 'Modul 1 har blitt godkjent', "2016-09-29", 6),
                ('Modul 2 Godkjent', 'Modul 2 har blitt godkjent', "2016-10-29", 7),
                #Varsel Student 3
                ('Modul 1 Godkjent', 'Modul 1 har blitt godkjent', "2016-09-29", 8),
                ('Modul 2 Godkjent', 'Modul 2 har blitt godkjent', "2016-10-29", 9),
                ('Modul 3 Ikke Godkjent', 'Modul 3 har ikke blitt godkjent', "2016-11-29", 10),
                #Varsel Student 4
                ('Modul 1 Godkjent', 'Modul 1 har blitt godkjent', "2016-09-29", 11),
                ('Modul 2 Ikke Godkjent', 'Modul 2 har ikke blitt godkjent', "2016-10-29", 12),
                #Varsel Student 5
                ('Modul 1 Godkjent', 'Modul 1 har blitt godkjent', "2016-09-29", 13),
                ('Modul 2 Ikke Godkjent', 'Modul 2 har ikke blitt godkjent', "2016-10-29", 14),
                #Varsel Student 6
                ('Modul 1 Godkjent', 'Modul 1 har blitt godkjent', "2016-09-29", 15),
                ('Modul 2 Ikke Godkjent', 'Modul 2 har ikke blitt godkjent', "2016-10-29", 16);
        
	INSERT INTO CoursePlan (coursePlan_Name, coursePlan_Forelesning, coursePlan_Plan)
		VALUES ('Semesterplan', "2016-12-24", 'Fortsette med JavaFX'),
        ('Semesterplan', "2016-12-17", 'Fortsette med Netbeans'),
        ('Semesterplan', "2016-01-02", 'Starte noe nytt i Java');  
        
        select * from Users;
        select * from ApprovalQueue;
        select * from Student;
        select * from Teacher;
        select * from Tutor;
        select * from Module;
		select * from Delivery;
        select * from feedback;
        select * from Courseplan;
        select * from Notification;