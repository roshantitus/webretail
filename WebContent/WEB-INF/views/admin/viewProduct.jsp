<%@include file="/WEB-INF/views/include.jsp" %>
<form:form method="POST" modelAttribute="product" name="form-product" id="form-product" class="form-horizontal">
    <div class="panel panel-default tabs">                            
        <ul class="nav nav-tabs" role="tablist">
            <li class="active"><a href="#tab-first" role="tab" data-toggle="tab">General</a></li>
            <li><a href="#tab-second" role="tab" data-toggle="tab">Attributes</a></li>
            <li><a href="#tab-third" role="tab" data-toggle="tab">Images</a></li>
        </ul>
        <div class="panel-body tab-content">
            <div class="tab-pane active" id="tab-first">

                <div class="form-group">
                    <div class="col-md-6 col-xs-12">                                                                                                                                                        
                        <form:hidden path="productId" class="form-control" />                                                    
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-3 col-xs-12 control-label">Product Name</label>
                    <div class="col-md-6 col-xs-12">                                                                                                                                                        
                        <form:input path="productName" type="text" class="form-control"/>        
	                    <div class="has-error">
	                        <form:errors path="productName" class="help-inline"/>
	                    </div>                                                                    
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 col-xs-12 control-label">Description</label>
                    <div class="col-md-6 col-xs-12">                                    
                        <form:textarea path="productDescription" class="block"></form:textarea>
	                    <div class="has-error">
	                        <form:errors path="productDescription" class="help-inline"/>
	                    </div>                          
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-3 col-xs-12 control-label">Category</label>
                    <div class="col-md-6 col-xs-12">                                    
                        <form:select path="category.categoryId" class="form-control select" data-style="btn-success">
				            <form:options items="${categoryList}" itemLabel="categoryName" itemValue="categoryId" />
				        </form:select>
	                    <div class="has-error">
	                        <form:errors path="category.categoryId" class="help-inline"/>
	                    </div>  				        
                    </div>
                </div>                

            </div>
            <div class="tab-pane" id="tab-second">
                
                <div class="form-group">
                    <label class="col-md-2 col-xs-12 control-label">Quantity</label>
                    <div class="col-md-6 col-xs-12">                                                                                                                                                        
                        <form:input path="quantity" type="text" class="form-control"/>       
	                    <div class="has-error">
	                        <form:errors path="quantity" class="help-inline"/>
	                    </div>                                                                       
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-2 col-xs-12 control-label">Price</label>
                    <div class="col-md-6 col-xs-12">                                                                                                                                                        
                        <form:input path="unitPrice" type="text" class="form-control"/>   
	                    <div class="has-error">
	                        <form:errors path="unitPrice" class="help-inline"/>
	                    </div>                                                                           
                    </div>
                </div>
                
            </div>                                        
            <div class="tab-pane" id="tab-third">
                
                <div class="form-group push-up-30">
                    <label class="col-md-3 col-xs-12 control-label">Thumbnail</label>
                    <div class="col-md-6 col-xs-12">                                                                                                                                                        
                        <input type="text" class="form-control"/>
                    </div>
                </div>
                
            </div>
        </div>
        <div class="panel-footer">                                                                        
            <button class="btn btn-primary pull-right" onclick="$('#form-product').submit()">Save Changes <span class="fa fa-floppy-o fa-right"></span></button>
        </div>
    </div>     
 </form:form>                                