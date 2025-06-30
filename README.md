Account Class:
This is a blueprint for creating bank accounts. It stores details like:
Account holder's name
Account number (unique for each user)
Current balance
List of past transactions

Deposit Method:
This method adds money to the account. It:
Checks if the amount is positive
Increases the balance
Records the transaction in history with timestamp and type

Withdraw Method:
This method removes money from the account. 
Checks if the amount is positive and does not exceed the balance
Decreases the balance
Records the transaction similarly


 
 2. Maintain account balance and transaction history
Balance:
A variable that keeps track of how much money is currently in the account. It's updated every time deposit or withdraw is done.

Transaction History:
A list that records every transaction (deposit or withdrawal). Each record includes:

Type of transaction (Deposit or Withdraw)

Amount

Exact time it occurred

*Creative Enhancements Added*
Unique Account Number:
Automatically generated for each new account.

Timestamped Transactions:
Every transaction includes the date and time for better tracking.

Menu-based Interface:
User can interact via terminal to perform actions like deposit, withdraw, view summary, and history.

Friendly Messages:
Icons and messages improve user experience, making it feel like a mini real-world app.

