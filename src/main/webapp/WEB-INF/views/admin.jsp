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
	    
	</head>
	<body>
		<p>Admin page :)</p>
	</body>
</html>
    