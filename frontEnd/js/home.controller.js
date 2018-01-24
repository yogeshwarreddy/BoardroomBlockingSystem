angular.module("index").controller("homeController", function ($scope, $http) {
  $http.get("/api/rooms").then(function (response) {
    $scope.rooms = response.data;
  }, function (response) {
    console.log("error in get rooms");
    $scope.rooms = [];
  });
  $http.get("/api/requests").then(function (response) {
    $scope.requests = response.data;
    $scope.requests.forEach(request => {
      request.from_time = new Date(request.startTime).toLocaleString();
      request.to_time = new Date(request.endTime).toLocaleTimeString();
    });
  }, function (response) {
    console.log("error in get rooms");
    $scope.requests = [];
  });
});