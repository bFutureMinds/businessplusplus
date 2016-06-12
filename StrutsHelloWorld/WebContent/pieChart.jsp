<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Application Chart</title>
<script type="text/javascript">
	function refreshPage() 
	{
		document.forms.formId.submit();
	}
</script>
</head>
<body>

	
	<table class="" border="0" cellspacing="0" width="90%">
			<tbody>
				<tr>
					<td colspan="5" class="blueHeader">


						<h2>
							Hi Admin : sfs
							...!
						</h2> <span>Holdings (What you have)</span>
					</td>
				</tr>
			</tbody>
		</table>
	<h3>Create Pie Chart Dynamically using JFreechart</h3>
	<%
		response.setIntHeader("Refresh", 1);
	%>
	<img src="pie1/displayChart" />
	<form id="formId">
		<input type="button" onclick="refreshPage()" value="Refresh Page" />
		<br /> 
	</form>
	
	

	
</body>
</html>