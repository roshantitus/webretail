<%@include file="/WEB-INF/views/include.jsp" %>

				<h1>Shipped Orders</h1>
				
                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">Home</a></li>                    
                    <li class="active">Shipped Orders</li>
                </ul>
                <!-- END BREADCRUMB -->     
                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">             
					<div ng-controller="ViewShippedOrdersController">                      
				        <div class="gridStyle" ng-grid="gridOptions"></div>
				    </div>                        
                </div>
                <!-- END PAGE CONTENT WRAPPER -->                         