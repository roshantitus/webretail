<%@include file="/WEB-INF/views/include.jsp" %>
		
				<h1>Add Product</h1>
				
                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">Home</a></li>                    
                    <li class="active">Products</li>
                </ul>
                <!-- END BREADCRUMB -->     
                
				<div class="pull-right">
				        <a data-original-title="Cancel" href="productList.html" data-toggle="tooltip" title="" class="btn btn-default"><i class="fa fa-reply"></i></a>
				</div>
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">      
                    <div class="row">
                        <div class="col-md-12">
                            
                            <form class="form-horizontal">
                                                            
                           		<%@include file="/WEB-INF/views/admin/viewProduct.jsp" %>
                            
                            </form>
                            
                        </div>
                    </div>                    
                </div>
                <!-- END PAGE CONTENT WRAPPER -->       
 

		     