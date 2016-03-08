<%@include file="/WEB-INF/views/include.jsp" %>
<form:form method="POST" modelAttribute="category" name="form-category" id="form-category" class="form-horizontal">
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
                        <form:hidden path="categoryId" class="form-control" />                                                    
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-3 col-xs-12 control-label">Category Name</label>
                    <div class="col-md-6 col-xs-12">                                                                                                                                                        
                        <form:input path="categoryName" type="text" class="form-control"/>      
	                    <div class="has-error">
	                        <form:errors path="categoryName" class="help-inline"/>
	                    </div>                                                                      
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 col-xs-12 control-label">Description</label>
                    <div class="col-md-6 col-xs-12">                                    
                        <form:textarea path="categoryDescription" class="block"></form:textarea>
	                    <div class="has-error">
	                        <form:errors path="categoryDescription" class="help-inline"/>
	                    </div>                        
                    </div>
                </div>

            </div>
            <div class="tab-pane" id="tab-second">
                
                <div class="form-group">
                    <label class="col-md-2 col-xs-12 control-label">Products</label>
                    <div class="col-md-6 col-xs-12">                                                                                                                                                        
                        <input type="text" class="form-control"/>                                                    
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
            <button class="btn btn-primary pull-right" onclick="$('#form-category').submit()">Save Changes <span class="fa fa-floppy-o fa-right"></span></button>
        </div>
    </div>     
 </form:form>                                