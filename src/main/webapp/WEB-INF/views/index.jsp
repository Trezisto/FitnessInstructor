<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Fitness Instructor</title>
<spring:url value="/css/bootstrap.min.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
<spring:url value="/css/bootstrap-theme.min.css" var="bootstrapTheme" />
<link href="${bootstrapTheme}" rel="stylesheet" />

<spring:url value="/js/jquery-2.2.0.min.js" var="jQuery" />
<script src="${jQuery}"></script>
<spring:url value="/js/bootstrap.min.js" var="bootstrapJS" />
<script src="${bootstrapJS}"></script>
<spring:url value="/js/angular.min.js" var="angularJS" />
<script src="${angularJS}"></script>
</head>
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Fitness Instructor</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#about">Training</a></li>
							<li><a href="#contact">Agenda</a></li>							
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Cabinet <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li role="separator" class="divider"></li>
									<li class="dropdown-header">Nav header</li>
									<li><a href="#">Separated link</a></li>
									<li><a href="#">One more separated link</a></li>
								</ul></li>
								<li><a href="#cabinet">Cabinet</a></li>
								<li><a href="#signUp">Sign up</a></li>
								<li><a href="#login">Log in</a></li>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>	
	<p>About</p>
	<p>Contact</p>
</body>
</html>
