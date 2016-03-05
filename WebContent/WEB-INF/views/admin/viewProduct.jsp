<%@include file="/WEB-INF/views/include.jsp" %>
                                <div class="panel panel-default tabs">                            
                                    <ul class="nav nav-tabs" role="tablist">
                                        <li class="active"><a href="#tab-first" role="tab" data-toggle="tab">General</a></li>
                                        <li><a href="#tab-second" role="tab" data-toggle="tab">Attribtes</a></li>
                                        <li><a href="#tab-third" role="tab" data-toggle="tab">Images</a></li>
                                    </ul>
                                    <div class="panel-body tab-content">
                                        <div class="tab-pane active" id="tab-first">

                                            <div class="form-group">
                                                <label class="col-md-3 col-xs-12 control-label">Product Name</label>
                                                <div class="col-md-6 col-xs-12">                                                                                                                                                        
                                                    <input type="text" class="form-control" value=""/>                                                    
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-md-3 col-xs-12 control-label">Description</label>
                                                <div class="col-md-6 col-xs-12">                                    
                                                    <textarea class="block"></textarea>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="tab-pane" id="tab-second">
                                            
                                            <div class="form-group">
                                                <label class="col-md-2 col-xs-12 control-label">Quantity</label>
                                                <div class="col-md-6 col-xs-12">                                                                                                                                                        
                                                    <input type="text" class="form-control" value=""/>                                                    
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="col-md-2 col-xs-12 control-label">Price</label>
                                                <div class="col-md-6 col-xs-12">                                                                                                                                                        
                                                    <input type="text" class="form-control" value=""/>                                                    
                                                </div>
                                            </div>
                                            
                                        </div>                                        
                                        <div class="tab-pane" id="tab-third">
                                            
                                            <div class="form-group push-up-30">
                                                <label class="col-md-3 col-xs-12 control-label">Copy to</label>
                                                <div class="col-md-6 col-xs-12">                                                                                                                                                        
                                                    <input type="text" class="form-control" value="doejohn@domain.com"/>
                                                </div>
                                            </div>
                                            
                                        </div>
                                    </div>
                                    <div class="panel-footer">                                                                        
                                        <button class="btn btn-primary pull-right">Save Changes <span class="fa fa-floppy-o fa-right"></span></button>
                                    </div>
                                </div>     