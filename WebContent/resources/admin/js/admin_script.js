function DataTableController(type, list, colDefs) {
	
    return function($scope, $http) {
	      $scope.filterOptions = {
		          filterText: "",
		          useExternalFilter: true
		      };
		      $scope.totalServerItems = $http.get(type + '/count/'+ list + '/').success(function (count) {
		    	  $scope.totalServerItems = count;
	    	  })
	    	  .error(function (data) {
	    		  $scope.totalServerItems = 0;
	    		  alert(0);
	    	  });
		      $scope.pagingOptions = {
		          pageSizes: [20, 50, 100],
		          pageSize: 20,
		          currentPage: 1
		      };  
		      $scope.setPagingData = function(data, page, pageSize){	
		          $scope.myData = data;
		          if (!$scope.$$phase) {
		              $scope.$apply();
		          }
		      };
		      $scope.getPagedDataAsync = function (pageSize, page, searchText) {
		          setTimeout(function () {
		              var data;
		              if (searchText) {
		                  var ft = searchText.toLowerCase();
		                  $http.get(type + '/list/'+ list +'/'+pageSize+"/"+page).success(function (largeLoad) {		
		                      data = largeLoad.filter(function(item) {
		                          return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
		                      });
		                      $scope.setPagingData(data,page,pageSize);
		                  });            
		              } else {
		                  $http.get(type + '/list/all/'+pageSize+"/"+page).success(function (largeLoad) {
		                      $scope.setPagingData(largeLoad,page,pageSize);
		                  });
		              }
		          }, 100);
		      };
		  	
		      $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
		  	
		      $scope.$watch('pagingOptions', function (newVal, oldVal) {
		          if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
		            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
		          }
		      }, true);
		      $scope.$watch('filterOptions', function (newVal, oldVal) {
		          if (newVal !== oldVal) {
		            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
		          }
		      }, true);
		  	
		      $scope.gridOptions = {
		          data: 'myData',
		          enablePaging: true,
		          showFooter: true,
		          totalServerItems: $scope.totalServerItems,
		          pagingOptions: $scope.pagingOptions,
		          filterOptions: $scope.filterOptions,
		          showSelectionCheckbox: true,
		          selectWithCheckboxOnly: true,
		          multiSelect: false,
		          columnDefs: colDefs
		      };
		  }
}


var app = angular.module('adminApp', ['ngGrid']);

app.controller('ViewAllCategoriesController', ['$scope', '$http', DataTableController('category', 'all', [ {
                                                                                                              field: 'categoryName',
                                                                                                              displayName: 'Category Name',
                                                                                                              enableCellEdit: false
                                                                                                            },
                                                                                                            {
                                                                                                              field: 'categoryDescription',
                                                                                                              displayName: 'Category Description',
                                                                                                              enableCellEdit: false
                                                                                                            },
                                                                                                            {
                                                                                                              field: 'categoryId',
                                                                                                              displayName: 'Action',
                                                                                                              enableCellEdit: false,
                                                                                                              cellTemplate: '<div class="ngCellText"><a data-original-title="Edit" ng-href="editCategory.html?categoryId={{COL_FIELD}}" data-toggle="tooltip" title="" class="btn btn-primary"><i class="fa fa-pencil"></i></a></div>'
                                                                                                            }
                                                                                                        ])]);

app.controller('ViewAllProductsController', ['$scope', '$http', DataTableController('product', 'all', [
                                                                                                       {
                                                                                                           field: 'productName',
                                                                                                           displayName: 'Product Name',
                                                                                                           enableCellEdit: false
                                                                                                         },
                                                                                                         {
                                                                                                           field: 'quantity',
                                                                                                           displayName: 'Quantity',
                                                                                                           enableCellEdit: false
                                                                                                         },
                                                                                                         {
                                                                                                           field: 'unitPrice',
                                                                                                           displayName: 'Unit Price',
                                                                                                           enableCellEdit: false
                                                                                                         },			
                                                                                                         {
                                                                                                           field: 'productId',
                                                                                                           displayName: 'Action',
                                                                                                           enableCellEdit: false,
                                                                                                           cellTemplate: '<div class="ngCellText"><a data-original-title="Edit" ng-href="editProduct.html?productId={{COL_FIELD}}" data-toggle="tooltip" title="" class="btn btn-primary"><i class="fa fa-pencil"></i></a></div>'
                                                                                                         }
                                                                                                     ])]);
app.controller('ViewAllOrdersController', ['$scope', '$http', DataTableController('order', 'all', [
                                                                                                   {
                                                                                                       field: 'orderId',
                                                                                                       displayName: 'Order ID',
                                                                                                       enableCellEdit: false
                                                                                                     },		
                                                                                                     {
                                                                                                       field: 'orderStatus',
                                                                                                       displayName: 'Status',
                                                                                                       enableCellEdit: false
                                                                                                     },			
                                                                                                     {
                                                                                                       field: 'orderDate',
                                                                                                       displayName: 'Order Date',
                                                                                                       enableCellEdit: false
                                                                                                     },		
                                                                                                     {
                                                                                                       field: 'orderId',
                                                                                                       displayName: 'Action',
                                                                                                       enableCellEdit: false,
                                                                                                       cellTemplate: '<div class="ngCellText"><a data-original-title="Edit" ng-href="viewOrder.html?orderId={{COL_FIELD}}" data-toggle="tooltip" title="" class="btn btn-primary"><i class="fa fa-pencil"></i></a></div>'
                                                                                                     }
                                                                                                 ])]);
pp.controller('ViewPendingOrdersController', ['$scope', '$http', DataTableController('order', 'pending', [
                                                                                                             {
                                                                                                                 field: 'orderId',
                                                                                                                 displayName: 'Order ID',
                                                                                                                 enableCellEdit: false
                                                                                                               },		
                                                                                                               {
                                                                                                                 field: 'orderStatus',
                                                                                                                 displayName: 'Status',
                                                                                                                 enableCellEdit: false
                                                                                                               },			
                                                                                                               {
                                                                                                                 field: 'orderDate',
                                                                                                                 displayName: 'Order Date',
                                                                                                                 enableCellEdit: false
                                                                                                               },		
                                                                                                               {
                                                                                                                 field: 'orderId',
                                                                                                                 displayName: 'Action',
                                                                                                                 enableCellEdit: false,
                                                                                                                 cellTemplate: '<div class="ngCellText"><a data-original-title="Edit" ng-href="viewOrder.html?orderId={{COL_FIELD}}" data-toggle="tooltip" title="" class="btn btn-primary"><i class="fa fa-pencil"></i></a></div>'
                                                                                                               }
                                                                                                           ])]);
app.controller('ViewShippedOrdersController', ['$scope', '$http', DataTableController('order', 'shipped', [
                                                                                                              {
                                                                                                                  field: 'orderId',
                                                                                                                  displayName: 'Order ID',
                                                                                                                  enableCellEdit: false
                                                                                                                },		
                                                                                                                {
                                                                                                                  field: 'orderStatus',
                                                                                                                  displayName: 'Status',
                                                                                                                  enableCellEdit: false
                                                                                                                },			
                                                                                                                {
                                                                                                                  field: 'orderDate',
                                                                                                                  displayName: 'Order Date',
                                                                                                                  enableCellEdit: false
                                                                                                                },		
                                                                                                                {
                                                                                                                  field: 'orderId',
                                                                                                                  displayName: 'Action',
                                                                                                                  enableCellEdit: false,
                                                                                                                  cellTemplate: '<div class="ngCellText"><a data-original-title="Edit" ng-href="viewOrder.html?orderId={{COL_FIELD}}" data-toggle="tooltip" title="" class="btn btn-primary"><i class="fa fa-pencil"></i></a></div>'
                                                                                                                }
                                                                                                            ])]);
app.controller('ViewReturnedOrdersController', ['$scope', '$http', DataTableController('order', 'returned', [
                                                                                                                {
                                                                                                                    field: 'orderId',
                                                                                                                    displayName: 'Order ID',
                                                                                                                    enableCellEdit: false
                                                                                                                  },		
                                                                                                                  {
                                                                                                                    field: 'orderStatus',
                                                                                                                    displayName: 'Status',
                                                                                                                    enableCellEdit: false
                                                                                                                  },			
                                                                                                                  {
                                                                                                                    field: 'orderDate',
                                                                                                                    displayName: 'Order Date',
                                                                                                                    enableCellEdit: false
                                                                                                                  },		
                                                                                                                  {
                                                                                                                    field: 'orderId',
                                                                                                                    displayName: 'Action',
                                                                                                                    enableCellEdit: false,
                                                                                                                    cellTemplate: '<div class="ngCellText"><a data-original-title="Edit" ng-href="viewOrder.html?orderId={{COL_FIELD}}" data-toggle="tooltip" title="" class="btn btn-primary"><i class="fa fa-pencil"></i></a></div>'
                                                                                                                  }
                                                                                                              ])]);
