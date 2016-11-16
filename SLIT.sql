create database slitdb;
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
        user_tutor BOOLEAN NOT NULL,
		PRIMARY KEY(user_ID)
		);

	CREATE TABLE ApprovalQueue ( #Køsystem der innleveringer(Delivery) blir plassert.
		approvalQueue_ID INTEGER(10) AUTO_INCREMENT,
		PRIMARY KEY(approvalQueue_ID)
		);

	CREATE TABLE Student ( #Inneholder alle studenter
		student_user_ID INTEGER (4) AUTO_INCREMENT,
        CONSTRAINT fk_UserStudent FOREIGN KEY (student_user_ID) REFERENCES Users (user_ID),
		PRIMARY KEY (student_user_ID)
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
		delivery_Status BOOLEAN NOT NULL,
		delivery_Date DATE NOT NULL,
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
		feedback_ID INTEGER(10) NOT NULL AUTO_INCREMENT,
		feedback_Comment VARCHAR(64) NOT NULL,
		feedback_HiddenComment VARCHAR(64) NOT NULL,
		feedback_Date DATE NOT NULL,
		feedback_Approved BOOLEAN NOT NULL,
		student_user_ID INTEGER(4),
        teacher_user_ID INTEGER (4),
        tutor_user_ID INTEGER (4),
        FK_delivery_ID INTEGER(10),
        CONSTRAINT fk_DeliveryFeedback FOREIGN KEY(FK_delivery_ID) REFERENCES Delivery (delivery_ID),
		CONSTRAINT fk_TeacherFeedback FOREIGN KEY(teacher_user_ID) REFERENCES Teacher (teacher_user_ID),
        CONSTRAINT fk_TutorFeedback FOREIGN KEY(tutor_user_ID) REFERENCES Tutor (tutor_user_ID),
        CONSTRAINT fk_StudentFeedback FOREIGN KEY(student_user_ID) REFERENCES Student (student_user_ID),
		PRIMARY KEY (feedback_ID)
		);

	CREATE TABLE CoursePlan ( #Skal inneholde semesterplan.docx. Fortsatt under arbeid
		coursePlan_ID INTEGER AUTO_INCREMENT,
		coursePlan_Name VARCHAR(64) NOT NULL,
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
	INSERT INTO ApprovalQueue (approvalQueue_ID)
		VALUES (1);
        
    INSERT INTO Users (user_UserName, user_Password, user_FirstName, user_LastName, user_Email, user_Phone, user_Tutor)
		VALUES('Maghov', 'root', 'Magnus', 'Høvik', 'magnus@gmail.com', '12345678', FALSE),
				('Evby', 'root', 'Even', 'Larsen', 'even@gmail.com', '87654321', FALSE),
                ('Rob', 'root', 'Robin', 'Hjelp', 'robin@gmail.com', '65487253', TRUE);
		
	INSERT INTO Student (student_user_ID)
		VALUES (1);
        
	INSERT INTO Teacher (teacher_user_ID, teacher_Office, FK_approvalQueue_ID)
		VALUES (1, 'H1337',1);
        
    INSERT INTO Tutor (tutor_user_ID, FK_approvalQueue_ID)
		VALUES (3, 1);
    
	INSERT INTO Module (module_Name, module_Task, module_Resources, module_Aim, module_Deadline, module_Obligatory, teacher_user_ID)
		VALUES ('Modul 3 - Modul 3', 'Lag en video der du forklarer læringsmålene i modulen. Bruk Camtasia Relay eller annet egnet verktøy for skjermopptak. Link skal inn på bloggen. (PS: Max 5 min)', 'Objects first with BlueJ',
        'Lære å bruke BlueJ', "2016-09-30", TRUE, 1);
	
	INSERT INTO Delivery (delivery_Name, delivery_Comment, delivery_Status, delivery_Date, student_user_ID, FK_approvalQueue_ID)
		VALUES ('Modul 1', 'Her er modul 1', TRUE, "2016-09-25", 1, 1);
        
	INSERT INTO Feedback (feedback_Comment, feedback_HiddenComment, feedback_Date, feedback_Approved, student_user_ID, teacher_user_ID, FK_delivery_ID)
		VALUES ('Godt jobbet', 'Han har full kontroll', "2016-09-29", FALSE, 1, 1, 1);
        
	INSERT INTO Notification (notification_Title, notification_Text, notification_Date, FK_feedback_ID)
		VALUES ('Modul 1 Godkjent', 'Modul 1 har blitt godkjent', "2016-09-29", 1);
        
	INSERT INTO CoursePlan (coursePlan_Name)
		VALUES ('Semesterplan');      
        
        
        
        select * from feedback;

     


    

		