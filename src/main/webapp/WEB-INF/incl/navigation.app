<!-- Navigation bar -->
<div id="navibar">
	<div id="navi-logo">LOGO</div>
	<div id="db-label"><label>Dashboard</label></div>
	<div class="navi-tiles">
		<a href="/catalog">Catalog</a>
    </div><br>
 	<div class="navi-tiles">
        <a href="/construction-site">Construction Sites</a>
    </div><br>
	<div class="navi-tiles">
        <a href="/orders">Order</a>
    </div><br>
    <div class="navi-tiles">
        <a href="/liabilities">Liabilities</a>
    </div><br>
    <sec:authorize access = "hasRole('ROLE_ADMIN')">
   		<div class="navi-tiles">
        	<a href="/admin">Admin Dashboard</a>
		</div>
	</sec:authorize>
	
</div>