<%@include file="/WEB-INF/views/include.jsp" %>

				<h1>Returned Orders</h1>
				
                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">Home</a></li>                    
                    <li class="active">Returned Orders</li>
                </ul>
                <!-- END BREADCRUMB -->     
                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">             
					<div ng-controller="ViewReturnedOrdersController">                      
				        <div class="gridStyle" ng-grid="gridOptions"></div>
				    </div>                        
                </div>
                <!-- END PAGE CONTENT WRAPPER -->                         