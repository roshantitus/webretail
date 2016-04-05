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
                            <li><a href="categoryList.html"><span class="fa fa-cogs"></span> Categories</a></li>
                            <li><a href="productList.html"><span class="fa fa-list-ul"></span> Products</a></li>                            
                            <li><a href="categoryList.html"><span class="fa fa-list-ul"></span> Reviews</a></li>  
                        </ul>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">Sales</span></a>                        
                        <ul>
                            <li><a href="pendingOrderList.html"><span class="fa fa-heart"></span> Pending Orders</a></li>                            
                            <li><a href="shippedOrderList.html"><span class="fa fa-cogs"></span> Shipped Orders</a></li> 
                            <li><a href="returnedOrderList.html"><span class="fa fa-th"></span> Returned Orders</a></li>                                               
                            <li><a href="categoryList.html"><span class="fa fa-pencil-square-o"></span> Track Shipping</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-pencil"></span> Payments</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-warning"></span> Tax</a></li>                              
                            <li><a href="categoryList.html"><span class="fa fa-list-ul"></span> Gift Vouchers</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-arrows-h"></span> Coupons</a></li>
                        </ul>
                    </li>         
                	<li class="xn-openable">
                        <a href="#"><span class="fa fa-cogs"></span> <span class="xn-text">System</span></a>                        
                        <ul>                            
                            <li><a href="localeList.html"><span class="fa fa-cogs"></span> Languages</a></li>
                            <li><a href="currencyList.html"><span class="fa fa-square-o"></span> Currencies</a></li>    
                            <li><a href="countryList.html"><span class="fa fa-cogs"></span> Countries</a></li>
                            <li><a href="stateList.html"><span class="fa fa-square-o"></span> States</a></li> 
                            <li><a href="cityList.html"><span class="fa fa-cogs"></span> Cities</a></li>
                            <li><a href="userList.html"><span class="fa fa-user"></span> Users</a></li>                            
                            <li><a href="roleList.html"><span class="fa fa-square-o"></span> Roles</a></li>      
                            <li><a href="shippingCompanyList.html"><span class="fa fa-square-o"></span> Shipping Companies</a></li>  
                            <li><a href="bankList.html"><span class="fa fa-square-o"></span> Banks</a></li>  
                            <li><a href="paymentGatewayList.html"><span class="fa fa-square-o"></span> Payment Gateways</a></li>                                                                                                                                     
                            <li><a href="categoryList.html"><span class="fa fa-list-ul"></span> Site Information</a></li>       
                            <li><a href="taskList.html"><span class="fa fa-square-o"></span> Tasks</a></li>  
                            <li><a href="categoryList.html"><span class="fa fa-square-o"></span> Mailbox</a></li>                          
                            <li><a href="categoryList.html"><span class="fa fa-square-o"></span> Search</a></li> 
                            <li><a href="contactList.html"><span class="fa fa-square-o"></span> Address Book</a></li>                                                               
                            <li><a href="categoryList.html"><span class="fa fa-square-o"></span> Error Logs</a></li>                                             
                        </ul>
                    </li>                        
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-bar-chart-o"></span> <span class="xn-text">Reports</span></a>                      
                        <ul>
                        	<li><a href="orderList.html"><span class="fa fa-heart"></span> Order History</a></li>   
                        	<li><a href="categoryList.html"><span class="fa fa-heart"></span> Products Viewed Report</a></li> 
                        	<li><a href="categoryList.html"><span class="fa fa-heart"></span> Products Purchased List</a></li>
                        	<li><a href="categoryList.html"><span class="fa fa-heart"></span> Wishlist Products List</a></li>
                            <li><a href="categoryList.html"><span class="fa fa-heart"></span> Customer Actvity</a></li>
                            <li><a href="visitorList.html"><span class="fa fa-list-ul"></span> Visitors</a></li>                            
                        </ul>
                    </li>                                
                </ul>
                <!-- END X-NAVIGATION -->
            </div>
            <!-- END PAGE SIDEBAR -->