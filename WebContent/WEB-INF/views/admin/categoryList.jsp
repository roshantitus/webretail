<%@include file="/WEB-INF/views/include.jsp" %>

        <body>
        <!-- START ng-grid -->
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.2/angular.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.debug.js"></script>     
        <script type="text/javascript" src="<c:url value='/resources/admin/js/data_table.js'/>"></script>        
		<!-- END ng-grid -->   
		
				<h1>Categories</h1>
				
                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">Home</a></li>                    
                    <li class="active">Categories</li>
                </ul>
                <!-- END BREADCRUMB -->     
                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">             
                 	<div class="filler">
			        <div class="gridStyle" ng-grid="gridOptions"></div>
			                            
                </div>
                <!-- END PAGE CONTENT WRAPPER -->       

            </body>    