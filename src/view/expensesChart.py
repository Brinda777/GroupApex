# import mysql connector
# use mysql-connector 
# pip install mysql-connector-python
# pip install mysql-connector-python-rf
import mysql.connector
# to make a pie chart from mysql table named expenses which has 3 columns named  name , cost and date

# connect to mysql database
mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  passwd="root",
  database="apex"
)

# store command line arguments in variables
# import sys
import sys
uid = sys.argv[1]

# create a cursor
mycursor = mydb.cursor()

# execute the query
mycursor.execute("SELECT expense_name, expense_amount FROM expenses_data WHERE uid = "+uid+"")

# fetch all the records
result = mycursor.fetchall()

# create a list of tuples

# create a list of tuples
expenses = []
for row in result:
    expenses.append((row[0],row[1]))

# create a pie chart
import matplotlib.pyplot as plt

# create a list of colors
colors = ["red","green","blue","yellow","orange","purple","brown","pink","grey","cyan"]

# create a pie chart

plt.pie([row[1] for row in expenses], labels=[row[0] for row in expenses], colors=colors, autopct='%1.1f%%', shadow=True, startangle=90)

# add a title
plt.title("Expenses")
# save the plot with dimensions in pixels of 100x100

plt.savefig("py_expenses.png", bbox_inches="tight", pad_inches=0.2, dpi=100)


# show the plot
plt.show()

