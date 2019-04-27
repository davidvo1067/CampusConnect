<!DOCTYPE html>
<!-- allows the user to log in -->
<html>
	<head>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans|Pacifico|Material+Icons" rel="stylesheet">
		<link href="../Formatting/login-styles.css" rel="stylesheet">
		<title>Campus Connect</title>
	</head>
	<body>
		<div id="login">
			<h1> Campus Connect!</h1>
			<form action="../PHPScripts/authenticate.php" method="post">
				<label for="email">Email: </label>
				<input type="email" name="email" placeholder="abc@uw.edu" required>
				<label for="password">Password: </label>
				<input type="password" name="password" placeholder="••••••••••" id="password" required>
				<button type="submit">Login</button>
				<!--<button id="register" formaction="register.php">Create Account</button>-->
			</form>
		</div>
	</body>
</html>