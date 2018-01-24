angular.module("index").controller("logoutController", function ($scope, $routeParams, $http, auth, $location) {
  $http.get("/api/logout").then(function (response) {
    console.log(response);
    auth.logout();
    $location.path("/");
  },
    function (response) {
      console.log("error in logout");
      console.log(response);
    });
});