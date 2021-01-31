# hotel

Abstract: 
This paper contains steps to create a complete hotel system for the Java project, we will see how to create a hotel reservation management system in the Java programming language with the MySQL database. We will see the project creation step and will display the project UML. tools: 
-	netbeans ide 8.2. 
-	java programming language. 
-	xampp server. 
-	mysql database. 
-	phpmyadmin. 
Introduction: 
Today, software development has become a new era other than features of work in many areas, and software has become indispensable in many institutions. 
It plays a very large role in facilitating transactions and it has a fundamental role in reducing human interference and some organizations whose entire system depends on software. Today we will talk about the use of software development in creating a complete hotel system. 
Many institutions have become mainly dependent on a software system that reduces human intervention and reduces paper. Because the software system is fast, organized, and easy to use. We will do a project for employees to manage the hotel, such as reserving rooms for visitors and other services. Reservation of rooms. We will use Java language. This system will work on desktop systems The Database Schema: the database will contains 4 tables: 
1	- table users: to store the users usernames and passwords and allow them to login. 
2	- table resident: to store and manage the hotel clients data. 
3	- table room's type: to store the hotel rooms categories ( single, double, family, suite ). 
4	- table rooms: to store and manage the hotel rooms data. 
5- table reservations : to store and manage the hotel rooms reservations data. The Hotel System: 
The system consists of 8 user interface to control each window has a role either in adding or displaying data from databases we will talk about each interface in detail.  
1-Loginform 
2-All_Rooms_Types_Form 
3-MainForm 
4-ManageResidentsForm 
5-ManageResirvationsForm 
6-ManageRoomsForm 
7-check-out 
8-check-in 

![image](https://user-images.githubusercontent.com/73136710/106370963-f948a100-6367-11eb-88e5-396b14a1a758.png)

 
 
 
 
 Login Form: the login form will allow the Users to login into the application Main Form. 
the user need to enter his username and password before clicking the login button. 
UML 
![image](https://user-images.githubusercontent.com/73136710/106370979-1d0be700-6368-11eb-838f-6b206399bd3b.png)

![image](https://user-images.githubusercontent.com/73136710/106370990-2bf29980-6368-11eb-8fb7-e60643348c7d.png)

if the user enter wrong username or password or let any one of this two fields empty an error message will show up telling him what's the problem. 

![image](https://user-images.githubusercontent.com/73136710/106371005-42005a00-6368-11eb-8c5a-61ec9be64006.png)



 and if everything is ok, when you click on the login button the main hotel system form will show up and the login form will close itself. 
 
 
 Main Form:  
UML 

![image](https://user-images.githubusercontent.com/73136710/106371011-593f4780-6368-11eb-9bd9-f4202737d129.png)
![image](https://user-images.githubusercontent.com/73136710/106371014-5cd2ce80-6368-11eb-9d56-d12e7be5c4ce.png)


and he can select where he want to go. 

Manage Residents Form: 
when you select "Clients" form the main form menu, the Manage Residents Form will show up   
UML: 

 
![image](https://user-images.githubusercontent.com/73136710/106371022-7ecc5100-6368-11eb-9599-1e7ba28107d4.png)

![image](https://user-images.githubusercontent.com/73136710/106371026-84299b80-6368-11eb-866b-2b01adcd2e3e.png)


-	when this form load all clients will be displayed into a jtable. 
 
-	to add a new client enter his data and click on "Add New Client" button. 
 
-	to edit a client you need to select him first from the jtable and enter the his newdata. - when you want to delete a product just select the product you want to remove and click on the "Remove" button. 
-	when you Edit or Remove a CLIENT click on the "Refresh" button to see the new results in the jtable. 
 
Manage Rooms Form: 
UML: 
![image](https://user-images.githubusercontent.com/73136710/106371035-999ec580-6368-11eb-9b7e-97b02654b5a1.png)
here the user can add a new room to the hotel system. when you add a new room you need to select the type of room (single, double, family, suite). and like the client form you can view all rooms in a datagridview and add, edit, remove the selecte one + a combobox populated with all room's categories.  
here the user can add a new room to the hotel system. when you add a new room you need to select the type of room (single, double, family, suite). 
and like the client form you can view all rooms in a datagridview and add, edit, remove the selecte one + a combobx populated with all room's categories. 

![image](https://user-images.githubusercontent.com/73136710/106371046-b0ddb300-6368-11eb-9bce-a97c13d407b7.png)
![image](https://user-images.githubusercontent.com/73136710/106371047-b3d8a380-6368-11eb-83db-6b3b13bb1266.png)

i you click on the show types button this form will show up with all the room's types available in this hotel managemnt system. 
 
Note: there is no form to mange room's types, if you want to add, edit, delete a category you can do that directly from the database. 

![image](https://user-images.githubusercontent.com/73136710/106371053-c3f08300-6368-11eb-8c7b-d5e26e5c12ff.png)
![image](https://user-images.githubusercontent.com/73136710/106371054-cfdc4500-6368-11eb-8c47-37778d2e8279.png)


 ManageResirvationsForm: 
UML: 

![image](https://user-images.githubusercontent.com/73136710/106371058-dff42480-6368-11eb-9267-0aa85c22901c.png)

This form allow the user to manage the clients room reservations. 
to create a reservation you need: 1) enter the reservation id, 2) select the client who will reserve, 3) you need to select the room where the client will stay. 
when you add a new reservation the system will check: 
-	if the user enter all required informations. 
-	if the user enter a date in that is equal or come after the current day date. 
-	if the user enter a date out that is equal or come after the date in. 

 ![image](https://user-images.githubusercontent.com/73136710/106371065-eedad700-6368-11eb-8c5c-e0aef44bfd3b.png)
![image](https://user-images.githubusercontent.com/73136710/106371067-f4d0b800-6368-11eb-883a-86c0d4e58871.png)

 Client-form: 
UML: 

![image](https://user-images.githubusercontent.com/73136710/106371075-03b76a80-6369-11eb-9ab0-417fe5d44095.png)

Log in as a user. The user name and password are written and you click on the login button as a customer 

![image](https://user-images.githubusercontent.com/73136710/106371090-2d709180-6369-11eb-9451-a40c06c3a4a4.png)

Then you will be taken to  client-form  
After logging in, the page displays all customer information 

![image](https://user-images.githubusercontent.com/73136710/106371098-36f9f980-6369-11eb-9920-1fc1f5b83cd4.png)

There is in this interface 2 buttons, the first is responsible for reserving rooms for the customer and the second is to cancel the rooms reservation. If we press the button to reserve rooms, it will take us to the room reservation interface. 
check-in:  UML: 

![image](https://user-images.githubusercontent.com/73136710/106371099-3f523480-6369-11eb-8290-39ab20fe6ef2.png)

In this interface the customer makes a reservation 

![image](https://user-images.githubusercontent.com/73136710/106371104-48db9c80-6369-11eb-8ae8-063c4d7598e9.png)

After filling in the data, the program returns to the main page to display the data, and the program adjusts the databases in the table of rooms, it is reserved and the room number is written in the customer information in the customer table 

![image](https://user-images.githubusercontent.com/73136710/106371112-51cc6e00-6369-11eb-897c-b7e86f7138de.png)




Cancel reservation button scans the room and cancels the reservation of the customer 

![image](https://user-images.githubusercontent.com/73136710/106371117-5abd3f80-6369-11eb-8cdb-38c86994a005.png)

Now all the operating windows of the program have been explained All_Rooms_Types_Form class: 
![image](https://user-images.githubusercontent.com/73136710/106371123-627ce400-6369-11eb-8f44-b161ea1cd2f3.png)









The conclusion: 
 
We learned how to create desktop software in Java and created a complete system project for a hotel with databases 
 
 
Refrences: 
1-https://netbeans.org/downloads/6.1/index.html 
2-https://www.apachefriends.org/index.html 
3-https://guigarage.com/javafx-book/ 
4-https://stackoverflow.com/questions/22433952/what-are-javafx-fxml-and-scenebuilder 



