# Write your MySQL query statement below
Select email from Person
Group by email
Having count(email) >1;