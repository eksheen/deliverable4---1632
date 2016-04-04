<?php
	$db = new mysqli('localhost','ContactDB','password','ContactDB');

	if($db->connect_errno > 0) {
    	die('Unable to connect to database [' . $db->connect_error . ']');
	}

$formName = $_POST["name"];
$formEmail = $_POST["email"];
$formInquiry = $_POST["inquiry"];

echo $formName . "<br/>";
echo $formEmail . "<br/>";
echo $formInquiry . "<br/>";

//$result = $db->query("drop table Contact");
$createTable = $db->query("CREATE TABLE Contact_form (
						  contact_form_id int(10) not null auto_increment,
					      name varchar(30) not null,
					      email varchar(30) not null,
					      inquiry TEXT not null,
						  PRIMARY KEY( contact_form_id ))");

$query = "INSERT INTO Contact_form (name, email, inquiry) VALUES ('$formName', '$formEmail', '$formInquiry')";
$db->query($query) or die ("Invalid insert " . $db->error);

echo "<h3>Here is your data:</h3>"; //this bit of code courtesy of setCDs.php
  		$query = "SELECT * from Contact_form";
  		$result = $db->query($query);
  		$rows = $result->num_rows;
  		for ($i = 0; $i < $rows; $i++):
  			$row = $result->fetch_array();
  			foreach ($row as $key=>$val):
  				echo "$key:$val  " . "<br/>";
  			endforeach;
  			echo "<br/>";
  		endfor;

// use javascript to update page to say thank you?
// or just create another thank you for submission HTML page
?>