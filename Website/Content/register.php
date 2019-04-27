<!DOCTYPE html>
<!-- lets user create account with campus connect -->
<html>
	<head>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans|Pacifico|Material+Icons" rel="stylesheet">
		<link href="../Formatting/register-styles.css" rel="stylesheet">
		<title>Campus Connect</title>
	</head>
	<body>
		<div id="register">
			<h1> Campus Connect!</h1>
			
			<form action="../PHPScripts/createuser.php" method="post">
			
				<label for="email">Email: </label>
				<input type="email" name="email" placeholder="abc@uw.edu" required>
				
				<label for="password">Password: </label>
				<input type="password" name="password" placeholder="••••••••••" required>
				
				<label for="studentid">Student ID: </label>
				<input type="number" name="studentid" placeholder="12345" required>
				
				<label for="name">Name: </label>
				<input type="text" name="name" placeholder="Hermione Grancer" required>
				
				<label for="major">Major: </label>
				<input type="text" name="major" placeholder="Undeclared">
				
				<button type="submit">Register</button>
			</form>
		</div>
	</body>
</html>