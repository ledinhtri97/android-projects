
<?php

include '../connect_database.php'; 

$daily = "SELECT points FROM tracker WHERE (username ='yashDev' AND date=CURRENT_DATE() AND type = 'Daily Checkin Credit')";

$dai_result = $connect->query($daily);
$se = $dai_result->fetch_assoc();
//echo $se["points"];

$y = "20".date('y-m-d');
//echo $y;


if($se["points"] == "12"){

echo 'has';

}else{

echo 'not has';

}


?>