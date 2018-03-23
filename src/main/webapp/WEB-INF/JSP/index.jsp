<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="nl">
	<head>
		<title>Frituur Frida</title>
		<link rel='icon' href='images/frida.ico' type='images/x-icon'>
		<meta name='viewport' content='width=device-width,intitial-scale=1'>
		<link rel='stylesheet' href='css/frituurfrida.css'>
	</head>
	<body>
		<h1>Welkom bij Frituur Frida</h1>
		<img src="images/${openOfGesloten}.png">
		<h2>Adres</h2>
		${adres.straat} ${adres.huisNr}<br>
		${adres.gemeente.postcode} ${adres.gemeente.naam}
	</body>
</html>