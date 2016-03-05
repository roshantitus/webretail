<%@include file="/WEB-INF/views/include.jsp" %>

				<h1>Products</h1>
				
                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">Home</a></li>                    
                    <li class="active">Products</li>
                </ul>
                <!-- END BREADCRUMB -->     
                
				<div class="pull-right">
						<a data-original-title="Add New" href="addProduct.html" data-toggle="tooltip" title="Add New" class="btn btn-primary"><i class="fa fa-plus"></i></a>        
				        <button data-original-title="Delete" type="button" data-toggle="tooltip" title="Delete" class="btn btn-danger" onclick="confirm('Delete cannot be undone! Are you sure you want to do this?');"><i class="fa fa-trash-o"></i></button>
				</div>                
				                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">      
                       
					<div ng-controller="ViewAllProductsController">                      
				        <div class="gridStyle" ng-grid="gridOptions"></div>
				    </div>      
				                     
                </div>
                <!-- END PAGE CONTENT WRAPPER -->                       