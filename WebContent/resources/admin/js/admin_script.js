function DataTableController(type) {
	
    return function($scope, $http) {
	      $scope.filterOptions = {
		          filterText: "",
		          useExternalFilter: true
		      };

		      $scope.totalServerItems = $http.get(type + '/count/all/').success(function (count) {
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
		                  $http.get(type + '/list/all/'+pageSize+"/"+page).success(function (largeLoad) {		
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
		          filterOptions: $scope.filterOptions
		      };
		  }
}


var app = angular.module('adminApp', ['ngGrid']);

app.controller('CategoryController', ['$scope', '$http', DataTableController('category')]);
app.controller('ProductController', ['$scope', '$http', DataTableController('product')]);
