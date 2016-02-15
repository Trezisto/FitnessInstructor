<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Fitness Instructor</title>
<spring:url value="/css/bootstrap.min.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
<spring:url value="/css/bootstrap-theme.min.css" var="bootstrapTheme" />
<link href="${bootstrapTheme}" rel="stylesheet" />
<spring:url value="/css/main.css" var="mainCSS" />
<link href="${mainCSS}" rel="stylesheet" />

<spring:url value="/js/jquery-2.2.0.min.js" var="jQuery" />
<script src="${jQuery}"></script>
<spring:url value="/js/bootstrap.min.js" var="bootstrapJS" />
<script src="${bootstrapJS}"></script>

    <!-- IE required polyfill -->
    <spring:url value="/js/es6-shim.min.js" var="es6Shim" />
    <script src="${es6Shim}"></script>

	<!-- TODO: replace with .min version in production env -->
	<spring:url value="https://code.angularjs.org/2.0.0-beta.6/angular2-polyfills.js" var="angular2Polyfills" />
    <script src="${angular2Polyfills}"></script>
    <spring:url value="https://code.angularjs.org/2.0.0-beta.6/Rx.umd.js" var="Rx" />
    <script src="${Rx}"></script>
    <spring:url value="https://code.angularjs.org/2.0.0-beta.6/angular2-all.umd.js" var="angular2All" />
    <script src="${angular2All}"></script>    
    
    <spring:url value="/js/app/app.component.js" var="appComponent" />
    <script src='${appComponent}'></script>
    <spring:url value="/js/app/main.js" var="mainJs" />
    <script src='${mainJs}'></script>

<spring:url value="/images/header1.png" htmlEscape="true" var="header1"/>
<spring:url value="/images/header2.png" htmlEscape="true" var="header2"/>
<spring:url value="/images/header3.png" htmlEscape="true" var="header3"/>
</head>
<body>
	<!-- NAVIGATION BAR -->
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
	
	<!-- CAROUSEL -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active logoCarousel">
          <img class="first-slide logoCarousel" src="${header1}" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Train correctly on your one's own!</h1>
              <p>Choose a plan and be sure that you will achieve great results</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
            </div>
          </div>
        </div>
        <div class="item logoCarousel">
          <img class="second-slide logoCarousel" src="${header2}" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Develop yourself according to science-based recommendations!</h1>
              <p>Your will get personal program related to your personal characteristics and the best recognized techniques</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
            </div>
          </div>
        </div>
        <div class="item logoCarousel">
          <img class="third-slide logoCarousel" src="${header3}" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>It's time to be always prepared!</h1>
              <p>Don't forget about mobile application and be flexible as never before!</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Download app</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>	
    <div class="form-group auth-form">
    	<input type="email" placeholder="Email" class="form-control" />
    	<input type="password" placeholder="Password" class="form-control" />
    	<button type="button" class="btn btn-lg btn-success">Sign up</button>
    </div>
    <div class="form-group auth-form">
    	<input type="email" placeholder="Email" class="form-control" />
    	<input type="password" placeholder="Password" class="form-control" />
    	<button type="button" class="btn btn-lg btn-success">Log in</button>
    </div>
    
	<p>About</p>
	<p>Contact</p>
	<my-app>Loading...</my-app>
</body>
</html>
