<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction Management</title>
</head>
<body>
    <h1>Manage Your Transactions</h1>

    <!-- Form to add new transaction -->
    <form method="post" action="addTransaction">
        <label for="category">Category:</label>
        <input type="text" id="category" name="category"><br><br>

        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount"><br><br>

        <label for="description">Description:</label>
        <input type="text" id="description" name="description"><br><br>

        <button type="submit">Add Transaction</button>
    </form>
</body>
</html>
