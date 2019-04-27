<?php
//logs the user out

if (session_status() != PHP_SESSION_ACTIVE) {
    session_start();
}
    session_destroy();
    $_SESSION = array();
    header('Location: ../Content/login.php');
    exit();
?>