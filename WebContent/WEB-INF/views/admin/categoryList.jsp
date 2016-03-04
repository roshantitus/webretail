<%@include file="/WEB-INF/views/include.jsp" %>
		
				<h1>Categories</h1>
				
                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">Home</a></li>                    
                    <li class="active">Categories</li>
                </ul>
                <!-- END BREADCRUMB -->     
                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">      
                       
					<div ng-controller="ViewAllCategoriesController">                      
				        <div class="gridStyle" ng-grid="gridOptions"></div>
				    </div>
			                
                </div>
                <!-- END PAGE CONTENT WRAPPER -->       
 