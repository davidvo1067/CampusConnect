<?php
//codes the banner, (non-implemented) search bar, and side-bar with quicklinks

if (session_status() != PHP_SESSION_ACTIVE) {
	session_start();
}

if(!isset($_SESSION['loggedin'])) {
	header("Location: /../Content/login.php");
	exit();
}
?>

<!DOCTYPE html>
<html>
	<head>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans|Pacifico|Material+Icons" rel="stylesheet">
		<link href="../Formatting/styles.css" rel="stylesheet">
		<title>Campus Connect</title>
	</head>
	<body>
		<div id="header">
			Campus Connect!
			<div id="search">
				<form action="search.php">
					<input type="text" placeholder="Search..." name="keyword">
					<button type="submit"><i class="material-icons">search</i></button>
				</form>
			</div>
		</div>
		
		<div id="sidebar">
			<ul>
				<li><a href="home.php">Home</a></li>
				<li><a href="events.php">Events</a></li>
				<li><a href="groups.php">Groups</a></li>
				<li><a href="calendar.php">Calendar</a></li>
				<li><a href="classes.php">Classes</a></li>
				<li><a href="profile.php">Profile</a></li>
				<li><a href="messages.php">Messages</a></li>
				<li><a href="../PHPScripts/logout.php">Log Out</a></li>
			</ul>
		</div>
		<div id="content">