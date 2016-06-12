<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wooden Impressions - Interiors</title>
<link rel="stylesheet" href="screen.css" type="text/css" media="screen" />
<link type="text/css" media="screen" href="sample.css" rel="stylesheet">
<script src="https://maps.googleapis.com/maps/api/js"></script>

<link href="http://fonts.googleapis.com/css?family=Raleway:200,100,400"
	rel="stylesheet" type="text/css" />

<style>
footer {
	bottom: auto;
}

#map-canvas {
	width: 530px;
	height: 400px;
}

#mysubmitbtn {
	padding: 10px 110px;
	color: #000000;
	cursor: pointer;
}

#custom_spacing {
	padding-right: 20px;
}

#custom_spacing1 {
	padding-right: 22px;
}

#username,#emailid,#msg,#code {
	color: #000;
}
</style>
<script>
	function initialize() {
		var myLatlng = new google.maps.LatLng(19.186941, 72.96109);
		var mapOptions = {
			zoom : 15,
			center : myLatlng,
		//mapTypeId: google.maps.MapTypeId.HYBRID
		}
		var map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);

		var marker = new google.maps.Marker({
			position : myLatlng,
			map : map,
			title : 'Hallmark Interiors'
		});
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>

</head>
<body background="images/golden_yellow.jpg" marginwidth="85%">
	<!-- Lightbox usage markup -->

	<font color="#FFA54A">
		<table background="images/bgBrown.jpg" width=100%>
			<tr>
				<td>

					<h1 class="site-title">
						<div align="Center">Wooden Impressions</div>
					</h1>
					<p>
					<div align="Center">Punches of Color Keeps a room feeling
						youthful and engaging</div>
					</p>
				</td>
			</tr>
		</table>
	</font>


	<div id="navigation">

		<nav id="site-navigation" class="main-navigation smallPart"
			role="navigation">
		<button class="menu-toggle">
			Menu<i class="fa fa-align-justify"></i>
		</button>
		<div class="menu-menu-1-container">
			<ul id="menu-menu-1" class="menu">
				<li id="menu-item-108"
					class="menu-item menu-item-type-custom menu-item-object-custom menu-item-108"><a
					title="glyphicon-home" href="test1.jsp">Home</a></li>

				<li id="menu-item-69"
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-69"><a
					href="portfolio.jsp">Portfolio</a></li>
				<li id="menu-item-62"
					class="menu-item menu-item-type-taxonomy menu-item-object-category current-post-ancestor current-menu-parent current-post-parent menu-item-has-children menu-item-62"><a
					href="#">Home Decor</a>
					<ul class="sub-menu">
						<li id="menu-item-56"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-56"><a
							href="bathroom.jsp">Bathroom</a></li>

						<li id="menu-item-57"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-57"><a
							href="bedroom.jsp">Master Bedroom</a></li>
						<li id="menu-item-571"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-571"><a
							href="childbedroom.jsp">Child Bedroom</a></li>

						<li id="menu-item-63"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-63"><a
							href="kitchen.jsp">Kitchen</a></li>
						<li id="menu-item-64"
							class="menu-item menu-item-type-taxonomy menu-item-object-category current-post-ancestor current-menu-parent current-post-parent menu-item-64"><a
							href="livingroom.jsp">Living Room</a></li>
					</ul></li>

				<li id="menu-item-68"
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-has-children menu-item-68"><a
					href="#">Top</a>
					<ul class="sub-menu">
						<li id="menu-item-78"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-78"><a
							href="fashiondiy.jsp">Fashion DIY</a></li>
						<li id="menu-item-73"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-73"><a
							href="animals.jsp">Animals</a></li>
						<li id="menu-item-77"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-77"><a
							href="photography.jsp">PET ROOM</a></li>
						<li id="menu-item-60"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-60"><a
							href="drinks.jsp">Food &#038; Drinks</a></li>
					</ul></li>
				<li id="menu-item-76"
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-has-children menu-item-76"><a
					href="#">Outdoors</a>
					<ul class="sub-menu">
						<li id="menu-item-74"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-74"><a
							href="gardens.jsp">Gardens</a></li>
						<li id="menu-item-75"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-75"><a
							href="outdoorfurniture.jsp">Outdoor Furniture</a></li>
					</ul></li>
				<li id="menu-item-58"
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-58"><a
					href="contactus.jsp">Contact-US</a></li>
			</ul>
		</div>
		</nav>
	</div>

	<div>
	<table width="5%">
	</table>
		<table width="65%">
			<tr>
				<td width="5%"></td>
				<td width="85%"><font
					style="font-family: FontHallmark; font-size: 16px; color: #235645">
						<div>
							<font style="font-family: FontHallmark; font-size: 28x;">
								<B><u>ABOUT : </u> </B>
							</font>
						</div> <br> Stark Interiors is your One Stop Solution Provider for
						Interior Design, Project Management & Renovation Services in
						Chennai. The company provides interior design and consultancy
						services and turnkey installations for various type of projects,
						including corporate and housing sectors. Stark Interiors has its
						Corporate Office, and Factory in Chennai with branch offices in
						Kerala. Our current projects includes Residential Bungalows in
						ECR, Villas and individual Apartments in Chennai.
				</font></td>
				<td width="10%">
					
				</td>
			</tr>
		</table>
		<table width="30%">
		<tr>
				<td width="5%"></td>
				<td width="85%">
				<!-- thumbnail image wrapped in a link -->
					<div>
						<iframe width="450" height="250"
							src="https://www.youtube.com/embed/Aqb0KVAhtvk?autoplay=1">
						</iframe>
						
					</div>
				</td>
				<td width="10%">
		</table>
	</div>

	<table>
		<tr>
			<td width=5%></td>
			<td width=20%>
				<div class="contact">
					<img src="images/ContactUs.JPG" alt"Contact Us" width=100%
						height=20px></img><br> <font
						style="font-family: FontHallmark; font-size: 16px;"> <font
						style="font-family: FontHallmark; font-size: 25px;"><B><u>Quick
									Contact : </u> </B> </font> <br> #132, Sterling road,<br>
						Nungambakkam, <br> Chennai-600 034. <br> Phone: +91
						98845 - 46149, +91 90430- 02990 <br>Email:
						info@starkinteriors.in, starkinteriors@yahoo.com
					</font>
				</div> <br>
				<div style="float: left; margin-top: -25px; margin-right: 58px;">
					<a
						href="https://www.facebook.com/pages/Hallmark-Interior-Lifestyles-Pvt-Ltd/160382810701437?ref=hl"
						target="_blank"> <img src="images/f.png" alt="" height="30"
						width="30">
					</a> <a
						href="https://twitter.com/search/realtime?q=%40hallmarkveena&src=typd"
						target="_blank"> <img src="images/t.png" alt="" height="31"
						width="32">
					</a>
				</div>
			</td>
			<td width=50%>
				<div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<img src="images/testimonial_original.jpg"
						alt"Testimonials" width=447 height=100></img>

					<marquee direction="up" style="margin-top: 10px;" scrollamount="5"
						onMouseOver="this.stop();" onMouseOut="this.start();"
						height="280px;">
						<ul>
							<li style="border-bottom: 1px solid #ccc;"><b><font
									style="font-family: FontHallmark; font-size: 16px;">Omron
										Automation India Private Limited</font> </b> <br> <br>
								<p>
									We are extremely satisfied with the design and execution of our
									new office at Andheri (east). I would also put on record that
									the project was delivered well within the committed timeline. <br>
									We would certainly like to engage Hallmark Interiors again for
									our future offices and would recommend them highly to others. <br>
									We wish you good luck. <br> <br> <strong>-
										Sanjeev Bhatia</strong>
								</p></li>

							<li style="border-bottom: 1px solid #ccc; padding-top: 15px;">
								<b><font style="font-family: FontHallmark; font-size: 16px;">Sands
										Hotel Pvt Ltd</font> </b> <br> <br>
								<p>
									We hereby confirm that our appointed Interior Designers,
									Hallmark Interior Lifestyles Pvt Ltd and its recommended team
									of vendors have completed the Interior Designing, consulting
									and execution of renovation of 32 rooms, corridors, lobby,
									conference rooms, external canopy, staircase etc. to our
									satisfaction as agreed. <br> <br> <strong>-
										Krishnamurthy I </strong>
								</p>
							</li>

						</ul>
					</marquee>
				</div>
			</td>
			<td width=25%>
				<div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="images/clients.jpg"
						alt"Our Clients" width=247 height=180></img>

					<marquee direction="up" style="margin-top: 10px;" scrollamount="5"
						onMouseOver="this.stop();" onMouseOut="this.start();"
						height="380px;">
						<ul>
							<li style="border-bottom: 1px solid #ccc;"><img
								src="images/casaGrande.jpg" alt"Casa Grande" width=100%
								height=30px></img></li>

							<li style="border-bottom: 1px solid #ccc; padding-top: 15px;">
								<img src="images/casaGrande.jpg" alt"Casa Grande" width=100%
								height=30px></img>
							</li>

						</ul>
					</marquee>
			</td>
		</tr>
	</table>


	<br>
	<h2 align="left">
		<font style="font-family: FontHallmark; font-size: 25px;"><B><u>FIND
					US : </u> </B> </font>
	</h2>
	<div id="map-canvas"></div>

	<div>Copyright &copy; 2015 &bull; DhineshKumar & Krishnamoorthy
		associates, Architects Chennai India, Interior Designers Chennai India
		&bull; All rights reserved &bull;</div>



</body>
</html>
<script src="https://maps.googleapis.com/maps/api/js"></script>
