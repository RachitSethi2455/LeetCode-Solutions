# Write your MySQL query statement below
Select firstname,lastname,city,state 
From Person
Left Join Address
On Person.personId=Address.personId;