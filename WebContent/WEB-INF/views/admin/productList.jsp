<%@include file="/WEB-INF/views/include.jsp" %>

				<h1>Products</h1>
				
                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">Home</a></li>                    
                    <li class="active">Products</li>
                </ul>
                <!-- END BREADCRUMB -->     
                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">      
                       
				<div ng-controller="ProductController">                      
			        <div class="gridStyle" ng-grid="gridOptions"></div>
			    </div>                       
                </div>
                <!-- END PAGE CONTENT WRAPPER -->                       