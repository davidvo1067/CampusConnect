<?php 
session_start();
include_once 'ccfunctions.php';
include 'header.php';

$bioid = (isset($_POST['profileid'])?: $_SESSION['userid'];
?>
			<div id="profile">
				<div id="about">
					<div id="pic">
						<img>
						<div id="quick-icons">
							<img class="profile-pic" src="harryProfile.jpg" alt="Profile picture" height="200px" width="200px">
						</div>
					</div>
					<div id="summary">
						<h1><?= $_SESSION['name']; ?></h1>
						<p><?= $_SESSION['major']; ?></p>
						<p><?= getBio($_SESSION['userid']); ?></p>
					</div>
				</div>
				<div id="feed">
					<p>Pretending there's a feed</p>
					<p>Yup totally a feed</p>
				</div>
			</div>
<?php include 'footer.php'; ?>