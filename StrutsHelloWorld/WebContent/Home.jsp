<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>CAR APPLICATION</title>
    <link type="text/css" media="screen" href="http://www.appelsiini.net/css/appelsiini.css" rel="stylesheet">
  <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet">
  <link rel="shortcut icon" href="http://www.appelsiini.net/img/favicon.ico">
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->
  <script>
//<![CDATA[
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-190966-1']);
_gaq.push(['_trackPageview']);
(function() {
  var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
  ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
  var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();
//]]>

  </script>
   <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="http://www.appelsiini.net/projects/lazyload/jquery.lazyload.js?v=1.9.1"></script>
  <script src="http://www.appelsiini.net/js/all.js"></script>
  <script type="text/javascript" charset="utf-8">
  $(function() {
     $("img.lazy").lazyload();
  });
  </script>
  <style type="text/css">
    .container img {
      margin-bottom: 10px;
    }
  </style>
  <script src="lightbox.js"></script>
  <script type="text/javascript">
        var started;
  function showLightBox() 
  { 
    if (started) return;
    started = setTimeout(function(){
        Lightbox.start(document.getElementById('firstImage'));
        started;
    },500);
  }
</script>
</head>


<body bgcolor="#ffffff" onLoad="javascript:showLightBox()">
    <center>
        <h1>CAR APPLICATION</h1>
    </center>
    
    <a class="vlightbox1" href="images/1.jpg" title="10" id="firstImage">
   <img src="images/1.jpg" alt="10"/>
   </a>
      
  <div class="container">
    <div class="col-md-10 col-lg-8 col-md-offset-1 col-lg-offset-2">
      
      <h2>Plugin enabled</h2>
      <p>
        Images below the fold (the ones lower than window bottom) are not loaded. When scrolling down
        they are loaded when needed. Empty cache and shift-reload to test again. Compare this to page 
        where plugin is <a href="disabled.html">disabled</a>, same page with 
        <a href="enabled_fadein.html">fadein effect</a>,  page with <a href="enabled_wide.html">wide 
        layout</a> or wide content <a href="enabled_wide_container.html">inside container</a>.
      </p>

      <pre class="prettyprint">$("img.lazy").lazyload();</pre>
      <pre class="prettyprint">&lt;img class="lazy" data-original="1.jpg" width="765" height="574"&gt;</pre>

      <div id="container">
        <img class="lazy img-responsive" data-original="images/2.jpg" width="765" height="574" alt="BMW M1 Hood"><br/>
        <img class="lazy img-responsive" data-original="images/3.jpg" width="765" height="574" alt="BMW M1 Side"><br/>
        <img class="lazy img-responsive" data-original="images/4.jpg" width="765" height="574" alt="Viper 1"><br/>
        <img class="lazy img-responsive" data-original="images/5.jpg" width="765" height="574" alt="Viper Corner"><br/>
        <img class="lazy img-responsive" data-original="images/6.jpg" width="765" height="574" alt="BMW M3 GT"><br/>
        <img class="lazy img-responsive" data-original="images/7.jpg" width="765" height="574" alt="Corvette Pitstop"><br/>      
      </div>
    </div>
  </div>
  
    

    <table border="5" bordercolor="red" align="center">
        <tr>
            <th colspan="3">SONAKSHI RAINA 10B ROLL No:-32</th> 
        </tr>
        <tr>
            <th>Name</th>
            <th>Origin</th>
            <th>Photo</th>
        </tr>
        <tr>
            <td>Bugatti Veyron Super Sport</td>
            <td>Molsheim, Alsace, France</td>
                    <!-- considering it is on the same folder that .html file -->
            <td  background="images/1.jpg" width =100 height=100> </td>
        </tr>
        <tr>
            <td>SSC Ultimate Aero TT  TopSpeed</td>
            <td>United States</td>
            <td  background="images/2.jpg" width =100 height=100> </td>
        </tr>
        <tr>
            <td>Koenigsegg CCX</td>
            <td>Ängelholm, Sweden</td>
            <td  background="images/3.jpg" width =100 height=100> </td>
        </tr>
        <tr>
            <td>Saleen S7</td>
            <td>Irvine, California, United States</td>
            <td  background="images/4.jpg" width =100 height=100> </td>
        </tr>
        <tr>
            <td> McLaren F1</td>
            <td>Surrey, England</td>
            <td  background="images/5.jpg" width =100 height=100> </td>
        </tr>
        <tr>
            <td>Ferrari Enzo</td>
            <td>Maranello, Italy</td>
            <td  background="images/6.jpg" width =100 height=100> </td>
        </tr>
        <tr>
            <td> Pagani Zonda F Clubsport</td>
            <td>Modena, Italy</td>
            <td  background="images/7.jpg" width =100 height=100> </td>
        </tr>
    </table>
    
    
</body>
<html>