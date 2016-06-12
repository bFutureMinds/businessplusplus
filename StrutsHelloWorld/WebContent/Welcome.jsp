<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Welcome to HDFC Bank NetBanking</title>
<style>
mark { 
    background-color: #568988;
    color: yellow;
}
</style>
</head>
<body marginwidth="0" marginheight="0">
	<form class="width" method="post" action="entry" name="frmAcctList">
		
		<font color="#FFA54A" size="12">
			<table bgcolor="#FFFFFF" width=100%>
				<tr>
					<td>

						<h1 class="site-title">
							<div align="Center">
								<font color="#2CA6DF"> Barclays</font> <br> <a
									href="/personal" alt="Link title"
									aria-label="Barclaycard logo - link to Barclaycard home page">
									<img class="logo-img" alt="Link title"
									src="images/barclaycard-logo.png">
								</a>
							</div>
						</h1>


					</td>
				</tr>
							</table>
		</font>
		
		
		 <br>

		<div class="topHeader">
		
			<h1 class="pull-left PSMHeader">Financial Summary</h1>
			
			<p style="margin: 16px 0 0 10px" class="print"><font  size="4"><mark>
			It seems your credit card limit is insufficient for your upcoming transactions, 
				<a href="reg.jsp">Click here </a>  for the quick solution without increasing your credit limit.
			</mark></font></p>
			<div style="clear: both;"></div>
			<p></p>
			
		</div>
		<table class="" border="0" cellspacing="0" width="90%">
			<tbody>
				<tr>
					<td colspan="5" class="blueHeader">


						<h2>
							Howdy,
							<s:property value="username" />
							...!
						</h2> <span>Holdings (What you have)</span>
					</td>
				</tr>
			</tbody>
		</table>

		<table style="border-bottom: 1px solid #ced2df;" cellspacing="0"
			border="0" width="90%" class="datatable landTable">
			<tbody>
				<tr onclick="return toggleSavingAcctListDiv()">
					<td colspan="5" class="PSMSubHeader"><span
						style="float: left;" class="tableHeaderPSM">Savings Account</span><span
						style="float: right;" class="tableHeaderPSM"><a
							style="text-decoration: none;" href="javascript:void(0)">
								&nbsp;&nbsp;&nbsp;
						</a></span><span id="SavingTotalSummary" style="float: right;"
						class="tableHeaderPSM">Total Available Balance: INR
							101,329.84</span></td>
				</tr>
				<script language="JavaScript">
					if (document.getElementById('SavingTotalSummary') != null) {
						document.getElementById('SavingTotalSummary').innerHTML = 'Total Available Balance: '
								+ ' INR ' + totalSavingAcct;
					}
				</script>
				<tr class="hideSavingAccts">
					<td style="border-bottom: 0 none" class="darkrow" width="20%"><span
						class="headingLable">Account No.</span><a
						onclick="return sendReq('50100090112362  ')"
						href="javascript:void(0)">50100090112362 </a></td>
					<td style="border-bottom: 0 none" class="darkrow" width="22%"><span
						class="headingLable">Branch</span><span>HINJAWADI</span></td>
					<td style="border-bottom: 0 none" class="darkrow" width="28%"><span
						class="headingLable">Name</span><span>GOPINATH V</span> <br>
					</td>
					<td style="border-bottom: 0 none" class="darkrow" width="20%"><span
						class="headingLable">Available Balance</span><span class="othcurr">INR&nbsp;<script
								language="JavaScript">
							document.write(formatAmount("101329.84"));
						</script>101,329.84
					</span></td>
					<td style="border-bottom: 0 none" class="darkrow" align="center"
						width="10%"><a class="viewBtnGrey"
						onclick="return miniStatement('50100090112362  ')"
						href="javascript:void(0)"></a></td>
				</tr>
				
				<tr>
					<td>
						<div>
						
							<div><br><br><br><br><br><br><br><br>Copyright &copy; 2015 &bull; Barclaycard US &
								 associates&bull; All rights reserved &bull;</div>

						</div>
					</td>

				</tr>
				
			</tbody>
		</table>
	</form>


	<embed type="application/x-dap-background" id="DAPPlugin"
		style="visibility: collapse">
</body>
</html>