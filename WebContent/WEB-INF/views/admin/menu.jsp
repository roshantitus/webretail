<%@include file="/WEB-INF/views/include.jsp" %>
            <!-- START PAGE SIDEBAR -->
            <div class="page-sidebar">
                <!-- START X-NAVIGATION -->
                <ul class="x-navigation">
                    <li class="xn-logo">
                        <a href="dashboard.html"><spring:message code="index.title"/></a>
                        <a href="#" class="x-navigation-control"></a>
                    </li>
                    <li class="xn-profile">
                        <a href="#" class="profile-mini">
                            <img src="<c:url value='/resources/admin/assets/images/users/avatar.jpg'/>" alt="Roshan Titus"/>
                        </a>
                        <div class="profile">
                            <div class="profile-image">
                                <img src="<c:url value='/resources/admin/assets/images/users/avatar.jpg'/>" alt="Roshan Titus"/>
                            </div>
                            <div class="profile-data">
                                <div class="profile-data-name">Roshan Titus</div>
                                <div class="profile-data-title">Web Developer/Designer</div>
                            </div>
                        </div>                                                                        
                    </li>
                    <li class="xn-title">Navigation</li>
                    <li class="active">
                        <a href="dashboard.html"><span class="fa fa-desktop"></span> <span class="xn-text">Dashboard</span></a>                        
                    </li>                    
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-file-text-o"></span> <span class="xn-text">Catalog</span></a>
                        <ul>
                            <li><a href="categoryList.html"><span class="fa fa-cogs"></span> Catagories</a></li>
                            <li><a href="productList.html"><span class="fa fa-list-ul"></span> Products</a></li>
                            <li><a href="userList.html"><span class="fa fa-user"></span> Customers</a></li>                            
                            <li><a href="categoryList.html"><span class="fa fa-list-ul"></span> Reviews</a></li>
                        </ul>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">Sales</span></a>                        
                        <ul>
                            <li><a href="categoryList.html"><span class="fa fa-heart"></span> Pending Orders</a></li>                            
                            <li><a href="categoryList.html"><span class="fa fa-cogs"></span> Completed Orders</a></li>                         
                            <li><a href="categoryList.html"><span class="fa fa-pencil-square-o"></span> Shipping</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-pencil"></span> Payments</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-th"></span> Returns</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-warning"></span> Tax</a></li>                              
                            <li><a href="categoryList.html"><span class="fa fa-list-ul"></span> Gift Vouchers</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-arrows-h"></span> Coupons</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-list-ul"></span> Visitors</a></li>
                        </ul>
                    </li>         
                	<li class="xn-openable">
                        <a href="#"><span class="fa fa-cogs"></span> <span class="xn-text">System</span></a>                        
                        <ul>
                            <li><a href="categoryList.html"><span class="fa fa-heart"></span> Preferences</a></li>                            
                            <li><a href="localeList.html"><span class="fa fa-cogs"></span> Languages</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-square-o"></span> Currency</a></li>                            
                            <li><a href="categoryList.html"><span class="fa fa-user"></span> Users</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-list-ul"></span> Site Information</a></li>                            
                        </ul>
                    </li>                        
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-bar-chart-o"></span> <span class="xn-text">Reports</span></a>                      
                        <ul>
                        	<li><a href="orderList.html"><span class="fa fa-heart"></span> Order History</a></li>   
                        	<li><a href="categoryList.html"><span class="fa fa-heart"></span> Products Viewed Report</a></li> 
                        	<li><a href="categoryList.html"><span class="fa fa-heart"></span> Products Purchased List</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-heart"></span> Customer Actvity</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-square-o"></span> Error Logs</a></li>
                        </ul>
                    </li>                                
                </ul>
                <!-- END X-NAVIGATION -->
            </div>
            <!-- END PAGE SIDEBAR -->