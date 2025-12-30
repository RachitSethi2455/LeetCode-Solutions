# Write your MySQL query statement below
Select * from Cinema
Where id % 2 =1
And description != "boring"
Order By rating desc;