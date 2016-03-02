	  var app = angular.module('myApp', ['ngGrid']);

	  app.controller('MyController', function($scope, $http) {
	      $scope.filterOptions = {
	          filterText: "",
	          useExternalFilter: true
	      };
	      $scope.totalServerItems = $http.get('category/count/all/');
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
	                  $http.get('category/list/all/'+pageSize+"/"+page).success(function (largeLoad) {		
	                      data = largeLoad.filter(function(item) {
	                          return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
	                      });
	                      $scope.setPagingData(data,page,pageSize);
	                  });            
	              } else {
	                  $http.get('category/list/all/'+pageSize+"/"+page).success(function (largeLoad) {
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
	  });