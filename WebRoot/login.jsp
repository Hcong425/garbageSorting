<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="apple-touch-icon" sizes="180x180"
	href="apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/flexslider.css">
<link rel="stylesheet" href="css/jquery.fancybox.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/animate.min.css">
<link href="css/font-awesome.css" rel="stylesheet">
<link
	href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>

<body>
<body>
	<section class="banner" role="banner">
		<header id="header">
			<div class="header-content clearfix">
				<a class="logo" href="#"><img src="images/logo.png" alt=""></a>
				<nav class="navigation" role="navigation">
					<ul class="primary-nav">
						<li><a href="#features">Features</a></li>
						<li><a href="#works">Works</a></li>
						<li><a href="#teams">Our Team</a></li>
						<li><a href="#testimonials">Testimonials</a></li>
						<li><a href="#download">Download</a></li>
					</ul>
				</nav>
				<a href="#" class="nav-toggle">Menu<span></span></a>
			</div>
			<!-- header content -->
		</header>
		<!-- header -->
		<div class="container">
			<div class="col-md-10 col-md-offset-1">
				<div class="banner-text text-center">
					<h1>Your Favorite One Page Multi Purpose Template</h1>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Praesent commodo cursus magna vel scelerisque nisl consectetur et.</p>
					<a class="btn btn-large" data-toggle="modal" data-target="#myModal">Find
						out more</a>

					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">登录</h4>
								</div>
								<div class="modal-body  row">
								<div id="alert">
								</div>
									<form class="form-horizontal" id="loginForm" action="manger_login" method="post">
										<div class="form-group">
											<label for="inputEmail3" class="col-sm-3 control-label">账号:
											</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="name"
													placeholder="Username">
											</div>
										</div>
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-3 control-label">密码:
											</label>
											<div class="col-sm-8">
												<input type="password" class="form-control" id="password"
													id="inputPassword3" placeholder="Password">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4 col-sm-offset-2">
												<div class="checkbox">
													<label> <input type="checkbox"> Remember me
													</label>
												</div>
											</div>
											<div class="col-sm-5" style="line-height:30px">
												<a>忘记密码</a>
											</div>
										</div>
										<div class="form-group">
											<div class=" col-sm-2 col-sm-offset-4">
												<button type="button" id="submit" class="btn btn-default">登录</button>
											</div>
											<div class="col-sm-2">
												<button type="reset" class="btn btn-default" id="reset">重置</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
	<!-- banner -->
	<section id="features" class="features section">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-6 feature text-center">
					<span class="icon icon-tools"></span>
					<div class="feature-content">
						<h5>Easily Customised</h5>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Nullam quis risus eget urna mollis ornare vel eu leo. Donec
							ullamcorper nulla non metus auctor fringilla.</p>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 feature text-center">
					<span class="icon icon-desktop"></span>
					<div class="feature-content">
						<h5>Responsive Ready</h5>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Nullam quis risus eget urna mollis ornare vel eu leo. Donec
							ullamcorper nulla non metus auctor fringilla.</p>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 feature text-center">
					<span class="icon icon-lightbulb"></span>
					<div class="feature-content">
						<h5>Modern Design</h5>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Nullam quis risus eget urna mollis ornare vel eu leo. Donec
							ullamcorper nulla non metus auctor fringilla.</p>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 feature text-center">
					<span class="icon icon-genius"></span>
					<div class="feature-content">
						<h5>Clean Code</h5>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Nullam quis risus eget urna mollis ornare vel eu leo. Donec
							ullamcorper nulla non metus auctor fringilla.</p>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 feature text-center">
					<span class="icon icon-briefcase"></span>
					<div class="feature-content">
						<h5>Ready to Ship</h5>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Nullam quis risus eget urna mollis ornare vel eu leo. Donec
							ullamcorper nulla non metus auctor fringilla.</p>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 feature text-center">
					<span class="icon icon-download"></span>
					<div class="feature-content">
						<h5>Download for Free</h5>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Nullam quis risus eget urna mollis ornare vel eu leo. Donec
							ullamcorper nulla non metus auctor fringilla.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- features -->
	<div class="copyrights">
		Collect from <a href="http://www.cssmoban.com/">网页模板</a>
	</div>

	<footer class="footer">
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="footer-col col-md-4">
						<h5>Location</h5>
						<p>
							3481 Melrose Place<br>Beverly Hills, CA 90210
						</p>
					</div>
					<div class="footer-col col-md-4">
						<h5>Share with Love</h5>
						<ul class="footer-share">
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="https://twitter.com/kamal_chaneman"><i
									class="fa fa-twitter"></i></a></li>
							<li><a href="https://www.linkedin.com/in/kamalchaneman"><i
									class="fa fa-linkedin"></i></a></li>
							<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
						</ul>
					</div>
					<div class="footer-col col-md-4">
						<h5>About ActiveBox</h5>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec ullamcorper nulla non metus auctor fringilla.</p>
					</div>
				</div>
			</div>
		</div>
		<!-- footer top -->
		<div class="footer-bottom">
			<div class="container">
				<div class="col-md-12">
					<p>
						Copyright © 2015 ActiveBox. All Rights Reserved<br>Made with
						by Kamal Chaneman. More Templates <a
							href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
						- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
							target="_blank">网页模板</a>
					</p>
				</div>
			</div>
		</div>

<!-- 		<script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>')
		</script> -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.flexslider-min.js"></script>
		<script src="js/jquery.fancybox.pack.js"></script>
		<script src="js/jquery.waypoints.min.js"></script>
		<script src="js/retina.min.js"></script>
		<script src="js/modernizr.js"></script>
		<script src="js/main.js"></script>
</body>
</html>
