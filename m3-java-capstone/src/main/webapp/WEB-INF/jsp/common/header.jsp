<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/npgeek.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">

</head>

<body>

<c:url value="/" var="homeHref"/>
<a href ="${homeHref}"><img id="header-image" src="img/logo.png"/></a>