<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href="<%=request.getContextPath()%>/assets/plugins/images/favicon.png">
<title>Pixel Admin</title>
<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/assets/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Menu CSS -->
<link
	href="<%=request.getContextPath()%>/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<!-- animation CSS -->
<link href="<%=request.getContextPath()%>/assets/css/animate.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/assets/css/style.css"
	rel="stylesheet">
<!-- color CSS -->
<link
	href="<%=request.getContextPath()%>/assets/css/colors/blue-dark.css"
	id="theme" rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/./css/custom.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>



	<!-- Preloader -->
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top m-b-0">
			<div class="navbar-header">
				<a class="navbar-toggle hidden-sm hidden-md hidden-lg "
					href="javascript:void(0)" data-toggle="collapse"
					data-target=".navbar-collapse"> <i class="fa fa-bars"></i>
				</a>
				<div class="top-left-part">
					<a class="logo" href="<%=request.getContextPath()%>/home"> <b> <img
							src="<%=request.getContextPath()%>/assets/plugins/images/pixeladmin-logo.png" alt="home" />
					</b> <span class="hidden-xs"> <img
							src="<%=request.getContextPath()%>/assets/plugins/images/pixeladmin-text.png" alt="home" />
					</span>
					</a>
				</div>
				<ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
					<li>
						<form role="search" class="app-search hidden-xs">
							<input type="text" placeholder="Search..." class="form-control">
							<a href=""> <i class="fa fa-search"></i>
							</a>
						</form>
					</li>
				</ul>
				<ul class="nav navbar-top-links navbar-right pull-right">
					<li>
						<div class="dropdown">
							<a class="profile-pic dropdown-toggle" data-toggle="dropdown"
								href="#"> <img src="<%=request.getContextPath()%>/assets/plugins/images/users/varun.jpg"
								alt="user-img" width="36" class="img-circle" /> <b
								class="hidden-xs">Cybersoft</b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="profile.html">Th??ng tin c?? nh??n</a></li>
								<li><a href="#">Th???ng k?? c??ng vi???c</a></li>
								<li class="divider"></li>
								<li><a href="<%= request.getContextPath() %>/logout">????ng xu???t</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
			<!-- /.navbar-header -->
			<!-- /.navbar-top-links -->
			<!-- /.navbar-static-side -->
		</nav>
		<!-- Left navbar-header -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse slimscrollsidebar">
				<ul class="nav" id="side-menu">
					<li style="padding: 10px 0 0;"><a href="<%=request.getContextPath()%>/home"
						class="waves-effect"><i class="fa fa-clock-o fa-fw"
							aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a></li>
					<li><a href="<%=request.getContextPath()%>/listusers" class="waves-effect"><i
							class="fa fa-user fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Th??nh vi??n</span></a></li>
					<li><a href="<%=request.getContextPath()%>/roles" class="waves-effect"><i
							class="fa fa-modx fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Quy???n</span></a></li>
					<li><a href="<%=request.getContextPath()%>/project" class="waves-effect"><i
							class="fa fa-table fa-fw" aria-hidden="true"></i><span
							class="hide-menu">D??? ??n</span></a></li>
					<li><a href="<%=request.getContextPath()%>/listtask" class="waves-effect"><i
							class="fa fa-table fa-fw" aria-hidden="true"></i><span
							class="hide-menu">C??ng vi???c</span></a></li>
					
				</ul>
			</div>
		</div>
		<!-- Left navbar-header end -->
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Th??m m???i th??nh vi??n</h4>
					</div>
				</div>
				<!-- /.row -->
				<!-- .row -->
				<div class="row">
					<div class="col-md-2 col-12"></div>
					<div class="col-md-8 col-xs-12">
						<div class="white-box">
							<form action="" method="post"
								class="form-horizontal form-material">
								<div class="form-group">
									<label class="col-md-12">Full Name</label>
									<div class="col-md-12">
										<input name="fullname" placeholder="Full name"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<label for="example-email" class="col-md-12">Email</label>
									<div class="col-md-12">
										<input placeholder="Email"
											class="form-control form-control-line" name="email"
											id="example-email">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Password</label>
									<div class="col-md-12">
										<input type="password" name="password"
											class="form-control form-control-line">
									</div>
								</div>
								
								<div class="form-group">
                                    <label class="col-md-12">Address</label>
                                    <div class="col-md-12">
                                        <input type="address" name="address"
                                            class="form-control form-control-line"> </div>
                                </div>
								
								<div class="form-group">
                                    <label class="col-md-12">Phone Number</label>
                                    <div class="col-md-12">
                                        <input type="phone"  name="phone"
                                            class="form-control form-control-line"> </div>
                                </div>
                             
                                
								
								<div class="form-group">
									<label for="role_id">Role Id:</label> <select id="role"
										name="role_id" data-toggle="select" class="form-control">
										<option value="1">ADMIN</option>
										<option value="2">LEADER</option>
										<option value="3">MEMBER</option>
									</select>
								</div>


								<div class="form-group">
									<div class="col-sm-12">
										<button type="submit" class="btn btn-success">Add
											User</button>
										<a class="btn btn-secondary" href="<%=request.getContextPath()%>/listusers" >Quay l???i</a>
									</div>
								</div>

							</form>
						</div>
					</div>
					<div class="col-md-2 col-12"></div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
			<footer class="footer text-center"> 2018 &copy; myclass.com
			</footer>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script src="assets/plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="assets/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src="assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
	<!--slimscroll JavaScript -->
	<script src="assets/js/jquery.slimscroll.js"></script>
	<!--Wave Effects -->
	<script src="assets/js/waves.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="assets/js/custom.min.js"></script>
</body>

</html>