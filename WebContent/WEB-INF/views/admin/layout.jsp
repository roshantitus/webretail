<%@include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE html>
<html lang="en" ng-app="adminApp">
    <head>        
        <!-- META SECTION -->
        <title><tiles:insertAttribute name="title" ignore="true" /></title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="icon" href="favicon.ico" type="image/x-icon" />
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="<c:url value='/resources/admin/css/theme-default.css'/>"/>
        <!-- EOF CSS INCLUDE -->                            
		        
        <!-- START ng-grid -->
        <link rel="stylesheet" type="text/css" id="theme" href="<c:url value='/resources/admin/css/admin_style.css'/>"/>
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.css" />
                
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.2/angular.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.debug.js"></script>     
        <script type="text/javascript" src="<c:url value='/resources/admin/js/admin_script.js'/>"></script>        
		<!-- END ng-grid -->   		        
    </head>
    <body>
    

        <!-- START PAGE CONTAINER -->
        <div class="page-container">
            
			<tiles:insertAttribute name="menu" />
            
            <!-- PAGE CONTENT -->
            <div class="page-content">
                
				<tiles:insertAttribute name="header" />                
                
                <tiles:insertAttribute name="body" />
                
             </div>            
            <!-- END PAGE CONTENT -->
            
        </div>
        <!-- END PAGE CONTAINER -->
                    

        <!-- START PRELOADS -->
        <audio id="audio-alert" src="<c:url value='/resources/admin/audio/alert.mp3'/>" preload="auto"></audio>
        <audio id="audio-fail" src="<c:url value='/resources/admin/audio/fail.mp3'/>" preload="auto"></audio>
        <!-- END PRELOADS -->                  
        
    <!-- START SCRIPTS -->
        <!-- START PLUGINS -->
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/jquery/jquery.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/jquery/jquery-ui.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/bootstrap/bootstrap.min.js'/>"></script>        
        <!-- END PLUGINS -->

        <!-- START THIS PAGE PLUGINS-->        
        <script type='text/javascript' src="<c:url value='/resources/admin/js/plugins/icheck/icheck.min.js'/>"></script>        
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/scrolltotop/scrolltopcontrol.js'/>"></script>
        
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/morris/raphael-min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/morris/morris.min.js'/>"></script>       
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/rickshaw/d3.v3.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/rickshaw/rickshaw.min.js'/>"></script>
        <script type='text/javascript' src='<c:url value='/resources/admin/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'/>'></script>
        <script type='text/javascript' src='<c:url value='/resources/admin/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'/>'></script>                
        <script type='text/javascript' src='<c:url value='/resources/admin/js/plugins/bootstrap/bootstrap-datepicker.js'/>'></script>                
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/owl/owl.carousel.min.js'/>"></script>                 
        
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/moment.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins/daterangepicker/daterangepicker.js'/>"></script>
        <!-- END THIS PAGE PLUGINS-->        

        <!-- START TEMPLATE -->
        <script type="text/javascript" src="<c:url value='/resources/admin/js/settings.js'/>"></script>
        
        <script type="text/javascript" src="<c:url value='/resources/admin/js/plugins.js'/>"></script>        
        <script type="text/javascript" src="<c:url value='/resources/admin/js/actions.js'/>"></script>
        
        <script type="text/javascript" src="<c:url value='/resources/admin/js/demo_dashboard.js'/>"></script>
		  
        <!-- END TEMPLATE -->
        
<!--  		<div id="footer"><a href="http://www.webretail.com">Webretail</a> © 2015-2016 All Rights Reserved.<br>Version 1.0.0</div>      -->
    <!-- END SCRIPTS -->  
       
    </body>
</html>
    