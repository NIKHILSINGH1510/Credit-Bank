# Credit-Bank
INTRODUCTION
AS PER THE GOI EDUCATION MINISTRY’S NEW 
EDUCATION POLICY INDIVIDUAL CREDIT(SCORE) WILL 
PLAY A VITAL ROLE IN ONE’S APPROACH TOWARDS 
THE UPCOMING SYLLABUS AND COURSES.
THUS THERE ARISES THE CONCEPT OF MANAGING 
THE CREDIT IN AN EASY AND EFFICIENT FAST WAY
WE INTRODUCE YOU WITH OUR PROJECT WHICH 
WILL WORK WITH THE SAME AND PROCESS THE 
CREDITS MAINTAINED BY THE ADMINISTRATION
AND REMINDING ABOUT THE UPCOMING COURSES 
WITH INDIVIDUAL INTEREST.
IT WILL PREVENT THE STUDENTS FROM STANDING 
IN LINE WHILE RGISTERING THE COURSE OR 
RECEIVING THE RESULT.
INCREASES THE REPUTATION OF THE INSTITUTE 
TOWARDS THE TECHNOLOGY COMPATIBILITY 
COMPARED TO OTHERS.
Problem Statement
Credit Bank
As per the policy of National Education Policy (NEP) total credits of every individual students will play 
a vital role in student’s career of students take drop.
For example, if a student takes a drop in first year of his engineering and has acquired some 
particular credits or more then he would be awarded a degree of diploma. Then his knowledge 
won’t be wasted.
The primary purpose of this bank is to input students’ details, check credits, update credits and 
details. In this system only administration can update the credits of students and students can check 
their credits and update their details.
The Credit Bank consist of following components:
- Student Registration
- Student Login
• Check Credits
• Update Details
- Admin Login
• Check Details
• Update Credits
Students Registration
Where new Students can input their details and register with our institute.
Students Login
It also has 2 options. Once students logged in with their respective id and password, they have to 
choose
if(rs.next()) //check whether id and password exists in database or not
{
frame.dispose(); //if exists the close the current frame
StudentOptions so = new StudentOptions();
so.frame.setVisible(true); //Open another page to select Check 
Credits and Update Details
}
else { //if id and password not exists then show message invalid id
frame.dispose();
JOptionPane.showMessageDialog(frame, "Invalid ID");
}
• Check Credits
This page shows the total credits of the students, his current eligible degree if he takes drop 
and credits needed for the next degree that are only updated by admins after each 
semester. Apart from this admin can send mail to all the students of his individual credits 
after every semester.
//If check credits buttons click then set the visibility of checkCredits class 
true
checkCredits cc = new checkCredits();
cc.frame.setVisible(true);
while(rs.next()&&rs1.next()) //Show credits of logged in student
{
model.addRow(new Object[] {rs.getString("Id"), rs.getString("TotalCredit"), 
rs1.getString("CurrentSem"), rs.getString("TypeOfDegree")});
}
• Update Details
In this page students can change his/her details and update it in the database of the 
institute.
//If update detail buttons click then set the visibility of firstform class true
firstform ff = new firstform();
ff.setVisible(true);
Admin Login
After entering correct details and password other page open with again 2 pages. The password of 
admin is 123.
• Check Details
Admin can check details of any students by entering his/her id whenever admin need it. To 
be precise admin will have access to the updated details of every students.
//Check whether admin id and password exists in database or not
if(tnam.getText().equals("admin") && jTextField1.getText().equals("123"))
{
JOptionPane.showMessageDialog(this,"welcome");// If exists the show message 
welcome
new searchid().setVisible(true);//And set the visibility of log class true
this.dispose(); //close the current frame

}
else{
 JOptionPane.showMessageDialog(this,"login failed");//else show login failed 
message
}
• Update Credits
Admin can update the credits of every individual students and will announce his/her eligible 
degree and credits needed for next degree. And the updated credits can be declared for 
students of “Check Credits” page.
//Update the credits in the database 
 pst.setString(1, ID);
 pst.setString(2,jTextField1.getText());
 pst.setString(3,jTextField2.getText());
 pst.setString(4,jTextField3.getText());
 pst.executeUpdate();
 
// After credits updated show credits updated message and send mail to the 
respective student
 JOptionPane.showMessageDialog(null, "Credits Updated");
 SendMail ob = new SendMail();
 ob.main(null);
 this.dispose();
